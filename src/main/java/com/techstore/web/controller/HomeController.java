package com.techstore.web.controller;
import java.util.List;
import java.util.Optional;
import com.techstore.web.dao.CategoriaRepository;
import com.techstore.web.dao.ProductoRepository;
import com.techstore.web.dao.TipoProductoRepository;
import com.techstore.web.model.Categoria;
import com.techstore.web.model.Producto;
import com.techstore.web.model.TipoProducto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Log4j2
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/{categoriaID}")
    public ModelAndView mostrartipoproducto(@PathVariable Long categoriaID,ModelMap model){
        List<TipoProducto> tipoProducto = tipoProductoRepository.findAllByCategoriaId(categoriaID);
        Optional<Categoria> categoria=categoriaRepository.findById(categoriaID);
        model.addAttribute("categoria",categoria.get());
        model.addAttribute("tipoproducto",tipoProducto);
        return new ModelAndView("home/hometipoproducto",model);
    }

    @GetMapping("/categoria/{lista}")
    public ModelAndView mostrarproducto(@PathVariable Long lista,ModelMap model){
        List<Producto> productos= productoRepository.findAllByTipoProducto_Id(lista);
        Optional<TipoProducto>tipo=tipoProductoRepository.findById(lista);
        //Categoria categoria=categoriaRepository.findById(tipoProductoRepository.findByCategoria_Id(lista));
        //model.addAttribute("categoria",categoria);
        model.addAttribute("tipo",tipo.get());
        model.addAttribute("productos",productos);
        return new ModelAndView("home/homeproductos",model);
    }

    @GetMapping("/")
    public ModelAndView mostrarcategorias(ModelMap model){
        List<Categoria>listaCategoria=categoriaRepository.findAll();
        model.addAttribute("categorias",listaCategoria);
        return new ModelAndView("home/home",model);
    }
}
