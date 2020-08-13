package com.techstore.web.service;

import com.techstore.web.dao.FacturaRepository;
import com.techstore.web.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private UsuarioService usuarioService;

	public List<Factura> getListaFacturas(){
		return facturaRepository.getAllByUsuario(usuarioService.getCurrentUsuario());
	}

	public void guardarFactura(Factura factura){
		facturaRepository.save(factura);
	}
}
