/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import com.ibecole.ibecole.commun.enumerate.TypeExamen;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author idirene.youcef
 */
@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "examen", uniqueConstraints
        = @UniqueConstraint(columnNames = {"enseigner_fk", "eleve_fk"}))
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "enseigner_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Enseigner enseigner;

    @JoinColumn(name = "eleve_fk", referencedColumnName = "id",
            nullable = false)
    @ManyToOne
    private Eleve eleve;

    private BigDecimal note;

    @Column(name = "date_examen")
    private LocalDate dateExamen;

    @NotNull
    @Column(name = "type_examen", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeExamen typexamens;

    public Examen(Integer id) {
        this.id = id;
    }
}
