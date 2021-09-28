import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Ville } from '../classes/ville';
import { HttpOptions } from '../config';

@Injectable({
  providedIn: 'root'
})
export class VilleService {

  constructor(private http: HttpClient) { }

  loadCities() : Observable<Ville[]> {
    return this.http.get<Ville[]>(environment.baseUrl + "ville", HttpOptions)
   }

   addVille(ville : Ville) : Observable<Ville> {
    return this.http.post<Ville>(environment.baseUrl + "ville", ville, HttpOptions);
  }

   getVille(id? : number) : Observable<Ville> {
    return this.http.get<Ville>(environment.baseUrl + "ville/" + id, HttpOptions);
  }

  editVille(ville : Ville) : Observable<Ville> {
    return this.http.put<Ville>(environment.baseUrl + "ville/" + ville.id, ville, HttpOptions);
  }

  deleteVille(id? : number) : Observable<Ville> {
    return this.http.delete<Ville>(environment.baseUrl + "ville/" + id, HttpOptions);
  }
}
