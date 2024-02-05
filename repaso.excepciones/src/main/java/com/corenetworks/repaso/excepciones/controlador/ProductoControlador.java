package com.corenetworks.repaso.excepciones.controlador;

import com.corenetworks.repaso.excepciones.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.repaso.excepciones.modelo.Producto;
import com.corenetworks.repaso.excepciones.service.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    private IProductoServicio servicio;
@PostMapping
    public ResponseEntity<Producto> insertar(@RequestBody Producto p) throws Exception {
        Producto p1 = servicio.listarUno(p.getProductoId());
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + p.getProductoId());
        }
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicio.listarTodos(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> consultarUno(@PathVariable(name = "id") int id) throws Exception {
        Producto p1 = servicio.listarUno(id);
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + id);
        }
        return new ResponseEntity<>(servicio.listarUno(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable(name = "id") int id) throws Exception {
        Producto p1 = servicio.listarUno(id);
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Producto no encontrado con ID" + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}