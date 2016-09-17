package leunam.sparelajarte.models.Promocion;

/**
 * Created by manuel on 26/05/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombrep")
    @Expose
    private String nombrep;
    @SerializedName("servicio")
    @Expose
    private String servicio;
    @SerializedName("preciop")
    @Expose
    private Integer preciop;
    @SerializedName("fechaini")
    @Expose
    private String fechaini;
    @SerializedName("fechafin")
    @Expose
    private String fechafin;


    public Result() {

    }

    public Result( String nombrep, String servicio, Integer preciop, String fechaini, String fechafin) {

        this.nombrep = nombrep;
        this.servicio = servicio;
        this.preciop = preciop;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
    }

    public Result(String servicio, Integer preciop, String fechaini, String fechafin) {


        this.servicio = servicio;
        this.preciop = preciop;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
    }

//    public Result(String servicio, Integer preciop) {
//        this.servicio = servicio;
//        this.preciop = preciop;
//    }

    public Result(String nombrep, String servicio, Integer preciop) {
        this.nombrep = nombrep;
        this.servicio = servicio;
        this.preciop = preciop;
    }

    public Result(String nombrep, Integer preciop) {
        this.nombrep = nombrep;
        this.preciop = preciop;
    }

    public Result(Integer id, String nombrep, String servicio, Integer preciop, String fechaini, String fechafin) {
        this.id = id;
        this.nombrep = nombrep;
        this.servicio = servicio;
        this.preciop = preciop;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
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
     * The nombrep
     */
    public String getNombrep() {
        return nombrep;
    }

    /**
     *
     * @param nombrep
     * The nombrep
     */
    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public Result withNombrep(String nombrep) {
        this.nombrep = nombrep;
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

    public Result withServicio(String servicio) {
        this.servicio = servicio;
        return this;
    }

    /**
     *
     * @return
     * The preciop
     */
    public Integer getPreciop() {
        return preciop;
    }

    /**
     *
     * @param preciop
     * The preciop
     */
    public void setPreciop(Integer preciop) {
        this.preciop = preciop;
    }

    public Result withPreciop(Integer preciop) {
        this.preciop = preciop;
        return this;
    }

    /**
     *
     * @return
     * The fechaini
     */
    public String getFechaini() {
        return fechaini;
    }

    /**
     *
     * @param fechaini
     * The fechaini
     */
    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public Result withFechaini(String fechaini) {
        this.fechaini = fechaini;
        return this;
    }

    /**
     *
     * @return
     * The fechafin
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     *
     * @param fechafin
     * The fechafin
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public Result withFechafin(String fechafin) {
        this.fechafin = fechafin;
        return this;
    }

    @Override
    public String toString() {
        return "- "+nombrep +", " + preciop +" eur";
    }


}