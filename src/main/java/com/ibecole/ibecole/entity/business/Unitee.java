package com.ibecole.ibecole.entity.business;

import com.ibecole.ibecole.commun.StaticUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = StaticUtil.SCH_BUSINESS, name = "unitee")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Unitee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code", length = 250)
    private String code;

    @Column(name = "libelle", length = 250)
    private String libelle;

    @OneToMany(mappedBy = "unitee")
    private List<Contient> contientList;

}
