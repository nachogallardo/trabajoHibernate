package es.altair.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.bean.Articulo;

public class ArticuloDaoImp implements ArticuloDao {

	public void save(Articulo a) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.save(a);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}

	}

	public void borrar(Articulo a) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(a);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}
		
	}

	public Articulo get(int i) {
		Articulo a=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			a=sesion.get(Articulo.class, i);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}	
		return a;
	}

	public void actualizar(Articulo a) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.update(a);
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
		List<Articulo> articulos= new ArrayList<Articulo>();
		try {
			sesion.beginTransaction();
			articulos = sesion.createQuery("from Articulo").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}	
		for (Articulo articulo : articulos) {
			System.out.println(articulo.getIdArticulo()+")  Nombre:"+articulo.getNombre()+"   Precio:"+articulo.getPrecio()+"   Fecha compra:"+articulo.getFechaCompra());
		}
	}

	public void MostrarMasCaro() {
		Articulo a=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			a=(Articulo)sesion.createQuery("FROM Articulo where precio=(select MAX(precio) from Articulo)").uniqueResult();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		System.out.println(a.getNombre()+" "+a.getPrecio()+"$");
		
	}

}
