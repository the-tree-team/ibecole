package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.TypeFormation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "formation")
@XmlRootElement
@Data
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true) 
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "intitulee", length = 30, nullable = false)
    private String intitulee;

    private boolean acceleree;

    @Column(name = "prix")
    private BigDecimal prix;

    @Column(name = "total_heur")
    private Integer totalHeur;

    @ManyToOne
    @JoinColumn(name = "type_formation")
    private TypeFormation sexe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatiere")
    private List<Contient> inFormation;

    private boolean active;
}
