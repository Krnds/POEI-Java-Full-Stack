import { Component, OnInit, ViewChild } from '@angular/core';
import { Rdv } from '../classes/rdv';
import { RdvService } from '../service/rdv.service';

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {

  newRdv: Rdv = new Rdv();
  rdv: Array<Rdv> = [];
  @ViewChild('closebutton') closebuttonelement: any;
  success: boolean = false;
  error: boolean = false;

  constructor(private rdvService: RdvService) { }

  ngOnInit(): void {
    this.loadRdv();
  }

  loadRdv(): void {
    this.rdvService.loadRdv().subscribe(data => {
      this.rdv = data;
      console.log(data);
    })
  }

  editRdv(id?: number): void {
    this.rdvService.getRdv(id).subscribe(data => {
      this.newRdv = data;
      this.loadRdv();
      this.success = true;
      console.log(data);
    })
  }

  deleteRdv(id?: number): void {
   if (confirm("Voulez-vous vraiment supprimer ce rendez-vous ?")) {
    this.rdvService.deleteRdv(id).subscribe(data => {
      this.loadRdv();
      this.success = true;
    })
  } else {
    this.error = true;
  }
  }


  submitForm(): void {
    if (this.newRdv.id == undefined) {
      this.rdvService.addRdv(this.newRdv).subscribe(data => {
        this.closebuttonelement.nativeElement.click();
        this.loadRdv();
        this.success = true;
      })
    } else {
      this.rdvService.editRdv(this.newRdv).subscribe(data => {
        this.closebuttonelement.nativeElement.click();
        this.loadRdv();
        this.success = true;
      })
    }

  }

}
