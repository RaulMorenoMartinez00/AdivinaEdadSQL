package es.android.adivinaedad.entidad;

public class Persona {
    private String name;
    private int edad;

    public Persona(String name, int edad){

        this.name=name;
        this.edad=edad;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String edadToString() {
        return "" + edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                '}';
    }
}
