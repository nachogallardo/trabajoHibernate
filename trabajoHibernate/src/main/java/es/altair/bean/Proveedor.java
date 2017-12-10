package es.altair.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProveedor;
	@NotNull
	@NotBlank
	private String nombre;
	@Min(100000000)
	@Max(999999999)
	private int telefono;
	@OneToMany(mappedBy="proveedor",cascade=CascadeType.ALL)
	private Set<ProveedorTienda> proveedores;
	public Proveedor() {
		super();
	}
	public Proveedor(String nombre, int telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
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
	public Set<ProveedorTienda> getProveedores() {
		return proveedores;
	}
	public void setProveedores(Set<ProveedorTienda> proveedores) {
		this.proveedores = proveedores;
	}
	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", proveedores=" + proveedores + "]";
	}
	
	
}
