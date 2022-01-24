package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pais")
@Getter
@Setter
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie;//m2

    
   
 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    
    private ContinenteEntity continente;

    //guardar y actualizar
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;
    
    
  @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )@JoinTable(

            name = "iconPais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id")

    )

    private List<IconEntity> icon = new ArrayList<>();


    /**
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PaisEntity other = (PaisEntity) obj;
        return other.id == this.id;
    }
    * */
}
