import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { PatientComponent } from './patient/patient.component';
import { RdvComponent } from './rdv/rdv.component';
import { DetailsComponent } from './ville/details/details.component';
import { VilleComponent } from './ville/ville.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'ville/addedit/:id', component: DetailsComponent },
  {
    path: '', component: MainComponent, canActivate: [AuthGuard], children:
      [
        { path: 'patient', component: PatientComponent, canActivate: [AuthGuard] },
        { path: 'ville', component: VilleComponent, canActivate: [AuthGuard] },
        { path: 'rdv', component: RdvComponent, canActivate: [AuthGuard] },]
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
