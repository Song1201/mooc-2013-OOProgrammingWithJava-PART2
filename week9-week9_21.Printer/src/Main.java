
public class Main {

  public static void main(String[] args) throws Exception {
    Printer printer = new Printer("src/textfile.txt");
    //printer.printLinesWhichContain("Siinä");
    printer.printLinesWhichContain("vanha");
  }
}
