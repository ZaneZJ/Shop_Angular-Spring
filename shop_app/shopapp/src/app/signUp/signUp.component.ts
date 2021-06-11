import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { RouterLinkWithHref } from '@angular/router';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css']
})
export class SignUpComponent implements OnInit {

  public users: User[];

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

  constructor(private userService: UserService){
    // Initialization inside the constructor
    this.users = [];
  }

  signUp() {
    alert(this.username + " " + this.password);
  }

  close() {
    window.location.href = "localhost:4200/main";
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