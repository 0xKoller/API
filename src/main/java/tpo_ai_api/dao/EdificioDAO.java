package tpo_ai_api.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import tpo_ai_api.model.Edificio;

public class EdificioDAO {
	
	private static EdificioDAO instancia;
	
	public static EdificioDAO getInstancia() {
		if(instancia == null)
			instancia = new EdificioDAO();
		return instancia;
	}
	
	public List<Edificio> getEdificios(){
	
		
		Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Edificio.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        

		
		Query<Edificio> getQuery = session.createQuery("FROM Edificio ORDER BY nombre", Edificio.class);
		List<Edificio> edificios = getQuery.getResultList();
		return edificios;
		
		
	}
	
	public Edificio findById(int numero) throws Exception{
		
				Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Edificio.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        

		
		Query<Edificio> getQuery = session.createQuery("FROM Edificio where id=?", Edificio.class);
		Edificio edificio = getQuery.getSingleResult();
		if(edificio == null)
			throw new Exception("No existe el edificio " + numero);
				return toNegocio(edificio);
	}

	public void save(Edificio edificio){
		
		Edificio edificiosave = toEntity(edificio);
		
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(edificiosave);
		tx.commit();
	}
	
	public void update(Edificio edificio){
		Edificio edificiosave = toEntity(edificio);
		
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.update(edificiosave);
		tx.commit();
		
		
		
		
	}
	
	Edificio toEntity(Edificio edificio){
		return new Edificio(edificio.getNombre(), edificio.getDireccion());
	} 
	
	Edificio toNegocio(Edificio entity){
		return new Edificio(entity.getNombre(), entity.getDireccion());
	}
	
	
}

