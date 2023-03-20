package prueba4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(12348);

        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String comando;
//hay que hacer tryCatch porque si escribes mal el comando te salta:
//    Exception in thread "main" java.io.IOException:
//    Cannot run program "genome-t": error=2, No existe el fichero o el directorio
            String linea ;
            do {
                System.out.print("Comando: ");
                comando = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println(comando);
                linea = in.readLine();
                System.out.println(linea);
            } while (true);
//            socket.close();
        }
    }
}