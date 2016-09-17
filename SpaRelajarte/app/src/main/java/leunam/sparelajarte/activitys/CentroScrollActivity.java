package leunam.sparelajarte.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.adapters.MensajeAdapter;
import leunam.sparelajarte.models.Mensaje.Mensaje;
import leunam.sparelajarte.models.centro.Result;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CentroScrollActivity extends AppCompatActivity {


    Button reserva, aniadeComen, promocion, mapa;
    int errorCode;
    CollapsingToolbarLayout tb;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    TextView nombrec, desc;
    ImageView imageViewToolbar;
    String usuarioEmisor, ubi;
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_scroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        datos();
        mensajes();


        Log.i("idmensaje", Utils.id);

        tb = (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        nombrec = (TextView) findViewById(R.id.textViewNombreCentro);
        desc = (TextView) findViewById(R.id.textViewDescripcionCentro);
        imageViewToolbar =(ImageView) appBarLayout.findViewById(R.id.imageViewToolbar);
        mRecycler = (RecyclerView) findViewById(R.id.recicladorComen);
        mLayoutManager = new LinearLayoutManager(getBaseContext());
        mRecycler.setLayoutManager(mLayoutManager);



        promocion = (Button) findViewById(R.id.buttonpromo);
        reserva = (Button) findViewById(R.id.buttonReservar);
        aniadeComen = (Button) findViewById(R.id.buttonComentario);
        mapa = (Button) findViewById(R.id.ButtonMapa);


        /**
         *Acción del botón al añadir comentario nos pasa a otro activity
         * en el que escribiremos en mensaje
         */
        aniadeComen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentroScrollActivity.this, EnviaActivity.class);
                startActivity(intent);
            }
        });

        /**
         *Acción del botón al realizar la reserva nos manda al activity
         * en el cual hacemos la reserva
         */
        reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.comprobarInternet(v.getContext())) {



                Intent intent = new Intent(CentroScrollActivity.this, ReservaActivity.class);
                    //intent.putExtra("idreserva",resultads.getId());
                startActivity(intent);
                }else {
                    Toast.makeText(v.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         *Acción del botón al realizar la reserva nos manda al activity
         * de promociones en el cual hacemos la reserva
         */
        promocion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.comprobarInternet(v.getContext())) {
                Intent intent = new Intent(CentroScrollActivity.this, PromoActivity.class);
                startActivity(intent);
                }else {
                    Toast.makeText(v.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
                }
            }
        });
        /**
         *Acción del botón al realizar la reserva nos manda al activity
         * en el que vemos cual es la ubicación del centro
         */
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.comprobarInternet(v.getContext())) {
                 Uri location = Uri.parse("geo:"+ubi+"?z=18"); // z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                }else {
                    Toast.makeText(v.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /**
     *Metodo con callback para obtener los datos de un centro concreto
     * mediante el id del mismo
     */

    public void datos(){

        Call<Result> userCall = Utils.serviceConInterceptors2().centro(Utils.id);

        userCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {


                Result result = response.body();
                errorCode = response.code();

                Log.i("Centros", String.valueOf(result));
                Log.i("ERROR", String.valueOf(errorCode));

                if (errorCode == 200) {
                    if (result.getNombre() != null) {


                        Utils.servicentro = result.getServicio();

                        Log.i("Listaservicios", Utils.servicentro.toString());
                        nombrec.setText(result.getNombre());
                        desc.setText(result.getDescripcion());
                        ubi = result.getCoordenadas();
                        Utils.map = result.getCoordenadas();
                        Picasso.with(CentroScrollActivity.this).load(result.getImg()).fit().into(imageViewToolbar);

                    }

                    Log.i("cent", String.valueOf(result));

                } else {


                }

            }

            @Override
            public void onFailure(Throwable t) {

            }


        });
    }


    /**
     *Metodo con callback para obtener los mensajes que han dejado los usuario en ese centro
     */
    private void mensajes(){
        Call<Mensaje> sitioCall = Utils.serviceConInterceptors2().mensajes(Utils.id);


        sitioCall.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Response<Mensaje> response, Retrofit retrofit) {

                Mensaje resultado = response.body();
                Log.i("ResultadoComen", String.valueOf(resultado));
                Log.i("ErrorComentaro", String.valueOf(response.code()));


                if (response.code() == 200) {


                    for (int i = 0; i < resultado.getResults().size(); i++) {
                        String fecha = resultado.getResults().get(i).getFecha();
                        usuarioEmisor = resultado.getResults().get(i).getUsuarioEmisor();


                        //Utils.urlob = resultado.getResults().get(i).getCentro();
                        Log.i("centro", Utils.urlob);


                        String[] separated = usuarioEmisor.split("users/");
                        String idcon = separated[0];
                        Log.i("iduser", idcon);
                        String[] separa = idcon.split("/");
                        String ue = separa[0];
                    }

                    mAdapter = new MensajeAdapter(resultado.getResults());
                    mRecycler.setAdapter(mAdapter);

                } else if (response.code() == 404) {

                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }



}
