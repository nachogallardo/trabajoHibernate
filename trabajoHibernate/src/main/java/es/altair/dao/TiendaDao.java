package es.altair.dao;

import java.util.List;

import es.altair.bean.Tienda;

public interface TiendaDao {
	public void save(Tienda t);
	public void borrar(Tienda t);
	public Tienda get(int i);
	public void actualizar(Tienda t);
	public void listar();
}
