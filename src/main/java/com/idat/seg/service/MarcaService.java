package com.idat.seg.service;

import java.util.List;

import com.idat.seg.DTO.MarcaDTORequest;
import com.idat.seg.DTO.MarcaDTOResponse;

public interface MarcaService {

	void guardarMarca(MarcaDTORequest marca);
	void actualizarMarca(MarcaDTORequest marca);
	void eliminarMarca(Integer id);
	List<MarcaDTOResponse> listarMarcas();
	MarcaDTOResponse obtenerMarca(Integer id);
}
