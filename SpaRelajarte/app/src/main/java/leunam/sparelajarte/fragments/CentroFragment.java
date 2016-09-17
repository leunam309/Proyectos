package leunam.sparelajarte.fragments;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.adapters.CentroAdapter;
import leunam.sparelajarte.models.centro.Centro;
import leunam.sparelajarte.models.centro.Result;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CentroFragment extends Fragment {


    public static Context context;
    ArrayList<String> result;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayaoutManager;
    int errorCode;


    public CentroFragment() {
        // Required empty public constructor
    }


    private LinearLayout linearLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_centro, container, false);
        context = container.getContext();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewBar);
        mRecyclerView.setHasFixedSize(true);
        mLayaoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayaoutManager);


        // llamada metodo
        datos();


        return v;

    }


    /**
     * Metodo con callback para obtener los datos de un centro pasandole un id
     */
    public void datos(){

        Call<Centro> userCall = Utils.serviceConInterceptors2().centros(Utils.id);

        userCall.enqueue(new Callback<Centro>() {
            @Override
            public void onResponse(Response<Centro> response, Retrofit retrofit) {


                Centro result = response.body();
                errorCode = response.code();

                Log.i("Centros", String.valueOf(result));
                Log.i("ERROR", String.valueOf(errorCode));

                if (errorCode == 200) {
                    ArrayList<Result> listacentro= new ArrayList<>();

                    for (int i = 0; i< result.getResults().size(); i++){
                        listacentro.add(result.getResults().get(i));
                    }

                    mAdapter = new CentroAdapter(listacentro);
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



