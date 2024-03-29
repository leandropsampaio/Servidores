package ServidorTCP;

import java.net.*;
import java.io.*;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Cliente {

    public static void main(String[] args) {
        System.out.println("------------- CLIENTE --------------");
        try {
            Socket cliente = new Socket("127.0.0.1", 12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
