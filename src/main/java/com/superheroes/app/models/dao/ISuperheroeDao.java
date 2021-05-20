package com.superheroes.app.models.dao;

import java.util.List;

import com.superheroes.app.models.entity.SuperHeroe;

public interface ISuperheroeDao {
	
	public List<SuperHeroe> findAll();
	
	public void save(SuperHeroe superheroe);
	
	public SuperHeroe findOne(Long id);
	
	public void delete(Long id);

}
