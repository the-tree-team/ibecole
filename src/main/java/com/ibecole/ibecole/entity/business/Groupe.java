package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "groupe")
@Getter
@Setter
public class Groupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @NotNull
    @Column(name = "nombre_max_eleve")
    private Integer nombeMaxEleve;

    @OneToOne
    @JoinColumn(name = "periode_actuelle_fk")
    private Periode periodeActuelle;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            schema = StaticUtil.SCH_BUSINESS,
            name = "join_groupe_periode",
            joinColumns = @JoinColumn(name = "groupe_fk"),
            inverseJoinColumns = @JoinColumn(name = "periode_fk")
    )
    private List<Periode> periodeList;

    @OneToMany(
            mappedBy = "groupe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EleveAppartenanceGroupe> eleveAppartenanceGroupeList;

    @ManyToOne
    private Niveau niveau ;
    
}
