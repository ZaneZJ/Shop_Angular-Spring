import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Bank } from '../bank';
import { Service } from '../service';
import { UserService } from '../user.service';
import { BankService } from '../bank.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  public users: User[];
  public services: Service[];
  public banks: Bank[];

  public deleteUser!: User;
  updatePasswordForm!: FormGroup;
  updateBanksForm!: FormGroup;
  updateAddressForm!: FormGroup;

  step = 0;
  
  currentPassword = new FormControl('password');
  newPassword = new FormControl('password');

  username!: string;
  name!: string;
  currentUser!: User;
  // value: string = this.cookieService.get('username');

  constructor(
    private userService: UserService,
    private cookieService: CookieService,
    private _formBuilder: FormBuilder,
    private serviceServices: ServiceService,
    private bankServices: BankService,
    private http: HttpClient,
    private router: Router
    ) {
    // Initialization inside the constructor
    this.users = [];
    this.services = [];
    this.banks = [];

    this.username = this.cookieService.get('username');
    this.userService.getUserByUsername(this.username).subscribe(user => this.currentUser = user);
    // if(this.username) {
    //   this.router.navigate(['/main']);
    // }
  }

  ngOnInit() {
    this.getAllUsers();
    this.getAllServices();
    this.updatePasswordForm = this._formBuilder.group({
      currentPassword: ['', Validators.required],
      newPassword: ['', Validators.required],
    });    
    this.updateBanksForm = this._formBuilder.group({
      newAccountNo: [''],
      newBeneficiary: [''],
      newTextBanks: [''],
    });    
    this.updateAddressForm = this._formBuilder.group({
      newAddress: [''],
      newPostalCode: [''],
    });
  }

  onLogOut() {

    console.log("before");
    console.log(this.cookieService.get('username'));
    this.cookieService.delete('username');
    console.log("after");
    console.log(this.cookieService.get('username'));
  }

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
    this.userService.getUserByUsername(this.username).subscribe(
      (response: User) => {
        if (this.updateAddressForm.value["newAddress"] != null && this.updateAddressForm.value["newAddress"] != this.currentUser.address) {
          response.address = this.updateAddressForm.value["newAddress"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed address details!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change address details!");
              alert(error.message);
            }
          );
        }
        if (this.updateAddressForm.value["newPostalCode"] != null && this.updateAddressForm.value["newPostalCode"] != this.currentUser.postalCode) {
          response.postalCode = this.updateAddressForm.value["newPostalCode"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed postal code!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change postal code!");
              alert(error.message);
            }
          );
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  saveBanksInfo() {
    // update bank, accountNo, beneficiary
    this.userService.getUserByUsername(this.username).subscribe(
      (response: User) => {
        if (this.updateBanksForm.value["newAccountNo"] != null && this.updateBanksForm.value["newAccountNo"] != this.currentUser.bank.accountNo) {
          response.bank.accountNo = this.updateBanksForm.value["newAccountNo"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed banks account numbers details!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change banks account numbers details!");
              alert(error.message);
            }
          );
        }
        if (this.updateBanksForm.value["newTextBanks"] != null && this.updateBanksForm.value["newTextBanks"] != this.currentUser.bank.textBanks) {
          response.bank.textBanks = this.updateBanksForm.value["newTextBanks"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed banks name!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change banks name!");
              alert(error.message);
            }
          );
        }
        if (this.updateBanksForm.value["newBeneficiary"] != null && this.updateBanksForm.value["newBeneficiary"] != this.currentUser.bank.beneficiary) {
          response.bank.beneficiary = this.updateBanksForm.value["newBeneficiary"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed banks beneficiarys details!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change beneficiarys details!");
              alert(error.message);
            }
          );
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  savePassword() {
    // update to new password
    this.userService.getUserByUsername(this.username).subscribe(
      (response: User) => {
        if (this.updatePasswordForm.value["currentPassword"] == this.currentUser.password) {
          response.password = this.updatePasswordForm.value["newPassword"];
          this.userService.updateUser(response).subscribe(
            (userResponse: User) => {
              alert("Changed password!");
            },
            (error: HttpErrorResponse) => {
              console.log("Failed to change password!");
              alert(error.message);
            }
          );
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  // FIXME:

  addService() {
    // rederect to URL to add service
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

  public onDeleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAllUsers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
