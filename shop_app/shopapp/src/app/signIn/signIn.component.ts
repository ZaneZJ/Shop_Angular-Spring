import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormControl } from '@angular/forms';
import { FormBuilder, FormGroup, Validators, NgForm } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { stringify } from '@angular/compiler/src/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signIn',
  templateUrl: './signIn.component.html',
  styleUrls: ['./signIn.component.css'],
})
export class SignInComponent implements OnInit {
  public users: User[];

  hide = true;

  signInForm!: FormGroup;

  username!: string;
  @Input() isEnglish: boolean;

  constructor(
    private userService: UserService, 
    private cookieService: CookieService,
    private _formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
    ) {
    // Initialization inside the constructor
    this.users = [];

    this.username = this.cookieService.get('username');
    this.isEnglish = true;
    if(this.username) {
      this.router.navigate(['/main']);
    }
  }

  changeLanguage() {
    this.isEnglish = !this.isEnglish;
  }

  ngOnInit() {
    this.signInForm = this._formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  public signIn(): void {
    // SET PASSWORD IN THIS STRING:
    var pass:string = this.signInForm.value["password"];
    var password:string = btoa(pass);

    console.log(this.signInForm);
    this.userService.signInUser(this.signInForm.value["username"], password).subscribe(
      (response: User) => {
        if (response == null) {
          alert("Wrong username or password!");
          return;
        }
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
