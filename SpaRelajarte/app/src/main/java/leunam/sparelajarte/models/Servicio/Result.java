package leunam.sparelajarte.models.Servicio;

/**
 * Created by manuel on 20/05/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("precio")
    @Expose
    private Integer precio;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param id
     * @param precio
     * @param tipo
     */
    public Result(Integer id, String tipo, Integer precio) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Result withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     * The tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Result withTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    /**
     *
     * @return
     * The precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     * The precio
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Result withPrecio(Integer precio) {
        this.precio = precio;
        return this;
    }


    @Override
    public String toString() {
        return "- "+ tipo +", " + precio +" eur";
    }
}