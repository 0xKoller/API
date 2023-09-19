package tpo_ai_api.main;
import tpo_ai_api.main.App;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tpo_ai_api.dao.*;
import tpo_ai_api.model.Direccion;
import tpo_ai_api.model.Edificio;
import tpo_ai_api.model.EstadoUnidad;
import tpo_ai_api.model.Unidad;
import tpo_ai_api.model.Usuario;

public class App {
    public static void main(String[] args) {
    	
    Configuration conf = new Configuration().configure();
    SessionFactory sf = conf.buildSessionFactory();
    Session session = sf.openSession();
       	
   DAOUsuario dao = new DAOUsuarioImpl();
   Usuario usuario = new Usuario("juquin","1234",3333333,5555555,"juanca@juanca.com",true,null,null);
   Usuario usuario2 = new Usuario("fercho","4567",4444444,6666666,"fercho@mercho.com",true,null,null);
   try {
	   dao.save(usuario,session);
	   System.out.println(usuario);
	} catch (Exception e) {
		System.out.println("ERROR: " + e);
	}
   try {
	   dao.save(usuario2,session);
	   System.out.println(usuario2);
	} catch (Exception e) {
		System.out.println("ERROR: " + e);
	}

    	
   DAOUsuario dao4 = new DAOUsuarioImpl();
   List<Usuario> usuarios2=null;
try {
	usuarios2 = dao4.getUsuarios(session);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    	for (Usuario dao32 : usuarios2) {
			System.out.println(dao32 );
		}
    	
    	
   DAOEdificio dao2 = new DAOEdificioImpl();
   Edificio edificio2 = new Edificio("salta",new Direccion("CABA","monserrat","salta",221));
   Edificio edificio3 = new Edificio("torres lagos",new Direccion("Bs AS","lanu","arias",221));
   try {
	dao2.save(edificio2,session);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   System.out.println(edificio2);
   try {
	dao2.save(edificio3,session);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   System.out.println(edificio3);  	    	
    			
   DAOEdificio dao3 = new DAOEdificioImpl();
   List<Edificio> edificios2 = null;
try {
	edificios2 = dao3.getEdificios(session);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    	for (Edificio dao31 : edificios2) {
			System.out.println(dao31 );
		}
     
    	EstadoUnidad est1= EstadoUnidad.ALQUILADA;
    	EstadoUnidad est2= EstadoUnidad.HABITADA;
       DAOUnidad daou2 = new DAOUnidadImpl();
  	   Unidad unidad2 = new Unidad(6,1,est1,1,2);
  	   Unidad unidad3 = new Unidad(12,4,est2,2,1);
  	   try {
  		daou2.save(unidad2,session);
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	   System.out.println(unidad2);
  	   try {
  		daou2.save(unidad3,session);
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	   System.out.println(unidad3);  	    	
  	    			
  	   DAOUnidad daou3 = new DAOUnidadImpl();
  	   List<Unidad> unidades2 = null;
  	try {
  		unidades2 = daou3.getUnidades(session);
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	    	for (Unidad daou31 : unidades2) {
  				System.out.println(daou31 );
  			}
  			
        /*Configuration conf = new Configuration().configure();
        conf.addAnnotatedClass(Edificio.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        Edificio edificio = new Edificio("La marta", new Direccion("GBA", "Avellaneda", "Pasteur", 717));

        Transaction tx = session.beginTransaction();
        session.save(edificio);
        tx.commit();

        session.beginTransaction();
        Edificio res = session.get(Edificio.class, 1);
        session.getTransaction().commit();
        System.out.println(res);*/
    	sf.close();
    }
}



