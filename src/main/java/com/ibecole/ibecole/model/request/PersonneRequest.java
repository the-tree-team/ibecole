package com.ibecole.ibecole.model.request;

import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.entity.business.Parent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonneRequest {

    private Integer id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateNaissance;

    private String lieuNaissance;

    private String adresse;

    private String telephone;

    private String email;

    private MultipartFile photo;

    private boolean active;

    /* Eleve----------------------------- */
    /** Pas besoin du matricule parcequ'on le crée nous même avant de persister **/
    //private String matricule;

    /** Doit être changé en idParent car on n'a pas le model parent dans le coté Angular **/
    private Parent parent;
/*    private Integer idParent;*/
/* On ne doit pas lui créer les sanctions et les absences alors qu'il n'existe même pas dans notre S.I

    private List<Sanction> sanctionList;


    private List<Absence> absenceList;
*/
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
