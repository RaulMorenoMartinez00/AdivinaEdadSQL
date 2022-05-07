package es.android.adivinaedad;

import android.text.Editable;

import java.util.List;

import es.android.adivinaedad.entidad.Persona;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SevicioPersona {

    List<Persona> generarPersona(String recurso) throws Exception;
}
