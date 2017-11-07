package ar.com.magm.ti.app;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import ar.com.magm.ti.model.dao.*;
import ar.com.magm.ti.model.dao.hibernate.*;
import ar.com.magm.ti.model.service.*;
import ar.com.magm.ti.model.service.impl.*;

/**
 *
 * @author magm
 *
 */
@Component
public class Beans {

    //DAO
    @Bean
    @Autowired
    public IEntidadDAO entidadDAO(final SessionFactory sessionFactory) {
        return new EntidadDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IAlbumDAO albumDAO(final SessionFactory sessionFactory) {
        return new AlbumDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IArtistaDAO artistaDAO(final SessionFactory sessionFactory) {
        return new ArtistaDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public ICancionDAO cancionDAO(final SessionFactory sessionFactory) {
        return new CancionDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IConciertoDAO conciertoDAO(final SessionFactory sessionFactory) {
        return new ConciertoDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IGeneroDAO generoDAO(final SessionFactory sessionFactory) {
        return new GeneroDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IPlaylistDAO playlistDAO(final SessionFactory sessionFactory) {
        return new PlaylistDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public ISubgeneroDAO subgeneroDAO(final SessionFactory sessionFactory) {
        return new SubgeneroDAO(sessionFactory);
    }
    @Bean
    @Autowired
    public IUsuarioDAO usuarioDAO(final SessionFactory sessionFactory) {
        return new UsuarioDAO(sessionFactory);
    }

    //Services
    @Bean
    @Autowired
    public IEntidadService entidadService(final IEntidadDAO entidadDAO) {
        return new EntidadService(entidadDAO);
    }
    @Bean
    @Autowired
    public IAlbumService album(final IAlbumDAO albumDAO) {
        return new AlbumService(albumDAO);
    }
    @Bean
    @Autowired
    public IArtistaService artista(final IArtistaDAO artistaDAO) {
        return new ArtistaService(artistaDAO);
    }
    @Bean
    @Autowired
    public ICalcularCancionService calcularCancionService() {
        return new CalcularCancionService();
    }
    @Bean
    @Autowired
    public ICancionService cancion(final ICancionDAO cancionDAO) {
      return new CancionService(cancionDAO);
    }
    @Bean
    @Autowired
    public IConciertoService concierto(final IConciertoDAO conciertoDAO) {
      return new ConciertoService(conciertoDAO);
    }
    @Bean
    @Autowired
    public IGeneroService genero(final IGeneroDAO generoDAO) {
      return new GeneroService(generoDAO);
    }
    @Bean
    @Autowired
    public IPlaylistService playlist(final IPlaylistDAO playlistDAO) {
      return new PlaylistService(playlistDAO);
    }
    @Bean
    @Autowired
    public ISubgeneroService subgenero(final ISubgeneroDAO subgeneroDAO) {
      return new SubgeneroService(subgeneroDAO);
    }
    @Bean
    @Autowired
    public IUsuarioService subgenero(final IUsuarioDAO subgeneroDAO) {
      return new UsuarioService(subgeneroDAO);
    }
}