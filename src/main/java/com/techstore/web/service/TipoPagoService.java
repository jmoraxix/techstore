package com.techstore.web.service;

import com.techstore.web.dao.TipoPagoRepository;
import com.techstore.web.model.TipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoService {

	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	public List<TipoPago> findAll() {
		return tipoPagoRepository.findAll();
	}
}
