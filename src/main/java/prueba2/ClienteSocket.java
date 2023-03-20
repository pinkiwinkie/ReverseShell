package prueba2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSocket {
    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1"; // Dirección IP del servidor
        int portNumber = 12345; // Puerto del servidor

        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            // Enviar mensaje al servidor
            out.println("Hola servidor!");

            // Leer respuesta del servidor
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo conectar a " + hostName);
            System.exit(1);
        }
    }
}