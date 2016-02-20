package fpu.si4p.t2.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fpu.si4p.t2.entidades.Usuarios;

public interface UsuarioRepository extends CrudRepository<Usuarios, Long>{
	@Query(value = "select * from Usuarios where name = ?1", nativeQuery = true)
	public List<Usuarios> findByName(String name);
}
