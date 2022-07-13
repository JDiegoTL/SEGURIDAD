package com.idat.seg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.seg.DTO.MotorDTORequest;
import com.idat.seg.DTO.MotorDTOResponse;
import com.idat.seg.model.Motor;
import com.idat.seg.repository.MotorRepository;

public class MotorServiceImpl implements MotorService{
	
	@Autowired
	private MotorRepository repository;
	
	@Override
	public void guardarMotor(MotorDTORequest motor) {
		Motor m = new Motor();
		
		m.setDescripcion(motor.getDescripcion());
		
		repository.save(m);
	}

	@Override
	public void actualizarMotor(MotorDTORequest motor) {
		Motor m = new Motor();
		
		m.setIdMotor(motor.getIdMotor());
		m.setDescripcion(motor.getDescripcion());
		
		repository.saveAndFlush(m);
	}

	@Override
	public void eliminarMotor(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<MotorDTOResponse> listarMotores() {
		
		List<MotorDTOResponse> listar = new ArrayList<>();
		
		MotorDTOResponse dto = null;
		
		List<Motor> m = repository.findAll();
		
		for(Motor motor:m) {
			
			dto = new MotorDTOResponse();
			
			dto.setDescripcion(motor.getDescripcion());
			dto.setIdMotor(motor.getIdMotor());
			
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public MotorDTOResponse obtenerMotor(Integer id) {
		
		Motor motor = repository.findById(id).orElse(null);
		MotorDTOResponse dto = new MotorDTOResponse();
		
		dto.setDescripcion(motor.getDescripcion());
		dto.setIdMotor(motor.getIdMotor());
		
		return dto;
	}

}
