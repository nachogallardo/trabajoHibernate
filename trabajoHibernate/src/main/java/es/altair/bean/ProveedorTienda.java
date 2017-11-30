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
@Entity
@Table(name="proveedortienda")
public class ProveedorTienda implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproveedorTienda;
	@Temporal(TemporalType.DATE)
	private Date ultimaNegociacion;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idTienda")
	private Tienda tnd;
	public ProveedorTienda() {
		super();
	}
	public ProveedorTienda(Date ultimaNegociacion) {
		super();
		this.ultimaNegociacion = ultimaNegociacion;
	}
	public int getIdproveedorTienda() {
		return idproveedorTienda;
	}
	public void setIdproveedorTienda(int idproveedorTienda) {
		this.idproveedorTienda = idproveedorTienda;
	}
	public Date getUltimaNegociacion() {
		return ultimaNegociacion;
	}
	public void setUltimaNegociacion(Date ultimaNegociacion) {
		this.ultimaNegociacion = ultimaNegociacion;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Tienda getTnd() {
		return tnd;
	}
	public void setTnd(Tienda tnd) {
		this.tnd = tnd;
	}
	@Override
	public String toString() {
		return "ProveedorTienda [idproveedorTienda=" + idproveedorTienda + ", ultimaNegociacion=" + ultimaNegociacion
				+ ", proveedor=" + proveedor + ", tnd=" + tnd + "]";
	}
	
	
}
