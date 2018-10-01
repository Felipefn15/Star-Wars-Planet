package DAO;

import Entidade.Planeta;
import InterfaceRemota.PlanetaRemote;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Felipe França Nogueira
 */
@Path("planeta")
public class PlanetaResource {
   private Gson gson = new Gson();

    @EJB
    private PlanetaRemote ejb;

    public PlanetaResource() {
    }

    @GET
    @Produces("application/json")
    public String getPlanetas() {
        return gson.toJson(ejb.consultaTotal());
    }

    @Path("{id}")
    @GET
    @Produces("application/json")
    public String getPlanetaID(@PathParam("id") String planetaId) {
        return gson.toJson(ejb.consultaPorId(Long.valueOf(planetaId)));
    }

    @Path("{nome}")
    @GET
    @Produces("application/json")
    public String getPlanetaNome(@PathParam("id") String planetaNome) {
        return gson.toJson(ejb.consultaPorNome(planetaNome));
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String salvarPlaneta(String planeta) {
        try {
            Planeta p = gson.fromJson(planeta, Planeta.class);
            return gson.toJson(ejb.salvar(p));
        } catch (Exception e) {
            return null;
        }
    }

    @DELETE
    @Path("/{id}")
    public void removerPlaneta(final @PathParam("id") String id) throws Exception {
        ejb.deletar(Long.valueOf(id));
    }

    @PUT
    @Consumes("application/json")
    public void putPlaneta(String planeta) {
        salvarPlaneta(planeta);
    }
}
