package daos;

import java.util.List;

import entities.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import util.JpaUtil;

public class RolDao {

	private static EntityManager em;

	public RolDao() {
		em = JpaUtil.getEntityManager("hibernateOracle");
	}	

	public Roles buscarPorDni(String rol) {
		//logger.debug("buscarPorDni " + dni);
		Query query = em.createQuery("from Roles a where a.rol=?1", Roles.class);
		query.setParameter(1, rol);
		Roles roles = null;
		try {
			roles = (Roles) query.getSingleResult();
		}catch(NoResultException nre) {
			//logger.error("No se ha econtrado al alumno con Dni "+ dni);
		}

		return roles;
	}

	public void agregarUsuario(Roles rol) {	

		em.getTransaction().begin();
		try {
			em.persist(rol);

			em.getTransaction().commit();
			System.out.println("Insertando usuario");
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Entrando a rollback");
		}
	}

	public boolean isVacio() {
		List<Roles> roles = em.createQuery("from Roles", Roles.class).getResultList();
		System.out.println(roles.size());
		boolean isVacio = false;
		if(roles.isEmpty()) {
			isVacio = true;
		}
		return isVacio;


	}



}
