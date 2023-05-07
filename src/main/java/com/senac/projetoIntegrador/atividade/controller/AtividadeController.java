package com.senac.projetoIntegrador.atividade.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoIntegrador.atividade.response.LatestAtividadesResponse;
import com.senac.projetoIntegrador.atividade.service.IAtividadeService;

@RestController
@RequestMapping(value = "/atividade", produces = "application/json")
public class AtividadeController {
	@Autowired
	IAtividadeService service;
	
	@GetMapping("/latest/{usuarioId}")
	public ResponseEntity<List<LatestAtividadesResponse>> retrieveLatestAtividadesByUsuarioId(@PathVariable(required = true, value = "usuarioId") String usuarioId){
		List<LatestAtividadesResponse> listaAtividades = service.getLatestAtividadesByUsuarioId(usuarioId).stream()
				.map(item -> new LatestAtividadesResponse(
						item.getDescricao(),
						item.getDataFim()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<LatestAtividadesResponse>>(listaAtividades, HttpStatus.OK);
	}
}
