import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {ElementRef, ViewChild} from '@angular/core';
import {FormControl} from '@angular/forms';
import {MatAutocompleteSelectedEvent, MatAutocomplete} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-addService',
  templateUrl: './addService.component.html',
  styleUrls: ['./addService.component.css']
})
export class AddServiceComponent implements OnInit {

    public users: User[];
  
    title: string = "";
    description: string = "";
    theme: string = "";

    visible = true;
    selectable = true;
    removable = true;
    separatorKeysCodes: number[] = [ENTER, COMMA];
    serviceCtrl = new FormControl();
    filteredServices: Observable<string[]>;
    services: string[] = ['Design'];
    allServices: string[] = ['Programming', 'Design', 'Graphics', 'Music', 'Video', 'Education', 'Translation', 'Writing', 'Lifestyle', 'Health', 'Business'];
  
    @ViewChild('serviceInput') serviceInput!: ElementRef<HTMLInputElement>;
    @ViewChild('auto') matAutocomplete!: MatAutocomplete;

    constructor(private userService: UserService){
      // Initialization inside the constructor
      this.users = [];
      this.filteredServices = this.serviceCtrl.valueChanges.pipe(
        startWith(null),
        map((service: string | null) => service ? this._filter(service) : this.allServices.slice()));
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
    
        return this.allServices.filter(service => service.toLowerCase().indexOf(filterValue) === 0);
      }
  
    createService() {
      
    }

    ngOnInit() {
      this.getUsers();
    }
  
    public getUsers(): void {
      this.userService.getUser().subscribe(
        (response: User[]) => {
          this.users = response;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    }
  
    public onAddUser(addForm: NgForm): void {
      document!.getElementById('add-user-form')!.click();
      this.userService.addUser(addForm.value).subscribe(
        (response: User) => {
          console.log(response);
          this.getUsers();
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
    }
}