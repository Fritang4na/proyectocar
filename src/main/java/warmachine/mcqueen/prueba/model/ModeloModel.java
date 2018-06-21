
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="combustible")
public class ModeloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModelo;
    private String nombreModelo;
    private String detalle;
    private MarcaModel marca;

    public static ArrayList<ModeloModel> modelos = new ArrayList<>();
    
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }
    
    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalle, MarcaModel marca) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    private ModeloModel(int idModelo, String nombreModelo, String detalle, MarcaModel marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }
    
}
