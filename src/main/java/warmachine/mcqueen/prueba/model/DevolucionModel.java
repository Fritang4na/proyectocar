
package warmachine.mcqueen.prueba.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class DevolucionModel {
    
    private int idDevolucion;
    private Date fechaDevolucion;
    private Time horaDevolucion;
    private ArriendoModel arriendo;
    
    public static ArrayList<DevolucionModel> devoluciones = new ArrayList<>();

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

    public Time getHoraDevolucion() {
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

    public DevolucionModel(Date fechaDevolucion, Time horaDevolucion, ArriendoModel arriendo) {
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }

    private DevolucionModel(int idDevolucion, Date fechaDevolucion, Time horaDevolucion, ArriendoModel arriendo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.arriendo = arriendo;
    }
    
    public boolean nuevaDevolucion(DevolucionModel nuevaDevolucion){
    
        int id = 0;
        
        if (!devoluciones.isEmpty()) {
            
            for (DevolucionModel devolucion : devoluciones) {
                if (devolucion.getIdDevolucion()> id) {
                    id = devolucion.getIdDevolucion();
                }
            }
            
        }
        
        id++;
        
       devoluciones.add(new DevolucionModel(id, nuevaDevolucion.getFechaDevolucion(), nuevaDevolucion.getHoraDevolucion(), nuevaDevolucion.getArriendo()));
         
        return true;
    }
    
    public DevolucionModel buscaDevolucion(int idDevolucionBuscada){
    
        DevolucionModel devolucionEncontrada = null;
        
        if(!devoluciones.isEmpty()){
            for (DevolucionModel devolucion : devoluciones) {
                if (devolucion.getIdDevolucion()== idDevolucionBuscada) {
                    devolucionEncontrada = devolucion;
                }
            }
        }
        
        return devolucionEncontrada;
        
    }
    
    public DevolucionModel editarDevolucion(int idDevolucion, DevolucionModel devolucionEditar){
    
        DevolucionModel devolucionEditada = null;
        
        if(!devoluciones.isEmpty()){
            for (DevolucionModel devolucion : devoluciones) {
                if (devolucion.getIdDevolucion()== idDevolucion) {
                    devolucion.setFechaDevolucion(devolucionEditar.getFechaDevolucion());
                    devolucion.setHoraDevolucion(devolucionEditar.getHoraDevolucion());
                    devolucion.setArriendo(devolucionEditar.getArriendo());
                    
                    devolucionEditada = devolucion;
                }
            }
        }
        
        return devolucionEditada;
        
    }
    
    public boolean eliminarDevolucion(int id){
        DevolucionModel devolucionEliminada = null;
        
        if(!devoluciones.isEmpty()){
            for (DevolucionModel devolucion : devoluciones) {
                if (devolucion.getIdDevolucion()== id) {
                   devolucionEliminada = devolucion;
                }
            }
        }
        
        devoluciones.remove(devolucionEliminada);
        
        
        return true;
    }
    
}
