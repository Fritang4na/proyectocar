
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;

public class MarcaModel {
    
    private int idMarca;
    private String nombreMarca;
    private String detalle;
    
    public static ArrayList<MarcaModel> marcas = new ArrayList<>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    private MarcaModel(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }
    
    public boolean nuevaMarca(MarcaModel nuevaMarca){
    
        int id = 0;
        
        if (!marcas.isEmpty()) {
            
            for (MarcaModel marca : marcas) {
                if (marca.getIdMarca()> id) {
                    id = marca.getIdMarca();
                }
            }
            
        }
        
        id++;
        
       marcas.add(new MarcaModel(id, nuevaMarca.getNombreMarca(), nuevaMarca.getDetalle()));
         
        return true;
    }
    
    public MarcaModel buscaMarca(int idMarcaBuscada){
    
        MarcaModel marcaEncontrada = null;
        
        if(!marcas.isEmpty()){
            for (MarcaModel marca : marcas) {
                if (marca.getIdMarca()== idMarcaBuscada) {
                    marcaEncontrada = marca;
                }
            }
        }
        
        return marcaEncontrada;
        
    }
    
    public MarcaModel editarMarca(int idMarca, MarcaModel marcaEditar){
    
        MarcaModel marcaEditada = null;
        
        if(!marcas.isEmpty()){
            for (MarcaModel marca : marcas) {
                if (marca.getIdMarca()== idMarca) {
                    marca.setNombreMarca(marcaEditar.getNombreMarca());
                    marca.setDetalle(marcaEditar.getDetalle());
                    
                    marcaEditada = marca;
                }
            }
        }
        
        return marcaEditada;
        
    }
    
    public boolean eliminarMarca(int id){
        MarcaModel marcaEliminada = null;
        
        if(!marcas.isEmpty()){
            for (MarcaModel marca : marcas) {
                if (marca.getIdMarca()== id) {
                   marcaEliminada = marca;
                }
            }
        }
        
        marcas.remove(marcaEliminada);
        
        
        return true;
    }
    
}
