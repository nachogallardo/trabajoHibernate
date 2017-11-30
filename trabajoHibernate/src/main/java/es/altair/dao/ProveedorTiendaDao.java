package es.altair.dao;

import java.util.List;

import es.altair.bean.ProveedorTienda;

public interface ProveedorTiendaDao {
	public void save(ProveedorTienda pt1);
	public void borrar(ProveedorTienda pt1);
	public ProveedorTienda get(int i);
	public void actualizar(ProveedorTienda pt1);
	public void listar();
}
