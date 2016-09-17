package leunam.sparelajarte.activitys;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import leunam.sparelajarte.R;
import leunam.sparelajarte.Utils;
import leunam.sparelajarte.fragments.CentroFragment;
import leunam.sparelajarte.fragments.PerfilFragment;
import leunam.sparelajarte.fragments.ReservaFragment;
import leunam.sparelajarte.models.Reserva.Reserva;
import leunam.sparelajarte.models.Reserva.Result;
import leunam.sparelajarte.models.Usuario;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class NavegationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout contenedor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(getResources().getDrawable(R.drawable.actlogo));
        contenedor = (FrameLayout)findViewById(R.id.contenedor);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_centros);
            transicionPagina(new CentroFragment());


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (Utils.comprobarInternet(NavegationActivity.this)) {

            if (id == R.id.nav_centros) {
                f = new CentroFragment();
            } else if (id == R.id.nav_reservas) {
                f = new ReservaFragment();
            } else if (id == R.id.nav_perfil) {
                f = new PerfilFragment();
            } else if (id == R.id.nav_salir) {

                Call<Usuario> userCall = Utils.serviceConInterceptors2().usuariodes();

                userCall.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Response<Usuario> response, Retrofit retrofit) {


                      int  errorCode = response.code();


                        Log.i("ERROR", String.valueOf(errorCode));

                        if (errorCode == 200) {

                            Toast.makeText(NavegationActivity.this.getApplication(), "Deslogueado correctamente", Toast.LENGTH_LONG).show();


                        }

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });


                Intent i = new Intent(NavegationActivity.this, MainActivity.class);
                startActivity(i);
            }
            if (f != null) {
                transicionPagina(f);
            }
        }else {
            Toast.makeText(NavegationActivity.this, "Debe conectarse a alguna red", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void transicionPagina(Fragment f) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor,f).commit();
    }






}
