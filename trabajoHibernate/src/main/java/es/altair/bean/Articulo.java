package es.altair.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArticulo;
	@NotNull
	@Size(min=1,max=20)
	@NotBlank
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idTienda")
	private Tienda tienda;
	@Min(0)
	@Max(100000)
	private int precio;

	public Articulo() {
		super();
	}

	public Articulo(String nombre, Date fechaCompra, Tienda tienda, int precio) {
		super();
		this.nombre = nombre;
		this.fechaCompra = fechaCompra;
		this.tienda = tienda;
		this.precio = precio;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombre=" + nombre + ", fechaCompra=" + fechaCompra
				+ ", tienda=" + tienda + ", precio=" + precio + "]";
	}

}
