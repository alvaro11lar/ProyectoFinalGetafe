package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "USUARIOGEN", sequenceName = "USUARIO_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;
	
	private String nombre; 
	private String apellidos;
	@Column(length = 9, name = "DNI_USUARIO", unique = true, nullable = false)
	private String dni;
	@Column(length = 9, name = "SEXO_USUARIO", nullable = false)
	private String sexo;
	@Column(length = 15, name = "ID_USUARIO", nullable = false)
	private String idUsuario;
	@Column(length = 14, name = "CONTRASEÑA_USUARIO", nullable = false)
	private String contraseña;
	private String email;
	@Column(length = 9, name = "TELEFONO_USUARIO", nullable = false)
	private int telefono;
	@Column(name = "FECHA_NACIMIENTO_USUARIO", nullable = false)
	private Date fechaNacimmiento;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="TB_USUARIOS_ROLES", joinColumns = {@JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ROLES_ID")})
	private List<Roles> roles = new ArrayList<Roles>();
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellidos, String dni, String sexo, String idUsuario, String contraseña,
			String email, int telefono, Date fechaNacimmiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.idUsuario = idUsuario;
		this.contraseña = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimmiento = fechaNacimmiento;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/*public Date getFechaNacimmiento() {
		return fechaNacimmiento;
	}*/
	
    public String getFechaNacimmiento() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechaNacimmiento);
    }
	

	/*public void setFechaNacimmiento(Date fechaNacimmiento) {
		this.fechaNacimmiento = fechaNacimmiento;
	}*/
    
    public void setFechaNacimmiento(String fechaNacimiento) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	try {
			Date fecha = sdf.parse(fechaNacimiento);
			this.fechaNacimmiento = fecha;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	} 
	
	
	

}
