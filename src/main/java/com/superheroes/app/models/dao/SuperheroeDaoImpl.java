package com.superheroes.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.superheroes.app.models.entity.SuperHeroe;
@Repository
public class SuperheroeDaoImpl implements ISuperheroeDao {
	
	@PersistenceContext
	private EntityManager em; 
	
	@SuppressWarnings("unchecked")
	@Transactional()
	@Override
	public List<SuperHeroe> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from SuperHeroe").getResultList();
	}

	@Override
	@Transactional 
	public void save(SuperHeroe superheroe) {
		if(superheroe.getId()!= null && superheroe.getId()>0) {
			em.merge(superheroe);
		}else {
			em.persist(superheroe);
		}
		
		
	}

	@Override
	public SuperHeroe findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(SuperHeroe.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
		
	}

}
