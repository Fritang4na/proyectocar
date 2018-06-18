
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class CarroceriaModel {
    
    private int idCarroceria;
    private String nombreCarroceria;
    private String detalle;
    
    public static ArrayList<CarroceriaModel> carrocerias = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }
    
    public boolean nuevaCarroceria(CarroceriaModel nuevaCarroceria){
    
        int id = 0;
        
        if (!carrocerias.isEmpty()) {
            
            for (CarroceriaModel carroceria : carrocerias) {
                if (carroceria.getIdCarroceria()> id) {
                    id = carroceria.getIdCarroceria();
                }
            }
            
        }
        
        id++;
        
        carrocerias.add(new CarroceriaModel(id, nuevaCarroceria.getNombreCarroceria(), nuevaCarroceria.getDetalle()));
         
        return true;
    }
    
    public CarroceriaModel buscaCarroceria(int idCarroceriaBuscada){
    
        CarroceriaModel carroceriaEncontrada = null;
        
        if(!carrocerias.isEmpty()){
            for (CarroceriaModel carroceria : carrocerias) {
                if (carroceria.getIdCarroceria()== idCarroceriaBuscada) {
                    carroceriaEncontrada = carroceria;
                }
            }
        }
        
        return carroceriaEncontrada;
        
    }
    
    public CarroceriaModel editarCarroceria(int idCarroceria, CarroceriaModel carroceriaEditar){
    
        CarroceriaModel carroceriaEditada = null;
        
        if(!carrocerias.isEmpty()){
            for (CarroceriaModel carroceria : carrocerias) {
                if (carroceria.getIdCarroceria()== idCarroceria) {
                    carroceria.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                    carroceria.setDetalle(carroceriaEditar.getDetalle());
                    
                    carroceriaEditada = carroceria;
                }
            }
        }
        
        return carroceriaEditada;
        
    }
    
    public boolean eliminarCarroceria(int id){
        CarroceriaModel carroceriaEliminada = null;
        
        if(!carrocerias.isEmpty()){
            for (CarroceriaModel carroceria : carrocerias) {
                if (carroceria.getIdCarroceria()== id) {
                   carroceriaEliminada = carroceria;
                }
            }
        }
        
        carrocerias.remove(carroceriaEliminada);
        
        
        return true;
    }
    
}
