export class Ville {

     id: number | undefined;
     nom : string | undefined;
     codePostal : number | undefined;



    constructor(_id? : number | undefined, _nom? : string | undefined, _codePostal? : number | undefined) {
        this.id = _id;
        this.nom = _nom;
        this.codePostal = _codePostal;

    }

}
