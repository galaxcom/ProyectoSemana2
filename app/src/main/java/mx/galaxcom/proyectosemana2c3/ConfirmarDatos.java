package mx.galaxcom.proyectosemana2c3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        TextView nombre = (TextView) findViewById(R.id.txtVNombre);
        TextView fecha = (TextView) findViewById(R.id.txtVFechaA2);
        TextView telefono = (TextView) findViewById(R.id.txtVTel);
        TextView email = (TextView) findViewById(R.id.txtVEmail);
        TextView descripcion = (TextView) findViewById(R.id.txtVDescripcion);

        Intent miIntent = getIntent();
        final Contacto contacto = miIntent.getParcelableExtra("Contacto");

        nombre.setText(contacto.getNombre());
        fecha.setText(contacto.getFecha());
        telefono.setText(contacto.getTelefono());
        email.setText(contacto.getEmail());
        descripcion.setText(contacto.getDescripcion());

        Button botonEditar = (Button) findViewById(R.id.btnEditar);

        botonEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent elIntent = new Intent(ConfirmarDatos.this, MainActivity.class);
                //startActivity(elIntent);
                onBackPressed();
            }
        });

    }
}
