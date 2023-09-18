package tpo_ai_api.dao;


import java.util.List;

import tpo_ai_api.model.Edificio;


public interface DAOEdificio {
	List<Edificio> getEdificios() throws Exception;
	Edificio findById(int numero) throws Exception;
	void save(Edificio edificio) throws Exception;
	void update(Edificio edificio) throws Exception;
	
}
