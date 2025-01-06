import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginLayoutComponent } from './layout/login-layout/login-layout.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { HeaderComponent } from './components/main/header/header.component';
import { BodyComponent } from './components/main/body/body.component';
import { SideBarIzqComponent } from './components/main/side-bar-izq/side-bar-izq.component';
import { SideBarDerComponent } from './components/main/side-bar-der/side-bar-der.component';
import { FooterComponent } from './components/main/footer/footer.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { ForumPageComponent } from './pages/forum-page/forum-page.component';
import { SubjectPageComponent } from './pages/subject-page/subject-page.component';
import { CoursePageComponent } from './pages/course-page/course-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginLayoutComponent,
    MainLayoutComponent,
    MainPageComponent,
    LoginPageComponent,
    HeaderComponent,
    BodyComponent,
    SideBarIzqComponent,
    SideBarDerComponent,
    FooterComponent,
    AuthPageComponent,
    UserPageComponent,
    ForumPageComponent,
    SubjectPageComponent,
    CoursePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
