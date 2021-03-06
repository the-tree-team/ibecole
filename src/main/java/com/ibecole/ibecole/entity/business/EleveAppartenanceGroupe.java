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
@Table(schema = StaticUtil.SCH_BUSINESS, name = "join_eleve_appartenance_groupe")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class EleveAppartenanceGroupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eleve_fk")
    private Eleve eleve;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_fk")
    private Groupe groupe;

    @NotNull
    @Column(name = "formation_payee")
    private boolean formationPayee;


    @Column(name = "date_inscription")
    private LocalDate dateInscription;




}
