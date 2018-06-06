/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorUDP;

import java.io.*;
import java.net.*;
import java.util.Arrays;

/**
 *
 * @author Leandro Pereira Sampaio
 */
public class Remetente {

    public static void main(String[] args) {

        /*
        if (args.length != 3) {
            System.out.println("Uso correto: <Nome da maquina> <Porta> <Mensagem>");
            System.exit(0);
        }
         */
        try {
            //Primeiro argumento é o nome do host destino
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            int port = Integer.parseInt("1234");
            byte[] msg = "HELLO WORLD!!!!!!!!!!".getBytes();
            //Monta o pacote a ser enviado
            DatagramPacket pkg = new DatagramPacket(msg, msg.length, addr, port);
            // Cria o DatagramSocket que será responsável por enviar a mensagem
            DatagramSocket ds = new DatagramSocket();
            //Envia a mensagem
            ds.send(pkg);
            System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n"
                    + "Porta: " + port + "\n" + "Mensagem: " + new String(msg));

            //Fecha o DatagramSocket
            ds.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
