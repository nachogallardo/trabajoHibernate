package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Query;
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
		}catch (ConstraintViolationException e) {
			sesion.getTransaction().rollback();
			System.out.println("--ERRORES--");
			for (ConstraintViolation cv  : e.getConstraintViolations()) {
				System.out.println("Campo ("+cv.getPropertyPath()+") Mensaje ("+cv.getMessage()+")");
			}
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
		}catch (ConstraintViolationException e) {
			sesion.getTransaction().rollback();
			System.out.println("--ERRORES--");
			for (ConstraintViolation cv  : e.getConstraintViolations()) {
				System.out.println("Campo ("+cv.getPropertyPath()+") Mensaje ("+cv.getMessage()+")");
			}
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

	public void muestraProveedores(int tamanyoPagina) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			long numProveedores = (Long) sesion.createQuery("SELECT count(*) FROM Proveedor")
					.uniqueResult();
			
			int numPaginas = (int) Math.ceil(numProveedores/tamanyoPagina);
			
			Query query = (Query) sesion.createQuery("FROM Proveedor").setMaxResults(tamanyoPagina);
			
			for (int i = 0; i < numPaginas+1; i++) {
				System.out.println("-- Página " + (i + 1) + " --");
				query.setFirstResult(i*tamanyoPagina);
				List<Proveedor> proveedores = query.list();
				for (Proveedor proveedor : proveedores) {
					System.out.println("Proveedor: "+proveedor.getNombre()+" y su número de teléfono es: "+proveedor.getTelefono());
				}
			}

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		
	}


}
