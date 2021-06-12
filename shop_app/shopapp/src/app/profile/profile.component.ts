import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  public users: User[];

  public deleteUser!: User;

  step = 0;

  currentPassword = new FormControl('password');
  newPassword = new FormControl('password');

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

  // FIXME: connect to databasee

  saveEmailPhoneURL() {
    // update email, phoneNo, pictureMain
  }

  saveAddressPostCode() {
    // update address, postalCode
  }

  saveBanksInfo() {
    // update bank, accountNo, beneficiary
  }

  savePassword() {
    // update to new password
  }

  // FIXME:

  addService() {
    // rederect to URL to add service
  }

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

  public onDeleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUsers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
