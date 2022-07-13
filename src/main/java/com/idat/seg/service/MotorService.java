package com.idat.seg.service;

import java.util.List;

import com.idat.seg.DTO.MotorDTORequest;
import com.idat.seg.DTO.MotorDTOResponse;

public interface MotorService {

	void guardarMotor(MotorDTORequest motor);
	void actualizarMotor(MotorDTORequest motor);
	void eliminarMotor(Integer id);
	List<MotorDTOResponse> listarMotores();
	MotorDTOResponse obtenerMotor(Integer id);
}
