import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { RouterLinkWithHref } from '@angular/router';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css']
})
export class SignUpComponent implements OnInit {

  public users: User[];

  isLinear = false;
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  thirdFormGroup!: FormGroup;
  hide = true;

  username: string = "";
  password: string = "";
  name: string = "";
  surname: string = "";
  phoneNo: string = "";
  address: string = "";
  email: string = "";
  postalCode: string = "";
  pictureMain: string = "";
  accountNo: string = "";
  beneficiary: string = "";
  bank: string = "";

  constructor(private userService: UserService, private _formBuilder: FormBuilder){
    // Initialization inside the constructor
    this.users = [];
  }

  signUp() {
    alert(this.username + " " + this.password);
  }

  close() {
    window.location.href = "localhost:4200/main";
  }

  done() {
    
  }

  ngOnInit() {
    this.getUsers();

    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required]
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