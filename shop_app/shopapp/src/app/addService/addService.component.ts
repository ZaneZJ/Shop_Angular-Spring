import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { ElementRef, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import {
  MatAutocompleteSelectedEvent,
  MatAutocomplete,
} from '@angular/material/autocomplete';
import { MatChipInputEvent } from '@angular/material/chips';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Service } from '../service';
import { Instance } from '../instance';
import { Pictures } from '../pictures';
import { CdkStepper } from '@angular/cdk/stepper';
import { ServiceService } from '../service.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addService',
  templateUrl: './addService.component.html',
  styleUrls: ['./addService.component.css'],
})
export class AddServiceComponent implements OnInit {

  public users: User[];
  public servicess: Service[];
  public instances: Instance[];
  public picturess: Pictures[];

  mainServiceForm!: FormGroup;
  instanceOneForm!: FormGroup;
  instanceTwoForm!: FormGroup;
  instanceThreeForm!: FormGroup;

  @Input() isEnglish: boolean;

  stepper!: CdkStepper;

  // MatPaginator Inputs
  length = 0;

  username!: string;

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  serviceCtrl = new FormControl();
  filteredServices: Observable<string[]>;
  services: string[] = ['Design'];
  allServices: string[] = [
    'Programming',
    'Design',
    'Graphics',
    'Music',
    'Video',
    'Education',
    'Translation',
    'Writing',
    'Lifestyle',
    'Health',
    'Business',
  ];

  // title: string = '';
  // description: string = '';
  // theme: string = '';

  @ViewChild('serviceInput') serviceInput!: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete!: MatAutocomplete;

  constructor(
    private serviceService: ServiceService, 
    private userService: UserService, 
    private _formBuilder: FormBuilder,
    private cookieService: CookieService,
    private router: Router
    ) {
    // Initialization inside the constructor
    this.users = [];
    this.servicess = [];
    this.instances = [];
    this.picturess = [];

    this.username = this.cookieService.get('username');
    this.isEnglish = true;
    if(!this.username) {
      this.router.navigate(['/signIn']);
    }

    this.filteredServices = this.serviceCtrl.valueChanges.pipe(
      startWith(null),
      map((service: string | null) =>
        service ? this._filter(service) : this.allServices.slice()
      )
    );
  }

  changeLanguage() {
    this.isEnglish = !this.isEnglish;
  }

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    // Add our service
    if (value) {
      this.services.push(value);
    }

    // Clear the input value
    event.chipInput!.clear();

    this.serviceCtrl.setValue(null);
  }

  remove(service: string): void {
    const index = this.services.indexOf(service);

    if (index >= 0) {
      this.services.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.services.push(event.option.viewValue);
    this.serviceInput.nativeElement.value = '';
    this.serviceCtrl.setValue(null);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.allServices.filter(
      (service) => service.toLowerCase().indexOf(filterValue) === 0
    );
  }

  createService() {}

  ngOnInit() {
    this.getAllUsers();

    this.mainServiceForm = this._formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      theme: ['', Validators.required],
      // TODO: add img
    });
    this.instanceOneForm = this._formBuilder.group({
      price: ['', Validators.required],
      time: ['', Validators.required],
      info: ['', Validators.required],
    });
    this.instanceTwoForm = this._formBuilder.group({
      price: ['', Validators.required],
      time: ['', Validators.required],
      info: ['', Validators.required],
    });
    this.instanceThreeForm = this._formBuilder.group({
      price: ['', Validators.required],
      time: ['', Validators.required],
      info: ['', Validators.required],
    });
  }

  public getAllUsers(): void {
    this.userService.getAllUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  // public getUserByUsername(find: string): void {
  //   this.userService.getUserByUsername(find).subscribe(
  //     (response: User) => {
        
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message);
  //     }
  //   );
  // }

  public getAllServices(): void {
    this.serviceService.getAllServices().subscribe(
      (response: Service[]) => {
        this.servicess = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public submitAll() {
    [this.mainServiceForm, this.instanceOneForm, this.instanceTwoForm, this.instanceThreeForm].forEach((form) => {
      console.log(form);
    })

    // FIXME: get user that's logged on and assign to it!

    // can run the function in the future
    this.userService.getUserByUsername(this.username).subscribe(
      (user: User) => {
        const service: Service = {
          ...this.mainServiceForm.value,
          user: user,
          instances: [this.instanceOneForm.value, this.instanceTwoForm.value, this.instanceThreeForm.value]
        }
    
        console.log(service);
        console.log("before service is created");
    
        this.serviceService.addService(service).subscribe(
          (response: Service) => {
            console.log(response);
            console.log("created service");
            this.getAllServices();
          },
          (error: HttpErrorResponse) => {
            console.log("failed to create service");
            alert(error.message);
          }
        );
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  // public serviceTest(user: User) {
  //   const service: Service = {
  //     ...this.mainServiceForm.value,
  //     user: user,
  //     instances: [this.instanceOneForm.value, this.instanceTwoForm.value, this.instanceThreeForm.value]
  //   }

  //   console.log(service);
  //   console.log("before service is created");

  //   this.serviceService.addService(service).subscribe(
  //     (response: Service) => {
  //       console.log(response);
  //       console.log("created service");
  //       this.getAllServices();
  //       this.stepper.reset();
  //     },
  //     (error: HttpErrorResponse) => {
  //       console.log("failed to create service");
  //       alert(error.message);
  //       this.stepper.reset();
  //     }
  //   );
  // }
}
