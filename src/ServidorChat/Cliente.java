package ServidorChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private String host;
    private int porta;

    public Cliente(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void executa() {
        try (Socket cliente = new Socket(host, porta);
                Scanner teclado = new Scanner(System.in);
                PrintStream saida = new PrintStream(cliente.getOutputStream())) {
            System.out.println("O cliente se conectou ao servidor!");

            RecebedorDeMensagemDoServidor r = new RecebedorDeMensagemDoServidor(cliente.getInputStream());
            new Thread(r).start();

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
