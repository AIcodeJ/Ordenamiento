import java.util.List;

public class Metodos {

    public static void ordenarLong(List<String> lista){
        lista.sort((String o1, String o2) -> {
            int num = Integer.compare(o1.length(), o2.length());
            return num;
        });
    }

    public static void ordenarAlf(List<String>lista){
        lista.sort(String::compareTo);
    }
}

