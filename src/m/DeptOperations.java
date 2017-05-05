package m;

import c.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by Bettayeb on 5/4/2017.
 */
public class DeptOperations {

    public void add(Dept dept){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(dept);
        session.getTransaction().commit();
    }

    public void update(Dept dept){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(dept);
        session.getTransaction().commit();
    }

    public void delete(Dept dept){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(dept);
        session.getTransaction().commit();
    }

    public List getAll(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Dept");
        return query.list();
    }

}
