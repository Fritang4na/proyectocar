
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class CiudadModel {
    
    private int idCiudad;
    private String nombreCiudad;
    private String detalle;
    private RegionModel region;
    
    public static ArrayList<CiudadModel> ciudades = new ArrayList<>();

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String detalle, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }
    
    public boolean nuevaCiudad(CiudadModel nuevaCiudad){
    
        int id = 0;
        
        if (!ciudades.isEmpty()) {
            
            for (CiudadModel ciudad : ciudades) {
                if (ciudad.getIdCiudad()> id) {
                    id = ciudad.getIdCiudad();
                }
            }
            
        }
        
        id++;
        
        ciudades.add(new CiudadModel(id, nuevaCiudad.getNombreCiudad(), nuevaCiudad.getDetalle(), nuevaCiudad.getRegion()));
         
        return true;
    }
    
    public CiudadModel buscaCiudad(int idCiudadBuscada){
    
        CiudadModel ciudadEncontrada = null;
        
        if(!ciudades.isEmpty()){
            for (CiudadModel ciudad : ciudades) {
                if (ciudad.getIdCiudad()== idCiudadBuscada) {
                    ciudadEncontrada = ciudad;
                }
            }
        }
        
        return ciudadEncontrada;
        
    }
    
    public CiudadModel editarCiudad(int idCiudad, CiudadModel ciudadEditar){
    
        CiudadModel ciudadEditada = null;
        
        if(!ciudades.isEmpty()){
            for (CiudadModel ciudad : ciudades) {
                if (ciudad.getIdCiudad()== idCiudad) {
                    ciudad.setNombreCiudad(ciudadEditar.getNombreCiudad());
                    ciudad.setDetalle(ciudadEditar.getDetalle());
                    ciudad.setRegion(ciudadEditar.getRegion());
                    
                    ciudadEditada = ciudad;
                }
            }
        }
        
        return ciudadEditada;
        
    }
    
    public boolean eliminarCiudad(int id){
        CiudadModel ciudadEliminada = null;
        
        if(!ciudades.isEmpty()){
            for (CiudadModel ciudad : ciudades) {
                if (ciudad.getIdCiudad()== id) {
                   ciudadEliminada = ciudad;
                }
            }
        }
        
        ciudades.remove(ciudadEliminada);
        
        
        return true;
    }
    
    
}
