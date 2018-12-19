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
@Table(schema = StaticUtil.SCH_BUSINESS, name = "formation_contient_matiere", uniqueConstraints
        = @UniqueConstraint(columnNames = {"matiere_fk", "formation_fk"}))
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Contient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "matiere_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Matiere matiere;

    @JoinColumn(name = "formation_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Formation formation;

    @JoinColumn(name = "unitee_fk", referencedColumnName = "id")
    @ManyToOne
    private Unitee unitee;

    @ManyToOne
    private Niveau niveau;

    public Contient(Integer id) {
        this.id = id;
    }
}
