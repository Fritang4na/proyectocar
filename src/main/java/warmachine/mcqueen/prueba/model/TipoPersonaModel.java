
package warmachine.mcqueen.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_persona")
public class TipoPersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPersona;
    private String nombreTipoPersona;
    private String detalle;

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    private TipoPersonaModel(int idTipoPersona, String nombreTipoPersona, String detalle) {
        this.idTipoPersona = idTipoPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }
    
}
