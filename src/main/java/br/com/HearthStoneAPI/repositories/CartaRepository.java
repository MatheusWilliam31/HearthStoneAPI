package br.com.HearthStoneAPI.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.HearthStoneAPI.entities.Carta;

public interface CartaRepository extends CrudRepository<Carta, Integer> {

}
