
package jogocerto.modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author jonathan
 */
public class Jogo 
{
    private int codConcurso;
    private int codnumero ;
    private Calendar dataConcurso;
    private ArrayList <Bola> bola = new ArrayList();

    public int getCodConcurso() {
        return codConcurso;
    }

    public void setCodConcurso(int codConcurso) {
        this.codConcurso = codConcurso;
    }

    public int getCodnumero() {
        return codnumero;
    }

    public void setCodnumero(int codnumero) {
        this.codnumero = codnumero;
    }

    public Calendar getDataConcurso() {
        return dataConcurso;
    }

    public void setDataConcurso(Calendar dataConcurso) {
        this.dataConcurso = dataConcurso;
    }

    public ArrayList <Bola> getBola() {
        return bola;
    }

    public void setBola(ArrayList <Bola> bola) {
        this.bola = bola;
    }
    
    
}
