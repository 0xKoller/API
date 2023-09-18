package tpo_ai_api.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tpo_ai_api.model.Direccion;
import tpo_ai_api.model.Edificio;
/*import tpo_ai_api.model.Usuario;*/
public class App {
    public static void main(String[] args) {

/*por DAO*/
        /*DAOUsuarioImpl dao = new DAOUsuarioImpl();
    	Usuario usuario = new Usuario("juquin","1234",3333333,5555555,"juanca@juanca.com",true,null,null);
    	dao.save(usuario);
    	System.out.println(usuario);
    	
    	
    	DAOEdificioImpl dao2 = new DAOEdificioImpl();
    	Edificio edificio2 = new Edificio("salta",new Direccion("CABA","monserrat","salta",221));
    	dao2.save(edificio2);
    	System.out.println(edificio2);*/
        
        Configuration conf = new Configuration().configure();
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
        System.out.println(res);
    }
}



