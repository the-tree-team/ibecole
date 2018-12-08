package com.ibecole.ibecole.entity.business;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@DiscriminatorValue("Professeur")
@Getter
@Setter
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Professeur extends Personne implements Serializable {

    @Column(name = "date_recrutement")
    private LocalDate dateRecrutement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesseur", orphanRemoval = true)
    private List<Enseigner> enseigner;
}
