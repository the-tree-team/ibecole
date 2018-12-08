package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;
import com.ibecole.ibecole.commun.enumerate.TypeSanction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "sanction")
@Getter
@Setter
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


    @NotNull
    @Column(name = "type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
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
