package grupoAD.appconcurso.modelos;

/**
 *
 * @author usuario
 */
public class PreguntaFormulada
{
    private int preguntaFormuladaId;
    private int testId;
    private int preguntaId;
    private boolean acertada;
    private float puntos;

    public PreguntaFormulada()
    {
    }

    public PreguntaFormulada(int preguntaFormuladaId, int testId, int preguntaId, boolean acertada,
                             float puntos)
    {
        this.preguntaFormuladaId = preguntaFormuladaId;
        this.testId = testId;
        this.preguntaId = preguntaId;
        this.acertada = acertada;
        this.puntos = puntos;
    }

    public int getPreguntaFormuladaId()
    {
        return preguntaFormuladaId;
    }

    public void setPreguntaFormuladaId(int preguntaFormuladaId)
    {
        this.preguntaFormuladaId = preguntaFormuladaId;
    }

    public int getTestId()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId = testId;
    }

    public int getPreguntaId()
    {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId)
    {
        this.preguntaId = preguntaId;
    }

    public boolean isAcertada()
    {
        return acertada;
    }

    public void setAcertada(boolean acertada)
    {
        this.acertada = acertada;
    }

    public float getPuntos()
    {
        return puntos;
    }

    public void setPuntos(float puntos)
    {
        this.puntos = puntos;
    }

}
