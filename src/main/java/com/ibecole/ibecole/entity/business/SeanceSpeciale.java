package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "seance_speciale")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class SeanceSpeciale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code", length = 250)
    private String code;

    @Column(name = "date")
    private LocalDate date;
    
    @Column(name = "heur_debut")
    private LocalTime heurDebut;
    
    @Column(name = "heur_fin")
    private LocalTime heurFin;
    
    @Column(name = "prof_present")
    private boolean profPresent;
    
    @Column(name = "libelle", length = 250)
    private String libelle;
 
    @ManyToOne
    private Seance seance;
}
