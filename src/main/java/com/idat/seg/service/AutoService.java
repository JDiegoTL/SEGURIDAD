package com.idat.seg.service;

import java.util.List;

import com.idat.seg.DTO.AutoDTORequest;
import com.idat.seg.DTO.AutoDTOResponse;




public interface AutoService {

	void guardarAuto(AutoDTORequest auto);
	void actualizarAuto(AutoDTORequest auto);
	void eliminarAuto(Integer id);
	List<AutoDTOResponse> listarAutos();
	AutoDTOResponse obtenerAuto(Integer id);

}
