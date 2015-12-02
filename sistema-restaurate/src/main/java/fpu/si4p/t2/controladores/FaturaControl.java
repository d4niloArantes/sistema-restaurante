package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fpu.si4p.t2.entidades.Pedido;
import fpu.si4p.t2.repositorios.ItemPedidoRepo;
import fpu.si4p.t2.repositorios.PedidoRepo;

@Controller
public class FaturaControl 
{	
	@Autowired
	private ItemPedidoRepo itemPedidoRepo;
	
	@Autowired
	private PedidoRepo pRepo;
	
	@RequestMapping(value = "/fatura")
	public String listaEditaPedido(Pedido pedido, Model model)
	{
		model.addAttribute("iPedidos", itemPedidoRepo.findAllItensDoPedido(pedido.getId()));
		model.addAttribute("pedido", pRepo.findOne(pedido.getId()));
		return "Fatura";
	}
}
