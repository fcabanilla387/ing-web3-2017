package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.model.Usuario;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.GeneroDAO;
import ar.com.magm.ti.model.service.IGeneroService;
import ar.com.magm.ti.model.service.impl.GeneroService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GeneroTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Genero p = new Genero();
        p.setNombre("Clasica");
        p.setSubgeneros(new ArrayList<Subgenero>());
        p.setUsuarios(new ArrayList<Usuario>());

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }
    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Genero p = new Genero();
        p.setNombre("Punk");
        p.setSubgeneros(new ArrayList<Subgenero>());
        p.setUsuarios(new ArrayList<Usuario>());

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }
    @Test
    public void testUpdate() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Genero p = new Genero();
        p.setIdGenero(1);
        p.setNombre("Metal");
        p.setSubgeneros(new ArrayList<Subgenero>());
        p.setUsuarios(new ArrayList<Usuario>());
        try{
            p = service.update(p);
        }catch(NotFoundException e){
            
        }
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }
    @Test
    public void testList() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Genero> p = service.list();

        assertNotNull("Se generó la lista", p);
    }/*
    @Test
    public void testListFilter() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Album> p = service.list("eath");

        assertNotNull("No se generó la lista", p);
    }*/
    @Test
    public void testLoad() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Genero p = new Genero();
        p = null;
        try{
            p = service.load(1);
        }catch(NotFoundException e){
        }
        
        assertNotNull("No se cargo el genero");
    }/*
    @Test
    public void testDelete()  throws ServiceException{
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Genero p = new Genero();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro el genero", p);
    }*/
    
}
