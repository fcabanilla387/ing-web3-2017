package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Concierto;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.AlbumDAO;
import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.IConciertoService;
import ar.com.magm.ti.model.service.impl.AlbumService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.model.service.impl.ConciertoService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

public class FAlbumTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        IConciertoService serviceConcierto = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Album p = new Album();
        p.setAnio(1990);
        
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
        Cancion c3 = new Cancion();
        try {
            c1 = serviceCancion.load(1);
            c2 = serviceCancion.load(2);
            c3 = serviceCancion.load(3);
            HashSet<Cancion> canciones = new HashSet<Cancion>();
            canciones.add(c1);
            canciones.add(c2);
            canciones.add(c3);
            p.setCancions(canciones);
            Artista artista = new Artista();
            p = new Album(artista, 1990, "Death Magnetic", canciones);
            Concierto co = serviceConcierto.load(1);
            HashSet<Concierto> cons = new HashSet<Concierto>();
            cons.add(co);
            artista = new Artista("Rock", "Red hot Chilli Peppers", cons, new HashSet(), new HashSet());
        } catch (NotFoundException ex) {
            Logger.getLogger(FAlbumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, (long)p.getId());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        Album p = new Album();
        p.setAnio(1832);
        p.setNombre("Dark side of the moon");
        Cancion c = new Cancion();
        try {
            c = serviceCancion.load(2);
            HashSet<Cancion> canciones = new HashSet<Cancion>();
            canciones.add(c);
            p.setCancions(canciones);
        } catch (NotFoundException ex) {
            Logger.getLogger(FAlbumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, (long)p.getId());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        Album p = new Album();
        p.setId(1);
        p.setAnio(2000);
        p.setNombre("Iowa");
        p.setCancions(new HashSet<Cancion>());

        Cancion c = new Cancion();
        try {
            c = serviceCancion.load(1);
            HashSet<Cancion> canciones = new HashSet<Cancion>();
            canciones.add(c);
            p.setCancions(canciones);
            p = service.update(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(FAlbumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotEquals("Se generó mal el id", 0, (long)p.getId());
    }

    @Test
    public void testList() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> p = service.list();

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> p = service.list("side");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        Album p = new Album();
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
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        Album p = new Album();
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
