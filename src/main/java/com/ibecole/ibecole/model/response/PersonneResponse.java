package com.ibecole.ibecole.model.response;

import com.ibecole.ibecole.entity.business.Absence;
import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Sanction;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonneResponse {
    private Integer id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateNaissance;

    private String lieuNaissance;

    private String adresse;

    private String telephone;

    private String email;

    private byte[] photo;

    private boolean active;

    /* Eleve----------------------------- */
    private String matricule;

    /*private Integer idParent;*/
    private Parent parent;

    private List<Sanction> sanctionList;


    private List<Absence> absenceList;
    /** Doit être supprimée car on n'affecte pas les groupes dans la création de l'élève, mais on affecte les élèves
     * au groupe, et donc ça doit être placé dans le groupe
     */
    //private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;

    /* Parent ----------------------------- */
    /** Cette liste doit aussi être changée en une lsite d'id personne puisque nous n'avons pas l'entité Parent coté
     * Angular
     */
    // private List<Eleve> enfantsList;
    private List<Integer> enfantList;

    /* Professeur----------------------------- */
    private LocalDate dateRecrutement;

    /** Cette Liste doit être changé en une liste de Matières qui va être par la suite mappée en une liste "Enseigner"**/
    //private List<Enseigner> enseigner;
    private List<Matiere> matiereList;

    /* VIEW */

    private String type;
}
