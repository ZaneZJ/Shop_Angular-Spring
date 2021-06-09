import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './signUp/signUp.component';
// import { SignInComponent } from './signIn/signIn.component';
// import { ProfileComponent } from './profile/profile.component';
// import { MainComponent } from './main/main.component';
// import { EditProfileComponent } from './editProfile/editProfile.component';

const routes: Routes = [
  {
    path: 'signUp',
    component: SignUpComponent
  }
  // {
  //   path: 'signIn',
  //   component: SignInComponent
  // },
  // {
  //   path: 'profile',
  //   component: ProfileComponent
  // },
  // {
  //   path: 'main',
  //   component: MainComponent
  // },
  // {
  //   path: 'editProfile',
  //   component: EditProfileComponent
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
