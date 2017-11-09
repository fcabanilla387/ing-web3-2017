package ar.com.magm.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Entidades;
import ar.com.magm.ti.model.dao.hibernate.EntidadDAO;
import ar.com.magm.ti.model.service.IEntidadService;
import ar.com.magm.ti.model.service.impl.EntidadService;
import ar.com.magm.ti.service.exception.ServiceException;

public class TestEntidad extends BaseTest {

    @Test
    public void saveAndLoad() throws ServiceException, NotFoundException {
        IEntidadService entidadService = new EntidadService(new EntidadDAO((SessionFactory) sessionFactory()));

        List<Entidades> l = entidadService.list();
        int size = l.size();
        Entidades e = new Entidades();
        e.setNombre("nombre");
        e = entidadService.save(e);
        assertTrue("Error id entidad", e.getIdEntidad() > -1);
        assertEquals("Error nombre entidad", e.getNombre(), "nombre");
        int id = e.getIdEntidad();

        Entidades cargada = entidadService.load(id);
        assertEquals("Error en la carga", e, cargada);

        entidadService.delete(cargada);
        l = entidadService.list();
        assertEquals("Error eliminando", size, l.size());

    }
}
