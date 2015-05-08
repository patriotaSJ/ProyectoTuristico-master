package com.ramiromadriaga.viewpagerlistviewactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 23/12/2014.
 */
public class ListarCircuito extends ActionBarActivity {

    int[] imagenCircuitoChico = {
            R.drawable.circuitochico_plaza,
            R.drawable.circuitochico_iglesiacatedral,
            R.drawable.circuitochico_casanatalsarmiento,
            R.drawable.circuitochico_celdahistoriasanmartin,
            R.drawable.circuitochico_parque,
            R.drawable.circuitochico_auditorio,
            R.drawable.circuitochico_cienciasnaturales,
            R.drawable.circuitochico_museograffigna
    };

    int[] imagenCircuitoLunar = {
            R.drawable.circuitolunar_caucete,
            R.drawable.circuitolunar_difunta,
            R.drawable.circuitolunar_vallefertil,
            R.drawable.circuitolunar_ischigualasto
    };

    int[] imagenRutaDelVino = {
            R.drawable.rutadelvino_bodegaslaguarda,
            R.drawable.rutadelvino_champaneramiguelmas,
            R.drawable.rutadelvino_bodegasyvinedosfabril,
            R.drawable.rutadelvino_lasmarianasbodegafamliar,
            R.drawable.rutadelvino_vinassegisa
    };

    int[] imagenCircuitoDelSol = {
            R.drawable.circuitodelsol_parquefaunistico,
            R.drawable.circuitodelsol_diquedeullum,
            R.drawable.circuitodelsol_quebradazonda,
            R.drawable.circuitodelsol_jardindelospoetas,
            R.drawable.circuitodelsol_autodromodezonda,
            R.drawable.circuitodelsol_cavasdezonda
    };

    int[] imagenCircuitoVerde = {
            R.drawable.circuitoverde_iglesia,
            R.drawable.circuitoverde_pismanta,
            R.drawable.circuitoverde_rodeo,
            R.drawable.circuitoverde_tudcum,
            R.drawable.circuitoverde_cuestadelviento,
            R.drawable.circuitoverde_jachal,
            R.drawable.circuitoverde_huaco
    };

    int[] imagenCircuitoDelRio = {
            R.drawable.circuitodelrio_calingasta,
            R.drawable.circuitodelrio_barreal,
            R.drawable.circuitodelrio_pampa,
            R.drawable.circuitodelrio_obsevatorio
    };

    String[] titulo;
    String[] contenido;

    private ListView lista;
    ListViewAdapter adapter;

    int currentViewPager;
    String nombreCircuito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_circuito);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);  //ir atras

        Bundle extras = getIntent().getExtras();
        currentViewPager = extras.getInt("currentViewPager");
        nombreCircuito = extras.getString("nombreCircuito");
        Log.i("ramiro", "currentViewPager: " + currentViewPager);


        /**INDICAR TITULO **/
        actionBar.setTitle(nombreCircuito);

        lista = (ListView) findViewById(R.id.listView_listarCircuito);
        switch (currentViewPager){
            case 0: //circuito chico
                titulo = getResources().getStringArray(R.array.circuitochico_titulo);
                contenido = getResources().getStringArray(R.array.circuitochico_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoChico, titulo, contenido);
                break;
            case 1: //circuito lunar
                titulo = getResources().getStringArray(R.array.circuitolunar_titulo);
                contenido = getResources().getStringArray(R.array.circuitolunar_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoLunar, titulo, contenido);
                break;

            case 2: //ruta del vino
                titulo = getResources().getStringArray(R.array.rutadelvino_titulo);
                contenido = getResources().getStringArray(R.array.rutadelvino_contenido);
                adapter = new ListViewAdapter(this, imagenRutaDelVino, titulo, contenido);
                break;

            case 3: //circuito del sol
                titulo = getResources().getStringArray(R.array.circuitodelsol_titulo);
                contenido = getResources().getStringArray(R.array.circuitodelsol_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoDelSol, titulo, contenido);
                break;

            case 4: //circuito verde
                titulo = getResources().getStringArray(R.array.circuitoverde_titulo);
                contenido = getResources().getStringArray(R.array.circuitoverde_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoVerde, titulo, contenido);
                break;

            case 5: //circuito del río
                titulo = getResources().getStringArray(R.array.circuitodelrio_titulo);
                contenido = getResources().getStringArray(R.array.circuitodelrio_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoDelRio, titulo, contenido);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ListarUnCircuito.class);
                i.putExtra("idcircuito",currentViewPager);
                i.putExtra("position", position);
                i.putExtra("nombreCircuito", nombreCircuito);
                i.putExtra("nombreSubCircuito", titulo[position]);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


            }
        });
    }


    /******************* LISTVIEW ADAPTER **************************/

    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
            this.contenido = contenido;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            ImageView imgImg;
            TextView txtTitle;
            TextView txtContenido;

            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.single_post_circuito, parent, false);

            // Locate the TextViews in listview_item.xml
            imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post_circuito);
            txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post_circuito);
            txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post_circuito);

            // Capture position and set to the TextViews
            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);
            txtContenido.setText(contenido[position]);

            return itemView;
        }
    }
}
