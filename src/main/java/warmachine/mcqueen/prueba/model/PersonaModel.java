
package warmachine.mcqueen.prueba.model;

import java.util.ArrayList;
import java.util.Date;

public class PersonaModel {
    
    private int idPersona;
    private String rut;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String telefono;
    private String direccion1;
    private String direccion2;
    private CiudadModel ciudad;
    private TipoPersonaModel tipoPersona;
    
    public static ArrayList<PersonaModel> personas = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public TipoPersonaModel getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public PersonaModel() {
    }

    public PersonaModel(String rut, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }

    private PersonaModel(int idPersona, String rut, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion1, String direccion2, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.idPersona = idPersona;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }
    
    public boolean nuevaPersona(PersonaModel nuevaPersona){
    
        int id = 0;
        
        if (!personas.isEmpty()) {
            
            for (PersonaModel persona : personas) {
                if (persona.getIdPersona()> id) {
                    id = persona.getIdPersona();
                }
            }
            
        }
        
        id++;
        
       personas.add(new PersonaModel(id, nuevaPersona.getRut(), nuevaPersona.getNombre(), nuevaPersona.getApellido(), nuevaPersona.getFechaNacimiento(), nuevaPersona.getTelefono(), nuevaPersona.getDireccion1(), nuevaPersona.getDireccion2(), nuevaPersona.getCiudad(), nuevaPersona.getTipoPersona()));
         
        return true;
    }
    
    public PersonaModel buscaPersona(int idPersonaBuscada){
    
        PersonaModel personaEncontrada = null;
        
        if(!personas.isEmpty()){
            for (PersonaModel persona : personas) {
                if (persona.getIdPersona()== idPersonaBuscada) {
                    personaEncontrada = persona;
                }
            }
        }
        
        return personaEncontrada;
        
    }
    
    public PersonaModel editarPersona(int idPersona, PersonaModel personaEditar){
    
        PersonaModel personaEditada = null;
        
        if(!personas.isEmpty()){
            for (PersonaModel persona : personas) {
                if (persona.getIdPersona()== idPersona) {
                    persona.setRut(personaEditar.getRut());
                    persona.setNombre(personaEditar.getNombre());
                    persona.setApellido(personaEditar.getApellido());
                    persona.setFechaNacimiento(personaEditar.getFechaNacimiento());
                    persona.setTelefono(personaEditar.getTelefono());
                    persona.setDireccion1(personaEditar.getDireccion1());
                    persona.setDireccion2(personaEditar.getDireccion2());
                    persona.setCiudad(personaEditar.getCiudad());
                    persona.setTipoPersona(personaEditar.getTipoPersona());
                    
                    personaEditada = persona;
                }
            }
        }
        
        return personaEditada;
        
    }
    
    public boolean eliminarPersona(int id){
        PersonaModel personaEliminada = null;
        
        if(!personas.isEmpty()){
            for (PersonaModel persona : personas) {
                if (persona.getIdPersona()== id) {
                   personaEliminada = persona;
                }
            }
        }
        
        personas.remove(personaEliminada);
        
        
        return true;
    }
    
}
