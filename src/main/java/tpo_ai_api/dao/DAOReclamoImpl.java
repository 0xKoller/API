package tpo_ai_api.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import tpo_ai_api.model.Reclamo;



public class DAOReclamoImpl implements DAOReclamo {
	
	private static DAOReclamoImpl instancia;
	
	public static DAOReclamoImpl getInstancia() {
		if(instancia == null)
			instancia = new DAOReclamoImpl();
		return instancia;
	}
	
	public List<Reclamo> getReclamos(Session session){
		/*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Reclamo.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();*/
        

		
		Query<Reclamo> getQuery = session.createQuery("FROM Reclamo ORDER BY reclamo", Reclamo.class);
		List<Reclamo> reclamos = getQuery.getResultList();
		return reclamos;
	}
	
	public Reclamo findById(int id, Session session) throws Exception{
		/*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Reclamo.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();*/
        

		
		Query<Reclamo> getQuery = session.createQuery("FROM Reclamo where id=?", Reclamo.class);
		Reclamo reclamo = getQuery.getSingleResult();
		if(reclamo == null)
			throw new Exception("No existe el reclamo " + id);
				return toNegocio(reclamo);
	}
	
	public void save(Reclamo reclamo, Session session){
Reclamo reclamosave = toEntity(reclamo);
		/*
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();*/

		Transaction tx = session.beginTransaction();
		session.save(reclamosave);
		tx.commit();
	}
	
	public void update(Reclamo reclamo,Session session){
	Reclamo reclamosave = toEntity(reclamo);
		
		/*Configuration conf = new Configuration().configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
*/
		Transaction tx = session.beginTransaction();
		session.update(reclamosave);
		tx.commit();
	}
	
	Reclamo toEntity(Reclamo reclamo){
		
			return new Reclamo();

	

	} 
	
	Reclamo toNegocio(Reclamo entity){
		
			return new Reclamo();

		
	}

	

	
}