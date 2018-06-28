
package warmachine.mcqueen.prueba.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="devolucion")
public class DevolucionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevolucion;
    private Date fechaDevolucion;
    private Date horaDevolucion;
    @ManyToOne
    @JoinColumn(name="id_arriendo")
    private ArriendoModel arriendo;

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public ArriendoModel getArriendo() {
        return arriendo;
    }

    public void setArriendo(ArriendoModel arriendo) {
        this.arriendo = arriendo;
    }

    public DevolucionModel() {
    }

    public DevolucionModel(Date fechaDevolucion, Date horaDevolucion, ArriendoModel arriendo) {
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

    private DevolucionModel(int idDevolucion, Date fechaDevolucion, Date horaDevolucion, ArriendoModel arriendo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }
    
}
