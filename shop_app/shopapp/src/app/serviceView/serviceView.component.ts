import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-serviceView',
  templateUrl: './serviceView.component.html',
  styleUrls: ['./serviceView.component.css']
})
export class ServiceViewComponent implements OnInit {

  public users: User[];

  constructor(private userService: UserService){
    // Initialization inside the constructor
    this.users = [];
  }

  ngOnInit() {
    this.getAllUsers();
  }

  public getAllUsers(): void {
    this.userService.getAllUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}