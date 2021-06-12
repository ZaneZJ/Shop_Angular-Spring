import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatSliderModule } from '@angular/material/slider';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SignUpComponent } from './signUp/signUp.component';
import { AppRoutingModule } from './app-routing.module';
import { MaterialModule } from './material.module';
import { SignInComponent } from './signIn/signIn.component';
import { ProfileComponent } from './profile/profile.component';
import { MainComponent } from './main/main.component';
import { EditProfileComponent } from './editProfile/editProfile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProfileAllSeeComponent } from './profileAllSee/profileAllSee.component';
import { AddServiceComponent } from './addService/addService.component';
import { DisplayServiceComponent } from './displayService/displayService.component';
import { ServiceViewComponent } from './serviceView/serviceView.component';
import { UserService } from './user.service';
import { TextService } from './text.service';
import { ServiceService } from './service.service';
import { ReviewService } from './review.service';
import { PicturesService } from './pictures.service';
import { InstanceService } from './instance.service';
import { ChatService } from './chat.service';
import { BankService } from './bank.service';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    SignInComponent,
    ProfileComponent,
    MainComponent,
    EditProfileComponent,
    ProfileAllSeeComponent,
    AddServiceComponent,
    DisplayServiceComponent,
    ServiceViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
  ],
  providers: [
    UserService,
    TextService,
    ServiceService,
    ReviewService,
    PicturesService,
    InstanceService,
    ChatService,
    BankService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
