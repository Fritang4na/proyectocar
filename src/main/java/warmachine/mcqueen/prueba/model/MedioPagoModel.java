
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class MedioPagoModel {
    
    private int idMedioPago;
    private String nombreMedioPago;
    private String detalle;
    
    public static ArrayList<MedioPagoModel> medios = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }
    
    public boolean nuevoMedio(MedioPagoModel nuevoMedio){
    
        int id = 0;
        
        if (!medios.isEmpty()) {
            
            for (MedioPagoModel medio : medios) {
                if (medio.getIdMedioPago()> id) {
                    id = medio.getIdMedioPago();
                }
            }
            
        }
        
        id++;
        
        medios.add(new MedioPagoModel(id, nuevoMedio.getNombreMedioPago(), nuevoMedio.getDetalle()));
         
        return true;
    }
    
    public MedioPagoModel buscaMedio(int idMedioBuscado){
    
        MedioPagoModel medioEncontrado = null;
        
        if(!medios.isEmpty()){
            for (MedioPagoModel medio : medios) {
                if (medio.getIdMedioPago()== idMedioBuscado) {
                    medioEncontrado = medio;
                }
            }
        }
        
        return medioEncontrado;
        
    }
    
    public MedioPagoModel editarMedio(int idMedio, MedioPagoModel medioEditar){
    
        MedioPagoModel medioEditado = null;
        
        if(!medios.isEmpty()){
            for (MedioPagoModel medio : medios) {
                if (medio.getIdMedioPago()== idMedio) {
                    medio.setNombreMedioPago(medioEditar.getNombreMedioPago());
                    medio.setDetalle(medioEditar.getDetalle());
                    
                    medioEditado = medio;
                }
            }
        }
        
        return medioEditado;
        
    }
    
    public boolean eliminarMedio(int id){
        MedioPagoModel medioEliminado = null;
        
        if(!medios.isEmpty()){
            for (MedioPagoModel medio : medios) {
                if (medio.getIdMedioPago()== id) {
                   medioEliminado = medio;
                }
            }
        }
        
        medios.remove(medioEliminado);
        
        
        return true;
    }
    
}
