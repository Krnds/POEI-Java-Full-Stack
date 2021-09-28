import { Ville } from "./ville";

export class Patient {

     id: number | undefined;
     nom : string | undefined;
     prenom : string | undefined;
     telephone : string | undefined;
     email : string | undefined;
     ville : Ville | undefined;

    constructor(_id? : number | undefined,  nom? : string | undefined, prenom? : string | undefined, telephone? : string | undefined, email? : string | undefined, ville? : Ville | undefined) {
        this.id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.ville = ville;
        this.email = email;

    }

}
