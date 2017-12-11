package es.altair.dao;


import java.util.List;

import es.altair.bean.Proveedor;

public interface ProveedorDao {
	public void save(Proveedor p);
	public void borrar(Proveedor p);
	public Proveedor get(int i);
	public void actualizar(Proveedor p);
	public void listar();
	public void muestraProveedores(int i);
}
