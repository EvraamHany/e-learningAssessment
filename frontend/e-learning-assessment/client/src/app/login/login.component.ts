import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { Student } from '../models/student';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ LoginService ]
})
export class LoginComponent {

  public student : Student;

  constructor(private loginService: LoginService, private router: Router) {
  	this.student = new Student();
  }

  validateLogin() {
  
    if(this.student.username && this.student.password) {
  		this.loginService.validateLogin(this.student).subscribe(result => {
        console.log('result is ', result);
        if(result['status'] != null) {
          this.router.navigate(['/home']);
        } else {
          alert('Wrong username or password');
        }
        
      }, error => {
        console.log('error is ', error);
      });
  	} else {
  		alert('enter user name and password');
  	}
       
  }

}
