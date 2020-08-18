package com.techstore.web.service;

import com.techstore.web.dao.ItemOrdenRepository;
import com.techstore.web.dao.OrdenRepository;
import com.techstore.web.model.ItemOrden;
import com.techstore.web.model.Orden;
import com.techstore.web.model.Producto;
import com.techstore.web.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ItemOrdenRepository itemOrdenRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    private Orden findById(Long id){
        return ordenRepository.findById(id).get();
    }

    public Orden getCurrentOrden(){
        return getOrdenUsuario(usuarioService.getCurrentUsuario());
    }

    public Orden getOrdenUsuario(Usuario usuario){
        Orden orden = ordenRepository.findFirstByUsuarioAndActivaTrue(usuario);
        if(orden == null){
            orden = new Orden();
            orden.setUsuario(usuario);
            ordenRepository.save(orden);
            orden = ordenRepository.findFirstByUsuarioAndActivaTrue(usuario);
        } else {
            orden.setItems(getItemsOrden(orden));
        }
        return orden;
    }

    public void agregarProductoOrden(Long productoId){
        // Buscamos el producto y la carrito activa
        Producto producto = productoService.getProductoById(productoId);
        Orden orden = getCurrentOrden();
        // Buscamos si existe ya un item con ese producto en la carrito
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

    public void eliminarProductoOrden(Long itemOrdenId){
        itemOrdenRepository.deleteById(itemOrdenId);
    }

    public void guardarOrden(Orden orden){
        ordenRepository.save(orden);
    }

    public void actualizarOrden(Orden ordenActualizar){
        Orden ordenActual = findById(ordenActualizar.getId());
        ordenActual.setActiva(ordenActualizar.isActiva());
        ordenRepository.save(ordenActual);
    }

    private List<ItemOrden> getItemsOrden(Orden orden){
        List<ItemOrden> listaItems = itemOrdenRepository.findAllByOrden(orden);
        return listaItems.isEmpty() ? new ArrayList<ItemOrden>() : listaItems;
    }
}
