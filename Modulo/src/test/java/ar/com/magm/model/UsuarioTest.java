package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.hibernate.UsuarioDAO;
import ar.com.magm.ti.model.service.IUsuarioService;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.service.impl.UsuarioService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
public class UsuarioTest extends BaseTest {

	@Test
	public void testSave() throws ServiceException {
		IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

		List<Usuario> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Usuario p=new Usuario();
		p.setArtistasSeguidos(new ArrayList<Artista>());
                p.setContraseña("1234");
                p.setGenerosFavoritos(new ArrayList<Genero>());
                p.setMail("mmanzanelli069@alumnos.iua.edu.ar");
                p.setPais("Argentina");
                p.setPlaylists(new ArrayList<Playlist>());
                p.setPremiun(true);
                p.setUsuario("matias");
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
