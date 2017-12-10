package es.altair.dao;

import java.util.List;

import es.altair.bean.Articulo;

public interface ArticuloDao {
	public void save(Articulo a);
	public void borrar(Articulo a);
	public Articulo get(int i);
	public void actualizar(Articulo a);
	public void listar();
	public void MostrarMasCaro();
	public List<Articulo> criteriaQuery();
}
