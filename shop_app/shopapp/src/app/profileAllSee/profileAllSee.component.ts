import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profileAllSee',
  templateUrl: './profileAllSee.component.html',
  styleUrls: ['./profileAllSee.component.css'],
})
export class ProfileAllSeeComponent implements OnInit {
  public users: User[];

  constructor(private userService: UserService) {
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
    );
  }
}
