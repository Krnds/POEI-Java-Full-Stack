import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Ville } from '../classes/ville';
import { VilleService } from '../service/ville.service';

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
  success : boolean = false;
  error : boolean = false;
  search : String = "";

  constructor( private vs : VilleService ) { }

  ngOnInit(): void {
    this.loadCities();
  }

  loadCities(): void {
    console.log(this.search);
    this.vs.loadCities(this.search).subscribe(data => {
      this.villes = data;
      console.log(data);
    });
  }

  editCity(id?: number): void {
    this.vs.getVille(id).subscribe(data => {
      this.newVille = data;
      console.log(this.newVille);
      this.loadCities();
      //TODO: add this.success = true;
    })
  }

  deleteCity(id?: number): void {
    if (confirm ("Etes-vous sûrs de vouloir supprimer ?")) {
      this.vs.deleteVille(id).subscribe(data => {
        this.loadCities();
      })
    }
  }

  submitForm(): void {
    if (this.newVille.id == undefined) {
      this.vs.addVille(this.newVille).subscribe(data => {
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadCities();
        //TODO: add this.success = true;
      })
    } else {
      this.vs.editVille(this.newVille).subscribe(data => {
        console.log(data);
        this.closebuttonelement.nativeElement.click();
        this.loadCities();
        //TODO: add this.success = true;
      })
    }

  }

   onSave() {
     console.log("on save called");
     
    this.closebuttonelement.nativeElement.click();
  }

}