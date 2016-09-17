package leunam.sparelajarte.interfaces;



import com.squareup.okhttp.RequestBody;

import java.util.List;

import leunam.sparelajarte.models.Login;
import leunam.sparelajarte.models.Mensaje.Mensaje;
import leunam.sparelajarte.models.Mensaje.ResultEnviar;
import leunam.sparelajarte.models.Promocion.Promocion;
import leunam.sparelajarte.models.Registro;
import leunam.sparelajarte.models.Reserva.Reserva;
import leunam.sparelajarte.models.Reserva.ResultReserva;
import leunam.sparelajarte.models.Servicio.Servicio;
import leunam.sparelajarte.models.Token;
import leunam.sparelajarte.models.Usuario;
import leunam.sparelajarte.models.centro.Centro;
import leunam.sparelajarte.models.centro.Result;
import leunam.sparelajarte.models.usurl.Usurl;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by manuel on 17/02/2015.
 */
public interface TAPI {


    // logueo
    @Headers({"Content-Type: application/json"})
    @POST("/rest-auth/login/")
    Call<Token> login(@Body Login login);


    // registro
    @Headers({"Content-Type: application/json"})
    @POST("/rest-auth/registration/")
    Call<Token> registrarse(@Body Registro registro);

    //datos del usuario
    @GET("/api/users/{Id}")
    Call<leunam.sparelajarte.models.usurl.Result> me(@Path("Id") String id);

    //lista de centros
    @GET("/api/centro/")
    Call<Centro> centros(@Query("search") String nombre);

    //lista de centros
    @GET("/api/centro/")
    Call<Centro> centross();

    //lista de servicios
    @GET("/api/servicio/")
    Call<Servicio> servicio();

    // lista de servicios que no estan en promoción
    @GET("/api/servicio/obtenerServicios")
    Call<List<leunam.sparelajarte.models.Servicio.Result>> serviciob();

    //lista de promociones
    @GET("/api/promocion/")
    Call<Promocion> promocion();

    //datos de un servicio
    @GET("/api/servicio/{objetoId}")
    Call<leunam.sparelajarte.models.Servicio.Result> servicios(@Path("objetoId") String id);

    //datos de un centro
    @GET("/api/centro/{centroId}/")
    Call<Result> centro(@Path("centroId") String id);

    //lista usuarios
    @POST("/rest-auth/logout/")
    Call<Usuario> usuariodes();

    //lista usuarios
    @GET("/api/users/")
    Call<Usurl> usuariourl();

    // usuario modificación
    @PATCH("/api/users/{objectoId}/")
    Call<leunam.sparelajarte.models.usurl.Result> usuarioperfil(@Body leunam.sparelajarte.models.usurl.Result result, @Path("objectoId") String id);

    // reserva modificación
    @PATCH("/api/reserva/{objectoId}/")
    Call<leunam.sparelajarte.models.Reserva.Result> reservamodificada(@Body leunam.sparelajarte.models.Reserva.Result result, @Path("objectoId") String id);

    //mensajes de un centro
    @GET("/api/mensaje?")
    Call<Mensaje> mensajes(@Query("centro") String id);

    // crear mensaje
    @POST("/api/mensaje/")
    Call<leunam.sparelajarte.models.Mensaje.Result> mensajesnuevo(@Body ResultEnviar resultEnviar);

    // crear reserva
    @POST("/api/reserva/")
    Call<leunam.sparelajarte.models.Reserva.Result> reservanueva(@Body ResultReserva resultReserva);

    //eliminar reserva
    @DELETE("/api/reserva/{id}/")
    Call<Integer> eliminareserva(@Path("id") Integer id);

    // reservas de un usuario
    @GET("/api/reserva?")
    Call<Reserva> reservas(@Query("usuario") String id);

    //usuario
    @GET("/api/users/{objectoId}/")
    Call<Usuario> usuario(@Path("objectoId") String id);

}
