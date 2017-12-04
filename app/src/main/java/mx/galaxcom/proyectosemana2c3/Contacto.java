package mx.galaxcom.proyectosemana2c3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by david on 02/12/2017.
 */

public class Contacto implements Parcelable{
    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    // Constructores
    public Contacto(Parcel parcel) {
        nombre      = parcel.readString();
        fecha       = parcel.readString();
        telefono    = parcel.readString();
        email       = parcel.readString();
        descripcion = parcel.readString();
    }
    public Contacto(String nombre, String fecha, String telefono, String email, String descripcion){
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }
    public Contacto(){}

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Write to parcel
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nombre);
        dest.writeString(fecha);
        dest.writeString(telefono);
        dest.writeString(email);
        dest.writeString(descripcion);
    }

    // Creador
    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>(){
        @Override
        public Contacto createFromParcel(Parcel parcel){
            return new Contacto(parcel);
        }

        @Override
        public Contacto[] newArray(int size){
            return new Contacto[0];
        }
    };
}
