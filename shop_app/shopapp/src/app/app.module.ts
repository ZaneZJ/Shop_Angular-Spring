import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './signUp/signUp.component';
import { SignInComponent } from './signIn/signIn.component';
import { ProfileComponent } from './profile/profile.component';
import { MainComponent } from './main/main.component';
import { EditProfileComponent } from './editProfile/editProfile.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    SignInComponent,
    ProfileComponent,
    MainComponent,
    EditProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
