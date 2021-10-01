import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Rdv } from '../classes/rdv';
import { HttpOptions } from '../config';

@Injectable({
  providedIn: 'root'
})
export class RdvService {

  constructor(private http: HttpClient) { }


  loadRdv(): Observable<Rdv[]> {
    return this.http.get<Rdv[]>(environment.baseUrl + "rdv", HttpOptions);
  }


  addRdv(rdv: Rdv): Observable<Rdv> {
    return this.http.post<Rdv>(environment.baseUrl + "rdv", rdv, HttpOptions);
  }

  getRdv(id?: number): Observable<Rdv> {
    return this.http.get<Rdv>(environment.baseUrl + "rdv/" + id, HttpOptions);
  }

  editRdv(rdv: Rdv): Observable<Rdv> {
    return this.http.put<Rdv>(environment.baseUrl + "rdv/" + rdv.id, rdv, HttpOptions);
  }

  deleteRdv(id?: number): Observable<any> { //TODO: observable de rdv ou any ???
    console.log("service delete rdv called");
    return this.http.delete<Rdv>(environment.baseUrl + "rdv/" + id, HttpOptions);
  }
}
