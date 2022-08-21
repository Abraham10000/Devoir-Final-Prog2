package com.example.demo.example.model;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Erole name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Erole getName() {
        return name;
    }

    public void setName(Erole name) {
        this.name = name;
    }
}
