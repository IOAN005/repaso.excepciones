package com.corenetworks.repaso.excepciones.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private int productoId;
    @Column(length = 60,nullable = false)
    private String nombreProducto;
    private double precio;

}
