package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.hibernate.GeneroDAO;
import ar.com.magm.ti.model.service.IGeneroService;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.service.impl.GeneroService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
public class GeneroTest extends BaseTest {

	@Test
	public void testSave() throws ServiceException {
		IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

		List<Genero> l = service.list();

		
		//assertEquals("Tamaño erróneo de la lista",0,l.size());
		
		Genero p=new Genero();
		p.setNombre("Metal");
                p.setSubgeneros(new ArrayList<Subgenero>());
                p.setUsuarios(new ArrayList<Usuario>());
		p=service.save(p);
		assertNotEquals("Se generó mal el id", 0,p.getIdGenero());
		
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
