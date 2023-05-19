package com.senac.projetoIntegrador.unidadeCurricular.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoIntegrador.unidadeCurricular.response.CurrentUnidadesCurricularesResponse;
import com.senac.projetoIntegrador.unidadeCurricular.service.IUnidadeCurricularService;

@RestController
@RequestMapping(value = "/unidadecurricular", produces = "application/json")
public class UnidadeCurricularController {
	@Autowired
	IUnidadeCurricularService service;
	
	@GetMapping("/cursando/{usuarioId}")
	public ResponseEntity<List<CurrentUnidadesCurricularesResponse>> retrieveCurrentUnidadesCurricularesById(@PathVariable(required = true, value = "usuarioId") String usuarioId){
		List<CurrentUnidadesCurricularesResponse> listaUnidadesCurriculares = service.getCurrentUnidadesCurricularesByUsuarioId(usuarioId).stream()
				.map(item -> new CurrentUnidadesCurricularesResponse(
					item.getNomeCurto()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<CurrentUnidadesCurricularesResponse>>(listaUnidadesCurriculares, HttpStatus.OK);
	}

}
