package mains;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class PruebMain {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager("hibernateOracle");
	}

}
