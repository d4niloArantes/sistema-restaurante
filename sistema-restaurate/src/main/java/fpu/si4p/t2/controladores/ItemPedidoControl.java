package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpu.si4p.t2.entidades.Item;
import fpu.si4p.t2.entidades.ItemPedido;
import fpu.si4p.t2.entidades.Pedido;
import fpu.si4p.t2.repositorios.ItemPedidoRepo;
import fpu.si4p.t2.repositorios.ItemRepo;
import fpu.si4p.t2.repositorios.MesaRepo;
import fpu.si4p.t2.repositorios.PedidoRepo;

@Controller
public class ItemPedidoControl 
{
	@Autowired
	private ItemPedidoRepo itemPedidoRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private PedidoRepo pedidoRepo;
	
	@Autowired
	private MesaRepo mesaRepo;
	
	@RequestMapping(value = "/itemPedido")
	public String listaEditaPedido(Pedido p, Model model)
	{
		
		if(p.getId() != null)
		{
			model.addAttribute("pedido", pedidoRepo.findOne(p.getId()));
		}else
			model.addAttribute("pedido", new Pedido());
		
		model.addAttribute("pedidos", pedidoRepo.findAll());
		model.addAttribute("itens", itemRepo.findAll());
		model.addAttribute("iPedidos", itemPedidoRepo.findAllOrderPedido());
		return "ItemPedido";
	}
	
	@RequestMapping(value = "/itemPedido2")
	public String listaIPedido(Pedido p, Model model)
	{		
		if(p.getId() != null)
		{
			model.addAttribute("pedido", pedidoRepo.findOne(p.getId()));
		}else
			model.addAttribute("pedido", new Pedido());
		
		model.addAttribute("pedidos", pedidoRepo.findAll());
		model.addAttribute("itens", itemRepo.findAll());
		model.addAttribute("iPedidos", itemPedidoRepo.findAllOrderPedido());
		return "ItemPedido2";
	}
	
	@RequestMapping(value = "/itemPedido/finalizar")
	public String finalizaItemPedido(ItemPedido itemPedido, Model model)
	{
		itemPedidoRepo.setEstadoFinalizado(itemPedido.getId());
		return "redirect:/cozinha";
	}
	
	@RequestMapping(value = "/itemPedido/save")
	public String addItemPedido(@RequestParam("qtdItem") int qtdItem, @RequestParam("item") Long i,
			@RequestParam("pedido") Long p, Model model)
	{
		Pedido pedido = pedidoRepo.findOne(p);
		Item item = itemRepo.findOne(i);
		/*int qtdItemPedido = (int)itemPedidoRepo.verificaItensPedido(pedido.getId(), item.getId());
		if(qtdItemPedido > 0)
		{
			ItemPedido iPedido = itemPedidoRepo.findOne(itemPedidoRepo.retornaItemPedido(pedido.getId(), item.getId()));
			iPedido.setValor(iPedido.getValor()+(qtdItem*item.getPrecoItem()));
			iPedido.setQtdItem(iPedido.getQtdItem()+qtdItem);
			itemPedidoRepo.save(iPedido);
			pedido.setValor(pedido.getValor()+iPedido.getValor());
			pedidoRepo.save(pedido);
		}else{*/
			double valor = qtdItem * item.getPrecoItem();			
			itemPedidoRepo.save(new ItemPedido(pedido, item, qtdItem, valor, 1));
			pedido.setValor(pedido.getValor()+valor);
			pedidoRepo.save(pedido);
			
		return "redirect:/pedido";
	}
	
	@RequestMapping(value = "/itemPedido/del")
	public String deletaItemPedido(ItemPedido iP)
	{
		iP = itemPedidoRepo.findOne(iP.getId());
		Pedido pedido = pedidoRepo.findOne(iP.getPedido().getId());
		pedido.setValor(pedido.getValor()-iP.getValor());
		pedidoRepo.save(pedido);
		itemPedidoRepo.delete(iP);
		
		return "redirect:/itemPedido2";
	}
}
