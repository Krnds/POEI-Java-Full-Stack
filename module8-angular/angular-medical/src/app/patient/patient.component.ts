import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Patient } from '../classes/patient';
import { environment } from 'src/environments/environment';
import { Ville } from '../classes/ville';

const httpOptions = {
  headers: new HttpHeaders({
    // 'Access-Control-Allow-Origin':'*',
    'Authorization': 'Basic ' + environment.basicAuth
  })
}

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

  constructor(private http: HttpClient) { }

  ngOnInit(): void {

    console.log(this.newPatient);
    // On initialization of Patient Component, call loadPatient
    this.loadPatients();
    this.loadCities();
  }


  loadPatients(): void {
    this.http.get<Patient[]>(environment.baseUrl + "patient",
      httpOptions).subscribe(
        data => {
          this.patients = data;
          console.log(data);
        }
      );
  }


  loadCities(): void {
    this.http.get<Ville[]>(environment.baseUrl + "ville", httpOptions).subscribe(data => {
      this.villes = data;
      console.log(data);
    });
  }


  addPatient(patient: Patient): void {
    this.http.post<Patient>(environment.baseUrl + "patient", httpOptions).subscribe(
      data => { this.newPatient = data;
        this.loadPatients(); }
    )
  }

  editPatient(id?: number): void {
    this.http.put<Patient>(environment.baseUrl + "patient/" + id, httpOptions).subscribe(data => {
      this.newPatient = data;
      console.log(this.newPatient);
      //TODO: test update après edit d'un patient
      this.loadPatients();
    })
  }

  // getPatient(id? : number) : void {
  //   this.http.get<Patient>(environment.baseUrl + "patient/" + id, httpOptions).subscribe(data => {

  //   })
  // }


  deletePatient(id?: number): void {
    this.http.delete<Patient>(environment.baseUrl + "patient", httpOptions).subscribe(data => {
      this.loadPatients();
    })
  }

  submitForm(): void {
    // méthode POST qui prend url + body + options (HttpHeaders)
    console.log(this.newPatient);
    this.http.post<Patient>(environment.baseUrl + "patient", this.newPatient, httpOptions).subscribe(
      data => {
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadPatients();
      }
    );
  }

}
