/**
 * 
 */
package com.superheroes.app.models.test;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superheroes.app.models.dao.ISuperheroeDao;
import com.superheroes.app.models.dao.SuperheroeDaoImpl;
import com.superheroes.app.models.entity.SuperHeroe;

/**
 * @author Cesar
 * @version 1.0 20/05/2021
 *
 */
public class SuperheroeDaoImplTest {

	private ISuperheroeDao superheroeDao = new SuperheroeDaoImpl();

	/**
	 * Test method for
	 * {@link com.superheroes.app.models.dao.SuperheroeDaoImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		System.out.println("Test de buscar todos los superheroes ");

		List<SuperHeroe> superheroes = superheroeDao.findAll();

		for (SuperHeroe superheroe : superheroes) {
			System.out.println("superheroe:" + superheroe.getNombre());
		}

	}

}
