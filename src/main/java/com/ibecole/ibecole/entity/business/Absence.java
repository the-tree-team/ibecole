/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author idirene.youcef
 */
@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "absence",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"eleve_fk", "seance_fk"}))
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @JoinColumn(name = "seance_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Seance seance;

    @JoinColumn(name = "eleve_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Eleve eleve;

    @JoinColumn(name = "justificatif_fk", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Justificatif justificatif;

    public Absence() {
    }

    public Absence(Integer id) {
        if(id!=null)
        this.id = id;
    }
}
