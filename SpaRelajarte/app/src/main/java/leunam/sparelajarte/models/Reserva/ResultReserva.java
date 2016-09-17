package leunam.sparelajarte.models.Reserva;

/**
 * Created by manuel on 19/05/2016.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultReserva {


    @SerializedName("centro")
    @Expose
    private String centro;
    @SerializedName("servicio")
    @Expose
    private String servicio;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("fechar")
    @Expose
    private String fechar;
    @SerializedName("horar")
    @Expose
    private String horar;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResultReserva() {
    }

    /**
     *
     * @param fechar
     * @param servicio
     * @param horar
     * @param usuario
     * @param centro
     */
    public ResultReserva(String centro, String servicio, String usuario, String fechar, String horar) {

        this.centro = centro;
        this.servicio = servicio;
        this.usuario = usuario;
        this.fechar = fechar;
        this.horar = horar;
    }

    public ResultReserva(String servicio, String fechar, String horar) {

        this.servicio = servicio;
        this.fechar = fechar;
        this.horar = horar;
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

    public ResultReserva withCentro(String centro) {
        this.centro = centro;
        return this;
    }

    /**
     *
     * @return
     * The servicio
     */
    public String getServicio() {
        return servicio;
    }

    /**
     *
     * @param servicio
     * The servicio
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public ResultReserva withServicio(String servicio) {
        this.servicio = servicio;
        return this;
    }

    /**
     *
     * @return
     * The usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     * The usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ResultReserva withUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     *
     * @return
     * The fechar
     */
    public String getFechar() {
        return fechar;
    }

    /**
     *
     * @param fechar
     * The fechar
     */
    public void setFechar(String fechar) {
        this.fechar = fechar;
    }

    public ResultReserva withFechar(String fechar) {
        this.fechar = fechar;
        return this;
    }

    /**
     *
     * @return
     * The horar
     */
    public String getHorar() {
        return horar;
    }

    /**
     *
     * @param horar
     * The horar
     */
    public void setHorar(String horar) {
        this.horar = horar;
    }

    public ResultReserva withHorar(String horar) {
        this.horar = horar;
        return this;
    }

}