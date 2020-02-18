package ifal.edu.br.lista_de_compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerListaCompras {

    ListaCompras listacompras = new ListaCompras();
    
    @Autowired
    RepositoryListaCompras repository;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("listacompra.html");
    }
    
    @RequestMapping("/adicionar")
    public ModelAndView CadastraItem(ListaCompras itemCompras){
     ModelAndView mv = new ModelAndView("redirect:/listacompra");
     repository.save(itemCompras);
     return mv;
    }

    @RequestMapping("/listacompra")
    public ModelAndView listaCompras() {
        ModelAndView mv = new ModelAndView("listacompra");
        mv.addObject("itens", repository.findAll());
        return mv;
    }

    @RequestMapping("/listacompra/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id")long id){
        ModelAndView mv = new ModelAndView("redirect:/listacompra");
        repository.deleteById(id);
        return mv;
    }

    
}