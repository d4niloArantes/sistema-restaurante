package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fpu.si4p.t2.repositorios.ItemPedidoRepo;

@Controller
public class CozinhaControl 
{
	@Autowired
	private ItemPedidoRepo itemPedidoRepo;
	
	@RequestMapping(value = "/cozinha")
	public String mostraPedidos(Model model)
	{
		model.addAttribute("itemPedidos", itemPedidoRepo.findAllEstadoAberto());
		return "Cozinha";
	}
}
