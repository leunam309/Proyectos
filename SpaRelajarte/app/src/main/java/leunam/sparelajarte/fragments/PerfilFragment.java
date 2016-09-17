package leunam.sparelajarte.fragments;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.activitys.NavegationActivity;
import leunam.sparelajarte.models.Mensaje.ResultEnviar;
import leunam.sparelajarte.models.Servicio.Result;
import leunam.sparelajarte.models.Usuario;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    EditText user, nombre, apellido,email;
    Button guardar;
    Switch switche;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        user = (EditText) v.findViewById(R.id.editTextUserReg);
        nombre = (EditText) v.findViewById(R.id.editTextNombre);
        apellido= (EditText) v.findViewById(R.id.editTextApe);
        email= (EditText) v.findViewById(R.id.editTextEmailReg);
        guardar = (Button) v.findViewById(R.id.buttonguardarperfil);
        switche = (Switch) v.findViewById(R.id.switch1);

// llamada a metodo
        usuario();

        user.setEnabled(false);
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        email.setEnabled(false);
        guardar.setEnabled(false);


        //switch para ocultar o poner visible los campos del perfil

        switche.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    user.setEnabled(true);
                    nombre.setEnabled(true);
                    apellido.setEnabled(true);
                    email.setEnabled(true);
                    guardar.setEnabled(true);
                } else {
                    user.setEnabled(false);
                    nombre.setEnabled(false);
                    apellido.setEnabled(false);
                    email.setEnabled(false);
                    guardar.setEnabled(false);
                }
            }
        });

        /**
         * Acción del botón al realizar la modificiacion del perfil , hace un callback con los datos
         * modificados que le pasamos
         */

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.comprobarInternet(PerfilFragment.this.getContext())) {

                    String userp = user.getText().toString();
                    String nombrep = nombre.getText().toString();
                    String ape = apellido.getText().toString();
                    String correo = email.getText().toString();
                    List<Object> groups = new ArrayList<Object>();

                    leunam.sparelajarte.models.usurl.Result perfil = new leunam.sparelajarte.models.usurl.Result(Utils.urlue, userp, correo, nombrep, ape);

                    Log.i("perfil", perfil.getUrl().toString());
                    Log.i("perfil", perfil.getEmail().toString());
                    Log.i("perfil", perfil.getFirst_name().toString());
                    Log.i("perfil", perfil.getLast_name().toString());
                    Log.i("perfil", perfil.getUsername().toString());
                    Call<leunam.sparelajarte.models.usurl.Result> servicioCall = Utils.serviceConInterceptors3().usuarioperfil(perfil, Utils.idue);

                    servicioCall.enqueue(new Callback<leunam.sparelajarte.models.usurl.Result>() {
                        @Override
                        public void onResponse(Response<leunam.sparelajarte.models.usurl.Result> response, Retrofit retrofit) {

                            final leunam.sparelajarte.models.usurl.Result resultado = response.body();
                            Log.i("ResultadoComen", String.valueOf(resultado));
                            Log.i("ErrorComentaro", String.valueOf(response.code()));


                            if (response.code() == 200) {


                                Toast.makeText(PerfilFragment.this.getContext(), "Perfil guardado", Toast.LENGTH_LONG).show();
                                Intent inte = new Intent(PerfilFragment.this.getContext(), NavegationActivity.class);
                                getActivity().finish();
                                startActivity(inte);

                            } else if (response.code() == 404) {

                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }else {
                    Toast.makeText(PerfilFragment.this.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
                }
            }
        });

                return v;
    }


    /**
     * Metodo con callback para obtener los datos del perfil del usuario
     * mediante el id del usuario
     */
    public void usuario(){


        Call<leunam.sparelajarte.models.usurl.Result> servicioCall = Utils.serviceConInterceptors2().me(Utils.idue);

        servicioCall.enqueue(new Callback<leunam.sparelajarte.models.usurl.Result>() {
            @Override
            public void onResponse(Response<leunam.sparelajarte.models.usurl.Result> response, Retrofit retrofit) {

                final leunam.sparelajarte.models.usurl.Result resultado = response.body();
                Log.i("ResultadoComen", String.valueOf(resultado.getFirst_name()));
                Log.i("ResultadoComen", String.valueOf(resultado.getLast_name()));
                Log.i("ErrorComentaro", String.valueOf(response.code()));


                if (response.code() == 200) {


                    user.setText(resultado.getUsername());
                    nombre.setText(resultado.getFirst_name());
                    email.setText(resultado.getEmail());
                    apellido.setText(resultado.getLast_name());

                } else if (response.code() == 404) {

                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }



}
