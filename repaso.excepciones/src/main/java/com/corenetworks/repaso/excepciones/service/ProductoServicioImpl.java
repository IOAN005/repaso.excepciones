package com.corenetworks.repaso.excepciones.service;

import com.corenetworks.repaso.excepciones.modelo.Producto;
import com.corenetworks.repaso.excepciones.repository.IGenericoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl extends ICRUDImpl<Producto,Integer> implements IProductoServicio{
    @Autowired
    private IGenericoRepositori repo;

    @Override
    protected IGenericoRepositori<Producto, Integer> getRepo() {
        return repo;
    }
}
