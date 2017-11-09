package ar.com.magm.ti.model.service;

import java.util.List;

import ar.com.magm.ti.model.Personas;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IPersonaService extends IGenericService<Personas, Integer> {

    public List<Personas> list(String parteDelNombre) throws ServiceException;
}
