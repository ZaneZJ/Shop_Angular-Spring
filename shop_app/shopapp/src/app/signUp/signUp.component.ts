import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
// import { User } from '.signUp.component.spec/user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css']
})
export class AppComponent implements OnInit {

  public users: User[];

  constructor(private userService: UserService){
    // Initialization inside the constructor
    this.users = [];
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
    document.getElementById('add-user-form').click();
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