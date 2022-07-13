package com.idat.seg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.seg.DTO.MarcaDTORequest;
import com.idat.seg.DTO.MarcaDTOResponse;
import com.idat.seg.model.Marca;
import com.idat.seg.repository.MarcaRepository;

public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	@Override
	public void guardarMarca(MarcaDTORequest marca) {
		Marca m = new Marca();
		
		m.setDescripcion(marca.getDescripcion());
		
		repository.save(m);
	}

	@Override
	public void actualizarMarca(MarcaDTORequest marca) {
		Marca m = new Marca();
		
		m.setIdMarca(marca.getIdMarca());
		m.setDescripcion(marca.getDescripcion());
		
		repository.saveAndFlush(m);
	}

	@Override
	public void eliminarMarca(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<MarcaDTOResponse> listarMarcas() {
		List<MarcaDTOResponse> listar = new ArrayList<>();
		
		MarcaDTOResponse dto = null;
		
		List<Marca> m = repository.findAll();
		
		for(Marca marca:m) {
			
			dto = new MarcaDTOResponse();
			
			dto.setDescripcion(marca.getDescripcion());
			dto.setIdMarca(marca.getIdMarca());
			
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public MarcaDTOResponse obtenerMarca(Integer id) {
		
		Marca marca = repository.findById(id).orElse(null);
		MarcaDTOResponse dto = new MarcaDTOResponse();
		
		dto.setDescripcion(marca.getDescripcion());
		dto.setIdMarca(marca.getIdMarca());
		
		return dto;
	}

}
