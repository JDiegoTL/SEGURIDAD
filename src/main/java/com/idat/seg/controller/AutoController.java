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

import com.idat.seg.DTO.AutoDTORequest;
import com.idat.seg.DTO.AutoDTOResponse;
import com.idat.seg.service.AutoService;

@Controller
@RequestMapping("/auto/v1")
public class AutoController {
	
	@Autowired
	private AutoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<AutoDTOResponse>> listar() {
		return new ResponseEntity<List<AutoDTOResponse>>( service.listarAutos(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody AutoDTORequest autos) {
		service.guardarAuto(autos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		AutoDTOResponse p=service.obtenerAuto(id);
		if(p != null) {
			service.eliminarAuto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody AutoDTORequest auto) {
		AutoDTOResponse p=service.obtenerAuto(auto.getIdAutos());
		
		if(p != null) {
			service.actualizarAuto(auto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<AutoDTOResponse> obtenerID(@PathVariable Integer id) {
		AutoDTOResponse p=service.obtenerAuto(id);
		
		if(p != null) {			
			return new ResponseEntity<AutoDTOResponse>(service.obtenerAuto(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<AutoDTOResponse>(HttpStatus.NOT_FOUND);
	}

}
