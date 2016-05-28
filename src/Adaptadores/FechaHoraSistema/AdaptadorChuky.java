/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/


package Adaptadores.FechaHoraSistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdaptadorChuky implements FechaHoraSistema {

    @Override
    public String getFechaHora() {
        final String host = "localhost";
        final int portNumber = 8666;
        System.out.println("Creating socket to '" + host + "' on port " + portNumber);
        String userInput="";
        while (true) {
            try {
                Socket socket = new Socket(host, portNumber);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                System.out.println("server says:" + br.readLine());
                
                BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
                userInput = userInputBR.readLine();
                
                out.println(userInput);
                
                System.out.println("server says:" + br.readLine());
                
                if ("exit".equalsIgnoreCase(userInput)) {
                    socket.close();
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(AdaptadorChuky.class.getName()).log(Level.SEVERE, null, ex);
            }
	}return userInput;
    }
  
}
