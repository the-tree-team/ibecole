
import {Sanction} from "./model.sanction";
import {Matiere} from "./model.matiere";
import {Absence} from "./model.absence";

export class Personne{

  id: number;

  nom: string;

  prenom: string;

  sexe: string;

  dateNaissance: any;

  lieuNaissance: string;

  adresse: string;

  telephone: string;

  email: string;

  photo: File;

  active: boolean;

  /* Eleve */
  /*idParent: number;*/
  matricule: string;

  parent: Personne;

  sanctionList: Sanction[];

  absenceList: Absence[];

  /* Parent */
  enfantList: Personne[];


  /*  Professuer  */
  dateRecrutement: any;

  matiereList: Matiere[];
  /* View */
  type: string;
}
