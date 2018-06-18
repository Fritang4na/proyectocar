
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class TipoPersonaModel {
    
    private int idTipoPersona;
    private String nombreTipoPersona;
    private String detalle;
    
    public static ArrayList<TipoPersonaModel> tiposP = new ArrayList<>();

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
    
    public boolean nuevoTipoP(TipoPersonaModel nuevoTipoP){
    
        int id = 0;
        
        if (!tiposP.isEmpty()) {
            
            for (TipoPersonaModel tipo : tiposP) {
                if (tipo.getIdTipoPersona()> id) {
                    id = tipo.getIdTipoPersona();
                }
            }
            
        }
        
        id++;
        
        tiposP.add(new TipoPersonaModel(id, nuevoTipoP.getNombreTipoPersona(), nuevoTipoP.getDetalle()));
         
        return true;
    }
    
    public TipoPersonaModel buscaTipoP(int idTipoPBuscado){
    
        TipoPersonaModel tipoPEncontrado = null;
        
        if(!tiposP.isEmpty()){
            for (TipoPersonaModel tipo : tiposP) {
                if (tipo.getIdTipoPersona()== idTipoPBuscado) {
                    tipoPEncontrado = tipo;
                }
            }
        }
        
        return tipoPEncontrado;
        
    }
    
    public TipoPersonaModel editarTipoP(int idTipoP, TipoPersonaModel tipoPEditar){
    
        TipoPersonaModel tipoPEditado = null;
        
        if(!tiposP.isEmpty()){
            for (TipoPersonaModel tipo : tiposP) {
                if (tipo.getIdTipoPersona()== idTipoP) {
                    tipo.setNombreTipoPersona(tipoPEditar.getNombreTipoPersona());
                    tipo.setDetalle(tipoPEditar.getDetalle());
                    
                    tipoPEditado = tipo;
                }
            }
        }
        
        return tipoPEditado;
        
    }
    
    public boolean eliminarTipoP(int id){
        TipoPersonaModel tipoPEliminado = null;
        
        if(!tiposP.isEmpty()){
            for (TipoPersonaModel tipo : tiposP) {
                if (tipo.getIdTipoPersona()== id) {
                   tipoPEliminado = tipo;
                }
            }
        }
        
        tiposP.remove(tipoPEliminado);
        
        
        return true;
    }
    
}
