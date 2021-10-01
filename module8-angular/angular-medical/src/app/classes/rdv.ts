import { Patient } from "./patient";

export class Rdv {

    id : number | undefined;
    dateheure : Date | undefined;
    type : String | undefined;
    duree : number | undefined;
    note : String | undefined;
    patient : Patient | undefined;

    constructor( id?: number | undefined, dateheure?: Date | undefined, type?: String | undefined, duree?: number | undefined, note?: String | undefined, patient?: Patient | undefined ) {
        this.id = id;
        this.dateheure = dateheure;
        this.type = type;
        this.duree = duree;
        this.note = note;
        this.patient = patient;
    }

}
