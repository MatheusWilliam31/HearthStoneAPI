package br.com.HearthStoneAPI.services;

import java.util.List;

import br.com.HearthStoneAPI.entities.Carta;

public interface CartaService {

	public abstract Carta createdCarta(Carta carta);

	public abstract void updateCarta(Carta carta);

	public abstract List<Carta> getAllCartas();

	public abstract Carta getCartaById(int id);

	public abstract void deleteCarta(int id);

	public abstract boolean isCartaExist(int id);


}
