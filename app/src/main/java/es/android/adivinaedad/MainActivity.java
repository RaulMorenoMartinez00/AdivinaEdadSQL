package es.android.adivinaedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import es.android.adivinaedad.entidad.Persona;
import es.android.adivinaedad.repositorio.implementacion.PersonasDbSQLiteImpl;
import es.android.adivinaedad.servicio.implementacion.ServicioPersonaSQLiteImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView edadText;
    private EditText tv;
    List<Persona> personas;
    ServicioPersonaSQLiteImpl servicio;
    PersonasDbSQLiteImpl personadb;
    ArrayList<String> name, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edadText = findViewById(R.id.edad);
        tv = findViewById(R.id.nombre);

        findViewById(R.id.consultarEdad).setOnClickListener(view -> {
            mostrarEdad();
        });
    }

    private void mostrarEdad() {

                try {
                    for (Persona:personas)
                    {
                        if ()
                        {
                            int edad = ;
                            edadText.setText(Integer.toString(edad));
                        } else {
                            edadText.setText("Ha ocurrido un error");
                            return;
                        }
                    }
                }
                catch(Exception e) {
                    edadText.setText("No es un nombre Valido");
                }
            }
        };
