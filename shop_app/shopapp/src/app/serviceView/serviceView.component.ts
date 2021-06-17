import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Service } from '../service';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-serviceView',
  templateUrl: './serviceView.component.html',
  styleUrls: ['./serviceView.component.css']
})
export class ServiceViewComponent implements OnInit {

  @Input() isLoggedIn: boolean;
  username!: string;
  service!: Service;
  id!: number;

  constructor(
    private userService: UserService,
    private serviceService: ServiceService,
    private cookieService: CookieService,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute){

    this.username = this.cookieService.get('username');
    this.isLoggedIn = !!this.username;
    if(this.username) {
      function demoDisplay() {
        document.getElementById("hide")!.style.display = "none";
      }
    }
  }

  ngOnInit() {
    var serviceIdParam = this.route.snapshot.paramMap.get("service");
    var serviceId: number = parseInt(serviceIdParam!);
    this.serviceService.getAllServices().subscribe(
      (response: Service[]) => {
        response.forEach(s => {
          if (s.serviceId == serviceId) {
            this.service = s;
          }
        })
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}