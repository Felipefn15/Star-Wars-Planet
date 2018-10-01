package Entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe França Nogueira
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Planetas.consultarTodos",
            query = "SELECT p FROM Planetas p ORDER BY p.nome"), 
})
@XmlRootElement
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    private Long id;
    private String nome;
    private String clima;
    private String terreno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    
    
}
