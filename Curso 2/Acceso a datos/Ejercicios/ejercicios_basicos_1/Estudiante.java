package ejercicios_basicos_1;

import java.time.LocalDate;
import utilidades.FormattedIO;

public class Estudiante {
    private String m_Nia;
    private String m_Nombre;
    private LocalDate m_FechaNacimiento;
    private double m_Nota;

    private static double validarNota() {
        double nota = 0.0;
        while (nota <= 0.0 || nota > 10.0) {
            nota = Double.parseDouble(FormattedIO.leerCadena("Introduce la media por favor, entre 0 y 10: "));
        }

        return nota;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((m_Nia == null) ? 0 : m_Nia.hashCode());
        result = prime * result + ((m_Nombre == null) ? 0 : m_Nombre.hashCode());
        result = prime * result + ((m_FechaNacimiento == null) ? 0 : m_FechaNacimiento.hashCode());
        long temp;
        temp = Double.doubleToLongBits(m_Nota);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (m_Nia == null) {
            if (other.m_Nia != null)
                return false;
        } 
        else if (!m_Nia.equals(other.m_Nia))
            return false;

        if (m_Nombre == null) {
            if (other.m_Nombre != null)
                return false;
        } 
        else if (!m_Nombre.equals(other.m_Nombre))
            return false;

        if (m_FechaNacimiento == null) {
            if (other.m_FechaNacimiento != null)
                return false;
        } 
        else if (!m_FechaNacimiento.equals(other.m_FechaNacimiento))
            return false;

        if (Double.doubleToLongBits(m_Nota) != Double.doubleToLongBits(other.m_Nota))
            return false;

        return true;
    }

    public int compareTo(Estudiante other) {
        return m_Nia.compareTo(other.getNia());
    }

    private static LocalDate validarFechaNacimiento() {
        LocalDate fecha = null;
        boolean fechaValida = false;

        while (!fechaValida) {
            String[] input = FormattedIO.leerCadena("Introduce la fecha de nacimiento. Formato: DD/MM/YYYY (e.g. 12 5 2017): ").split(" ");
            
            if (input.length != 3) {
                continue;
            }
            else {
                fecha = LocalDate.of(Integer.parseInt(input[2]), Integer.parseInt(input[1]), Integer.parseInt(input[0]));
                fechaValida = true;
            }
        }
        
        return fecha;
    }

    public Estudiante() {

    }

    public Estudiante(String nia, String nombre, LocalDate fechaNacimiento, double nota) {
        this.m_Nia = nia;
        this.m_Nombre = nombre;
        setFechaNacimiento(fechaNacimiento);
        setNota(nota);
    }

    public String getNia() {
        return m_Nia;
    }
    
    public void setNia(String nia) {
        this.m_Nia = nia;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public void setNombre(String nombre) {
        this.m_Nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return m_FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (!fechaNacimiento.isAfter(LocalDate.now()))
            this.m_FechaNacimiento = fechaNacimiento;
    }

    public double getNota() {
        return m_Nota;
    }

    public void setNota(double nota) {
        if (nota > 0.0 && nota <= 10.0)
            this.m_Nota = nota;
    }

    public void leer() {
        m_Nia = FormattedIO.leerCadena("Introduce el NIA del estudiante: ");
        m_Nombre = FormattedIO.leerCadena("Introduce el nombre completo del estudiante: ");
        
        m_Nota = validarNota();
        m_FechaNacimiento = validarFechaNacimiento();
    }

    @Override
    public String toString() {
        return String.format("NIA: %s\nNombre: %s\nNota: %.1f\nFechanacimiento: %s",
                            m_Nia, m_Nombre, m_Nota, m_FechaNacimiento.toString());
    }

    public void mostrar() {
        System.out.println(this);
        System.out.println("-----------------------");
    }
}