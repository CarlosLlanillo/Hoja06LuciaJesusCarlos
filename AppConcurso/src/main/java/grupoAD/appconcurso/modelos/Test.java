package grupoAD.appconcurso.modelos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author usuario
 */
public class Test
{
    private int testId;
    private int usuarioId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int general;
    private int preguntas;
    private String categoria;
    private float punto;

    public Test()
    {
    }

    public Test(int testId, int usuarioId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                int general, int preguntas, String categoria, float punto)
    {
        this.testId = testId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.general = general;
        this.preguntas = preguntas;
        this.categoria = categoria;
        this.punto = punto;
    }

    public int getTestId()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId = testId;
    }

    public int getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFecha()
    {
        return fecha;
    }

    public void setFecha(LocalDate fecha)
    {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin()
    {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin)
    {
        this.horaFin = horaFin;
    }

    public int getGeneral()
    {
        return general;
    }

    public void setGeneral(int general)
    {
        this.general = general;
    }

    public int getPreguntas()
    {
        return preguntas;
    }

    public void setPreguntas(int preguntas)
    {
        this.preguntas = preguntas;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public float getPunto()
    {
        return punto;
    }

    public void setPunto(float punto)
    {
        this.punto = punto;
    }

}
