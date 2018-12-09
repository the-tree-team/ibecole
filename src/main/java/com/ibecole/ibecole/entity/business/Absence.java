/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import java.io.Serializable;
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
import lombok.ToString;

/**
 *
 * @author idirene.youcef
 */
@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "absence", uniqueConstraints
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

    @JoinColumn(name = "seance_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seance seance;

    @JoinColumn(name = "eleve_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Eleve eleve;

    @JoinColumn(name = "justificatif_fk", referencedColumnName = "id")
    @ManyToOne
    private Justificatif justificatif;
 

    public Absence(Integer id) {
        this.id = id;
    }
}
