package mx.galaxcom.proyectosemana2c3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputNombre      = (EditText) findViewById(R.id.inputNombre);
        final EditText inputTelefono    = (EditText) findViewById(R.id.inputTelefono);
        final EditText inputEmail       = (EditText) findViewById(R.id.inputEmail);
        final EditText inputDescripcion = (EditText) findViewById(R.id.inputDescripcion);
        final TextView fecha            = (TextView) findViewById(R.id.txtFecha);
        Button botonSiguiente = (Button) findViewById(R.id.btnSiguiente);

        /*Intent miIntent = getIntent();
        final Contacto contacto = miIntent.getParcelableExtra("Contacto");

        inputNombre.setText(contacto.getNombre());
        fecha.setText(contacto.getFecha());
        inputTelefono.setText(contacto.getTelefono());
        inputEmail.setText(contacto.getEmail());
        inputDescripcion.setText(contacto.getDescripcion());*/

        botonSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Contacto miContacto = new Contacto (inputNombre.getText().toString(), fecha.getText().toString(), inputTelefono.getText().toString(),
                        inputEmail.getText().toString(), inputDescripcion.getText().toString());

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("Contacto", miContacto);
                startActivity(intent);
            }
        });

    }

    // Date picker
    public void showDatePickerDialog(View v) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "miPicker");
    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.txtFecha)).setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

}

