import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { RouterLinkWithHref } from '@angular/router';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { Bank } from '../bank';
import { CdkStepper } from '@angular/cdk/stepper';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css'],
})
export class SignUpComponent implements OnInit {

  public users: User[];
  public banks: Bank[];

  isLinear = false;
  userDetailsForm!: FormGroup;
  addressForm!: FormGroup;
  bankForm!: FormGroup;
  hide = true;

  stepper!: CdkStepper;

  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder
  ) {
    // Initialization inside the constructor
    this.users = [];
    this.banks = [];
  }

  signUp() { }

  close() {
    window.location.href = 'http://localhost:4200/main';
  }

  ngOnInit() {
    this.getUsers();

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

  public getUsers(): void {
    this.userService.getUser().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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
        this.getUsers();
        this.stepper.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        this.stepper.reset();
      }
    );

  }

}
