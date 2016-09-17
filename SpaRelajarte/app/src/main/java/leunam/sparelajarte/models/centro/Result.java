package leunam.sparelajarte.models.centro;

/**
 * Created by manuel on 14/05/2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result {


    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("servicio")
    @Expose
    private List<String> servicio = new ArrayList<String>();
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("coordenadas")
    @Expose
    private String coordenadas;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param servicio
     * @param coordenadas
     * @param descripcion
     * @param img
     */
    public Result(Long id, String nombre, String img, List<String> servicio, String descripcion, String coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.coordenadas = coordenadas;
    }

    /**
     *
     * @return
     * The id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Result withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     * The nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Result withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     *
     * @return
     * The img
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     * The img
     */
    public void setImg(String img) {
        this.img = img;
    }

    public Result withImg(String img) {
        this.img = img;
        return this;
    }

    /**
     *
     * @return
     * The servicio
     */
    public List<String> getServicio() {
        return servicio;
    }

    /**
     *
     * @param servicio
     * The servicio
     */
    public void setServicio(List<String> servicio) {
        this.servicio = servicio;
    }

    public Result withServicio(List<String> servicio) {
        this.servicio = servicio;
        return this;
    }

    /**
     *
     * @return
     * The descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     * The descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Result withDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     *
     * @return
     * The coordenadas
     */
    public String getCoordenadas() {
        return coordenadas;
    }

    /**
     *
     * @param coordenadas
     * The coordenadas
     */
    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Result withCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
        return this;
    }


    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", img='" + img + '\'' +
                ", servicio=" + servicio +
                ", descripcion='" + descripcion + '\'' +
                ", coordenadas='" + coordenadas + '\'' +
                '}';
    }
}
