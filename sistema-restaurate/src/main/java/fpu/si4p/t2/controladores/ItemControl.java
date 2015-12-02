package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fpu.si4p.t2.entidades.Item;
import fpu.si4p.t2.repositorios.ItemRepo;

@Controller
public class ItemControl 
{
	@Autowired
	private ItemRepo itemRepo;
	
	@RequestMapping(value = "/prato")
	public String listaMesasLivres(Item item, Model model) 
	{
		if(item.getId() != null)
			model.addAttribute("prato", itemRepo.findOne(item.getId()));
		else
			model.addAttribute("prato", new Item());
		
		model.addAttribute("pratos", itemRepo.findAll());
		return "Pratos";
	}
	
	@RequestMapping(value = "/prato/save")
	public String salvar(Item item) 
	{
		itemRepo.save(item);
		return "redirect:/prato";
	}
	
	@RequestMapping(value = "/prato/del")
	public String deletar(Item item) 
	{
		itemRepo.delete(item);
		return "redirect:/prato";
	}
}
