import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Ville } from '../classes/ville';
import { environment } from 'src/environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    // 'Access-Control-Allow-Origin':'*',
    'Authorization': 'Basic ' + environment.basicAuth
  })
}

@Component({
  selector: 'app-ville',
  templateUrl: './ville.component.html',
  styleUrls: ['./ville.component.css']
})
export class VilleComponent implements OnInit {

  villes : Array<Ville> = []
  nom : string = ""
  newVille : Ville = new Ville();
  @ViewChild ('closebutton') closebuttonelement : any;

  constructor( private http : HttpClient ) { }

  ngOnInit(): void {

    this.updateCities()
  }

  updateCities() : void {
    this.http.get<Ville[]>(environment.baseUrl  + "ville" ,
    httpOptions ).subscribe(
     data => {
       this.villes = data;
       console.log( data );
     }
   );
  }

  submitForm() : void {
    console.log( this.newVille );
    this.http.post<Ville>(environment.baseUrl + "ville" , this.newVille , httpOptions ).subscribe(
      data => { console.log( data ); this.updateCities() }
    )
  }

}