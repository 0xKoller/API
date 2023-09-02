package tpo_ai_api.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tpo_ai_api.model.Direccion;
import tpo_ai_api.model.Edificio;

public class App {
    public static void main(String[] args) {
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



