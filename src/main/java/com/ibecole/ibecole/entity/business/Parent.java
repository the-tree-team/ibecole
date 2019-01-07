package com.ibecole.ibecole.entity.business;


import com.ibecole.ibecole.commun.StaticUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("Parent")
@XmlRootElement
@Data
@NoArgsConstructor
@ToString(of = "id", doNotUseGetters = true)
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public class Parent extends Personne implements Serializable, Cloneable {

    @JoinTable(
            schema = StaticUtil.SCH_BUSINESS,
            name = "join_eleve_parent",
            joinColumns = @JoinColumn(name = "parent_fk"),
            inverseJoinColumns = @JoinColumn(name = "enfant_fk")
    )
    @OneToMany
    private List<Eleve> enfantList;

    public Object cloneParent(){
        try {
            return this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
