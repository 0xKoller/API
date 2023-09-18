package tpo_ai_api.dao;


import java.util.List;

import tpo_ai_api.model.Usuario;


public interface DAOUsuario {
	List<Usuario> getUsuarios() throws Exception;
	void save(Usuario usuario) throws Exception;
	void update(Usuario usuario) throws Exception;
	void delete(Usuario usuario) throws Exception;
	Usuario findById(int id) throws Exception;
	Usuario findByDni(String dni) throws Exception;
	Usuario findByUsuario(String usuario1) throws Exception;
}




