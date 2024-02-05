package com.corenetworks.repaso.excepciones.service;

import com.corenetworks.repaso.excepciones.repository.IGenericoRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public  abstract   class ICRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericoRepositori<T,ID> getRepo() ;
    @Override
    public List<T> listarTodos() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarUno(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T insertar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);


    }




}
