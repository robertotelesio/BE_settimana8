package it.wallet.rest;
	import java.util.ArrayList;
	import java.util.List;

	import javax.websocket.server.PathParam;
	import javax.ws.rs.Consumes;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
	import javax.ws.rs.client.Entity;
	import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;

	import it.wallet.pojo.ContoCorrente;
import it.wallet.pojo.Movimenti;
	@Path("/contocorrente")
	public class GestioneEwallet {
		private static List<ContoCorrente> conti = new ArrayList <ContoCorrente>();
		private static List<Movimenti> movimenti= new ArrayList <Movimenti>();
		
		@GET
		@Path("/mostraconti")
		@Produces(MediaType.APPLICATION_JSON)
		public List<ContoCorrente> retrieveConto(){
			
			return conti;
		}
		@DELETE
		@Path("/cancella")
		@Produces(MediaType.APPLICATION_JSON)
		public Response cancellaConto(ContoCorrente c) {
			for(ContoCorrente cc : conti) {
				if(cc.getIban()== cc.getIban()) {
					conti.remove(cc);
					break;
				}
			}
			return Response.status(200).entity("eliminazione avvenuta con successo").build();
			
		}
		@GET
		@Path("/{iban}")
		@Produces(MediaType.APPLICATION_JSON)
		public ContoCorrente retrieveByIban(@PathParam("iban")int iban) {
			ContoCorrente c = null;
			for (ContoCorrente cc : conti) {
				if(cc.getIban()==c.getIban()) {
					c = cc;
					}
				}
			
			return c;
		}
		@POST
		@Path("/crea")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response inserisciIban(ContoCorrente c) {
			conti.add(c);
			return Response.status(200).entity("Inserimento avvenuto con successo").build();	
		}
		
		@PUT
		@Path("/aggiorna")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response aggiornaConto(ContoCorrente c) {
			for(ContoCorrente cc : conti) {
				if(cc.getIban()== c.getIban()) {
					int index = conti.lastIndexOf(cc);
					conti.set(index, c);
				}
			}
			return Response.status(200).entity("Aggiornamento avvenuto con successo").build();	
		}
		
		@PUT
		@Path("/preleva/{importo}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response preleva(ContoCorrente c, @PathParam("importo")double importo) {
			for(ContoCorrente cc : conti) {
				if(cc.getIban()== c.getIban()) {
		double nuovoSaldo = c.getSaldo()-importo;
				c.setSaldo(nuovoSaldo);
				Movimenti mov = new Movimenti();
				mov.setImporto(importo);
				mov.setTipo("prelievo");
				mov.setIbanMov(c.getIban());
				mov.setData("10/10/1910");
				movimenti.add(mov);
					int index = conti.lastIndexOf(cc);
					conti.set(index, c);
				}
			
			}
			return Response.status(200).entity("Aggiornamento avvenuto con successo").build();	
		}
		@PUT
		@Path("/versa/{importo}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response versamento(ContoCorrente c, @PathParam("importo")double importo) {
			for(ContoCorrente cc : conti) {
				if(cc.getIban()== c.getIban()) {
		double nuovoSaldo = c.getSaldo()+importo;
				c.setSaldo(nuovoSaldo);
				Movimenti mov = new Movimenti();
				mov.setImporto(importo);
				mov.setTipo("versamento");
				mov.setIbanMov(c.getIban());
				mov.setData("11/11/2011");
				movimenti.add(mov);
					int index = conti.lastIndexOf(cc);
					conti.set(index, c);
					}
			
				}
			return Response.status(200).entity("Aggiornamento avvenuto con successo").build();	
			}
		}
