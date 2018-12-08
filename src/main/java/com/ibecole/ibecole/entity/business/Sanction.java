package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "sanction")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Sanction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "motif", length = 250)
    private String motif;

    @Column(name = "commentaire", length = 250)
    private String commentaire;

    @Column(name = "date")
    private LocalDate date;



    @ManyToOne
    private TypeSanction type;

    @JoinTable(
            schema = StaticUtil.SCH_BUSINESS,
            name = "join_eleve_sanction",
            joinColumns = @JoinColumn(name = "eleve_fk"),
            inverseJoinColumns = @JoinColumn(name = "sanction_fk")
    )
    @ManyToOne
    private Eleve eleve;
}