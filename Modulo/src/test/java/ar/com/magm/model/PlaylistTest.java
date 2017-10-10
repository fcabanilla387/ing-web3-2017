package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import ar.com.magm.ti.model.service.IPlaylistService;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
public class PlaylistTest extends BaseTest {

	@Test
	public void testSave() throws ServiceException {
		IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

		List<Playlist> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Playlist p=new Playlist();
		p.setNombre("miLista");
                p.setCanciones(new ArrayList<Cancion>());
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getIdPlaylist());
		
	}/*
        @Test
	public void test3() throws ServiceException {
		IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

		List<Persona> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Persona p=new Persona();
		p.setApellido("García");
		p.setNombre("Mariano");
		p.setFechaNacimiento(new Date());
		
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getDni());
		
	}
        @Test
	public void test4() throws ServiceException {
		IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

		List<Persona> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Persona p=new Persona();
		p.setApellido("García");
		p.setNombre("Mariano");
		p.setFechaNacimiento(new Date());
		
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getDni());
		
	}
        @Test
	public void test5() throws ServiceException {
		IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

		List<Persona> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Persona p=new Persona();
		p.setApellido("García");
		p.setNombre("Mariano");
		p.setFechaNacimiento(new Date());
		
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getDni());
		
	}
        @Test
	public void test6() throws ServiceException {
		IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

		List<Persona> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Persona p=new Persona();
		p.setApellido("García");
		p.setNombre("Mariano");
		p.setFechaNacimiento(new Date());
		
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getDni());
		
	}
        @Test
	public void test7() throws ServiceException {
		IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

		List<Persona> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Persona p=new Persona();
		p.setApellido("García");
		p.setNombre("Mariano");
		p.setFechaNacimiento(new Date());
		
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getDni());
		
	}*/
}
