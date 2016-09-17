package leunam.sparelajarte;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import com.google.android.gms.maps.model.LatLng;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import leunam.sparelajarte.interfaces.TAPI;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by manuel on 17/02/2016.
 */
public class Utils {


    public static String token;
    public static String user;
    public static String id;
    public static String urlue;
    public static String idue;
    public static String urlob;
    public static List<String> servicentro;
    public static String urlcentromodi;
    public static String map;
    public static String ip = "192.168.1.37";




    public static TAPI serviceConInterceptors() {

        Interceptor interceptor = new Interceptor() {@Override
                                                     public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {

            Request newRequest = chain.request().newBuilder().build();

            return chain.proceed(newRequest);
        }

        };

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ip+":8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        TAPI service = retrofit.create(TAPI.class);

        return service;
    }


    public static TAPI serviceConInterceptorsOtro(final Context context) {

        Interceptor interceptor = new Interceptor() {@Override
                                                     public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {




            Request newRequest = chain.request().newBuilder().addHeader("Authorization", token)
                    .build();

            return chain.proceed(newRequest);
        }

        };

        // OkHttpClient es el encargado dde realizar las peticiones HTTP.
        OkHttpClient client = new OkHttpClient();

        // Al cliente se le añade el interceptor.
        client.interceptors().add(interceptor);

        // Cuando construimos Retrofit le decimos que el cliente sea el que acabamos de crea.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ip+":8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        TAPI service = retrofit.create(TAPI.class);

        return service;
    }




    public static TAPI serviceConInterceptors2() {

        Interceptor interceptor = new Interceptor() {@Override
                                                     public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {

            Log.i("TOKEN2",token);

            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", token)
                    .build();

            return chain.proceed(newRequest);

        }

        };

        OkHttpClient client = new OkHttpClient();

        client.interceptors().add(interceptor);

        //172.27.0.50
        //192.168.0.160
        //192.168.1.39

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ip+":8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        TAPI service = retrofit.create(TAPI.class);
        Log.i("Entra", "LLama al api");

        return service;
    }



    public static TAPI serviceConInterceptors3() {

        Interceptor interceptor = new Interceptor() {@Override
                                                     public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {

            Log.i("TOKEN2",token);

            Request newRequest = chain.request().newBuilder().addHeader("Authorization", token).addHeader("Content-Type", "application/json")
                    .build();

            return chain.proceed(newRequest);

        }

        };

        OkHttpClient client = new OkHttpClient();

        client.interceptors().add(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ip+":8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        TAPI service = retrofit.create(TAPI.class);
        Log.i("Entra", "LLama al api");

        return service;
    }



    public static String formatoFecha(String fecha){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");

        String fecha_formateada = "";

        try {
            Date date = f.parse(fecha);
            fecha_formateada = f1.format(date);
        } catch (ParseException e){
            e.printStackTrace();
        }

        return fecha_formateada;
    }


    public static boolean comprobarInternet(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        return !(i == null || !i.isConnected() || !i.isAvailable());

    }


}
