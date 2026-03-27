package com.example.proyectoregistroh2.logic;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "linea")
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento", nullable = false)
    private Documento documento;

    @Column(name = "cantidad")
    private Integer cantidad;

}

//Como si la hubiese escrito a mano:

//@Getter
//@Setter
//@Entity
//@Table(name = "linea")
//
//public class Linea {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @ManyToOne
//    private Usuario usuario;
//
//    @ManyToOne
//    private Documento documento;
//
//    private int cantidad;
//}