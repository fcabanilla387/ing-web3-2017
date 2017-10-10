package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Cancion;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.AlbumDAO;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.model.service.impl.AlbumService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AlbumTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Album p = new Album();
        p.setAño(1990);
        p.setNombre("Death Magnetic");
        p.setListaCanciones(new ArrayList<Cancion>());

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Album p = new Album();
        p.setAño(1832);
        p.setNombre("Dark side of the moon");
        p.setListaCanciones(new ArrayList<Cancion>());

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testUpdate() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Album p = new Album();
        p.setId(1);
        p.setAño(2000);
        p.setNombre("Iowa");
        p.setListaCanciones(new ArrayList<Cancion>());
        try{
            p = service.update(p);
        }catch(NotFoundException e){
            
        }
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testList() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Album> p = service.list();

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
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Album p = new Album();
        p = null;
        try{
            p = service.load(1);
        }catch(NotFoundException e){
        }
        
        assertNotNull("No se cargo el album");
    }
    @Test
    public void testDelete()  throws ServiceException{
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Album p = new Album();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro el Album", p);
    }
    
}
