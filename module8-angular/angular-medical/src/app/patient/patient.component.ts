import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Patient } from '../classes/patient';
import { environment } from 'src/environments/environment';
import { Ville } from '../classes/ville';
import { PatientService } from '../service/patient.service';


// const httpOptions = {
//   headers: new HttpHeaders({
//     // 'Access-Control-Allow-Origin':'*',
//     'Authorization': 'Basic ' + environment.basicAuth
//   })
// }

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  newPatient: Patient = new Patient();

  patients: Array<Patient> = [];
  villes: Array<Ville> = [];
  @ViewChild('closebutton') closebuttonelement: any;

  constructor(private ps: PatientService) { }

  ngOnInit(): void {
    // On initialization of Patient Component, call loadPatient
    this.loadPatients();
    this.loadCities();
  }

  currentVille : string | undefined;

  loadPatients(): void {
    this.ps.loadPatients().subscribe(
      data => {
        this.patients = data;
        console.log(data);
      }
    );
  }


  loadCities(): void {
    this.ps.loadCities().subscribe(data => {
      this.villes = data;
      console.log(data);
    });
  }

  editPatient(id?: number): void {
    this.ps.getPatient(id).subscribe(data => {
      this.newPatient = data;
      this.currentVille = this.newPatient.ville?.nom;
      console.log(this.newPatient);
      //TODO: test update après edit d'un patient
      this.loadPatients();
    })
  }

  deletePatient(id?: number): void {
    console.log("méthode delete patient");
    this.ps.deletePatient(id).subscribe(data => {
      this.loadPatients();
    })
  }

  submitForm(): void {
    if (this.newPatient.id == undefined) {
      this.ps.addPatient(this.newPatient).subscribe(data => {
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadPatients();
      })
    } else {
      this.ps.editPatient(this.newPatient).subscribe(data => {
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadPatients();
      })
    }

  }

}
