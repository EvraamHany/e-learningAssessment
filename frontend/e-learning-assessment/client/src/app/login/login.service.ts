import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Student } from '../models/student';

@Injectable()
export class LoginService {

	constructor(private http: HttpClient){

	}
	
	validateLogin(student: Student){
		return this.http.post('http://localhost:8080/login',{
			username : student.username,
			password : student.password
		})
	}

}