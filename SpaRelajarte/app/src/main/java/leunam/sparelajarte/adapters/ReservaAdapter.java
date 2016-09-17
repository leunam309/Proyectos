package leunam.sparelajarte.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import leunam.sparelajarte.activitys.CentroScrollActivity;
import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.activitys.PromoActivity;
import leunam.sparelajarte.activitys.PromoModiActivity;
import leunam.sparelajarte.activitys.ReservaActivity;
import leunam.sparelajarte.activitys.ReservaModiActivity;
import leunam.sparelajarte.models.Reserva.Result;
import leunam.sparelajarte.models.Servicio.Servicio;
import leunam.sparelajarte.models.centro.Centro;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by manuel on 19/05/2016.
 */
public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>{

    private ArrayList<leunam.sparelajarte.models.Reserva.Result> mDataset;
    Context context;
    int errorCode;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ReservaViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView servicio, fecha, centro,hora;
        public LinearLayout relativeclic1;
        private ArrayList<leunam.sparelajarte.models.Reserva.Result> mDataset;


        public ReservaViewHolder(ArrayList<leunam.sparelajarte.models.Reserva.Result>res, View v) {

            super(v);

            servicio = (TextView) v.findViewById(R.id.textservicio);
            fecha = (TextView) v.findViewById(R.id.textfecha);
            centro = (TextView) v.findViewById(R.id.textcentro);
            hora = (TextView) v.findViewById(R.id.texthora);
            relativeclic1 =(LinearLayout)v.findViewById(R.id.relativelinea);
            mDataset = res;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {

            if (Utils.comprobarInternet(v.getContext())) {

            int position= getLayoutPosition();

            final leunam.sparelajarte.models.Reserva.Result resultads = mDataset.get(position);
            Utils.id= String.valueOf(resultads.getId());
                Utils.urlcentromodi=resultads.getCentro();
                Log.i("urlcentro",Utils.urlcentromodi);

                Call<Centro> userCall = Utils.serviceConInterceptors2().centross();
                Log.i("entraCall", Utils.id);
                Log.i("entraCall", "entraCall");
                Log.i("entraCall", Utils.urlcentromodi);
                userCall.enqueue(new Callback<Centro>() {
                    @Override
                    public void onResponse(Response<Centro> response, Retrofit retrofit) {


                        Centro result = response.body();
                        int errorCode = response.code();

                        Log.i("Centros", String.valueOf(result));
                        Log.i("ERROR", String.valueOf(errorCode));

                        if (errorCode == 200) {

                            for (int i = 0; i < result.getResults().size(); i++) {
                                Log.i("entracentro", result.getResults().get(i).getServicio().toString());
                                if (Utils.urlcentromodi.equalsIgnoreCase(result.getResults().get(i).getNombre())) {
                                    Utils.servicentro = result.getResults().get(i).getServicio();
                                    Log.i("Lspromo", Utils.servicentro.toString());
                                } else {
                                    Log.i("ERROR", result.getResults().get(i).getServicio().toString());
                                }

                            }


                        } else {


                        }

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }


                });



            //callback para obtener los servicios

            Call<List<leunam.sparelajarte.models.Servicio.Result>> servicioCall = Utils.serviceConInterceptors2().serviciob();

            servicioCall.enqueue(new Callback<List<leunam.sparelajarte.models.Servicio.Result>>() {
                @Override
                public void onResponse(Response<List<leunam.sparelajarte.models.Servicio.Result>> response, Retrofit retrofit) {

                    final List<leunam.sparelajarte.models.Servicio.Result> resultado = response.body();
                    Log.i("ResultadoComen", String.valueOf(resultado));
                    Log.i("ErrorComentaro", String.valueOf(response.code()));

                    //Iterator it = resultado.iterator();

                    if (response.code() == 200) {
                        Intent inte = new Intent(v.getContext(), ReservaModiActivity.class);
                        Intent intent = new Intent(v.getContext(), PromoModiActivity.class);
                    int serv=0;
                        for (int i = 0; i < resultado.size(); i++) {
                                Log.i("servciocomparado",resultads.getServicio());
                                Log.i("con este",resultado.get(i).getTipo());

                           // while(it.hasNext()) {

                                if (resultads.getServicio().equalsIgnoreCase(String.valueOf(resultado.get(i).getTipo()))) {

                                    inte.putExtra("idreserva", resultads.getId());
                                    inte.putExtra("centro", resultads.getCentro());
                                    inte.putExtra("fechar", resultads.getFechar());
                                    inte.putExtra("horar", resultads.getHorar());
                                    inte.putExtra("servicior", resultads.getServicio());

                                    serv++;


                                } else {
                                    intent.putExtra("idreserva", resultads.getId());
                                    intent.putExtra("centro", resultads.getCentro());
                                    intent.putExtra("fechar", resultads.getFechar());
                                    intent.putExtra("horar", resultads.getHorar());
                                    intent.putExtra("servicior", resultads.getServicio());
                                }
                           // }
                        }

                        if (serv>0){

                            v.getContext().startActivity(inte);
                        }else {

                            v.getContext().startActivity(intent);
                        }

                    } else if (response.code() == 404) {

                    }

                }

                @Override
                public void onFailure(Throwable t) {

                }
            });



            }else {
                Toast.makeText(v.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
            }


        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ReservaAdapter(ArrayList<leunam.sparelajarte.models.Reserva.Result> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ReservaViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reservaview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ReservaViewHolder vh = new ReservaViewHolder(mDataset, v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ReservaViewHolder holder, final int position) {

        final leunam.sparelajarte.models.Reserva.Result resultados = mDataset.get(position);


        if(resultados != null){

            holder.servicio.setText(resultados.getServicio());
            holder.hora.setText(resultados.getHorar());
            holder.fecha.setText(resultados.getFechar());

            try {


                String CurrentString = resultados.getCentro();
                String[] separated = CurrentString.split("centro/");
                String idcon = separated[1];
                Log.i("IDcentroreserva", idcon);
                String[] separa = idcon.split("/");
                String id = separa[0];
                Log.i("IDcentroreserva", id);


                Call<leunam.sparelajarte.models.centro.Result> userCall = Utils.serviceConInterceptors2().centro(id);

                userCall.enqueue(new Callback<leunam.sparelajarte.models.centro.Result>() {
                    @Override
                    public void onResponse(Response<leunam.sparelajarte.models.centro.Result> response, Retrofit retrofit) {


                        leunam.sparelajarte.models.centro.Result result = response.body();
                        errorCode = response.code();

                        Log.i("Centros", String.valueOf(result));
                        Log.i("ERROR", String.valueOf(errorCode));

                        if (errorCode == 200) {
                            if (result.getNombre() != null) {
                                String centro = String.valueOf(result.getNombre());
                                Log.i("USUEMI", centro);
                                resultados.setCentro(centro);
                                holder.centro.setText(resultados.getCentro());

                            }


                        } else {


                        }

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }

            catch(
                    NullPointerException e
                    )

            {
                holder.centro.setText("No tiene nombre");
            }

            try {


                String CurrentString = resultados.getServicio();
                String[] separated = CurrentString.split("servicio/");
                String idcon = separated[1];
                Log.i("IDservicioreserva", idcon);
                String[] separa = idcon.split("/");
                String idser = separa[0];
                Log.i("IDservicioreserva", idser);


                Call<leunam.sparelajarte.models.Servicio.Result> serCall = Utils.serviceConInterceptors2().servicios(idser);

                serCall.enqueue(new Callback<leunam.sparelajarte.models.Servicio.Result>() {
                    @Override
                    public void onResponse(Response<leunam.sparelajarte.models.Servicio.Result> response, Retrofit retrofit) {


                        leunam.sparelajarte.models.Servicio.Result result = response.body();
                        errorCode = response.code();

                        Log.i("servicios", String.valueOf(result));
                        Log.i("ERROR", String.valueOf(errorCode));

                        if (errorCode == 200) {
                            if (result.getTipo() != null) {
                                String servicio = String.valueOf(result.getTipo());
                                Log.i("servicio", servicio);
                                resultados.setServicio(servicio);
                                holder.servicio.setText(resultados.getServicio());
                            }


                        } else {


                        }

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }

            catch(
                    NullPointerException e
                    )

            {
                holder.servicio.setText("servicio no disponible");
            }



        }else{
            holder.servicio.setText("reserva no disponible");
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}