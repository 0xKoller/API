package tpo_ai_api.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tpo_ai_api.model.Unidad;


public class UnidadDAO {
	
	private static UnidadDAO instancia;
		
	public static UnidadDAO getInstancia() {
		if(instancia == null)
			instancia = new UnidadDAO();
		return instancia;
	}
	
	public List<Unidad> getUnidades(){
		Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Unidad.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        

		
		Query<Unidad> getQuery = session.createQuery("FROM Unidad ORDER BY unidad", Unidad.class);
		List<Unidad> unidades = getQuery.getResultList();
		return unidades;
	}
	
	public Unidad findById(int id) throws Exception{
		Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Unidad.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        

		
		Query<Unidad> getQuery = session.createQuery("FROM Unidad where id=?", Unidad.class);
		Unidad unidad = getQuery.getSingleResult();
		if(unidad == null)
			throw new Exception("No existe el unidad " + id);
				return toNegocio(unidad);
	}
	




	public void save(Unidad unidad){
	Unidad unidadsave = toEntity(unidad);
		
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(unidadsave);
		tx.commit();
	}
	
	public void update(Unidad unidad){
Unidad unidadsave = toEntity(unidad);
		
		Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.update(unidadsave);
		tx.commit();
	}
	
	Unidad toEntity(Unidad unidad){
		return new Unidad(unidad.getPiso(), unidad.getNumero(), unidad.getEstado(), unidad.getIdDueno(),unidad.getIdInquilino());
	} 
	
	Unidad toNegocio(Unidad entity){
		return new Unidad(entity.getPiso(), entity.getNumero(), entity.getEstado(), entity.getIdDueno(),entity.getIdInquilino());	
		}
	}
