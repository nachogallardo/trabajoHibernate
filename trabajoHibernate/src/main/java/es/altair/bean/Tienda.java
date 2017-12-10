package es.altair.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tienda")
public class Tienda implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTienda;
	@NotNull
	@NotBlank
	private String nombre;
	@Min(100000000)
	@Max(999999999)
	private int telefono;
	@Email
	private String email;
	@NotBlank
	private String direccion;
	
	
	@OneToMany(mappedBy="tienda",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	
	private Set<Articulo> articulos;
	@OneToMany(mappedBy="tnd")
	private Set<ProveedorTienda> tiendas;
	public Tienda() {
		super();
	}
	public Tienda(String nombre, int telefono, String email, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}
	public int getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Set<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}
	public Set<ProveedorTienda> getTiendas() {
		return tiendas;
	}
	public void setTiendas(Set<ProveedorTienda> tiendas) {
		this.tiendas = tiendas;
	}
	@Override
	public String toString() {
		return "Tienda [idTienda=" + idTienda + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ ", direccion=" + direccion + ", articulos=" + articulos + ", tiendas=" + tiendas + "]";
	}
	
	
}
