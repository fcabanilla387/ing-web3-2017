package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Playlist;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PlaylistTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        p.setCanciones(new ArrayList<Cancion>());
        p.setNombre("Clasica");

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        p.setCanciones(new ArrayList<Cancion>());
        p.setNombre("Punk");

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        p.setIdPlaylist(1);
        p.setCanciones(new ArrayList<Cancion>());
        p.setNombre("Metal");
        try {
            p = service.update(p);
        } catch (NotFoundException e) {

        }
        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testList() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Playlist> p = service.list();

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
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo la Playlist");
    }/*

    @Test
    public void testDelete() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        try {
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro la Playlist", p);
    }*/

}
