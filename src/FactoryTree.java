import java.util.HashMap;

public class FactoryTree {


    public Map<String, String> getMap(int tipo){
        switch (tipo){
            case 1:
                SplayBST<String, String> diccionario = new SplayBST<>();
                return diccionario;

            case 2:
                HashMap<String, String> dicciona = new HashMap<>();
        }

        return null;
    }
}
