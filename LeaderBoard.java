import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;



// This is an example of how to save and restore
// state to a file via serialization
public class LeaderBoard implements Serializable {
  public HashMap<String, Integer> scores;
  //private static final String fileName = "State.ser";
  
  
  
  public String toString () {
  return scores.toString();
  }
  
  
  
  // Save non-transient state to a local file
  // If "name" is "marc", then the local file we'll save the
  // state to will be called "marcState.ser"
  public boolean save () {
  
    String fileName = "State.ser";
    
    try {
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(this);
    oos.close();
    fos.close();
    return true;
    } catch (IOException e) {
    System.err.println(e);
    return false;
    }
    }
    
  
  
  // Returns a State class from serialized state stored in the
  // file name + "State.ser", or null if unable to deserialize
  public static LeaderBoard restore () {
    String fileName = "State.ser";
    
    try {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      LeaderBoard s = (LeaderBoard) ois.readObject();
      ois.close();
      fis.close();
      return s;
    } catch(Exception e) { // IOException, ClassNotFoundException
      return null;
      }
    }
  }