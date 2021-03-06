package es.android.adivinaedad;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import es.android.adivinaedad.entidad.Persona;
import es.android.adivinaedad.repositorio.implementacion.PersonasDbSQLiteImpl;

public class MainActivity extends AppCompatActivity {

    private TextView edadText;
    private EditText tv;
    PersonasDbSQLiteImpl personadb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        personadb= new PersonasDbSQLiteImpl((getApplicationContext()));
        edadText = findViewById(R.id.edad);
        tv = findViewById(R.id.nombre);

        findViewById(R.id.consultarEdad).setOnClickListener(view -> {
            mostrarEdad();
        });
    }

    private void mostrarEdad() {

                try {
                    List<Persona> personas= personadb.getAll();
                    int i=0;
                    while (!tv.getText().toString().equals(personas.get(i).getName()))
                    {
                        i++;
                    }
                    edadText.setText((personas.get(i).edadToString()));
                }
                catch(Exception e) {
                    edadText.setText("No es un valido");
                }
            }
                                /*
                                Otra opcion para el metodo MostrarEdad pero usando un bucle Foreach
                           try {
                    List<Persona> personas= personadb.getAll();
                    for(Persona persona:personas){
                        if (tv.getText().toString().equals(persona.getName()))
                        {
                            edadText.setText(persona.edadToString());
                            break;
                        }
                        else
                        {
                            edadText.setText(persona.getName());
                        }
                    }
                    catch(Exception e) {
                    edadText.setText("No es un valido");
                }

                     */
        }
