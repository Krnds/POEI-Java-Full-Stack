import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpOptions } from '../config';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  authenticate(user : any) {
    return this.http.post<any>(environment.baseUrl + "login", user, HttpOptions);
  }
}
