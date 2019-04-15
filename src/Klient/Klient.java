package Klient;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klient {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 29090);
        PrintWriter pr = new PrintWriter((s.getOutputStream()));
        pr.println("hello");
        pr.flush();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg = in.readLine();
        JOptionPane.showMessageDialog(null, msg);
        System.exit(0);
    }
}