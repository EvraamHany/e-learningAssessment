import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core/src/metadata/ng_module';

import { LoginComponent } from './login/login.component';
import { ShowAllCoursesComponent } from './show-all-courses/show-all-courses.component';

export const AppRoutes: Routes = [
	{ path: '', component: LoginComponent },
	{ path: '/showAllCourses', component: ShowAllCoursesComponent}
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(AppRoutes);