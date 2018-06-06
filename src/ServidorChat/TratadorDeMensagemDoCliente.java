package ServidorChat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class TratadorDeMensagemDoCliente implements Runnable {

    private Socket cliente;
    private Servidor servidor;

    public TratadorDeMensagemDoCliente(Socket cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (Scanner s = new Scanner(this.cliente.getInputStream())) {
            while (s.hasNextLine()) {
                System.out.println("CLIENTE!!!");
                servidor.distribuiMensagem(this.cliente, s.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
