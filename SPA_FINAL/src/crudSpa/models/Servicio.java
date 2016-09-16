/**
 * 
 */
package crudSpa.models;

/**
 *Clase Servicio
 *
 * @author mrevuelta
 * @version 1.0
 * @since 1.0
 */
public class Servicio {
	
	
	private int idServicio;
	private String tipoServicio;
	private double precioUnitario;
	private int idPromo;
	
	/**
         * constructor vacio
         */
	public Servicio(){
            
        }
        
        public Servicio(int idServicio, String tipoServicio, double precioUnitario) {
		super();
		this.idServicio = idServicio;
		this.tipoServicio = tipoServicio;
		this.precioUnitario = precioUnitario;
	}
        
        /**
         * constructor con todos los atributos para un servicio
         * @param idServicio identificador del servicio
         * @param tipoServicio nombre del servicio
         * @param precioUnitario precio que tendra el servicio
         * @param idPromo identificador de la promocion que tendra el servicio
         */
	public Servicio(int idServicio, String tipoServicio, double precioUnitario, int idPromo) {
		super();
		this.idServicio = idServicio;
		this.tipoServicio = tipoServicio;
		this.precioUnitario = precioUnitario;
                this.idPromo = idPromo;
	}

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }
		
        

	@Override
	public String toString() {
		return "Producto Id Servicio=" + idServicio + ", Tipo Servicio=" + tipoServicio
				+ ", precioUnitario=" + precioUnitario;
	}
	
	
	
	
	
	

}
