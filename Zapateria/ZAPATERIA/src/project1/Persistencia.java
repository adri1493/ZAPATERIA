package project1;

import java.io.Serializable;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;

import java.util.List;

import javax.swing.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Persistencia {
    private Session session;
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public Persistencia() {
        session = Persistencia.getSessionFactory().openSession();
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void insert(Object unObjeto) {
        Transaction tr = session.beginTransaction();
        session.save(unObjeto);
        tr.commit();
    }

    public void update(Object unObjeto) throws HibernateException {
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(unObjeto);
        tr.commit();
    }

    public Empresa load(String idEmpresa) throws HibernateException {
        Empresa unaEmpresa = null;
        unaEmpresa = (Empresa) session.createQuery("SELECT FROM Empresa").uniqueResult();

        return unaEmpresa;

    }

    public List find(String sentencia) {
        List obj = session.createQuery(sentencia).list();
        return obj;
    }

    public void cerrar() {
        this.session.close();
        this.sessionFactory.close();
    }
    public Connection conn = null;
    private Statement stmt = null;

    public Connection AbrirConex() {
        try {
            String login = "postgres";
            String password = "1234";
            String url = "jdbc:postgresql://localhost:5432/ZAPATERIA";
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            stmt = conn.createStatement();
            return conn;
        } catch (Exception ex) {
            System.out.println("Error en la Conexion a la Base de Datos");
            System.out.println(ex.toString());
            return conn;
        }
    }

    public void eliminar() {
    Transaction tr = session.beginTransaction();
    session.createSQLQuery("drop schema public CASCADE");
    tr.commit();
    }
}
