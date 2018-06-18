
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class VehiculoModel {
    
    private int idVehiculo;
    private String patente;
    private int valor;
    private int ano;
    private String color;
    private TipoVehiculoModel tipoVehiculo;
    private VersionModel version;
    
    public static ArrayList<VehiculoModel> vehiculos = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String patente, int valor, int ano, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.patente = patente;
        this.valor = valor;
        this.ano = ano;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    private VehiculoModel(int idVehiculo, String patente, int valor, int ano, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.valor = valor;
        this.ano = ano;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }
    
    public boolean nuevoVehiculo(VehiculoModel nuevoVehiculo){
    
        int id = 0;
        
        if (!vehiculos.isEmpty()) {
            
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo()> id) {
                    id = vehiculo.getIdVehiculo();
                }
            }
            
        }
        
        id++;
        
       vehiculos.add(new VehiculoModel(id, nuevoVehiculo.getPatente(), nuevoVehiculo.getValor(), nuevoVehiculo.getAno(), nuevoVehiculo.getColor(), nuevoVehiculo.getTipoVehiculo(), nuevoVehiculo.getVersion()));
         
        return true;
    }
    
    public VehiculoModel buscaVehiculo(int idVehiculoBuscado){
    
        VehiculoModel vehiculoEncontrado = null;
        
        if(!vehiculos.isEmpty()){
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo()== idVehiculoBuscado) {
                    vehiculoEncontrado = vehiculo;
                }
            }
        }
        
        return vehiculoEncontrado;
        
    }
    
    public VehiculoModel editarVehiculo(int idVehiculo, VehiculoModel vehiculoEditar){
    
        VehiculoModel vehiculoEditado = null;
        
        if(!vehiculos.isEmpty()){
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo()== idVehiculo) {
                    vehiculo.setPatente(vehiculoEditar.getColor());
                    vehiculo.setValor(vehiculoEditar.getValor());
                    vehiculo.setAno(vehiculoEditar.getAno());
                    vehiculo.setColor(vehiculoEditar.getColor());
                    vehiculo.setTipoVehiculo(vehiculoEditar.getTipoVehiculo());
                    vehiculo.setVersion(vehiculoEditar.getVersion());
                    
                    vehiculoEditado = vehiculo;
                }
            }
        }
        
        return vehiculoEditado;
        
    }
    
    public boolean eliminarVehiculo(int id){
        VehiculoModel vehiculoEliminado = null;
        
        if(!vehiculos.isEmpty()){
            for (VehiculoModel vehiculo : vehiculos) {
                if (vehiculo.getIdVehiculo()== id) {
                   vehiculoEliminado = vehiculo;
                }
            }
        }
        
        vehiculos.remove(vehiculoEliminado);
        
        
        return true;
    }
    
}
