package ar.com.magm.ti.model.dao;

import java.util.List;

import ar.com.magm.ti.model.Personas;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IPersonaDAO extends IGenericDAO<Personas, Integer> {

    public List<Personas> list(String parteDelNombre) throws PersistenceException;
}
