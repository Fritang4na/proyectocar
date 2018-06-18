
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class TipoVehiculoModel {
    
    private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalle;
    
    public static ArrayList<TipoVehiculoModel> tiposv = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }
    
    public boolean nuevoTipoV(TipoVehiculoModel nuevoTipoV){
    
        int id = 0;
        
        if (!tiposv.isEmpty()) {
            
            for (TipoVehiculoModel tipo : tiposv) {
                if (tipo.getIdTipoVehiculo()> id) {
                    id = tipo.getIdTipoVehiculo();
                }
            }
            
        }
        
        id++;
        
        tiposv.add(new TipoVehiculoModel(id, nuevoTipoV.getNombreTipoVehiculo(), nuevoTipoV.getDetalle()));
         
        return true;
    }
    
    public TipoVehiculoModel buscaTipoV(int idTipoVBuscado){
    
        TipoVehiculoModel tipoVEncontrado = null;
        
        if(!tiposv.isEmpty()){
            for (TipoVehiculoModel tipo : tiposv) {
                if (tipo.getIdTipoVehiculo()== idTipoVBuscado) {
                    tipoVEncontrado = tipo;
                }
            }
        }
        
        return tipoVEncontrado;
        
    }
    
    public TipoVehiculoModel editarTipoV(int idTipoV, TipoVehiculoModel tipoVEditar){
    
        TipoVehiculoModel tipoVEditado = null;
        
        if(!tiposv.isEmpty()){
            for (TipoVehiculoModel tipo : tiposv) {
                if (tipo.getIdTipoVehiculo()== idTipoV) {
                    tipo.setNombreTipoVehiculo(tipoVEditar.getNombreTipoVehiculo());
                    tipo.setDetalle(tipoVEditar.getDetalle());
                    
                    tipoVEditado = tipo;
                }
            }
        }
        
        return tipoVEditado;
        
    }
    
    public boolean eliminarTipoV(int id){
        TipoVehiculoModel tipoVEliminado = null;
        
        if(!tiposv.isEmpty()){
            for (TipoVehiculoModel tipo : tiposv) {
                if (tipo.getIdTipoVehiculo()== id) {
                   tipoVEliminado = tipo;
                }
            }
        }
        
        tiposv.remove(tipoVEliminado);
        
        
        return true;
    }
    
}
