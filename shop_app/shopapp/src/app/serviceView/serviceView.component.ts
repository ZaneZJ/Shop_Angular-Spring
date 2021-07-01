import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { Instance } from '../instance';
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
  @Input() isEnglish: boolean;
  username!: string;
  user!: User;
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
    this.isEnglish = true;
    if(this.username) {
      function demoDisplay() {
        document.getElementById("hide")!.style.display = "none";
      }
    }
  }

  buyService(instances: any){
    if(instances.count) {
      instances.count++;
    } else {
      instances.count=1;
    }
  }

  changeLanguage() {
    this.isEnglish = !this.isEnglish;
  }

  ngOnInit() {
    this.getUser();
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

  public getUser(): void {
    this.userService.getAllUsers().subscribe(
      (response: User[]) => {
        response.forEach(u => {
          if (u.username == this.username) {
            this.user = u;
            return;
          }
        })
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public deleteService() {
    this.serviceService.deleteService(this.username, this.service.serviceId).subscribe(
      (response: void) => {
        alert("Service deleted successfully!");
        window.location.href='http://localhost:4200/main';
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}