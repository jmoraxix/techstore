package com.techstore.web.service;

import com.techstore.web.dao.ItemOrdenRepository;
import com.techstore.web.dao.OrdenRepository;
import com.techstore.web.dao.UsuarioRepository;
import com.techstore.web.model.ItemOrden;
import com.techstore.web.model.Orden;
import com.techstore.web.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ItemOrdenRepository itemOrdenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoService productoService;

    public Orden gerOrden(){
        String nombreUsuario = getCurrentNombreUsuario();
        Orden orden = ordenRepository.getOrdenActiva(nombreUsuario);
        if(orden == null){
            orden = new Orden();
            orden.setUsuario(usuarioRepository.findByNombreUsuario(nombreUsuario));
            ordenRepository.save(orden);
            orden = ordenRepository.getOrdenActiva(nombreUsuario);
        } else {
            orden.setItems(itemOrdenRepository.findAllByOrden(orden));
        }
        return orden;
    }

    public void agregarProductoOrden(Long productoId){
        // Buscamos el producto y la orden activa
        Producto producto = productoService.getProductoById(productoId);
        Orden orden = gerOrden();
        // Buscamos si existe ya un item con ese producto en la orden
        ItemOrden itemOrden = orden.getItems().stream().filter(item -> item.getProducto().equals(producto)).findFirst().orElse(null);

        if(itemOrden != null){
            itemOrden.setCantidad(itemOrden.getCantidad() + 1);
            itemOrdenRepository.save(itemOrden);
        } else {
            itemOrden = new ItemOrden();
            itemOrden.setOrden(orden);
            itemOrden.setProducto(producto);
            itemOrden.setCantidad(1);
            itemOrdenRepository.save(itemOrden);
        }
    }

    public void guardarOrden(Orden orden){
        ordenRepository.save(orden);
    }

    private String getCurrentNombreUsuario(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
