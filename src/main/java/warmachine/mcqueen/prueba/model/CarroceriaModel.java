
package warmachine.mcqueen.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carroceria")
public class CarroceriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarroceria;
    private String nombreCarroceria;
    private String detalle;

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
       this.detalle = detalle;
    }   
}