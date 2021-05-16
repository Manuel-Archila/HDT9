import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SplayBST<String, String> diccionario = new SplayBST<>();
        Scanner scan = new Scanner(System.in);
        FactoryTree factory = new FactoryTree();

        System.out.println("Con que implemntacion desea trabajar:\n1.SplayTree\n2.HashMap");
        scan.nextLine();
        int deci;
        while(true) {
            try {
                deci = scan.nextInt();
                if (deci<1 && deci>2){
                    break;
                }else{
                    System.out.println("Ingrese una opcion valida");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida");
            }
        }
        Map<String, String> dicio = factory.getMap(deci);

        String data = "";
        try {
            File myObj = new File("Spanish.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                String[] keyval = data.split("\\s");
                System.out.println(data);

                if(!dicio.containsKey(keyval[0])){
                    dicio.put(keyval[0], keyval[1]);
                }

            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }

        System.out.println("Ingrese la ruta del archivo que se desa leer");
        scan.nextLine();
        String ruta = scan.nextLine();
        String traducido = "";
        try {
            File myObj2 = new File("texto.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {
                String temp = scan.next();
                if(diccionario.containsKey(temp)){
                    String traduccion = diccionario.get(temp);
                    traducido += traduccion;
                }else{
                    traducido += "*"+ temp + "* ";
                }
            }
            myReader2.close();
        }catch (Exception e){
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }

        System.out.println(traducido);
    }
}
