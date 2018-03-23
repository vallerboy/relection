import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<JavaObserver> javaObservers = new ArrayList<>();

    public static void main(String[] args) {
        try {
            for (Class aClass : getClasses(Main.class.getClassLoader(), "")) {
                if(aClass.isAnnotationPresent(JavaUser.class)){
                    javaObservers.add((JavaObserver) aClass.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        String answer;
        do{
            System.out.print("Komunikat: ");
            answer = scanner.nextLine();
            wakeUpObservers(answer);
        }while (!answer.equals("exit"));
    }

    public static void wakeUpObservers(String msg) {
        for (JavaObserver javaObserver : javaObservers) {
            javaObserver.onMessage(msg);
         }
    }

    public static List<Class> getClasses(ClassLoader cl, String pack) throws Exception{

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource("");

        DataInputStream dis = new DataInputStream((InputStream) upackage.getContent());
        String line = null;
        while ((line = dis.readLine()) != null) {
            if(line.endsWith(".class")) {
                classes.add(Class.forName(line.substring(0,line.lastIndexOf('.'))));
            }
        }
        return classes;
    }

}
