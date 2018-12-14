package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("Eleve") 
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Eleve extends Personne implements Serializable, Cloneable{

    @NotNull
    @Column(name = "matricule", unique = true)
    private String matricule;

    @JoinTable(
            schema = StaticUtil.SCH_BUSINESS,
            name = "join_eleve_parent",
            joinColumns = @JoinColumn(name = "parent_fk"),
            inverseJoinColumns = @JoinColumn(name = "enfant_fk")
    )
    @ManyToOne
    private Parent parent;

    @OneToMany(mappedBy = "eleve")
    private List<Sanction> sanctionList;


    @OneToMany(
            mappedBy = "eleve",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Absence> absenceList;

    @OneToMany(
            mappedBy = "eleve",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;

    public Object cloneEleve(){
        try {
            return this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
