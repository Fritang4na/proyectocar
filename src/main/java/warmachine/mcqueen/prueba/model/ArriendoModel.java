
package warmachine.mcqueen.prueba.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class ArriendoModel {
    
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    private PersonaModel vendedor;
    private PersonaModel cliente;
    private VehiculoModel vehiculo;
    private MedioPagoModel medioPago;
    
    public static ArrayList<ArriendoModel> arriendos = new ArrayList<>();

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public PersonaModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonaModel vendedor) {
        this.vendedor = vendedor;
    }

    public PersonaModel getCliente() {
        return cliente;
    }

    public void setCliente(PersonaModel cliente) {
        this.cliente = cliente;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MedioPagoModel getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPagoModel medioPago) {
        this.medioPago = medioPago;
    }

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    private ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }
    
    public boolean nuevoArriendo(ArriendoModel nuevoArriendo){
    
        int id = 0;
        
        if (!arriendos.isEmpty()) {
            
            for (ArriendoModel arriendo : arriendos) {
                if (arriendo.getIdArriendo()> id) {
                    id = arriendo.getIdArriendo();
                }
            }
            
        }
        
        id++;
        
       arriendos.add(new ArriendoModel(id, nuevoArriendo.getFechaArriendo(), nuevoArriendo.getHoraArriendo(), nuevoArriendo.getVendedor(), nuevoArriendo.getCliente(), nuevoArriendo.getVehiculo(), nuevoArriendo.getMedioPago()));
         
        return true;
    }
    
    public ArriendoModel buscaArriendo(int idArriendoBuscado){
    
        ArriendoModel arriendoEncontrado = null;
        
        if(!arriendos.isEmpty()){
            for (ArriendoModel arriendo : arriendos) {
                if (arriendo.getIdArriendo()== idArriendoBuscado) {
                    arriendoEncontrado = arriendo;
                }
            }
        }
        
        return arriendoEncontrado;
        
    }
    
    public ArriendoModel editarArriendo(int idArriendo, ArriendoModel arriendoEditar){
    
        ArriendoModel arriendoEditado = null;
        
        if(!arriendos.isEmpty()){
            for (ArriendoModel arriendo : arriendos) {
                if (arriendo.getIdArriendo()== idArriendo) {
                    arriendo.setFechaArriendo(arriendoEditar.getFechaArriendo());
                    arriendo.setHoraArriendo(arriendoEditar.getHoraArriendo());
                    arriendo.setVendedor(arriendoEditar.getVendedor());
                    arriendo.setCliente(arriendoEditar.getCliente());
                    arriendo.setVehiculo(arriendoEditar.getVehiculo());
                    arriendo.setMedioPago(arriendoEditar.getMedioPago());
                    
                    arriendoEditado = arriendo;
                }
            }
        }
        
        return arriendoEditado;
        
    }
    
    public boolean eliminarArriendo(int id){
        ArriendoModel arriendoEliminado = null;
        
        if(!arriendos.isEmpty()){
            for (ArriendoModel arriendo : arriendos) {
                if (arriendo.getIdArriendo()== id) {
                   arriendoEliminado = arriendo;
                }
            }
        }
        
        arriendos.remove(arriendoEliminado);
        
        
        return true;
    }
    
}
