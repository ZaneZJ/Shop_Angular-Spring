import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  public users: User[];

  @Input() isEnglish: boolean;

  constructor(private userService: UserService){
    // Initialization inside the constructor
    this.users = [];
    
    this.isEnglish = true;
  }

  changeLanguage() {
    this.isEnglish = !this.isEnglish;
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

  formatLabel(value: number) {
    if (value >= 5) {
      return Math.round(value / 20000);
    }

    return value;
  }

}