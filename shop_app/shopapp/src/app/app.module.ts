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
    DisplayServiceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
