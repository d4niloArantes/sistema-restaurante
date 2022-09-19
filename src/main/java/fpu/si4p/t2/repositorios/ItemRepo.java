package fpu.si4p.t2.repositorios;

import org.springframework.data.repository.CrudRepository;
import fpu.si4p.t2.entidades.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {}
