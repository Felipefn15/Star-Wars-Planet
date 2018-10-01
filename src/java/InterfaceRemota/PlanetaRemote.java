/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceRemota;

import Entidade.Planeta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Felipe França Nogueira
 */
@Remote
public interface PlanetaRemote {
     public Planeta salvar(Planeta p) throws Exception; 
     public void deletar(long id) throws Exception;
     public Planeta consultaPorNome(String nome);
     public Planeta consultaPorId(long id);
     public List<Planeta> consultaTotal();
}
