package ar.com.magm.ti.model.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.IConciertoDAO;
import ar.com.magm.ti.model.dao.IUsuarioDAO;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class UsuarioService extends GenericService<Usuario, Integer>
        implements IUsuarioService {

    private static Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
    private IUsuarioDAO dao;
    private IConciertoDAO daoConcierto;

    public UsuarioService(IUsuarioDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Usuario> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
    /*@Override
    public Object[][] getConciertosEnMiPais(Usuario usuario) throws ServiceException {
        try {
            return daoConcierto.list();
        } catch (PersistenceException e) {
            //LOG.error(e.getMessage(), e);
            //throw new ServiceException(e.getMessage(), e);
        }
    }*/

}
