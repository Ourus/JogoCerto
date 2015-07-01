package jogocerto.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class ConectarBanco {

    String driver = "com.mysql.jdbc.Driver";
    String caminho = "jdbc:mysql://localhost:3306/jogoCerto";
    String usuario = "admin";
    String senha = "admin";
    Connection con;
    Statement stm;
    
   
    
  
    
    String caminhoM = System.getProperty("user.home") + "////" + "banco.txt";

    
    public void conectarBanco() {
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void conectarBanco(String caminhoC, String usuarioC, String senhaC) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + caminhoC + ":3306/feira_de_curso", usuarioC, senhaC);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void desconetarBanco() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void criarBase() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", usuario, senha);

            System.out.println("Conexao criada " + con);

            String sql = "create database if not exists jogoCerto;";
            //String sql2 = " CREATE USER 'aluno'@'%' IDENTIFIED BY 'aluno';";
           //String sql3 = "GRANT ALL PRIVILEGES ON feira_de_curso. * TO 'aluno'@'%';";
          // String sql4="FLUSH PRIVILEGES;";

            stm = con.createStatement();

            stm.execute(sql);
          //  stm.execute(sql2);
           // stm.execute(sql3);
            //  stm.execute(sql4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            desconetarBanco();
        }
    }

    public void criarTabelas() {
        
          if(System.getProperty("os.name").toLowerCase().equals("linux"))
    {
        this.caminhoM = System.getProperty("user.home") + "/" + "banco.txt";
        
    }
        
        
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);

            System.out.println("Conexao criada " + con);

            String sql = "create table if not exists concurso\n"
                    + "(\n"
                    + "    codConcurso int not null auto_increment,\n"
                    + "    numero int not null,\n"
                    + "    dataConcurso date not null, \n"
                    + "    primary key (codCurso)\n"
                    + ");";

            String sql2 = "create table if not exists numeros \n"
                    + "(\n"
                    + "    codNumero int not null auto_increment,\n"
                    + "    codConcurso int not null,\n"
                    + "    numero int,\n"
                    + "    primary key (codNumero),\n"
                    + "    foreign key (codConcurso) references concurso (codConcurso) on delete cascade\n"
                    + ");";
            String sql3 = "load data local infile '" + caminhoM + "' into table jogoCerto.concurso;";
            String sql4 = "load data local infile '" + caminhoM + "' into table jogoCerto.numeros;";
            
            stm = con.createStatement();

            stm.execute(sql);
            stm.execute(sql2);
            stm.executeUpdate(sql3);
            stm.executeUpdate(sql4);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            desconetarBanco();
        }
    }

}
