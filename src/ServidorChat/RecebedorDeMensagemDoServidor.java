package ServidorChat;

import java.io.InputStream;
import java.util.Scanner;

class RecebedorDeMensagemDoServidor implements Runnable {

    private InputStream servidor;

    public RecebedorDeMensagemDoServidor(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (Scanner s = new Scanner(this.servidor)) {
            while (s.hasNextLine()) {
                System.out.println("SERVIDOR!!");
                System.out.println(s.nextLine());
            }
        }
    }
}
