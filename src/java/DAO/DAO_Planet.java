package DAO;
import Entidade.Planeta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query; 
import javax.persistence.TypedQuery;
/**
 *
 * @author Felipe França Nogueira
 */
public class DAO_Planet {
   private EntityManager em; 
   public DAO_Planet(EntityManager em){
       this.em = em;
   } 
   
   public Planeta salvar(Planeta p) throws Exception{
       if(p.getId() == null){
           em.persist(p);
       }
       else{
           if(!em.contains(p)){
               if(em.find(Planeta.class, p.getId())==null){
                   throw new Exception("Erro ao atualizar o planeta!");
               }
           }
           p = em.merge(p);
       }
       return(p);
   }
   public void deletar(long id) throws Exception{
       if(em.find(Planeta.class, id)==null){
           throw new Exception("Planeta não encontrado");
       }
       else{
           Planeta p =  em.find(Planeta.class, id);
           em.remove(p);         
       }      
   }
   
   public Planeta consultaPorNome(String nome){
       TypedQuery <Planeta> query = em.createQuery("select * from Planetas where nome = :nome",Planeta.class);
       return query.setParameter("nome", nome).getSingleResult();
   }
   
   public Planeta consultaPorId(long id){
       return em.find(Planeta.class, id);
   }
   
   public List<Planeta> consultaTotal(){
       Query q = em.createQuery("Planetas.consultarTodos");
       return q.getResultList();
   }
}
