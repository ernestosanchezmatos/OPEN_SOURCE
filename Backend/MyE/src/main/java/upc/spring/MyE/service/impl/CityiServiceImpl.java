package upc.spring.MyE.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import upc.spring.MyE.model.entity.City;
import upc.spring.MyE.model.repository.CityRepository;
import upc.spring.MyE.service.CityService;

public class CityiServiceImpl implements CityService {

	@Autowired
	private CityRepository CityRepo;
	
	@Transactional(readOnly=true)
	@Override
	public List<City> findAll() throws Exception {
		return CityRepo.findAll();
	}

	@Transactional
	@Override
	public City save(City t) throws Exception {
		return CityRepo.save(t);
	}

	@Transactional
	@Override
	public City update(City t) throws Exception {
		return CityRepo.save(t);
	}

	@Transactional (readOnly = true)
	@Override
	public Optional<City> findById(Integer id) throws Exception {
		return CityRepo.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		CityRepo.deleteById(id);		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		CityRepo.deleteAll();
	}

}
