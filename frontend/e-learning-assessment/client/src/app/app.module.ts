import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ROUTING } from './app.routing';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RootComponent } from './root/root.component';
import { LoginComponent } from './login/login.component';
import { ShowAllCoursesComponent } from './show-all-courses/show-all-courses.component';
import { CommonService } from './service/common.service';






@NgModule({
  declarations: [
  	RootComponent,
    LoginComponent,
    ShowAllCoursesComponent
  ],
  imports: [
    BrowserModule,
    ROUTING,
    FormsModule,
    HttpClientModule,
  ],

  providers: [CommonService],
  bootstrap: [RootComponent]
})
export class AppModule { }
