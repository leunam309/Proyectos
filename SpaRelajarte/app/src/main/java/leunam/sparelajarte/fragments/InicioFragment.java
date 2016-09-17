package leunam.sparelajarte.fragments;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import leunam.sparelajarte.activitys.MainActivity;
import leunam.sparelajarte.activitys.NavegationActivity;
import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.adapters.ReservaAdapter;
import leunam.sparelajarte.models.Login;
import leunam.sparelajarte.models.Reserva.Reserva;
import leunam.sparelajarte.models.Reserva.Result;
import leunam.sparelajarte.models.Token;
import leunam.sparelajarte.models.usurl.Usurl;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    public static Context context;
    Button entrar;
    EditText usuario, pass;
    String usu, pas;
    int errorCode;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        context = container.getContext();

        usuario = (EditText) v.findViewById(R.id.editTextUser);
        pass = (EditText) v.findViewById(R.id.editTextPass);
        entrar = (Button) v.findViewById(R.id.buttonEntrar);


        /**
         * Acción del botón al realizar el logueo , hace un callback con los datos
         * que le pasamos para entrar a la app
         */

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("ENTRA", "ENTRA");

                if(Utils.comprobarInternet(InicioFragment.this.getContext())) {

                    Log.i("si hay", "internet");

                    usu = usuario.getText().toString();
                    pas = pass.getText().toString();

                    Utils.user = usu;

                    if (usu.equals("") || pas.equals("")) {
                        Log.i("vacio", "vacio");
                        Toast.makeText(InicioFragment.this.getContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();

                    } else {

                        Login entra = new Login(usu, pas);

                        Call<Token> Callba = Utils.serviceConInterceptors().login(entra);
                        Log.i("ENTRA call", "ENTRA");
                        Log.i("USU", entra.toString());
                        Log.i("token", Callba.toString());
                        Callba.enqueue(new Callback<Token>() {
                            @Override
                            public void onResponse(Response<Token> response, Retrofit retrofit) {

                                Log.i("ENTRA call2", "ENTRA");
                                Token result = response.body();
                                errorCode = response.code();
                                Log.i("ENTRA errorCode", String.valueOf(errorCode));
                                Log.i("RESUL key", result.getKey());

                                Utils.token = "Token " + result.getKey();

                                Log.i("TOKEN", String.valueOf(response.body()));
                                Log.i("ERRORCode", String.valueOf(errorCode));

                                if (errorCode == 200) {
                                    idus();
                                    Intent i = new Intent(InicioFragment.this.getActivity(), NavegationActivity.class);
                                    startActivity(i);
                                    datos();
                                    // nombrecabecera.setText(Utils.urlue);

                                } else if (errorCode == 404) {
                                    Toast.makeText(InicioFragment.this.getActivity(), "Hay un error y no se ha podido loguear", Toast.LENGTH_LONG).show();
                                }

                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }

                        });

                    }
                    Toast.makeText(InicioFragment.this.getActivity(), "Usuario registrado correctamente", Toast.LENGTH_LONG);
                }else {
                    Log.i("no hay", "internet");
                    Toast toas = Toast.makeText(InicioFragment.this.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG);
                    toas.setGravity(Gravity.CENTER, 0, 0);
                    toas.show();
                }


            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    /**
     * Metodo con callback para obtener la url del usuario
     */

    public void idus(){
        Log.i("urlMIA","1");
        Call<Usurl> urlCall = Utils.serviceConInterceptors2().usuariourl();
        Log.i("urlMIA", "2");
        urlCall.enqueue(new Callback<Usurl>() {

            @Override
            public void onResponse(Response<Usurl> response, Retrofit retrofit) {
                Log.i("urlMIA","3");
                Usurl resultado = response.body();
                Log.i("urlMIA","4");
                if (response.code() == 200) {

                    Log.i("urlMIA","5");
                    for (int i = 0; i<resultado.getResults().size(); i++){
                        Log.i("urlMIA",resultado.getResults().get(i).getUsername());

                        String us = resultado.getResults().get(i).getUsername();
                        String url = resultado.getResults().get(i).getUrl();
                        if(us.equals(usu)){
                            Log.i("urlMIA","guardado");
                            Utils.urlue=url;
                            Log.i("urlUtil",Utils.urlue);
                            Log.i("urlMIAguardada",url);
                        }


                    }


                    String[] separated = Utils.urlue.split("users/");
                    String idcon = separated[1];
                    Log.i("IDUsuariologeado", idcon);
                    String[] separa = idcon.split("/");
                    String id = separa[0];
                    Log.i("IDUsuariologeado", id);
                    Utils.idue=id;
                    Log.i("Utils.idue", Utils.idue);

                } else if (response.code() == 404) {

                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    /**
     * Metodo que realiza un callback para obtener las reservas
     * de un usuario pasandole su id
     */
    public void datos(){


        Calendar cal = Calendar.getInstance();
        String ani = String.valueOf(cal.get(Calendar.YEAR));
        String mes = String.valueOf(cal.get(Calendar.MONTH));
        int m = Integer.parseInt(mes)+1;

        mes = String.valueOf(m);
        String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        if (Integer.valueOf(mes) <10 ){
            mes = 0+String.valueOf(m);

        }else{

        }

        if (Integer.valueOf(dia) <10){
            dia = 0+dia;
        }else {

        }

        final String fecha = ani + "-" + mes + "-" + dia;


        Call<Reserva> userCall = Utils.serviceConInterceptors2().reservas(Utils.idue);

        userCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Response<Reserva> response, Retrofit retrofit) {


                Reserva result = response.body();
                int errorCode = response.code();

                Log.i("Centros", String.valueOf(result));
                Log.i("ERROR", String.valueOf(errorCode));

                if (errorCode == 200) {
                    ArrayList<Result> listareserva = new ArrayList<>();

                    Log.i("fechacal", fecha);
                    // Log.i("fechareserva",result.getResults().get(i).getFechar());
                    int num_res = 0;
                    for (int i = 0; i < result.getResults().size(); i++) {
                        Log.i("fechareserva", result.getResults().get(i).getFechar());
                        if (result.getResults().get(i).getFechar().compareTo(fecha) < 0 || result.getResults().get(i).getFechar().compareTo(fecha) > 0) {
                            Log.i("la fecha es posterior", "");
                        } else {

                            num_res++;

                        }
                    }
                    if (num_res>0){

                        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                        Notification.Builder builder = new Notification.Builder(getActivity());

                        builder.setSmallIcon(R.drawable.actlogo)
                                .setContentTitle("Aviso de Spa' Relajarte").setContentInfo("Tiene " + num_res + " reservas para hoy").setSound(soundUri);

                        Notification notification = builder.getNotification();
                        notificationManager.notify(R.drawable.actlogo, notification);


                    }else {
                    Log.i("No hay ","reservas para hoy");

                    }
                } else {


                }

            }

            @Override
            public void onFailure(Throwable t) {

            }


        });
    }


}
