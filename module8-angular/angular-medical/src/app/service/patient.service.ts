import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Ville } from '../classes/ville';
import { HttpOptions } from '../config';

@Injectable({
  providedIn: 'root' // utilisable depuis n'importe quel composant de l'app
})
export class PatientService {

  constructor(private http : HttpClient) {}



  loadCities() : Observable<Ville[]> {
    return this.http.get<Ville[]>(environment.baseUrl + "ville", HttpOptions)

   }
}
