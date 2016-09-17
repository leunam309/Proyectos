package leunam.sparelajarte.fragments;


import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
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

import leunam.sparelajarte.Utils;
import leunam.sparelajarte.activitys.NavegationActivity;
import leunam.sparelajarte.R;
import leunam.sparelajarte.models.Registro;
import leunam.sparelajarte.models.Token;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment {

    public static Context context;
    Button reg;
    int errorCode;
    EditText usuario, pass, correo;
    String usu,pas, email;
    SoundPool soundPool;
    int sonidoExplosion;

    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registro, container, false);
        context = container.getContext();

        usuario = (EditText) v.findViewById(R.id.editTextUserReg);
        pass = (EditText) v.findViewById(R.id.editTextPassReg);
        correo = (EditText) v.findViewById(R.id.editTextEmailReg);
        reg = (Button) v.findViewById(R.id.buttonRegistrar);




        AudioAttributes aa = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(aa)
                .build();

        // Load sound of guitar
        sonidoExplosion = soundPool.load(v.getContext(), R.raw.demonstrative, 1);



        /**
         * Acción del botón al realizar el registro , hace un callback con los datos
         * que le pasamos
         */

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //llamada metodo sonido


                if(Utils.comprobarInternet(RegistroFragment.this.getContext())) {



                    usu = usuario.getText().toString();
                    pas = pass.getText().toString();
                    email = correo.getText().toString();

                    if (usu.equals("") || pas.length()<6 || pas.equals("") || email.equals("")) {
                        Log.i("vacio", "vacio");

                        Toast.makeText(RegistroFragment.this.getContext(), "Debe rellenar todos los campos corractamente", Toast.LENGTH_LONG).show();

                    } else {
                        sonido();
                        Registro entra = new Registro(usu, pas, pas, email);
                        Log.i("ENTRA", email.toString());
                        Call<Token> Callba = Utils.serviceConInterceptors().registrarse(entra);
                        Log.i("ENTRA call", "ENTRA");
                        Log.i("USUEMAIL", entra.toString());

                        Callba.enqueue(new Callback<Token>() {
                            @Override
                            public void onResponse(Response<Token> response, Retrofit retrofit) {

                                Log.i("ENTRA call2", "ENTRA");
                                Token result = response.body();
                                errorCode = response.code();
                                Log.i("ENTRA errorCode", String.valueOf(errorCode));
                                Log.i("RESUL key", result.getKey());

                                Utils.token = result.getKey();

                                Log.i("TOKEN", String.valueOf(response.body()));
                                Log.i("ERRORCode", String.valueOf(errorCode));

                                if (errorCode == 200 || errorCode == 201) {

                                    Toast toas = Toast.makeText(RegistroFragment.this.getContext(), "Reguistrado correctamente", Toast.LENGTH_LONG);
                                    toas.setGravity(Gravity.CENTER, 0, 0);
                                    toas.show();

                                    usuario.setText("");
                                    pass.setText("");
                                    correo.setText("");

                                    //Intent intent = new Intent(RegistroFragment.this.getContext(), InicioFragment.class);
                                    //startActivity(intent);

                                } else if (errorCode == 404) {
                                    Toast t = Toast.makeText(RegistroFragment.this.getContext(), "Hay un error y no se ha podido loguear", Toast.LENGTH_LONG);
                                    t.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
                                    t.show();
                                }

                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }

                        });

                    }

                }else {
                    Toast toastinternet = Toast.makeText(RegistroFragment.this.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG);
                    toastinternet.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
                    toastinternet.show();
                }

            }
        });

        return v;
    }

    /**
     * Metodo que realiza la ejecucion de un sonido
     */

    public void sonido(){
        Float izq=1.0f;
        Float der= 0.1f;

        for (int i =0; i<10;i++){
            izq=izq-0.1f;
            der=der+0.1f;

            soundPool.play(sonidoExplosion, 1, 1, 0, 0, 1);
        }
    }

}
