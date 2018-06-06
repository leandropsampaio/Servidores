package ServidorChat;

public class RodaCliente {

    public static void main(String[] args) {
        new Cliente("127.0.0.5", 12345).executa();
    }
}
