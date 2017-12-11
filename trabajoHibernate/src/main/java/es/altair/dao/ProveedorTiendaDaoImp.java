package es.altair.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import es.altair.bean.ProveedorTienda;


public class ProveedorTiendaDaoImp implements ProveedorTiendaDao {

	public void save(ProveedorTienda pt1) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.save(pt1);
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

	public void borrar(ProveedorTienda pt1) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(pt1);
			sesion.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sesion.close();
			sf.close();
		}		
	}
	public ProveedorTienda get(int i) {
		ProveedorTienda pt=null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			pt=sesion.get(ProveedorTienda.class, i);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}

		
		return pt;
	}

	public void actualizar(ProveedorTienda pt1) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion= sf.openSession();
		
		try {
			sesion.beginTransaction();
			sesion.update(pt1);
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
		List<ProveedorTienda> provtien= new ArrayList<ProveedorTienda>();
		try {
			sesion.beginTransaction();
			provtien = sesion.createQuery("from ProveedorTienda").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}	
		for (ProveedorTienda proveedorTienda : provtien) {
			System.out.println(proveedorTienda.getIdproveedorTienda()+")  Proveedor:"+proveedorTienda.getProveedor().getNombre()+"    Tienda:"+proveedorTienda.getTnd().getNombre()+"    Ultima Negociacion:"+proveedorTienda.getUltimaNegociacion());
		}
	}

}
