import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Patient } from '../classes/patient';
import { Ville } from '../classes/ville';
import { PatientService } from '../service/patient.service';

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
  success: boolean = false;

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
      this.loadPatients();
      this.success = true;
    })
  }

  deletePatient(id?: number): void {
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
        this.success = true;
      })
    } else {
      this.ps.editPatient(this.newPatient).subscribe(data => {
        console.log("submit form si id reconnu");
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadPatients();
        this.success = true;
      })
    }

  }

  comparePatientCity(v1 : Ville, v2 : Ville): boolean {
    return v1 != undefined && v2 != undefined && v1.id == v2.id;
  }

}
