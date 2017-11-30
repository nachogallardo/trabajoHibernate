package es.altair.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import es.altair.bean.Articulo;
import es.altair.bean.Proveedor;
import es.altair.bean.ProveedorTienda;
import es.altair.bean.Tienda;
import es.altair.dao.ArticuloDao;
import es.altair.dao.ArticuloDaoImp;
import es.altair.dao.ProveedorDao;
import es.altair.dao.ProveedorDaoImp;
import es.altair.dao.ProveedorTiendaDao;
import es.altair.dao.ProveedorTiendaDaoImp;
import es.altair.dao.TiendaDao;
import es.altair.dao.TiendaDaoImp;


public class App 
{
	private static Scanner sc= new Scanner(System.in);
    public static void main( String[] args )
    {
    	ProveedorDao pDao=new ProveedorDaoImp();
    	ProveedorTiendaDao ptDao= new ProveedorTiendaDaoImp();
    	TiendaDao tDao=new TiendaDaoImp();
        ArticuloDao aDao= new ArticuloDaoImp();
        int opcion=0;
        do {     	
        	menu();
        	opcion=sc.nextInt();
        	int clase=0;
        	switch (opcion) {
        	//AÑADIR OBJETOS A LA BASE DE DATOS
    		case 1:
    			menuSecundario();
    			System.out.println("Seleccione una opción");
    			clase=sc.nextInt();
    			switch (clase) {
    			//ProveedorTienda
    			case 1:
    				AniadirProveedorTienda(ptDao,pDao,tDao);
    				break;
    			//Proveedor
    			case 2:
    				AniadirProveedor(pDao);
    				break;
    			//Tienda
    			case 3:
    				AniadirTienda(tDao);
    				break;
    			//Articulo
    			case 4:
    				AniadirArticulo(aDao,tDao);
    				break;
    			}
    			break;
    		//BORRAR OBJETOS DE LA BASE DE DATOS
    		case 2:
    			menuSecundario();
    			System.out.println("Seleccione una opción");
    			clase=sc.nextInt();
    			switch (clase) {
    			//ProveedorTienda
    			case 1:
    				BorrarProveedorTienda(ptDao);
    				break;
    			//Proveedor
    			case 2:
    				BorrarProveedor(pDao);
    				break;
    			//Tienda
    			case 3:
    				BorrarTienda(tDao);
    				break;
    			//Articulo
    			case 4:
    				BorrarArticulo(aDao);
    				break;
    			}
    			break;
    		//ACTUALIZAR OBJETOS DE LA BASE DE DATOS
    		case 3:
    			menuSecundario();
    			System.out.println("Seleccione una opción");
    			clase=sc.nextInt();
    			switch (clase) {
    			//ProveedorTienda
    			case 1:
    				ActualizarProveedorTienda(ptDao,pDao,tDao);
    				break;
    			//Proveedor
    			case 2:
    				ActualizarProveedor(pDao);
    				break;
    			//Tienda
    			case 3:
    				ActualizarTienda(tDao);
    				break;
    			//Articulo
    			case 4:
    				ActualizarArticulo(aDao,tDao);
    				break;
    			}
    			break;
    		
    		case 4:
    			menuSecundario();
    			break;
    		}
        }while(opcion!=0);

        
        
    }
	private static void ActualizarArticulo(ArticuloDao aDao, TiendaDao tDao) {
		try {
			aDao.listar();
			System.out.println("Seleccione un articulo para actualizar:");
			int i= sc.nextInt();
			Articulo a1= aDao.get(i);
			System.out.println("Dime el nuevo nombre del articulo: ");
			a1.setNombre(sc.next()); 
			System.out.println("Dime el nuevo precio del articulo:");
			a1.setPrecio(sc.nextInt()); 
			tDao.listar();
			System.out.println("Dime la nueva tienda a la que pertenece el articulo:");
			int a= sc.nextInt();
			Tienda t= tDao.get(a);
			a1.setTienda(t);
			a1.setFechaCompra(new Date());
			aDao.actualizar(a1);
			
			
		}catch (Exception e) {
			System.out.println("Imposible actualizar.");
		}
		
	}
	private static void ActualizarTienda(TiendaDao tDao) {
		try {
			tDao.listar();
			System.out.println("Dime el id de la tienda a actualizar: ");
			int i= sc.nextInt();
			Tienda t= new Tienda();
			t=tDao.get(i);
			System.out.println("Dime el nuevo nombre de la tienda: ");
			t.setNombre(sc.next());
			System.out.println("Dime el nuevo teléfono de la tienda: ");
			t.setTelefono(sc.nextInt());
			System.out.println("Dime el nuevo email de la tienda: ");
			t.setEmail(sc.next());
			System.out.println("Dime la nueva dirección de la tienda: ");
			t.setDireccion(sc.next()); 
			tDao.actualizar(t);
			
			
			}catch (Exception e) {
				System.out.println("Imposible de actualizar Tienda");
			}	
		
	}
	private static void ActualizarProveedor(ProveedorDao pDao) {
		try {
			pDao.listar();
			System.out.println("Dime el id del proveedor para actualizar: ");
			int i=sc.nextInt();
			Proveedor p= new Proveedor();
			p=pDao.get(i);
			System.out.println("Dime el nuevo nombre del Proveedor: ");
			p.setNombre(sc.next()); 
			System.out.println("Dime el nuevo teléfono del Proveedor: ");
			p.setTelefono(sc.nextInt());
			pDao.actualizar(p);
			
			}catch (Exception e) {
				System.out.println("Imposible de actualizar Proveedor");
			}
		
	}
	private static void ActualizarProveedorTienda(ProveedorTiendaDao ptDao, ProveedorDao pDao, TiendaDao tDao) {
		try {
			ptDao.listar();
			System.out.println("Seleccione un proveedorTienda para actualizar:");
			int i= sc.nextInt();
			ProveedorTienda pt1= ptDao.get(i);
			pt1.setUltimaNegociacion(new Date());
			pDao.listar();
			System.out.println("Seleccione un nuevo proveedor: ");
			int proveedor =sc.nextInt();
			Proveedor p=pDao.get(proveedor);
			pt1.setProveedor(p);
			tDao.listar();
			System.out.println("Seleccione una nueva tienda: ");
			int tienda =sc.nextInt(); 
			Tienda t=tDao.get(tienda);
			pt1.setTnd(t);
			ptDao.actualizar(pt1);
		}catch (Exception e) {
			System.out.println("Imposible actualizar.");
		}
		
	}
	private static void BorrarArticulo(ArticuloDao aDao) {
		try {
			aDao.listar();
			System.out.println("Seleccione un articulo para borrar:");
			int i= sc.nextInt();
			Articulo a1= aDao.get(i);
			aDao.borrar(a1);
			System.out.println("Se ha borrado");
		}catch (Exception e) {
			System.out.println("Imposible borrar.");
		}
		
	}
	private static void BorrarTienda(TiendaDao tDao) {
		try {
			tDao.listar();
			System.out.println("Seleccione una tienda para borrar:");
			int i= sc.nextInt();
			Tienda t1= tDao.get(i);
			tDao.borrar(t1);
			System.out.println("Se ha borrado");
		}catch (Exception e) {
			System.out.println("Imposible borrar.");
		}
		
	}
	private static void BorrarProveedor(ProveedorDao pDao) {
		try {
			pDao.listar();
			System.out.println("Seleccione un proveedor para borrar:");
			int i= sc.nextInt();
			Proveedor p1= pDao.get(i);
			pDao.borrar(p1);
			System.out.println("Se ha borrado");
		}catch (Exception e) {
			System.out.println("Imposible borrar.");
		}
		
	}
	private static void BorrarProveedorTienda(ProveedorTiendaDao ptDao) {
		try {
			ptDao.listar();
			System.out.println("Seleccione un proveedorTienda para borrar:");
			int i= sc.nextInt();
			ProveedorTienda pt1= ptDao.get(i);
			ptDao.borrar(pt1);
			System.out.println("Se ha borrado");
		}catch (Exception e) {
			System.out.println("Imposible borrar.");
		}
		
	}
	private static void AniadirArticulo(ArticuloDao aDao, TiendaDao tDao) {
		try {
			System.out.println("Dime el nombre del articulo: ");
			String nombre= sc.next();
			System.out.println("Dime el precio del articulo:");
			int precio= sc.nextInt();
			tDao.listar();
			System.out.println("Dime la tienda a la que pertenece el articulo:");
			int i= sc.nextInt();
			Tienda t= tDao.get(i);
			Articulo a= new Articulo(nombre, new Date(), t, precio);
			aDao.save(a);	
			}catch (Exception e) {
				System.out.println("Imposible de añadir Articulo");
			}
		
	}
	private static void AniadirTienda(TiendaDao tDao) {
		try {
			System.out.println("Dime el nombre de la tienda: ");
			String nombre= sc.next();
			System.out.println("Dime el teléfono de la tienda: ");
			int telefono=sc.nextInt();
			System.out.println("Dime el email de la tienda: ");
			String email= sc.next();
			System.out.println("Dime la dirección de la tienda: ");
			String direccion= sc.next();
			tDao.save(new Tienda(nombre,telefono,email,direccion));	
			}catch (Exception e) {
				System.out.println("Imposible de añadir Tienda");
			}	
	}
	private static void AniadirProveedor(ProveedorDao pDao) {
		try {
		System.out.println("Dime el nombre del Proveedor: ");
		String nombre= sc.next();
		System.out.println("Dime el teléfono del Proveedor: ");
		int telefono=sc.nextInt();
		pDao.save(new Proveedor(nombre,telefono));	
		}catch (Exception e) {
			System.out.println("Imposible de añadir Proveedor");
		}
	}
	private static void AniadirProveedorTienda(ProveedorTiendaDao ptDao, ProveedorDao pDao, TiendaDao tDao) {
		try {
		ProveedorTienda pt1= new ProveedorTienda(new Date());
		pDao.listar();
		System.out.println("Seleccione un proveedor: ");
		int proveedor =sc.nextInt();
		Proveedor p=pDao.get(proveedor);
		pt1.setProveedor(p);
		tDao.listar();
		System.out.println("Seleccione una tienda: ");
		int tienda =sc.nextInt();
		Tienda t=tDao.get(tienda);
		pt1.setTnd(t);
		ptDao.save(pt1);	
		}catch (Exception e) {
			System.out.println("Imposible de añadir ProveedorTienda");
		}
		
	}
	private static void menu() {
	    System.out.println("\t\t╔════════════════════════════╗");
	    System.out.println("\t\t║           Menú             ║");
	    System.out.println("\t\t╠════════════════════════════╣");
	    System.out.println("\t\t║     1) Añadir              ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     2) Borrar              ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     3) Modificar           ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     4) Listar              ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     0) Salir               ║");
	    System.out.println("\t\t╚════════════════════════════╝");
		
	}
	public static void menuSecundario() {
	    System.out.println("\t\t╔════════════════════════════╗");
	    System.out.println("\t\t║           Menú             ║");
	    System.out.println("\t\t╠════════════════════════════╣");
	    System.out.println("\t\t║     1) ProveedorTienda     ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     2) Proveedor           ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     3) Tienda              ║");
	    System.out.println("\t\t║                            ║");
	    System.out.println("\t\t║     4) Articulo            ║");
	    System.out.println("\t\t╚════════════════════════════╝");
	}
	
}
