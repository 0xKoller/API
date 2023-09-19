package tpo_ai_api.dao;


import java.util.List;

import org.hibernate.Session;

import tpo_ai_api.model.Usuario;


public interface DAOUsuario {
	List<Usuario> getUsuarios(Session session) throws Exception;
	void save(Usuario usuario, Session session) throws Exception;
	void update(Usuario usuario,Session session) throws Exception;
	void delete(Usuario usuario, Session session) throws Exception;
	Usuario findById(int id,Session session) throws Exception;
	Usuario findByDni(String dni, Session session) throws Exception;
	Usuario findByUsuario(String usuario1, Session session) throws Exception;
}




