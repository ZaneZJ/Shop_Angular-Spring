import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { Pictures } from '../pictures';
import { Service } from '../service';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { ServiceService } from '../service.service';
import { PicturesService } from '../pictures.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  public users: User[];
  public services?: Service[];
  public picturess: Pictures[];
  public allServices: string[] = [
    'Programming',
    'Design',
    'Graphics',
    'Music',
    'Video',
    'Education',
    'Translation',
    'Writing',
    'Lifestyle',
    'Health',
    'Business',
  ];

  @Input() isLoggedIn: boolean;
  @Input() isEnglish: boolean;

  username!: string;

  constructor(
    private userService: UserService,
    private serviceServices: ServiceService,
    private picturesServices: PicturesService,
    private cookieService: CookieService,
    private http: HttpClient,
    private router: Router) {
    // Initialization inside the constructor
    this.users = [];
    this.services = [];
    this.picturess = [];

    this.username = this.cookieService.get('username');
    this.isLoggedIn = !!this.username;
    this.isEnglish = true;
    if(this.username) {
      function demoDisplay() {
        document.getElementById("hide")!.style.display = "none";
      }
    }

  }

  public goToService(id: number) {    
    window.location.replace('http://localhost:4200/serviceView/' + id);
  }

  signUp() {
    window.location.replace('http://localhost:4200/signUp');
  }

  signIn() {
    window.location.replace('http://localhost:4200/signIn');
  }

  changeLanguage() {
    this.isEnglish = !this.isEnglish;
  }

  ngOnInit() {
    this.getAllUsers();
    this.getAllServices();
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

  public getAllServices(): void {
    this.serviceServices.getAllServices().subscribe(
      (response: Service[]) => {
        this.services = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
