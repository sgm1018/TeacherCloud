import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { LoginLayoutComponent } from './layout/login-layout/login-layout.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { MainPageComponent } from './pages/main-page/main-page.component';

const routes: Routes = [
  { path: 'auth', component: LoginLayoutComponent , children:
    [
      {path : 'login', component: LoginPageComponent},
    ],
  },
  { path: 'main', component: MainLayoutComponent, children: [
    {path : 'user', component: LoginPageComponent},
    {path : 'course', component: LoginPageComponent},
    {path : 'subject', component: LoginPageComponent},
    {path : 'forum', component: LoginPageComponent},
    {path : 'login', component: LoginPageComponent},
    {path: '', component: MainPageComponent},
  ],
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
