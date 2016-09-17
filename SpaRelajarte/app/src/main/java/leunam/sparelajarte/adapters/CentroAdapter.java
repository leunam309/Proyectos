package leunam.sparelajarte.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import leunam.sparelajarte.fragments.CentroFragment;
import leunam.sparelajarte.activitys.CentroScrollActivity;
import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.models.centro.Result;


public class CentroAdapter extends RecyclerView.Adapter<CentroAdapter.CentroViewHolder>{

    private ArrayList<Result> mDataset;
    Context context;




    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CentroViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView nombre;
        public ImageView imagenBar;
        public RelativeLayout relativeclic1;
        private ArrayList<Result> mDataset;


        public CentroViewHolder(ArrayList<Result>res, View v) {

            super(v);

            nombre = (TextView) v.findViewById(R.id.CentroName);
            imagenBar = (ImageView) v.findViewById(R.id.imgCentro);
            relativeclic1 =(RelativeLayout)v.findViewById(R.id.relative);
            mDataset = res;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (Utils.comprobarInternet(v.getContext())) {

                int position = getLayoutPosition();
                Intent i = new Intent(v.getContext(), CentroScrollActivity.class);
                Result resultads = mDataset.get(position);
                Utils.id = String.valueOf(resultads.getId());
                Utils.urlob ="http://localhost:8000/api/centro/" + Utils.id + "/";
                v.getContext().startActivity(i);
            }else {
                Toast.makeText(v.getContext(), "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CentroAdapter(ArrayList<Result> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CentroViewHolder onCreateViewHolder(ViewGroup parent,
                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.centroview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        CentroViewHolder vh = new CentroViewHolder(mDataset, v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CentroViewHolder holder, int position) {

        final Result resultados = mDataset.get(position);


        if(resultados != null){
            String picasso = resultados.getImg();

            holder.nombre.setText(resultados.getNombre());
            Picasso.with(CentroFragment.context)
                    .load(picasso)
                    .into(holder.imagenBar);
        }else{
            holder.nombre.setText("Centro no disponible");
            holder.imagenBar.setImageResource(R.drawable.logo);
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}