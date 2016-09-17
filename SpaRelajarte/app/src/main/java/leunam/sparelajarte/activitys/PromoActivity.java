package leunam.sparelajarte.activitys;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.models.Promocion.Promocion;
import leunam.sparelajarte.models.Reserva.ResultReserva;
import leunam.sparelajarte.models.Servicio.Servicio;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class PromoActivity extends AppCompatActivity {

    private Button reser;
    private Spinner spinnerpro;
    TextView fecha,hora;
    Calendar myCalendar;
    List<leunam.sparelajarte.models.Promocion.Result> listapro=new ArrayList<>();
    int errorCode,m;
    String se="";
    Calendar cal;
    String ani, mes, dia, fechap, horap, hp, mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        reser = (Button) findViewById(R.id.buttonreservadop);
        spinnerpro = (Spinner) findViewById(R.id.spinnerPro);
        fecha = (TextView) findViewById(R.id.textfechapro);
        hora  = (TextView) findViewById(R.id.texthorapro);
        myCalendar = Calendar.getInstance();

        promociones();

        //Creamos un objeto de DatePicker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
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
                new DatePickerDialog(PromoActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(PromoActivity.this, time, myCalendar
                        .get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE), true).show();
            }

        });

        /**
         *Acción del botón al realizar la reserva de la promoción
         */
        reser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.comprobarInternet(PromoActivity.this)) {

                    //Obtenemos la fecha, hora, y servicio seleccionado

                    String f = fecha.getText().toString();
                    String h = hora.getText().toString();
                    String ser = spinnerpro.getSelectedItem().toString();


                    //Split para obtener el nombre del servicio

                    Log.i("reserva promo", ser);
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
                        Toast.makeText(PromoActivity.this, "Debe rellenar todos los campos de reserva", Toast.LENGTH_LONG).show();

                    } else {

                        if (f.compareTo(fechap) > 0 && h.compareTo("09:00") >= 0 && h.compareTo("22:00") < 0 ||
                                f.compareTo(fechap) == 0 && h.compareTo(horap) >= 0 && h.compareTo("09:00") >= 0 && h.compareTo("22:00") < 0) {


                            //Callback que realiza la reserva mediante los datos que les pasamos

                            ResultReserva reserv = new ResultReserva(Utils.urlob, se, Utils.urlue, f, h);


                            Call<leunam.sparelajarte.models.Reserva.Result> Callba = Utils.serviceConInterceptors3().reservanueva(reserv);


                            Callba.enqueue(new Callback<leunam.sparelajarte.models.Reserva.Result>() {
                                @Override
                                public void onResponse(Response<leunam.sparelajarte.models.Reserva.Result> response, Retrofit retrofit) {

                                    Log.i("ENTRA call2", "ENTRA");
                                    leunam.sparelajarte.models.Reserva.Result result = response.body();
                                    errorCode = response.code();


                                    Log.i("ERRORCode", String.valueOf(errorCode));

                                    if (errorCode == 201) {

                                        Toast.makeText(PromoActivity.this, "Disfrute de su reserva", Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(PromoActivity.this, NavegationActivity.class);
                                        finish();
                                        startActivity(intent);

                                    } else if (errorCode == 404) {
                                        Toast.makeText(PromoActivity.this, "Hay un error y no se ha podido reservar", Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(Throwable t) {

                                }

                            });
                        } else {
                            Toast.makeText(PromoActivity.this, "La fecha y hora no puede ser inferior a la actual", Toast.LENGTH_LONG).show();
                        }


                    }
                }else {
                    Toast.makeText(PromoActivity.this, "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    /**
     * Metodo con callback que usamos para obtener los servicios
     * que estan en promoción y cargarlos en el sppiner
     */

    public void promociones(){

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



        Log.i("fechap",fechap);
        Call<Promocion> promoCall = Utils.serviceConInterceptors2().promocion();

        promoCall.enqueue(new Callback<Promocion>() {
            @Override
            public void onResponse(Response<Promocion> response, Retrofit retrofit) {

                Promocion result = response.body();
                Log.i("Resultadopromo", String.valueOf(result));
                Log.i("Errorpromocion", String.valueOf(response.code()));


                if (response.code() == 200) {
                  for (int j = 0; j < Utils.servicentro.size(); j++) {
                        Log.i("j", String.valueOf(j));

                        for (int i = 0; i < result.getResults().size(); i++) {

                              if (Utils.servicentro.get(j).toString().equalsIgnoreCase(result.getResults().get(i).getServicio())) {

                            if (result.getResults().get(i).getFechaini().compareTo(fechap) < 0 &&
                                    result.getResults().get(i).getFechafin().compareTo(fechap) > 0) {
                                Log.i("fechapromo", fechap);
                                Log.i("servpromo", result.getResults().get(i).getServicio());
                                listapro.add(new leunam.sparelajarte.models.Promocion.Result(result.getResults().get(i).getNombrep(),
                                        result.getResults().get(i).getPreciop()));
                            } else {
                                Log.i("fecha de rango", "");
                            }
                        }else {

                              }
                        }
                    }
                    Log.i("spinner",listapro.toString());
                    ArrayAdapter<leunam.sparelajarte.models.Promocion.Result> adapter2 = new ArrayAdapter<leunam.sparelajarte.models.Promocion.Result>(
                            getBaseContext(), android.R.layout.simple_spinner_item,
                            listapro);
                    spinnerpro.setAdapter(adapter2);


                } else if (response.code() == 404) {

                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


}
