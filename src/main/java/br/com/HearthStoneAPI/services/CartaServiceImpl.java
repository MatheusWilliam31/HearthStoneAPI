package br.com.HearthStoneAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.HearthStoneAPI.entities.Carta;
import br.com.HearthStoneAPI.repositories.CartaRepository;

@Service
public class CartaServiceImpl implements CartaService {

	@Autowired
	private CartaRepository repository;

	@Override
	public Carta createdCarta(Carta carta) {

		return repository.save(carta);
	}

	@Override
	public void updateCarta(Carta carta) {
		repository.save(carta);
	}

	@Override
	public List<Carta> getAllCartas() {

		return (List<Carta>) repository.findAll();

	}

	@Override
	public Carta getCartaById(int id) {
		Optional<Carta> obj = repository.findById(id);
		Carta carta = obj.get();
		return carta;
	}

	@Override
	public void deleteCarta(int id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isCartaExist(int id) {
		return repository.existsById(id);
	}

}
