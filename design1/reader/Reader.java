import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    private Socket socket = null;
    private ServerSocket server = null;
    private BufferedReader reader = null;
    private FileWriter fileWriter;
    private File file;
    private HashMap<Character,Integer> map;

    public Reader(int port){
        try {

            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for connection request");

            socket = server.accept();
            System.out.println("Connection Established");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //reader = new BufferedReader(new FileReader("out.txt"));

            file = new File("output.txt");

            fileWriter = new FileWriter(file);
            String line;

            while(!(line = reader.readLine()).equals("$")){
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
            socket.close();
            reader.close();

            System.out.println("Program finished");

        }
        catch (IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[]){
        Reader reader = new Reader(5000);
    }

}

