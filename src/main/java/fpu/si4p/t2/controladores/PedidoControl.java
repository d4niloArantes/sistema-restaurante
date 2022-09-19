package fpu.si4p.t2.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpu.si4p.t2.entidades.Mesa;
import fpu.si4p.t2.entidades.Pedido;
import fpu.si4p.t2.repositorios.ItemPedidoRepo;
import fpu.si4p.t2.repositorios.ItemRepo;
import fpu.si4p.t2.repositorios.MesaRepo;
import fpu.si4p.t2.repositorios.PedidoRepo;

@Controller
public class PedidoControl 
{
	@Autowired
	private PedidoRepo pedidoRepo;
	
	@Autowired
	private MesaRepo mesaRepo;
	
	@Autowired
	private ItemPedidoRepo itemPedidoRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@RequestMapping(value = "/pedido")
	public String realizaPedido(Model model)
	{
		model.addAttribute("iPedidos", itemPedidoRepo.findAllOrderPedido());
		model.addAttribute("itens", itemRepo.findAll());
		model.addAttribute("mesas", mesaRepo.findAllMesasLivres());
		model.addAttribute("pedidos", pedidoRepo.findAllPedidosAbertos());
		return "Pedidos";
	}
	
	@RequestMapping(value = "/pedido/save")
	public String salvar(@RequestParam("mesa") Long Mesa)
	{	
		Mesa mesa = mesaRepo.findOne(Mesa);
		mesaRepo.setMesaReservada(mesa.getId());
		Pedido pedido = new Pedido(mesa, new Date(), 0.0, 1);
		pedidoRepo.save(pedido);
		return "redirect:/pedido";
	}
	
	@RequestMapping(value = "/pedido/del")
	public String deletar(Pedido pedido) 
	{
		pedidoRepo.delete(pedido);
		return "redirect:/pedido";
	}
	
	@RequestMapping(value = "/pedido/finalizar")
	public String finalizaPedido(Pedido p)
	{
		if (itemPedidoRepo.contaItensPedidoEmAberto(p.getId()) > 0)
			return "redirect:/pedido?error";
		
		p = pedidoRepo.findOne(p.getId());
		pedidoRepo.setPedidoFinalizado(p.getId());
		mesaRepo.setMesaLivre(p.getMesa().getId());
		return "redirect:/fatura?id="+p.getId();
	}
}
