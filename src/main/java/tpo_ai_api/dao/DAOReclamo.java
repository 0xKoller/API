package tpo_ai_api.dao;


import java.util.List;
import org.hibernate.Session;
import tpo_ai_api.model.Reclamo;

public interface DAOReclamo{
	List<Reclamo> getReclamos(Session session) throws Exception;
	Reclamo findById(int numero,Session session) throws Exception;
	void save(Reclamo reclamo,Session session) throws Exception;
	void update(Reclamo Reclamo, Session session) throws Exception;
	
}

