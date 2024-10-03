package org.example.xml;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;




@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "nombre", "apellidos", "username", "roles" })
public class Usuario {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "apellidos")
    private String apellidos;

    @XmlElement(name = "username")
    private String username;

    @XmlTransient
    private String password;

    @XmlElementWrapper(name = "roles")
    @XmlElement(name = "rol")
    private List<String> roles;

    // Getters y setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}