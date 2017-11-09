package ar.com.magm.ti.model.dao.hibernate;

import org.hibernate.SessionFactory;

import ar.com.magm.ti.model.Entidades;
import ar.com.magm.ti.model.dao.IEntidadDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;

public class EntidadDAO extends GenericDAO<Entidades, Integer> implements IEntidadDAO {

    public EntidadDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
