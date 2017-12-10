package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Articulo;
import es.altair.bean.Tienda;

public class TiendaDaoImp implements TiendaDao {

	public void save(Tienda t) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.save(t);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}	
	}

	public void borrar(Tienda t) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(t);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}
		
	}

	public Tienda get(int i) {
		Tienda t=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			t=sesion.get(Tienda.class, i);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}

		
		return t;
	}

	public void actualizar(Tienda t) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.update(t);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		
	}

	public void listar() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		List<Tienda> tiendas= new ArrayList<Tienda>();
		try {
			sesion.beginTransaction();
			tiendas = sesion.createQuery("from Tienda").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}	
		for (Tienda tienda : tiendas) {
			System.out.println(tienda.getIdTienda()+")  Nombre:"+tienda.getNombre()+"  Teléfono:"+tienda.getTelefono()+"    Email:"+tienda.getEmail()+"    Dirección:"+tienda.getDireccion());
		}
	}

	public void tiendasCon954() {
		List<Tienda> tiendas = new ArrayList<Tienda>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			tiendas = sesion.createSQLQuery("SELECT * FROM tienda where telefono like '954%'").addEntity(Tienda.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		for (Tienda tienda : tiendas) {
			System.out.println(tienda.getNombre()+"   "+tienda.getTelefono());
		}
		
	}

}
