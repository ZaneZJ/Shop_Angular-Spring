import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormControl } from '@angular/forms';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-signIn',
  templateUrl: './signIn.component.html',
  styleUrls: ['./signIn.component.css'],
})
export class SignInComponent implements OnInit {
  public users: User[];

  hide = true;

  username: string = '';
  password: string = '';
  signInForm!: FormGroup;

  constructor(
    private userService: UserService, 
    private cookieService: CookieService,
    private _formBuilder: FormBuilder) {
    // Initialization inside the constructor
    this.users = [];
  }

  ngOnInit() {
    this.signInForm = this._formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  public signIn(): void {
    console.log(this.signInForm.value);
    this.userService.signInUser(this.signInForm.value["username"], "password").subscribe(
      (response: User) => {
        console.log(response);
        this.cookieService.set( "username" , response.username );
        window.location.href='http://localhost:4200/main';
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
