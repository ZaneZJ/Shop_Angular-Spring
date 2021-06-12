import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { RouterLinkWithHref } from '@angular/router';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { Bank } from '../bank';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css'],
})
export class SignUpComponent implements OnInit {

  public users: User[];
  public banks: Bank[];

  isLinear = false;
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  thirdFormGroup!: FormGroup;
  hide = true;

  user_password: string = '';
  user_username: string = '';
  user_name: string = '';
  user_surname: string = '';
  user_phoneNo: string = '';
  user_address: string = '';
  user_email: string = '';
  user_postalCode: string = '';
  user_pictureMain: string = '';
  user_accountNo: string = '';
  user_beneficiary: string = '';
  user_bank: string = '';



  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder
  ) {
    // Initialization inside the constructor
    this.users = [];
    this.banks = [];
  }

  signUp() {
    alert(this.user_username + ' ' + this.user_password);
  }

  close() {
    window.location.href = 'http://localhost:4200/main';
  }

  ngOnInit() {
    this.getUsers();

    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required],
      firstCtrl1: ['', Validators.required],
      firstCtrl2: ['', Validators.required],
      firstCtrl3: ['', Validators.required],
      firstCtrl4: ['', Validators.required],
      firstCtrl5: ['', Validators.required],
      firstCtrl6: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required],
      secondCtrl1: ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required],
      thirdCtrl1: ['', Validators.required],
      thirdCtrl2: ['', Validators.required],
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

  public onAddUser(addUserForm: NgForm): void {
    // document!.getElementById('add-user-form')!.click();
    console.log("addUserForm:");
    console.log(addUserForm);
    console.log("addUserForm.value:");
    console.log(addUserForm.value);
    console.log("addUserForm.form.value:");
    console.log(addUserForm.form.value);
    this.userService.addUser(addUserForm.form.value).subscribe(
      (response: User) => {
        console.log(response);
        this.getUsers();
        addUserForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addUserForm.reset();
      }
    );
  }

}
