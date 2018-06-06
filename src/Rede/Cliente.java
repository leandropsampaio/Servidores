package Rede;

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
                PrintStream saida = new PrintStream(cliente.getOutputStream())) {
            System.out.println("O cliente se conectou ao servidor!");

            TratadorDeMensagemDoServidor r = new TratadorDeMensagemDoServidor(cliente);
            new Thread(r).start(); //Cria uma nova Thread e inicia para cada cliente conectado no sistema.

            while (true) {

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
