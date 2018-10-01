package InterfaceRemota;

import DAO.DAO_Planet;
import Entidade.Planeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe França Nogueira
 */
@Stateless
public class PlanetaBean implements PlanetaRemote{
    @PersistenceContext(unitName = "PlanetaPU")
    private EntityManager em;
    @Override
    public Planeta salvar(Planeta p) throws Exception {
       DAO_Planet dao = new DAO_Planet(em);
       return dao.salvar(p);
    }

    @Override
    public void deletar(long id) throws Exception {
        DAO_Planet dao = new DAO_Planet(em);
        dao.deletar(id);
    }

    @Override
    public Planeta consultaPorNome(String nome) {
       DAO_Planet dao = new DAO_Planet(em);
       return dao.consultaPorNome(nome);
    }

    @Override
    public Planeta consultaPorId(long id) {
        DAO_Planet dao = new DAO_Planet(em);
        return dao.consultaPorId(id);
    }

    @Override
    public List<Planeta> consultaTotal() {
        DAO_Planet dao = new DAO_Planet(em);
        return dao.consultaTotal();
    }
}
