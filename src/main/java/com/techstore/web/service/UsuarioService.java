package com.techstore.web.service;

import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.Usuario;
import com.techstore.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	public Usuario getCurrentUsuario(){
		return usuarioRepository.findByNombreUsuario(Utils.getCurrentNombreUsuario());
	}

	public Usuario findByNombreUsuario(String nombreUsuario){
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	public void save(Usuario usuario){
		usuarioRepository.save(usuario);
	}

	public void deleteByNombreUsuario(String nombreUsuario){
		usuarioRepository.deleteByNombreUsuario(nombreUsuario);
	}
}
