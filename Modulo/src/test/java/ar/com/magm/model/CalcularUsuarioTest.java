/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.magm.model;

import ar.com.magm.ti.model.Cancion;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.service.impl.CalcularUsuarioService;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author matia
 */
public class CalcularUsuarioTest extends BaseTest {
    
    @Test
    public void test1()throws ServiceException{
       ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        
        ArrayList<Cancion> canciones = (ArrayList<Cancion>)service.list();
        
        CalcularUsuarioService calc = new CalcularUsuarioService(canciones);
        Cancion c = calc.CancionMejorPuntuada();
        assertNotNull(c);
    }
    
    @Test
    public void test2()throws ServiceException{
       ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        
        ArrayList<Cancion> canciones = (ArrayList<Cancion>)service.list();
        
        CalcularUsuarioService calc = new CalcularUsuarioService(canciones);
        Cancion c = calc.CancionMasReproducida();
        assertNotNull(c);
    }
    
}
