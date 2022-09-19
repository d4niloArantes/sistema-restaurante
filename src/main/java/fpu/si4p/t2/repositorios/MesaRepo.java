package fpu.si4p.t2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import fpu.si4p.t2.entidades.Mesa;

public interface MesaRepo extends CrudRepository<Mesa, Long> 
{
	@Query("from Mesa where estado = 1")
	public List<Mesa> findAllMesasLivres();
	
	@Modifying
	@Transactional
	@Query("update Mesa m set m.estado = 0 where m.id = ?1")
	public void setMesaReservada(Long id);
	
	@Modifying
	@Transactional
	@Query("update Mesa set estado = 1 where id = ?1")
	public void setMesaLivre(Long id);
}
