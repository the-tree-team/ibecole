/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author idirene.youcef
 */
@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "seance", uniqueConstraints
        = @UniqueConstraint(columnNames = {"id_groupe", "id_enseigner"}))
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_groupe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groupe idGroupe;

    @JoinColumn(name = "id_enseigner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enseigner idEnseigner;

    @Column(name = "heur_debut")
    private LocalTime heurDebut;

    @Column(name = "heur_fin")
    private LocalTime heurFin;

    private boolean supplementaire;

    private boolean supplementairePayee;
    @JoinColumn(name = "id_classe", referencedColumnName = "id")
    @ManyToOne
    private Classe classe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeance", orphanRemoval = true)
    private List<Absence> absences;
    
    @OneToMany(mappedBy = "seance")
    private List<SeanceSpecial> seanceSpecials;

    public Seance(Integer id) {
        this.id = id;
    }

}
