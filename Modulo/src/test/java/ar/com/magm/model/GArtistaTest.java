package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.dao.hibernate.AlbumDAO;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.IConciertoService;
import ar.com.magm.ti.model.service.impl.AlbumService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.model.service.impl.ConciertoService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

public class GArtistaTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));
        IConciertoService serviceConcierto = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));
        IAlbumService serviceAlbum = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        Artista p = new Artista();
        p.setNombre("Kevin Johansen + The Nada");
        p.setGenero("Rock");
        HashSet<Concierto> conciertos = new HashSet<Concierto>();
        HashSet<Album> albums = new HashSet<Album>();
        try {
            Concierto con = new Concierto();
            con = serviceConcierto.load(1);
            conciertos.add(con);
            Album al = new Album();
            al = serviceAlbum.load(1);
            albums.add(al);
            p.setConciertos(conciertos);
            p.setAlbums(albums);
        } catch (NotFoundException ex) {
            Logger.getLogger(GArtistaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, (long) p.getId());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));
        IConciertoService serviceConcierto = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));
        IAlbumService serviceAlbum = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        //List<Artista> l = service.list();

        /*
         * ****************************************************
         * 					SETEO DE VARIABLES 
         * ****************************************************
         * */
        Artista p = new Artista();
        p.setNombre("The Black Eyes Peas");
        p.setGenero("Pop");
        HashSet<Concierto> conciertos = new HashSet<Concierto>();
        HashSet<Album> albums = new HashSet<Album>();
        try {
            Concierto con = new Concierto();
            con = serviceConcierto.load(2);
            conciertos.add(con);
            Album al = new Album();
            al = serviceAlbum.load(2);
            albums.add(al);
            p.setConciertos(conciertos);
            p.setAlbums(albums);
        } catch (NotFoundException ex) {
            Logger.getLogger(GArtistaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         * ****************************************************
         * 				FIN SETEO DE VARIABLES 
         * ****************************************************
         * */
        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, (long) p.getId());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));
        IConciertoService serviceConcierto = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));
        IAlbumService serviceAlbum = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        IArtistaService serviceArtista = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        Artista p = new Artista();
        p.setId(1);
        p.setNombre("Joss Stone");
        p.setGenero("Pop");
        HashSet<Concierto> conciertos = new HashSet<Concierto>();
        HashSet<Album> albums = new HashSet<Album>();
        HashSet<Artista> arts = new HashSet<Artista>();
        try {
            /*
            Concierto con = new Concierto();
            con = serviceConcierto.load(1);
            con.setArtista(p);
            conciertos.add(con);
            Album al = new Album();
            al = serviceAlbum.load(1);
            albums.add(al);
            Artista a = serviceArtista.load(1);
            arts.add(a);*/
            //p.setConciertos(conciertos);
            //p.setAlbums(albums);
            p = new Artista("Rock","Syracuse", new HashSet(), new HashSet(), new HashSet());
            p.setId(1);
            p = service.update(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(GArtistaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertNotEquals("Se generó mal el id", 0, (long) p.getId());
    }

    @Test
    public void testList() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        //List<Album> l = service.list();
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Artista> p = service.list();

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        List<Artista> p = service.list("Black");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        Artista p = new Artista();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el album");
    }
    /*
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
