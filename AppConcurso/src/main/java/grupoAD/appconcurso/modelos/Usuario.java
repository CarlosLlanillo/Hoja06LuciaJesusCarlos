package grupoAD.appconcurso.modelos;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class Usuario
{
    private int usuarioId;
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private LocalDate nacimiento;
    private int accesos;
    private int testRealizados;
    private float puntuacionMedia;

    public Usuario()
    {
    }

    public Usuario(int usuarioId, String usuario, String password, String nombre, String apellidos,
                   LocalDate nacimiento, int accesos, int testRealizados, float puntuacionMedia)
    {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.accesos = accesos;
        this.testRealizados = testRealizados;
        this.puntuacionMedia = puntuacionMedia;
    }

    public int getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public LocalDate getNacimiento()
    {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento)
    {
        this.nacimiento = nacimiento;
    }

    public int getAccesos()
    {
        return accesos;
    }

    public void setAccesos(int accesos)
    {
        this.accesos = accesos;
    }

    public int getTestRealizados()
    {
        return testRealizados;
    }

    public void setTestRealizados(int testRealizados)
    {
        this.testRealizados = testRealizados;
    }

    public float getPuntuacionMedia()
    {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(float puntuacionMedia)
    {
        this.puntuacionMedia = puntuacionMedia;
    }

}
