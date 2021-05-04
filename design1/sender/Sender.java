import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Sender {
    private Socket socket = null;

    public Sender(String ip,int port) throws IOException {

        try{
            socket = new Socket(ip,port);
            System.out.println("Connection Established");
        }
        catch (IOException e){
            System.out.println(e);
        }

        BufferedReader reader = new BufferedReader(new FileReader("filename.txt"));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

        String line;

        long StartTime = System.nanoTime();
        while((line = reader.readLine())!= null){
            writer.println(line);
        }

        writer.println("$");
        reader.close();
        writer.close();
        socket.close();

        long EndTime = System.nanoTime();

        long duration = TimeUnit.NANOSECONDS.toMillis(EndTime - StartTime);

        System.out.println(duration);

    }

    public static void main(String args[]) throws IOException {
        Sender sender = new Sender("reader",5000);
    }
}

