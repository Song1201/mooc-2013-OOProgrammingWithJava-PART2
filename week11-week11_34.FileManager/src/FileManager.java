
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

  public List<String> read(String fileName) throws FileNotFoundException {
    ArrayList<String> content = new ArrayList<String>();
    File file = new File(fileName);
    Scanner reader = new Scanner(file);
    while(reader.hasNextLine()) content.add(reader.nextLine());
    return content;
  }

  public void save(String fileName, String text) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    writer.write(text);
    writer.close();
  }

  public void save(String fileName, List<String> texts) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    for(String line:texts) writer.write(line+"\n");
    writer.close();
  }
}
