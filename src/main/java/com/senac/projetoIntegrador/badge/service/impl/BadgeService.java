package com.senac.projetoIntegrador.badge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.badge.dto.BadgeDto;
import com.senac.projetoIntegrador.badge.repository.IBadgeRepository;
import com.senac.projetoIntegrador.badge.service.IBadgeService;

@Service
public class BadgeService implements IBadgeService{
	@Autowired
	IBadgeRepository repository;

	public List<BadgeDto> getLatestBadgesByUsuarioId(String usuarioId) {
		return repository.getLatestBadgesByUsuarioId(usuarioId);
	}
}
