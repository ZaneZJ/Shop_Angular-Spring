import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../user';
import { Service } from '../service';
import { UserService } from '../user.service';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-profileAllSee',
  templateUrl: './profileAllSee.component.html',
  styleUrls: ['./profileAllSee.component.css'],
})
export class ProfileAllSeeComponent implements OnInit {
  public users: User[];
  public services: Service[];

  @Input() isLoggedIn: boolean;
  username!: string;

  constructor(
    private userService: UserService,
    private serviceService: ServiceService,
    private cookieService: CookieService,
    private http: HttpClient,
    private router: Router) {
    // Initialization inside the constructor
    this.users = [];
    this.services = [];

    this.username = this.cookieService.get('username');
    this.isLoggedIn = !!this.username;
    if(this.username) {
      function demoDisplay() {
        document.getElementById("hide")!.style.display = "none";
      }
    }
  }

  ngOnInit() {
    this.getAllUsers();
    this.getAllServices();
  }

  public getAllServices(): void {
    this.serviceService.getAllServices().subscribe(
      (response: Service[]) => {
        this.services = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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
