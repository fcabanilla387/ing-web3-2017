package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.Playlist;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ArtistaTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        //List<Artista> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Artista p = new Artista();
        p.setNombre("Kevin Johansen + The Nada");
        p.setGenero("Rock");
        p.setConciertos(new ArrayList<Concierto>());
        p.setAlbums(new ArrayList<Album>());
        p.setPlaylists(new ArrayList<Playlist>());
        
        //p.setListaCanciones(new ArrayList<Cancion>());

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        //List<Artista> l = service.list();

        /*
         * ****************************************************
         * 					SETEO DE VARIABLES 
         * ****************************************************
         * */
        
        Artista p = new Artista();
        p.setNombre("The Black Eyes Peas");
        p.setGenero("Pop");
        p.setConciertos(new ArrayList<Concierto>());
        p.setAlbums(new ArrayList<Album>());
        p.setPlaylists(new ArrayList<Playlist>());

        /*
         * ****************************************************
         * 				FIN SETEO DE VARIABLES 
         * ****************************************************
         * */
        
        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testUpdate() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        //List<Artista> l = service.list();

        /*
         * ****************************************************
         * 					SETEO DE VARIABLES 
         * ****************************************************
         * */
        
        Artista p = new Artista();
        p.setId(1);
        p.setNombre("Joss Stone");
        p.setGenero("Pop");
        p.setConciertos(new ArrayList<Concierto>());
        p.setAlbums(new ArrayList<Album>());
        p.setPlaylists(new ArrayList<Playlist>());

        /*
         * ****************************************************
         * 				FIN SETEO DE VARIABLES 
         * ****************************************************
         * */

        try{
            p = service.update(p);
        }catch(NotFoundException e){
            
        }
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testList() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        //List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Artista> p = service.list();

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
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        Artista p = new Artista();
        p = null;
        try{
            p = service.load(1);
        }catch(NotFoundException e){
        }
        
        assertNotNull("No se cargo el album");
    }/*
    @Test
    public void testDelete()  throws ServiceException{
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));


        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Artista p = new Artista();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro el Album", p);
    }*/
    
}