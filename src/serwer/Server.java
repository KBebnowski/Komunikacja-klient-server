package serwer;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(29090);

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Polaczyles sie z  serwerem");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = in.readLine();
                    if(msg.equals("Test"))
                        JOptionPane.showMessageDialog(null, "Klient wyslal test");
                    else
                        JOptionPane.showMessageDialog(null, "Klient wyslal cos innego niz test");
                } finally {
                    socket.close();
                }
            }
        } finally {
            serverSocket.close();
        }


    }
}