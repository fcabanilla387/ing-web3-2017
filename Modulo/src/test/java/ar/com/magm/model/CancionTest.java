package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.service.ICancionService;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
public class CancionTest extends BaseTest {

	@Test
	public void testSave() throws ServiceException {
		ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

		List<Cancion> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Cancion p=new Cancion();
		p.setDuracion("3'22'");
                p.setRating((float)2.5);
                p.setReproducciones(5);
                p.setSubgenero(new Subgenero());
                p.setTitulo("All nightmare long");
                p.setUsuarios(new ArrayList<Usuario>());
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
