package leunam.sparelajarte.activitys;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.models.Mensaje.ResultEnviar;
import leunam.sparelajarte.models.Promocion.Promocion;
import leunam.sparelajarte.models.Reserva.ResultReserva;
import leunam.sparelajarte.models.Servicio.Servicio;
import leunam.sparelajarte.models.centro.Result;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ReservaActivity extends AppCompatActivity {

    private Button reser;
    private Spinner spiner;
    TextView fecha,hora;
    Calendar myCalendar;
    List<leunam.sparelajarte.models.Servicio.Result> lista=new ArrayList<>();
    int errorCode,m;
    String se="";
    Calendar cal;
    String ani, mes, dia, fechap, horap, hp, mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        reser = (Button) findViewById(R.id.buttonreservado);
        spiner = (Spinner) findViewById(R.id.spinnerServicio);
        fecha = (TextView) findViewById(R.id.textfecha);
        hora  = (TextView) findViewById(R.id.texthora);
        myCalendar = Calendar.getInstance();
        servicios();


        //Creamos un objeto de DatePicker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                view.setMinDate(myCalendar.getTimeInMillis());
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

                fecha.setText(sdf.format(myCalendar.getTime()));

            }

        };

        //Creamos un objeto de TimePicker
        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hora, int min) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.HOUR, hora);
                myCalendar.set(Calendar.MINUTE, min);
                updateLabe();
            }

            private void updateLabe() {

                String myFormat = "HH:mm";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

                hora.setText(sdf.format(myCalendar.getTime()));

            }

        };

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ReservaActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(ReservaActivity.this, time, myCalendar
                        .get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE), true).show();
            }

        });

        /**
         *Acción del botón al realizar la reserva
         */

        reser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.comprobarInternet(ReservaActivity.this)) {

                    //Obtenemos la fecha, hora, y servicio seleccionado

                    String f = fecha.getText().toString();
                    String h = hora.getText().toString();
                    String ser = spiner.getSelectedItem().toString();

                    //Split para obtener el nombre del servicio

                    Log.i("reserva servicio1", ser);
                    String[] sep = ser.split(",");
                    Log.i("reserva idser2", sep[0]);
                    String us = sep[0];
                    final String nom_final = us.substring(2, us.length());
                    Log.i("reserva4", nom_final);


                    // Callback para obtener el id del servicio para hacer la reserva con la url

                    Call<Servicio> serviCall = Utils.serviceConInterceptors2().servicio();

                    serviCall.enqueue(new Callback<Servicio>() {
                        @Override
                        public void onResponse(Response<Servicio> response, Retrofit retrofit) {

                            Servicio resultado = response.body();

                            Log.i("entra200", "");

                            if (response.code() == 200) {
                                Log.i("entra200", "");

                                for (int i = 0; i < resultado.getResults().size(); i++) {

                                    if (resultado.getResults().get(i).getTipo().equalsIgnoreCase(nom_final)) {
                                        String iser = String.valueOf(resultado.getResults().get(i).getId());
                                        Log.i("idreserva", iser);
                                        se = "http://localhost:8000/api/servicio/" + iser + "/";
                                    } else {

                                    }

                                }


                            } else if (response.code() == 404) {

                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });

                    if (f.equals("") || h.equals("00:00") || se.equals("")) {
                        Log.i("vacio", "vacio");
                        Toast.makeText(ReservaActivity.this, "Debe rellenar todos los campos de reserva", Toast.LENGTH_LONG).show();

                    } else {


                        if (f.compareTo(fechap) > 0 && h.compareTo("09:00") >= 0 && h.compareTo("22:00") < 0 ||
                            f.compareTo(fechap) == 0 && h.compareTo(horap) >= 0 && h.compareTo("09:00") >= 0 && h.compareTo("22:00") < 0) {


                            //Callback que realiza la reserva mediante los datos que les pasamos

                            ResultReserva reserv = new ResultReserva(Utils.urlob, se, Utils.urlue, f, h);

                            Log.i("RESERVA","ha reservado");

                            Log.i("RESERVA",se);
                            Log.i("RESERVA",Utils.urlue);
                            Log.i("RESERVA",h);
                            Log.i("RESERVA",f);
                            Log.i("RESERVA",Utils.urlob);
                            Call<leunam.sparelajarte.models.Reserva.Result> Callba = Utils.serviceConInterceptors3().reservanueva(reserv);


                            Callba.enqueue(new Callback<leunam.sparelajarte.models.Reserva.Result>() {
                                @Override
                                public void onResponse(Response<leunam.sparelajarte.models.Reserva.Result> response, Retrofit retrofit) {

                                    Log.i("ENTRA call2", "ENTRA");
                                    leunam.sparelajarte.models.Reserva.Result result = response.body();
                                    errorCode = response.code();


                                    Log.i("ERRORCode", String.valueOf(errorCode));

                                    if (errorCode == 201) {

                                        Toast.makeText(ReservaActivity.this, "Disfrute de su reserva", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(ReservaActivity.this, NavegationActivity.class);
                                        finish();
                                        startActivity(intent);

                                    } else if (errorCode == 404) {
                                        Toast.makeText(ReservaActivity.this, "Hay un error y no se ha podido reservar", Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(Throwable t) {

                                }

                            });

                        } else {
                            Toast.makeText(ReservaActivity.this, "La fecha y hora no pueden ser inferior a la actual", Toast.LENGTH_LONG).show();

                        }
                    }


                }else {
                    Toast.makeText(ReservaActivity.this, "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    /**
     * Metodo con callback que usamos para obtener los servicios
     * que no estan en promoción y cargarlos en el sppiner
     */

    public void servicios(){


        cal = Calendar.getInstance();
        ani = String.valueOf(cal.get(Calendar.YEAR));
        mes = String.valueOf(cal.get(Calendar.MONTH));
        m = Integer.parseInt(mes)+1;
        mes = String.valueOf(m);
        dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        if (Integer.valueOf(mes) <10 ){
            mes = 0+String.valueOf(m);
        }else{

        }
        if (Integer.valueOf(dia) <10 ){
            dia = 0+dia;
        }else{

        }
        fechap = ani + "-" + mes + "-" + dia;

        hp = String.valueOf(cal.get(Calendar.HOUR));
        mp = String.valueOf(cal.get(Calendar.MINUTE));
        if (Integer.valueOf(hp) <10 ){
            hp = 0+hp;
        }else{

        }
        //horap = hp+":"+mp;
        String myFormat = "HH:mm";
        SimpleDateFormat sd = new SimpleDateFormat(myFormat);
        horap = sd.format(cal.getTime());


        Call<List<leunam.sparelajarte.models.Servicio.Result>> servicioCall = Utils.serviceConInterceptors2().serviciob();

        servicioCall.enqueue(new Callback<List<leunam.sparelajarte.models.Servicio.Result>>() {
            @Override
            public void onResponse(Response<List<leunam.sparelajarte.models.Servicio.Result>> response, Retrofit retrofit) {

                final List<leunam.sparelajarte.models.Servicio.Result> resultado = response.body();
                Log.i("ResultadoComen", String.valueOf(resultado));
                Log.i("ErrorComentaro", String.valueOf(response.code()));


                if (response.code() == 200) {
                    Iterator iter = (Iterator) resultado.iterator();

                    for (int j = 0; j < Utils.servicentro.size(); j++) {
                        Log.i("j", String.valueOf(j));
                        //int i=0;
                        for (int i = 0; i < resultado.size(); i++) {
                        //while (iter.hasNext()) {


                                String[] separated = Utils.servicentro.get(j).split("servicio/");
                                String idsc = separated[1];
                                String[] separa = idsc.split("/");
                                String id = separa[0];
                            Log.i("IDserviciocentro", id);
                            String iser=resultado.get(i).getId().toString();
                                if (id.equalsIgnoreCase(iser)) {
                                    lista.add(new leunam.sparelajarte.models.Servicio.Result(resultado.get(i).getId(),
                                            resultado.get(i).getTipo(), resultado.get(i).getPrecio()));
                                }else {
                                    Log.i("IDservicio", resultado.get(i).getId().toString());
                                }

                           // i++;
                           // }
                        }



                    }
                    Log.i("spinner", lista.toString());
                    ArrayAdapter<leunam.sparelajarte.models.Servicio.Result> adapter1 = new ArrayAdapter<leunam.sparelajarte.models.Servicio.Result>(
                            getBaseContext(), android.R.layout.simple_spinner_item,
                            lista);
                    spiner.setAdapter(adapter1);


                } else if (response.code() == 404) {

                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


}
