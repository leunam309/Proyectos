package leunam.sparelajarte.models.Mensaje;

/**
 * Created by manuel on 19/05/2016.
 *
 *
 *
 *
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultEnviar {



    @SerializedName("usuarioEmisor")
    @Expose
    private String usuarioEmisor;
    @SerializedName("centro")
    @Expose
    private String centro;
    @SerializedName("comentario")
    @Expose
    private String comentario;
    @SerializedName("fecha")
    @Expose
    private String fecha;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResultEnviar() {
    }

    /**
     *
     * @param fecha
     * @param usuarioEmisor
     * @param centro
     * @param comentario
     */
    public ResultEnviar( String usuarioEmisor, String centro, String comentario, String fecha) {
        this.usuarioEmisor = usuarioEmisor;
        this.centro = centro;
        this.comentario = comentario;
        this.fecha = fecha;
    }



    /**
     *
     * @return
     * The usuarioEmisor
     */
    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    /**
     *
     * @param usuarioEmisor
     * The usuarioEmisor
     */
    public void setUsuarioEmisor(String usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public ResultEnviar withUsuarioEmisor(String usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
        return this;
    }

    /**
     *
     * @return
     * The centro
     */
    public String getCentro() {
        return centro;
    }

    /**
     *
     * @param centro
     * The centro
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }

    public ResultEnviar withCentro(String centro) {
        this.centro = centro;
        return this;
    }

    /**
     *
     * @return
     * The comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     *
     * @param comentario
     * The comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ResultEnviar withComentario(String comentario) {
        this.comentario = comentario;
        return this;
    }

    /**
     *
     * @return
     * The fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     * The fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ResultEnviar withFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

}
