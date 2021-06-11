import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-addService',
  templateUrl: './addService.component.html',
  styleUrls: ['./addService.component.css']
})
export class AddServiceComponent implements OnInit {

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

}