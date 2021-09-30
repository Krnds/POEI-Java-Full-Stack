import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { Ville } from 'src/app/classes/ville';
import { VilleService } from 'src/app/service/ville.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  newVille: Ville = new Ville();

  constructor(private vs: VilleService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // current snapshot of this route
    let villeId = this.activatedRoute.snapshot.paramMap.get('id');
    this.vs.getVille(Number(villeId)).subscribe(data => {
      console.log(data);
      this.newVille = data;
    })
  }

  submitForm() {
    console.log(this.newVille);
    if (this.newVille.id == undefined) {
      this.vs.addVille(this.newVille).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['ville'])
        }
      )
    } else {
      this.vs.editVille(this.newVille).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['ville'])
        }
      )
    }
  }

}
