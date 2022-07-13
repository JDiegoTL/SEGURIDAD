package com.idat.seg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.seg.DTO.AutoDTORequest;
import com.idat.seg.DTO.AutoDTOResponse;
import com.idat.seg.model.Auto;
import com.idat.seg.repository.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService{
	
	@Autowired
	private AutoRepository repository;
	
	@Override
	public void guardarAuto(AutoDTORequest auto) {
		Auto a = new Auto();
		a.setCilindraje(auto.getCilindraje());
		a.setPotencia(auto.getPotencia());
		a.setPrecio(auto.getPrecio());
		a.setObservaciones(auto.getObservaciones());
		
		repository.save(a);
	}

	@Override
	public void actualizarAuto(AutoDTORequest auto) {
		Auto a = new Auto();
		a.setIdAutos(auto.getIdAutos());
		a.setCilindraje(auto.getCilindraje());
		a.setPotencia(auto.getPotencia());
		a.setPrecio(auto.getPrecio());
		a.setObservaciones(auto.getObservaciones());
		
		repository.saveAndFlush(a);
	}

	@Override
	public void eliminarAuto(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<AutoDTOResponse> listarAutos() {
		List<AutoDTOResponse> listar = new ArrayList<>();
		
		AutoDTOResponse dto = null;
		
		List<Auto> a = repository.findAll();
		
		for(Auto auto:a) {
			
			dto = new AutoDTOResponse();
			
			dto.setCilindraje(auto.getCilindraje());
			dto.setPotencia(auto.getPotencia());
			dto.setPrecio(auto.getPrecio());
			dto.setObservaciones(auto.getObservaciones());
			dto.setIdAutos(auto.getIdAutos());
			
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public AutoDTOResponse obtenerAuto(Integer id) {
		
		Auto auto = repository.findById(id).orElse(null);
		AutoDTOResponse dto = new AutoDTOResponse();
		
		dto.setCilindraje(auto.getCilindraje());
		dto.setPotencia(auto.getPotencia());
		dto.setPrecio(auto.getPrecio());
		dto.setObservaciones(auto.getObservaciones());
		dto.setIdAutos(auto.getIdAutos());
		
		return dto;
	}

}
