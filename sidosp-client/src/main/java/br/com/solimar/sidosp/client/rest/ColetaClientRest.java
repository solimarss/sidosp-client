package br.com.solimar.sidosp.client.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ColetaClientRest implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SERVER_URI = "http://67.205.95.237:10995/sidosp-m2/service";
	/*private static final String SERVER_URI = "http://localhost:8080/sidosp-m2/service";*/

	private static final String ENTRY_POINT = "/coleta";

	public int insert(Coleta coleta) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(SERVER_URI + ENTRY_POINT + "/");

		Response response = null;
		try {

			response = target.request(MediaType.APPLICATION_JSON)
					.buildPost(Entity.json(coleta)).invoke();

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
		
		return response.getStatus();

	}
	
	
	public Coleta find(long id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(SERVER_URI + ENTRY_POINT + "/" + id);

		Response response = null;
		try {

			response = target.request(MediaType.APPLICATION_JSON).get(
					Response.class);

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Status: " + response.getStatus());

		return response.readEntity(Coleta.class);

	}

	public static void main(String[] args) {

		ColetaClientRest cliente = new ColetaClientRest();

		System.out.println("******** Insert **********************");
		Coleta c = new Coleta();
		c.setNumero(123L);
		c.setData(new Date());
		c.setHorario(new Date());
		c.setDoadorNum(12l);
		c.setLaboratorioNum(234l);
		
		
		Exame exame = new Exame();
		exame.setCodigo(123l);
		exame.setNome("Hemograma");
		
		c.setExames(new ArrayList<Exame>());
		c.getExames().add(exame);

		int status = cliente.insert(c);
		System.out.println("Resposta status: " + status);
		
		Coleta resp = cliente.find(123);
		System.out.println("Resposta doador nº: " + resp.getDoadorNum());

	}

}
