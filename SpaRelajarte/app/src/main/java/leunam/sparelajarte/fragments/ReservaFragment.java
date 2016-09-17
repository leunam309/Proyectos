package leunam.sparelajarte.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.activitys.ReservaActivity;
import leunam.sparelajarte.adapters.CentroAdapter;
import leunam.sparelajarte.adapters.ReservaAdapter;
import leunam.sparelajarte.models.Reserva.Reserva;
import leunam.sparelajarte.models.centro.Centro;
import leunam.sparelajarte.models.centro.Result;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReservaFragment extends Fragment {



    public static Context context;
    ArrayList<String> result;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayaoutManager;
    int errorCode, m;
    Calendar cal;
    String ani, mes, dia, fecha;


    public ReservaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reserva, container, false);

        context = container.getContext();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewReserva);
        mRecyclerView.setHasFixedSize(true);
        mLayaoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayaoutManager);

        // llamada a metodo
        datos();




        return v;


    }


    /**
     * Metodo que realiza un callback para obtener las reservas
     * de un usuario pasandole su id
     */
    public void datos(){


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

        if (Integer.valueOf(dia) <10){
            dia = 0+dia;
        }else {

        }

        fecha = ani + "-" + mes + "-" + dia;


        Call<Reserva> userCall = Utils.serviceConInterceptors2().reservas(Utils.idue);

        userCall.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Response<Reserva> response, Retrofit retrofit) {


                Reserva result = response.body();
                errorCode = response.code();

                Log.i("Centros", String.valueOf(result));
                Log.i("ERROR", String.valueOf(errorCode));

                if (errorCode == 200) {
                    ArrayList<leunam.sparelajarte.models.Reserva.Result> listareserva = new ArrayList<>();

                    Log.i("fechacal", fecha);
                   // Log.i("fechareserva",result.getResults().get(i).getFechar());

                    for (int i = 0; i < result.getResults().size(); i++) {
                        Log.i("fechareserva",result.getResults().get(i).getFechar());
                        if(result.getResults().get(i).getFechar().compareTo(fecha) < 0){
                            Log.i("la fecha es posterior","");
                        }else {

                            listareserva.add(result.getResults().get(i));

                        }
                    }

                    mAdapter = new ReservaAdapter(listareserva);
                    mRecyclerView.setAdapter(mAdapter);


                } else {


                }

            }

            @Override
            public void onFailure(Throwable t) {

            }


        });
    }



}






