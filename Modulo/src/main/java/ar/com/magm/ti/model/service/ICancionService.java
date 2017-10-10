package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Cancion;
import java.util.List;

import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface ICancionService extends IGenericService<Cancion, Integer> {
	public List<Cancion> list(String parteDelNombre) throws ServiceException; 
}
