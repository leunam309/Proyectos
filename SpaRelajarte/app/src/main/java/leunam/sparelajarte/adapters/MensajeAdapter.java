package leunam.sparelajarte.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.models.Mensaje.Result;
import leunam.sparelajarte.models.Usuario;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by Fran on 25/10/2015.
 */


public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.CardViewHolder> {
    private List<Result> items;
    int errorCode;
    Context context;
    float total;


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        TextView user,fecha,comentario;


        public CardViewHolder(View v) {
            super(v);
             user = (TextView) v.findViewById(R.id.comentarioUser);
            fecha = (TextView) v.findViewById(R.id.comentarioFecha);
            comentario = (TextView) v.findViewById(R.id.comentario);



        }
    }

    public MensajeAdapter(List<Result> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mensajes, viewGroup, false);

        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder viewHolder, final int i) {


        try {
            viewHolder.comentario.setText(items.get(i).getComentario());
        }catch (NullPointerException e){
            viewHolder.comentario.setText("No tiene comentario");
        }

        try {
            viewHolder.fecha.setText(items.get(i).getFecha());
        }catch (NullPointerException e){
            viewHolder.fecha.setText("No tiene fecha");
        }

        try {

            //split para sacar el id del usuario

            String CurrentString = items.get(i).getUsuarioEmisor();
            String[] separated = CurrentString.split("users/");
            String idcon = separated[1];
            Log.i("IDUSUARIOEMIi", idcon);
            String[] separa = idcon.split("/");
            String id = separa[0];
            Log.i("IDUSUARIOEMI", id);

            //callback para obtener el nombre del usuario que a comentado

            Call<Usuario> userCall = Utils.serviceConInterceptors2().usuario(id);

            userCall.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Response<Usuario> response, Retrofit retrofit) {


                    Usuario result = response.body();
                    errorCode = response.code();

                    Log.i("Centros", String.valueOf(result));
                    Log.i("ERROR", String.valueOf(errorCode));

                    if (errorCode == 200) {
                        if (result.getUsername() != null) {
                            String usuario = String.valueOf(result.getUsername());
                            Log.i("USUEMI", usuario);
                            items.get(i).setUsuarioEmisor(usuario);
                            viewHolder.user.setText(items.get(i).getUsuarioEmisor());
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
                viewHolder.user.setText("No tiene nombre");
            }

        }


        }

