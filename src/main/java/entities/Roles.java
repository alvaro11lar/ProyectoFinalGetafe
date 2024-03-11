package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity

@Table(name = "TB_ROLES")
public class Roles {

	@Id
	@SequenceGenerator(name = "ROLESGEN", sequenceName = "ROLES_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLESGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;
	
	private String rol;

	public Roles() {
		super();
	}
	
	public Roles(String rol) {
		this.rol=rol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", rol=" + rol + "]";
	} 
	
	
	
	
}

