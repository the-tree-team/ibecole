package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "annee_scolaire")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class AnneeScolaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Column(name = "libelle", length = 10, nullable = false)
    private String libelle;

    @NotNull
    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @NotNull
    @Column(name = "date_fin")
    private LocalDate dateFin;


    @OneToMany(mappedBy = "anneeScolaire")
    private List<Periode> periodeList;
}
