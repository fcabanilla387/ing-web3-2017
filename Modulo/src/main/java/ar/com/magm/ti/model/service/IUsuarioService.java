package ar.com.magm.ti.model.service;

import java.util.List;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IUsuarioService extends IGenericService<Usuario, Integer> {

    public List<Usuario> list(String parteDelNombre) throws ServiceException;
}
