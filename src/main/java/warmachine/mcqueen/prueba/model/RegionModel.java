
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class RegionModel {
    
    private int idRegion;
    private String nombreRegion;
    private String detalle;
    
    public static ArrayList<RegionModel> regiones = new ArrayList<>();
    
    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public RegionModel() {
    }

    public RegionModel(String nombreRegion, String detalle) {
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }

    private RegionModel(int idRegion, String nombreRegion, String detalle) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }
    
    public boolean nuevaRegion(RegionModel nuevaRegion){
    
        int id = 0;
        
        if (!regiones.isEmpty()) {
            
            for (RegionModel region : regiones) {
                if (region.getIdRegion()> id) {
                    id = region.getIdRegion();
                }
            }
            
        }
        
        id++;
        
        regiones.add(new RegionModel(id, nuevaRegion.getNombreRegion(), nuevaRegion.getDetalle()));
         
        return true;
    }
    
    public RegionModel buscaRegion(int idRegionBuscada){
    
        RegionModel regionEncontrada = null;
        
        if(!regiones.isEmpty()){
            for (RegionModel region : regiones) {
                if (region.getIdRegion()== idRegionBuscada) {
                    regionEncontrada = region;
                }
            }
        }
        
        return regionEncontrada;
        
    }
    
    public RegionModel editarRegion(int idRegion, RegionModel regionEditar){
    
        RegionModel regionEditada = null;
        
        if(!regiones.isEmpty()){
            for (RegionModel region : regiones) {
                if (region.getIdRegion()== idRegion) {
                    region.setNombreRegion(regionEditar.getNombreRegion());
                    region.setDetalle(regionEditar.getDetalle());
                    
                    regionEditada = region;
                }
            }
        }
        
        return regionEditada;
        
    }
    
    public boolean eliminarRegion(int id){
        RegionModel regionEliminada = null;
        
        if(!regiones.isEmpty()){
            for (RegionModel region : regiones) {
                if (region.getIdRegion()== id) {
                   regionEliminada = region;
                }
            }
        }
        
        regiones.remove(regionEliminada);
        
        
        return true;
    }
    
}
