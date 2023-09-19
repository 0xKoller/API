package tpo_ai_api.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import tpo_ai_api.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

private static DAOUsuarioImpl instancia;
	
	public static DAOUsuarioImpl getInstancia() {
		if(instancia == null)
			instancia = new DAOUsuarioImpl();
		return instancia;
	}
	
	

	public List<Usuario> getUsuarios(Session session){
		
		//Configuration conf = new Configuration().configure();
        //conf.addAnnotatedClass(Usuario.class);
        //SessionFactory sf = conf.buildSessionFactory();
        //Session session = sf.openSession();
        

		
		Query<Usuario> getQuery = session.createQuery("FROM Usuario ORDER BY usuario", Usuario.class);
		List<Usuario> usuarios = getQuery.getResultList();
		return usuarios;
		
	}
	
	
	public Usuario findById(int id,Session session) throws Exception{
		/*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Usuario.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();*/
        

		
		Query<Usuario> getQuery = session.createQuery("FROM Usuario where id=?", Usuario.class);
		Usuario usuario = getQuery.getSingleResult();
		if(usuario == null)
			throw new Exception("No existe el usuario " + id);
				return usuario;
	}
	
	public Usuario findByDni(String dni,Session session) throws Exception{
		/*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Usuario.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();*/
        
		Query<Usuario> getQuery = session.createQuery("FROM Usuario where dni=?", Usuario.class);
		Usuario usuario = getQuery.getSingleResult();
		if(usuario == null)
			throw new Exception("No existe el usuario " + dni);
				return toNegocio(usuario);
	}

	public Usuario findByUsuario(String usuario1,Session session) throws Exception{
		/*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Usuario.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();*/
        
		Query<Usuario> getQuery = session.createQuery("FROM Usuario where usuario=?", Usuario.class);
		Usuario usuario = getQuery.getSingleResult();
		if(usuario == null)
			throw new Exception("No existe el usuario " + usuario1);
				return toNegocio(usuario);
	}

	
	public void save(Usuario usuario, Session session){
	Usuario usuariosave = toEntity(usuario);
		
		//Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		//SessionFactory sf = conf.buildSessionFactory();
		//Session session = sf.openSession();	

		Transaction tx = session.beginTransaction();
		session.save(usuariosave);
		tx.commit();
		
	}
	
	public void update(Usuario usuario,Session session){

Usuario usuariosave = toEntity(usuario);
		
		/*Configuration conf = new Configuration().configure();
		//conf.addAnnotatedClass(Estudiante.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();*/

		Transaction tx = session.beginTransaction();
		session.update(usuariosave);
		tx.commit();
	}
	
	Usuario toEntity(Usuario usuario){
		return new Usuario(usuario.getUsuario(),usuario.getContrasena(),usuario.getDni(),usuario.getTelefono(),usuario.getEmail(),usuario.isAdmin(),usuario.getReclamos(),usuario.getEdificios());
	} 
	
	Usuario toNegocio(Usuario entity){
		return new Usuario (entity.getUsuario(),entity.getContrasena(),entity.getDni(),entity.getTelefono(),entity.getEmail(),entity.isAdmin(),entity.getReclamos(),entity.getEdificios());
	}

	public void delete(Usuario usuario,Session session) throws Exception {
		List<Usuario> usuarios = DAOUsuarioImpl.getInstancia().getUsuarios(session);
		
		boolean bandera=false;
		
		for(Usuario us: usuarios) {
			if(us.getDni()==(usuario.getDni())) {
				bandera=true;
				}
		}
		
		if(bandera == true) {
			
			
			Usuario usuariodel = toEntity(usuario);
			//Configuration conf = new Configuration().configure();
			//conf.addAnnotatedClass(Estudiante.class);
			//SessionFactory sf = conf.buildSessionFactory();
			//Session session = sf.openSession();

			Transaction tx = session.beginTransaction();
			session.update(usuariodel);
			tx.commit();

		}
		else {
			throw new Exception("No se puede eliminar al usuario");
		}
	}



	
}




