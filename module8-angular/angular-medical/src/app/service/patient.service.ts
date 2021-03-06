import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Patient } from '../classes/patient';
import { Ville } from '../classes/ville';
import { HttpOptions } from '../config';

@Injectable({
  providedIn: 'root' // utilisable depuis n'importe quel composant de l'app
})

export class PatientService {

  constructor(private http: HttpClient) { }

  loadPatients(search: String): Observable<Patient[]> {
    let searchCondition = ""
    if (search.length > 0) {
      searchCondition = "?search=" + search;
    }
    console.log("recherche des Patients");
    return this.http.get<Patient[]>(environment.baseUrl + "patient" + searchCondition, HttpOptions);
  }

  loadCities(search : String): Observable<Ville[]> {
    return this.http.get<Ville[]>(environment.baseUrl + "ville", HttpOptions)
  }

  addPatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(environment.baseUrl + "patient", patient, HttpOptions);
  }

  getPatient(id?: number): Observable<Patient> {
    return this.http.get<Patient>(environment.baseUrl + "patient/" + id, HttpOptions);
  }

  editPatient(patient: Patient): Observable<Patient> {
    return this.http.put<Patient>(environment.baseUrl + "patient/" + patient.id, patient, HttpOptions);
  }

  deletePatient(id?: number): Observable<any> { //TODO: observable de patient ou any ???
    console.log("service delete patient");

    return this.http.delete<Patient>(environment.baseUrl + "patient/" + id, HttpOptions);
  }
}
