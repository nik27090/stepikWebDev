package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.factory.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UsersDAO {
    public UsersDataSet findByLogin(String login){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UsersDataSet.class, login);
    }

    public UsersDataSet findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UsersDataSet.class, id);
    }

    public void save(UsersDataSet user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(UsersDataSet user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(UsersDataSet user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
