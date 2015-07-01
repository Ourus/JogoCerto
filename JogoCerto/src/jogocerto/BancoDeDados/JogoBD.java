package jogocerto.BancoDeDados;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import jogocerto.modelo.*;

/**
 *
 * @author jonathan
 */
public class JogoBD extends ConectarBanco {

    public void cadastroConcurso(Jogo jogo, ArrayList<Bola> bola) 
    {
        int key = jogo.getCodConcurso();
        try
        {
            conectarBanco();
            String sql="insert into concurso(numero,dataConcurso)values (?,?)";
            PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, jogo.getCodnumero());
            
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
        desconetarBanco();
        }

    }

    public void casdastrarBola(Bola bola, int jogo) {
        try {
            conectarBanco();
            String sql = "insert into numeros(codConcurso,numero) values (?,?);";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, jogo);
            stm.setInt(2, bola.getNumero());

            stm.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
        }
    }

}
