
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class TransmisionModel {
    
    private int idTransmision;
    private String nombreTransmision;
    private String detalle;
    
    public static ArrayList<TransmisionModel> transmisiones = new ArrayList<>();

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
    
    public boolean nuevaTransmision(TransmisionModel nuevaTransmision){
    
        int id = 0;
        
        if (!transmisiones.isEmpty()) {
            
            for (TransmisionModel transmision : transmisiones) {
                if (transmision.getIdTransmision()> id) {
                    id = transmision.getIdTransmision();
                }
            }
            
        }
        
        id++;
        
        transmisiones.add(new TransmisionModel(id, nuevaTransmision.getNombreTransmision(), nuevaTransmision.getDetalle()));
         
        return true;
    }
    
    public TransmisionModel buscaTransmision(int idTransmisionBuscada){
    
        TransmisionModel transmisionEncontrada = null;
        
        if(!transmisiones.isEmpty()){
            for (TransmisionModel transmision : transmisiones) {
                if (transmision.getIdTransmision()== idTransmisionBuscada) {
                    transmisionEncontrada = transmision;
                }
            }
        }
        
        return transmisionEncontrada;
        
    }
    
    public TransmisionModel editarTransmision(int idTransmision, TransmisionModel transmisionEditar){
    
        TransmisionModel transmisionEditada = null;
        
        if(!transmisiones.isEmpty()){
            for (TransmisionModel transmision : transmisiones) {
                if (transmision.getIdTransmision()== idTransmision) {
                    transmision.setNombreTransmision(transmisionEditar.getNombreTransmision());
                    transmision.setDetalle(transmisionEditar.getDetalle());
                    
                    transmisionEditada = transmision;
                }
            }
        }
        
        return transmisionEditada;
        
    }
    
    public boolean eliminarTransmision(int id){
        TransmisionModel transmisionEliminada = null;
        
        if(!transmisiones.isEmpty()){
            for (TransmisionModel transmision : transmisiones) {
                if (transmision.getIdTransmision()== id) {
                   transmisionEliminada = transmision;
                }
            }
        }
        
        transmisiones.remove(transmisionEliminada);
        
        
        return true;
    }
    
}
