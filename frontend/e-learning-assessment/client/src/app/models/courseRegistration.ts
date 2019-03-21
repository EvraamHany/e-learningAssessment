import { Course } from "./course";
import { Student } from "./student";

export class CourseRegistration {
	constructor(){
		this.course = null;
		this.student = null;
	}
	public id;
	
	public course: Course;
	public student: Student;
}