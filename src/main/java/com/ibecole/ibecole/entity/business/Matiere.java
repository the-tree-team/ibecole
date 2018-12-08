package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "matiere")
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Matiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code", length = 5, nullable = false)
    private String code;

    @NotNull
    @Column(name = "libelle", length = 10, nullable = false)
    private String libelle;

    @NotNull
    @Column(name = "couleur", length = 10, nullable = false)
    private String couleur;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatiere", orphanRemoval = true)
    private List<Contient> inFormation;
}
