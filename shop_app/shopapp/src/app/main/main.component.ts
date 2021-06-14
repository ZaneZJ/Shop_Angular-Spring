import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Variable } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  public users: User[];

  username!: string;

  constructor(
    private userService: UserService,
    private cookieService: CookieService,
    private http: HttpClient,
    private router: Router) {
    // Initialization inside the constructor
    this.users = [];

    this.username = this.cookieService.get('username');
    if(this.username) {
      // function demoDisplay() {
      //   document.getElementById("hide")!.style.display = "none";
      // }
    }

  }

  signUp() {
    window.location.replace('http://localhost:4200/signUp');
  }

  signIn() {
    window.location.replace('http://localhost:4200/signIn');
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
    );
  }
}
