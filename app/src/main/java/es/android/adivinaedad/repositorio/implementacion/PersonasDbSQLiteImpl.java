package es.android.adivinaedad.repositorio.implementacion;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import es.android.adivinaedad.entidad.Persona;
import es.android.adivinaedad.repositorio.interfaz.PersonasDb;

public class PersonasDbSQLiteImpl extends SQLiteOpenHelper implements PersonasDb<Persona> {
    public PersonasDbSQLiteImpl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "Persona.db";

    public PersonasDbSQLiteImpl(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static class ContratoPersona{
        private ContratoPersona(){}
            public static class EntradaPersona implements BaseColumns{
                public static final String NOMBRE_TABLA = "edades";
                public static final String ID = "_id";
                public static final String NAME = "name";
                public static final String EDAD = "edad";
            }
        }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ContratoPersona.EntradaPersona.NOMBRE_TABLA + " (" +
                ContratoPersona.EntradaPersona.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ContratoPersona.EntradaPersona.NAME + " TEXT NOT NULL," +
                ContratoPersona.EntradaPersona.EDAD + " TEXT NOT NULL)");

        Persona p1 = new Persona(0, "Maria",23);
        this.save(p1, db);
        Persona p2 = new Persona(1, "Pedro",35);
        this.save(p2, db);
        Persona p3 = new Persona(2, "Luisa ",49);
        this.save(p3, db);
        Persona p4 = new Persona(3, "Jacobo",72);
        this.save(p4, db);
        Persona p5 = new Persona(4, "Lily ",19);
        this.save(p5, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public Optional<Persona> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Persona> getAll() {
        SQLiteDatabase db1 = getWritableDatabase();
        Persona p1 = new Persona(0 , "Maria",23);
        this.save(p1, db1);
        Persona p2 = new Persona(1, "Pedro",35);
        this.save(p2, db1);
        Persona p3 = new Persona(2, "Luisa ",49);
        this.save(p3, db1);
        Persona p4 = new Persona(3, "Jacobo",72);
        this.save(p4, db1);
        Persona p5 = new Persona(4, "Lily ",19);
        this.save(p5, db1);



        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                ContratoPersona.EntradaPersona.NOMBRE_TABLA, // Nombre de la tabla
                null, // Lista de Columnas a consultar
                null, // Columnas para la cláusula WHERE
                null, // Valores a comparar con las columnas del WHERE
                null, // Agrupar con GROUP BY
                null, // Condición HAVING para GROUP BY
                null // Cláusula ORDER BY
        );

        List<Persona> pokemons = new LinkedList<>();
        while(c.moveToNext()){
            @SuppressLint("Range")
            int id = c.getInt(
                    c.getColumnIndex(ContratoPersona.EntradaPersona.ID));
            @SuppressLint("Range")
            int edad = c.getInt(
                    c.getColumnIndex(ContratoPersona.EntradaPersona.EDAD));
            @SuppressLint("Range")
            String name = c.getString(
                    c.getColumnIndex(ContratoPersona.EntradaPersona.NAME));
            pokemons.add(new Persona(id, name, edad));
        }

        return pokemons;
    }

    @Override
    public void save(Persona persona) {
        this.save(persona, null);
    }

    private void save(Persona persona, SQLiteDatabase db) {
        if(db == null)
            db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ContratoPersona.EntradaPersona.ID, persona.getId());
        values.put(ContratoPersona.EntradaPersona.NAME, persona.getName());
        values.put(ContratoPersona.EntradaPersona.EDAD, persona.getEdad());
        db.insert(ContratoPersona.EntradaPersona.NOMBRE_TABLA, null, values);
    }
    @Override
    public void update(Persona persona) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ContratoPersona.EntradaPersona.ID, persona.getId());
        values.put(ContratoPersona.EntradaPersona.NAME, persona.getName());
        values.put(ContratoPersona.EntradaPersona.EDAD, persona.getEdad());

        db.update(ContratoPersona.EntradaPersona.NOMBRE_TABLA,
                values,
                "name=?",
                new String[] {persona.getName()});
    }


    @Override
    public void delete(Persona persona) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ContratoPersona.EntradaPersona.NOMBRE_TABLA,
                "name=?",
                new String[] {persona.getName()});
    }
}
