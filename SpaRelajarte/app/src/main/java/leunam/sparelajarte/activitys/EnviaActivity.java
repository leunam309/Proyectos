package leunam.sparelajarte.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Calendar;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.models.Mensaje.Result;
import leunam.sparelajarte.models.Mensaje.ResultEnviar;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class EnviaActivity extends AppCompatActivity {

    EditText mensaje;
    Calendar c2;
    String ani, mes, dia, fecha;
    int errorCode, m;
    Button envia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envia);

        envia = (Button) findViewById(R.id.buttonEnviar);
        mensaje = (EditText) findViewById(R.id.editTextMensaje);

        /**
         *Acción del botón al realizar el comentario, hace un callback con los datos
         * que le pasamos y nos manda al activity en el cual hemos comentado
         */

        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.comprobarInternet(EnviaActivity.this)) {

                    c2 = Calendar.getInstance();

                    ani = String.valueOf(c2.get(Calendar.YEAR));
                    mes = String.valueOf(c2.get(Calendar.MONTH));
                    m = Integer.parseInt(mes) + 1;
                    mes = String.valueOf(m);
                    dia = String.valueOf(c2.get(Calendar.DAY_OF_MONTH));
                    if (Integer.valueOf(mes) < 10) {
                        mes = 0 + String.valueOf(m);
                    } else {

                    }
                    fecha = ani + "-" + mes + "-" + dia;
                    //fecha="2016-06-11";

                    String com = mensaje.getText().toString();

                    Log.i("fechamensaje", fecha);
                    ResultEnviar men = new ResultEnviar(Utils.urlue, Utils.urlob, com, fecha);


                    Call<Result> Callba = Utils.serviceConInterceptors3().mensajesnuevo(men);


                    Callba.enqueue(new Callback<Result>() {
                        @Override
                        public void onResponse(Response<Result> response, Retrofit retrofit) {

                            Log.i("ENTRA call2", "ENTRA");
                            Result result = response.body();
                            errorCode = response.code();


                            Log.i("ERRORCode", String.valueOf(errorCode));

                            if (errorCode == 201) {

                                Toast.makeText(EnviaActivity.this, "Enviado correctamente", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(EnviaActivity.this, CentroScrollActivity.class);
                                finish();
                                startActivity(intent);

                            } else if (errorCode == 404) {
                                Toast.makeText(EnviaActivity.this, "Hay un error y no se ha podido enviar", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }

                    });

                }else {
                    Toast.makeText(EnviaActivity.this, "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();

                }
            }
        });


    }




}
