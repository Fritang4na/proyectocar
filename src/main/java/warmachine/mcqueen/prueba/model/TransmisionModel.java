
package warmachine.mcqueen.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transmision")
public class TransmisionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransmision;
    private String nombreTransmision;
    private String detalle;

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TransmisionModel() {
    }

    public TransmisionModel(String nombreTransmision, String detalle) {
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }

    private TransmisionModel(int idTransmision, String nombreTransmision, String detalle) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.detalle = detalle;
    }
    
}
