package es.android.adivinaedad.servicio.implementacion;

import android.content.Context;

import java.util.List;

import es.android.adivinaedad.SevicioPersona;
import es.android.adivinaedad.entidad.Persona;
import es.android.adivinaedad.repositorio.implementacion.PersonasDbSQLiteImpl;
import es.android.adivinaedad.repositorio.interfaz.PersonasDb;

public class ServicioPersonaSQLiteImpl implements SevicioPersona {

    private PersonasDb<Persona> personadb;
    private List<Persona> todasLasPersonas;
    public ServicioPersonaSQLiteImpl(Context context){
        personadb = new PersonasDbSQLiteImpl(context);
    }

    @Override
    public List<Persona> generarPersona(String recurso) throws Exception {
        todasLasPersonas = personadb.getAll();
        return todasLasPersonas;
    }
}
