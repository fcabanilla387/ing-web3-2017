package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.Usuario;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.UsuarioDAO;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.model.service.impl.UsuarioService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UsuarioTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p.setArtistasSeguidos(new ArrayList<Artista>());
        p.setContraseña("1234");
        p.setGenerosFavoritos(new ArrayList<Genero>());
        p.setMail("prueba123@gmail.com");
        p.setPais("prueba");
        p.setPlaylists(new ArrayList<Playlist>());
        p.setPremiun(false);
        p.setUsuario("prueba");

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p.setArtistasSeguidos(new ArrayList<Artista>());
        p.setContraseña("1111");
        p.setGenerosFavoritos(new ArrayList<Genero>());
        p.setMail("fcabanilla@gmail.com");
        p.setPais("Argentina");
        p.setPlaylists(new ArrayList<Playlist>());
        p.setPremiun(false);
        p.setUsuario("fcabanilla");

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p.setId(1);
        p.setArtistasSeguidos(new ArrayList<Artista>());
        p.setContraseña("6666");
        p.setGenerosFavoritos(new ArrayList<Genero>());
        p.setMail("matiasslpknt@gmail.com");
        p.setPais("Argentina");
        p.setPlaylists(new ArrayList<Playlist>());
        p.setPremiun(true);
        p.setUsuario("matiasslpknt");
        try {
            p = service.update(p);
        } catch (NotFoundException e) {

        }
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testList() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Usuario> p = service.list();

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
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el Usuario");
    }

    @Test
    public void testDelete() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        List<Usuario> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        try {
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro el Usuario", p);
    }

}
