package br.com.HearthStoneAPI.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.HearthStoneAPI.entities.Carta;
import br.com.HearthStoneAPI.entities.Cartas;
import br.com.HearthStoneAPI.resources.exceptions.CartaNotfoundException;
import br.com.HearthStoneAPI.services.CartaService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cartas")
@Path("/cartas")
public class CartaResource {

	@Autowired
	private CartaService cartaService;

	@RolesAllowed("ADMIN")
	@POST
	@Consumes("hearthStoneApiApplication/jsons")
	public Response createdCarta(Carta carta) throws URISyntaxException {
		carta = cartaService.createdCarta(carta);
		return Response.status(201).entity("Carta criada com sucesso, com o id " + carta.getId())
				.contentLocation(new URI("/cartas/" + carta.getId())).build();
	}

	@RolesAllowed("ADMIN")
	@PUT
	@Path("/{id}")
	@Consumes("hearthStoneApiApplication/jsons")
	@Produces("hearthStoneApiApplication/jsons")
	public Response updateCarta(@PathParam("id") int id, Carta carta) throws URISyntaxException {
		boolean isCartaExist = cartaService.isCartaExist(id);
		if (isCartaExist) {
			cartaService.updateCarta(carta);
			return Response.status(200).entity("Carta atualizada com sucesso!").build();
		} else {
			return Response.status(400).entity("Carta não encontrada").build();
		}
	}

	@PermitAll
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cartas getAllCartas() {
		Cartas cartas = new Cartas();
		ArrayList<Carta> cartasList = (ArrayList<Carta>) cartaService.getAllCartas();
		cartas.setCartas(cartasList);
		return cartas;
	}

	@PermitAll
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCartaById(@PathParam("id") int id) throws URISyntaxException {
		boolean isCartaExist = cartaService.isCartaExist(id);
		if (isCartaExist) {
			Carta carta = cartaService.getCartaById(id);
			return Response.status(200).entity(carta).contentLocation(new URI("/cartas/" + carta.getId())).build();
		} else {
			return Response.status(400).entity("Carta não encontrada").build();
		}
	}

	@DenyAll
	@DELETE
	@Path("/{id}")
	public Response deleteEmployee(@PathParam("id") int id) throws URISyntaxException, CartaNotfoundException {
		boolean isCartaExist = cartaService.isCartaExist(id);
		if (isCartaExist) {
			cartaService.deleteCarta(id);
			return Response.status(200).entity("Carta deletada com sucesso").build();
		} else {
			throw new CartaNotfoundException("Carta não encontrada");
		}
	}

}
