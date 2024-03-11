package daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Roles;
import entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

public class UsuarioDao {

	//private static final Logger logger = LogManager.getLogger(AlumnoHibernateDAO.class);
	private static EntityManager em;
	
	public UsuarioDao() {
		em = JpaUtil.getEntityManager("hibernateOracle");
	}	

//	public void cargaInicial() {
//		//logger.debug("Empezando carga inicial de datos");
//
//
//		try {
//			em.getTransaction().begin();
//			List<Roles> roles = new ArrayList<Roles>();
//			roles.add(new Roles("Administrador"));
//			roles.add(new Roles("Usuario_Normal"));
//			Usuario u = new Usuario("alvaro","Lara","Y8877291H",'M',"alvaroLara","alvarolara2002","alvaro2002711@gmail.com",123456789,new Date());
//			u.setRoles(roles);
//
//
//
//			em.persist(u);
//
//			em.getTransaction().commit();
//
//		} catch (Exception e) {
//			//logger.error("Error al insertar alumnos " + e.getMessage());
//			em.getTransaction().rollback();
//		}
//
//		//logger.debug("Termina");
//	}
	
	public void agregarUsuario(Usuario u ) {
//		try {
//			em.getTransaction().begin();
//			em.persist(u);
//			em.getTransaction().commit();
//			System.out.println("Usuario agreggado");
//		} catch (Exception e) {
//			System.out.println("no entra");
//		}
//		

			 em.getTransaction().begin();
			 try {
				 em.persist(u);
				 em.getTransaction().commit();
				 System.out.println("agregando  ususrio");
			 }catch(Exception e) {
				 em.getTransaction().rollback();
			 }
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = em.createQuery("from Usuario", Usuario.class).getResultList();
		return usuarios;
	}

	public static Usuario buscarPorId(Long id) {
		Usuario alumno = em.find(Usuario.class, id);
		return alumno;
	}
	
	public static Usuario buscarPorDni(String dni) {
		//logger.debug("buscarPorDni " + dni);
		Query query = em.createQuery("from Usuario a where a.dni=?1", Usuario.class);
		query.setParameter(1, dni);
		Usuario alumno = null;
		try {
			alumno = (Usuario) query.getSingleResult();
		}catch(NoResultException nre) {
			//logger.error("No se ha econtrado al alumno con Dni "+ dni);
		}

		return alumno;
	}

	
	public static void modificarUsuarioPorId(String dni, Usuario userModified) {
		System.out.println("Ingresando a metodo modifcar");
		TypedQuery<Usuario> query = em.createQuery(
				"from Usuario where dni=?1",
				Usuario.class);
		query.setParameter(1, dni);
		
		try {
			Usuario user = query.getSingleResult();
			System.out.println("imprimendo usuario para actuallizar: " +  user);
			em.getTransaction().begin();
			//user.setId(userModified.getId());
			user.setNombre(userModified.getNombre());
			user.setApellidos(userModified.getApellidos());
			user.setDni(userModified.getDni());
			user.setSexo(userModified.getSexo());
			user.setIdUsuario(userModified.getIdUsuario());
			user.setContraseña(userModified.getContraseña());
			user.setEmail(userModified.getEmail());
			user.setTelefono(userModified.getTelefono());
			user.setFechaNacimmiento(userModified.getFechaNacimmiento());
			user.setRoles(userModified.getRoles());
			
			
			em.merge(user);
			
			em.getTransaction().commit();
		}catch (NoResultException nre) {
			System.out.println("Dni "+userModified.getDni()+ " no encontrado");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	
	}
	
	public void borrarUsuarioPorNombre (String dni) {
		 em.getTransaction().begin();
		 try {
			Usuario usuario = buscarPorDni(dni);
			System.out.println(usuario);
           
           
           	em.remove(usuario);
           
           em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	public List<Usuario> buscarPorNombreRol(String nombre, String rol) {
		List<Usuario> usuarios  = em.createQuery(
				"from Usuario where idUsuario=?1 && roles=?2",
				Usuario.class).getResultList();
		return usuarios;
	}
	
	


}
