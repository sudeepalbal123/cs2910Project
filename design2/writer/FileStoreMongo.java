import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.io.*;
import com.mongodb.DBCursor;
import java.util.concurrent.TimeUnit;

public class FileStoreMongo {

   public static void main( String args[] ) throws IOException{
      // Creating a Mongo client
      MongoClient mongo = new MongoClient("172.17.0.2", 27017 );
      File myFile = new File("/root/"+args[0]);

      // Creating Credentials
      MongoCredential credential;
      credential = MongoCredential.createCredential("sampleUser", "myDb",
         "password".toCharArray());
      System.out.println("Connected to the database successfully");

      //Accessing the database
      DB database = mongo.getDB("myDb");
      long StartTime = System.nanoTime();
      saveToDb(database, myFile, args[0]);
      long EndTime = System.nanoTime();

      long duration = TimeUnit.NANOSECONDS.toMillis(EndTime - StartTime);

      System.out.println(duration);
   }

   private static void saveToDb(DB db, File f, String name) throws IOException{
      String dbFilename = name.substring(0, name.length()-4);
      GridFS gridFS = new GridFS(db);
      GridFSInputFile gridFSInputFile = gridFS.createFile(f);
      gridFSInputFile.setFilename(dbFilename);
      gridFSInputFile.save();
   }
}
