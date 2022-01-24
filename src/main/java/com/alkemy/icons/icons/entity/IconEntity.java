
package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String imagen;
    
    private String denominacion;
    
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long historia;
    
    //private boolean deleted = Boolean.FALSE;
    @ManyToMany(
            mappedBy = "icon",
            cascade = CascadeType.ALL,
            fetch  = FetchType.LAZY
    )
    private List<PaisEntity> pais = new ArrayList<>();
    
    //add and remove paises
    /**
    
    public void addPais(PaisEntity pais){
        this.paises.add(pais);
    }
    public void removePais(PaisEntity pais){
        this.paises.remove(pais);
    }
    * */
}
