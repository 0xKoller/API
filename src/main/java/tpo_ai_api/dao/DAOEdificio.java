package tpo_ai_api.dao;


import java.util.List;

import org.hibernate.Session;

import tpo_ai_api.model.Edificio;


public interface DAOEdificio {
	List<Edificio> getEdificios(Session session) throws Exception;
	Edificio findById(int numero,Session session) throws Exception;
	void save(Edificio edificio,Session session) throws Exception;
	void update(Edificio edificio, Session session) throws Exception;
	
}
