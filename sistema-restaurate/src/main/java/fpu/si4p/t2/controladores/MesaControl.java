package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fpu.si4p.t2.entidades.Mesa;
import fpu.si4p.t2.repositorios.MesaRepo;

@Controller
public class MesaControl 
{
	@Autowired
	private MesaRepo mesaRepo;
	
	@RequestMapping(value = "/mesa")
	public String listaMesasLivres(Model model) 
	{		
		model.addAttribute("mesas", mesaRepo.findAll());
		return "Mesas";
	}
	
	@RequestMapping(value = "/mesa/save")
	public String salvar(Mesa mesa)
	{
		mesaRepo.save(mesa);
		return "redirect:/mesa";
	}
	
	@RequestMapping(value = "/mesa/del")
	public String deletar(Mesa mesa) 
	{
		mesaRepo.delete(mesa);
		return "redirect:/mesa";
	}
}