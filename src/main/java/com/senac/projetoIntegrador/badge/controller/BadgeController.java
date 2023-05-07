package com.senac.projetoIntegrador.badge.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoIntegrador.badge.response.LatestBadgesResponse;
import com.senac.projetoIntegrador.badge.service.IBadgeService;

@RestController
@RequestMapping(value = "/badge", produces = "application/json")
public class BadgeController {
	@Autowired
	IBadgeService service;
	
	@GetMapping("latest/{usuarioId}")
	public ResponseEntity<List<LatestBadgesResponse>> retrieveLatestBadgesByUsuarioId(@PathVariable(required = true, value = "usuarioId") String usuarioId) {
		List<LatestBadgesResponse> listaBadges = service.getLatestBadgesByUsuarioId(usuarioId).stream()
				.map(item -> new LatestBadgesResponse(
						item.getDescricao(),
						item.getImagem()))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<LatestBadgesResponse>>(listaBadges, HttpStatus.OK);
	}
	
}
