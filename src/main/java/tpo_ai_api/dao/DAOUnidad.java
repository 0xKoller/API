package tpo_ai_api.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tpo_ai_api.model.Edificio;
import tpo_ai_api.model.Unidad;

public interface DAOUnidad {
	List<Unidad> getUnidades(Session session) throws Exception;
	Unidad findById(int numero,Session session) throws Exception;
	void save(Unidad unidad,Session session) throws Exception;
	void update(Unidad Unidad, Session session) throws Exception;
	
}