package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.Persona;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.dao.hibernate.PersonaDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.IPersonaService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.model.service.impl.PersonaService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
public class ArtistaTest extends BaseTest {

	@Test
	public void testSave() throws ServiceException {
		IArtistaService service = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

		List<Artista> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Artista p=new Artista();
		p.setAlbums(new ArrayList<Album>());
                p.setConciertos(new ArrayList<Concierto>());
                p.setGenero("Metal");
                p.setNombre("Metallica");
                p.setPlaylists(new ArrayList<Playlist>());
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getId());
		
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
