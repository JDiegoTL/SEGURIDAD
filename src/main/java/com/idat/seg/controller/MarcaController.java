package com.idat.seg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.seg.DTO.MarcaDTORequest;
import com.idat.seg.DTO.MarcaDTOResponse;
import com.idat.seg.service.MarcaService;

@Controller
@RequestMapping("/marca/v1")
public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<MarcaDTOResponse>> listar() {
		return new ResponseEntity<List<MarcaDTOResponse>>( service.listarMarcas(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MarcaDTORequest autos) {
		service.guardarMarca(autos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		MarcaDTOResponse p=service.obtenerMarca(id);
		if(p != null) {
			service.eliminarMarca(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody MarcaDTORequest marca) {
		MarcaDTOResponse p=service.obtenerMarca(marca.getIdMarca());
		
		if(p != null) {
			service.actualizarMarca(marca);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MarcaDTOResponse> obtenerID(@PathVariable Integer id) {
		MarcaDTOResponse p=service.obtenerMarca(id);
		
		if(p != null) {			
			return new ResponseEntity<MarcaDTOResponse>(service.obtenerMarca(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<MarcaDTOResponse>(HttpStatus.NOT_FOUND);
	}

}
