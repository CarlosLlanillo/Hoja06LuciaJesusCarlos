package grupoAD.appconcurso.modelos;

/**
 *
 * @author usuario
 */
public class Pregunta
{
    private int preguntaId;
    private String enunciado;
    private String categoria;
    //private int nivel;
    private String foto;
    private int vecesFormulada;
    private int vecesAcertada;

    public Pregunta()
    {
    }

    public Pregunta(int preguntaId, String enunciado, String categoria,
                    /*int nivel,*/ String foto,
                    int vecesFormulada, int vecesAcertada)
    {
        this.preguntaId = preguntaId;
        this.enunciado = enunciado;
        this.categoria = categoria;
        //this.nivel = nivel;
        this.foto = foto;
        this.vecesFormulada = vecesFormulada;
        this.vecesAcertada = vecesAcertada;
    }

    public int getPreguntaId()
    {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId)
    {
        this.preguntaId = preguntaId;
    }

    public String getEnunciado()
    {
        return enunciado;
    }

    public void setEnunciado(String enunciado)
    {
        this.enunciado = enunciado;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    /*public int getNivel()
    {
        return nivel;
    }

    public void setNivel(int nivel)
    {
        this.nivel = nivel;
    }*/
    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public int getVecesFormulada()
    {
        return vecesFormulada;
    }

    public void setVecesFormulada(int vecesFormulada)
    {
        this.vecesFormulada = vecesFormulada;
    }

    public int getVecesAcertada()
    {
        return vecesAcertada;
    }

    public void setVecesAcertada(int vecesAcertada)
    {
        this.vecesAcertada = vecesAcertada;
    }

}
