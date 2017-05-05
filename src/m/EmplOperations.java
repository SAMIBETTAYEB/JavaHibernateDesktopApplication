package m;

import c.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by Bettayeb on 5/4/2017.
 */
public class EmplOperations {


    public void add(Empl empl){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(empl);
        session.getTransaction().commit();
    }

    public void update(Empl empl){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(empl);
        session.getTransaction().commit();
    }

    public void delete(Empl empl){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(empl);
        session.getTransaction().commit();
    }


    public List<Empl> getAll(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Empl");
        return query.list();
    }


}
