package fpu.si4p.t2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fpu.si4p.t2.entidades.Usuarios;
import fpu.si4p.t2.repositorios.UsuarioRepository;


@Controller
public class UsuariosController {

	@Autowired
	private UsuarioRepository usuarioRepositorio;

	@RequestMapping("/usuario")
	public String listaEditaUsuarios(Usuarios usuario, Model model) {
		model.addAttribute("usuarios", usuarioRepositorio.findAll());

		if (usuario.getId() != null) {
			model.addAttribute("usuario", usuarioRepositorio.findOne(usuario.getId()));
		} else
			model.addAttribute("usuario", new Usuarios());

		return "usuarios";
	}

	@RequestMapping("/usuario/save")
	public String salvarUsuario(Usuarios usuario) {
		usuarioRepositorio.save(usuario);
		return "redirect:/usuario";
	}

	@RequestMapping("/usuario/delete")
	public String deletar(Usuarios usuario) {
		usuarioRepositorio.delete(usuario);
		return "redirect:/usuario";
	}
}
