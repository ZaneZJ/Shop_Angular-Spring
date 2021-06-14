import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router, RouterLinkWithHref } from '@angular/router';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { Bank } from '../bank';
import { CdkStepper } from '@angular/cdk/stepper';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css'],
})
export class SignUpComponent implements OnInit {

  fileName = '';

  public users: User[];
  public banks: Bank[];

  isLinear = false;
  userDetailsForm!: FormGroup;
  addressForm!: FormGroup;
  bankForm!: FormGroup;
  hide = true;

  stepper!: CdkStepper;

  username!: string;

  

  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder,
    private cookieService: CookieService,
    private http: HttpClient,
    private router: Router
    ) {
    // Initialization inside the constructor
    this.users = [];
    this.banks = [];

    this.username = this.cookieService.get('username');
    if(this.username) {
      this.router.navigate(['/main']);
    }
  }

  signUp() { }

  close() {
    window.location.href = 'http://localhost:4200/main';
  }

  ngOnInit() {

    this.userDetailsForm = this._formBuilder.group({
      username: ['', Validators.required],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      email: ['', Validators.required],
      phoneNo: ['', Validators.required],
      pictureMain: [''],
      password: ['', Validators.required],
    });
    this.addressForm = this._formBuilder.group({
      address: ['', Validators.required],
      postalCode: ['', Validators.required],
    });
    this.bankForm = this._formBuilder.group({
      accountNo: ['', Validators.required],
      beneficiary: ['', Validators.required],
      bank: ['', Validators.required],
    });

  }

  // Add User 

  public submitAll() {
    [this.userDetailsForm, this.addressForm, this.bankForm].forEach((form) => {
      console.log(form);
    })

    const user: User = {
      ...this.userDetailsForm.value, 
      ...this.addressForm.value,
      bank: this.bankForm.value,
      loyaltyType: 'BRONZE',
      status: 'ACTIVE'
    }

    console.log(user);

    this.userService.addUser(user).subscribe(
      (response: User) => {
        console.log(response);
        this.cookieService.set( "username" , response.username );
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

}
