package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.bean.Proveedor;

public class ProveedorDaoImp implements ProveedorDao {

	public void save(Proveedor p) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.save(p);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}


	}

	public void borrar(Proveedor p) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(p);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}


	}

	public Proveedor get(int i) {
		Proveedor p1=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			p1=sesion.get(Proveedor.class, i);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}

		
		return p1;
	}

	public void actualizar(Proveedor p) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.update(p);
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
		List<Proveedor> proveedores= new ArrayList<Proveedor>();
		try {
			sesion.beginTransaction();
			proveedores = sesion.createQuery("from Proveedor").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}	
		for (Proveedor proveedor : proveedores) {
			System.out.println(proveedor.getIdProveedor()+")  Nombre:"+proveedor.getNombre()+"   Teléfono:"+proveedor.getTelefono());
		}
	}


}
