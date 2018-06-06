package Rede;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class TratadorDeMensagemDoServidor implements Runnable {

    private Socket servidor;

    public TratadorDeMensagemDoServidor(Socket servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (Scanner s = new Scanner(servidor.getInputStream())) {

            PrintStream saida = new PrintStream(servidor.getOutputStream()); //Enviar Mensagem para o servidor

            while (s.hasNextLine()) { // Receber Mensagem
                // Recebe a lista de salas ou recebe a lista de Sockets
                System.out.println("SERVIDOR!!");
                System.out.println(s.nextLine());
                saida.println("Recebi!"); // Enviar Mensagem
                if (true) { // Se receber a lista de sockets
                    new Servidor(12345).executa();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TratadorDeMensagemDoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
