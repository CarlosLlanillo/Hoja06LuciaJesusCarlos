package grupoAD.appconcurso.modelos;

/**
 *
 * @author usuario
 */
public class Respuesta
{
    private int respuestaId;
    private String texto;
    private boolean correcta;
    private String foto;
    private int vecesRespondida;

    public Respuesta()
    {
    }

    public Respuesta(int respuestaId, String texto, boolean correcta, String foto,
                     int vecesRespondida)
    {
        this.respuestaId = respuestaId;
        this.texto = texto;
        this.correcta = correcta;
        this.foto = foto;
        this.vecesRespondida = vecesRespondida;
    }

    public int getRespuestaId()
    {
        return respuestaId;
    }

    public void setRespuestaId(int respuestaId)
    {
        this.respuestaId = respuestaId;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public boolean isCorrecta()
    {
        return correcta;
    }

    public void setCorrecta(boolean correcta)
    {
        this.correcta = correcta;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public int getVecesRespondida()
    {
        return vecesRespondida;
    }

    public void setVecesRespondida(int vecesRespondida)
    {
        this.vecesRespondida = vecesRespondida;
    }
}
