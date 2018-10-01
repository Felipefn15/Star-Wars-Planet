/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Entidade.Planeta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PlanetaMB {
    private Planeta planeta = new Planeta();
    private List<Planeta> planetas = new ArrayList();
    private Client c = Client.create();
    private Gson gson = new Gson();

    public PlanetaMB() {
        recarregar();
    }

    public void recarregar() {
        WebResource wr = c.resource(
          "http://localhost:8080/PlanetasWSREST/recursos/planeta");
        String json = wr.get(String.class);
        planetas = gson.fromJson(json, new TypeToken<List<Planeta>>() {}.getType());
    }

    public String salvar() {
        WebResource wr = c.resource(
          "http://localhost:8080/PlanetasWSREST/recursos/planeta");
        if(planeta.getId() == null) {
            wr.type("application/json").accept("application/json")
              .post(gson.toJson(planeta));
        } else {
            wr.type("application/json").accept("application/json")
              .put(gson.toJson(planeta));
        }
        planeta = new Planeta();
        recarregar();
        return "index";
    }

    public void remover(Planeta p) {
        WebResource wr = c.resource(
          "http://localhost:8080/PalestraWSREST/recursos/palestra/"+p.getId());
        wr.delete();
        recarregar();
    }

    public void editar(Planeta p) {
        this.planeta = p;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }
}
