package com.ramiromadriaga.viewpagerlistviewactivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListarUnCircuito extends ActionBarActivity {

    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido;
    String[] titulo;
    String[] contenido;

    private int[] imagenCircuitoChico = {
            R.drawable.circuitochico_plaza,
            R.drawable.circuitochico_iglesiacatedral,
            R.drawable.circuitochico_casanatalsarmiento,
            R.drawable.circuitochico_celdahistoriasanmartin,
            R.drawable.circuitochico_parque,
            R.drawable.circuitochico_auditorio,
            R.drawable.circuitochico_cienciasnaturales,
            R.drawable.circuitochico_museograffigna
    };

    private int[] imagenCircuitoLunar = {
            R.drawable.circuitolunar_caucete,
            R.drawable.circuitolunar_difunta,
            R.drawable.circuitolunar_vallefertil,
            R.drawable.circuitolunar_ischigualasto
    };

    private int[] imagenRutaDelVino = {
            R.drawable.rutadelvino_bodegaslaguarda,
            R.drawable.rutadelvino_champaneramiguelmas,
            R.drawable.rutadelvino_bodegasyvinedosfabril,
            R.drawable.rutadelvino_lasmarianasbodegafamliar,
            R.drawable.rutadelvino_vinassegisa
    };

    private int[] imagenCircuitoDelSol = {
            R.drawable.circuitodelsol_parquefaunistico,
            R.drawable.circuitodelsol_diquedeullum,
            R.drawable.circuitodelsol_quebradazonda,
            R.drawable.circuitodelsol_jardindelospoetas,
            R.drawable.circuitodelsol_autodromodezonda,
            R.drawable.circuitodelsol_cavasdezonda
    };

    private int[] imagenCircuitoVerde = {
            R.drawable.circuitoverde_iglesia,
            R.drawable.circuitoverde_pismanta,
            R.drawable.circuitoverde_rodeo,
            R.drawable.circuitoverde_tudcum,
            R.drawable.circuitoverde_cuestadelviento,
            R.drawable.circuitoverde_jachal,
            R.drawable.circuitoverde_huaco
    };

    private int[] imagenCircuitoDelRio = {
            R.drawable.circuitodelrio_calingasta,
            R.drawable.circuitodelrio_barreal,
            R.drawable.circuitodelrio_pampa,
            R.drawable.circuitodelrio_obsevatorio
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_un_circuito);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        int idcircuito = extras.getInt("idcircuito");
        final int position = extras.getInt("position");
        String nombreCircuito = extras.getString("nombreCircuito");
        String nombreSubCircuito = extras.getString("nombreSubCircuito");

        //Log.i("ramiro", "listar un circuito idcircuito" + idcircuito);
        //Log.i("ramiro", "listar un circuito position " + position);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle(nombreCircuito);
        actionBar.setSubtitle(nombreSubCircuito);

        txtTitulo = (TextView) findViewById(R.id.tv_titulo_listaruncircuito);
        txtContenido = (TextView) findViewById(R.id.tv_contenido_listaruncircuito);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen_listaruncircuito);

        switch (idcircuito){
            case 0: //circuito chico
                titulo = getResources().getStringArray(R.array.circuitochico_titulo);
                contenido = getResources().getStringArray(R.array.circuitochico_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoChico[position]);
                break;
            case 1: //circuito lunar
                titulo = getResources().getStringArray(R.array.circuitolunar_titulo);
                contenido = getResources().getStringArray(R.array.circuitolunar_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoLunar[position]);
                break;

            case 2: //ruta del vino
                titulo = getResources().getStringArray(R.array.rutadelvino_titulo);
                contenido = getResources().getStringArray(R.array.rutadelvino_contenido_completo);
                imgImagen.setImageResource(imagenRutaDelVino[position]);
                break;

            case 3: //circuito del sol
                titulo = getResources().getStringArray(R.array.circuitodelsol_titulo);
                contenido = getResources().getStringArray(R.array.circuitodelsol_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoDelSol[position]);
                break;

            case 4: //circuito verde
                titulo = getResources().getStringArray(R.array.circuitoverde_titulo);
                contenido = getResources().getStringArray(R.array.circuitoverde_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoVerde[position]);
                break;

            case 5: //circuito del río
                titulo = getResources().getStringArray(R.array.circuitodelrio_titulo);
                contenido = getResources().getStringArray(R.array.circuitodelrio_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoDelRio[position]);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);
    }
}
