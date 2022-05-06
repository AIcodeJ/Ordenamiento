import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Heredamos de la clase Metodos
public class Main extends Metodos{

    //Declaración de la lista
    static List<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        // Se agregan 10 palabras a la lista
        lista.add("Manzana");
        lista.add("Relojeria");
        lista.add("Desoxirribonucleico");
        lista.add("Aviacion");
        lista.add("E-Commerce");
        lista.add("Navegacion");
        lista.add("Imperialismo");
        lista.add("Star Wars");
        lista.add("Documentacion");
        lista.add("Programacion");

        System.out.println("Lista sin ordenar:");
        System.out.println(lista);

        /*   --------------------------------------------------------------     */

        //Metodo de instanciar la clase anónima heredando algunos métodos de la clase metodos
        classAnon anonimo = new classAnon(){

            @Override
            public void ordenarLong(List<String> lista){
                lista.sort(Comparator.comparingInt(String::length));
            }

            @Override
            public void ordenarAlf(List<String>lista){
                lista.sort(String::compareTo);
            }
        };

        //Clase Anónima (Alfabéticamente)
        anonimo.ordenarAlf(lista);
        System.out.println("\nClase Anónima - Orden Alfabético:");
        lista.forEach(System.out::println);

        //Clase Anónima (Longitud)
        anonimo.ordenarLong(lista);
        System.out.println("\nClase Anónima - Orden Por Longitud:");
        lista.forEach(System.out::println);

        /*   --------------------------------------------------------------     */

        //Expresión Lambda (Alfabéticamente)
        lista.sort((String word, String palabra) -> word.compareTo(palabra));
        System.out.println("\nExpresión Lambda - Orden Alfabético:");
        lista.forEach(palabra -> System.out.println(palabra));

        //Expresión Lambda (Longitud)
        lista.sort((String p1, String p2) -> {
            int output = Integer.compare(p1.length(), p2.length());
            return output;
        });

        System.out.println("\nExpresión Lambda - Orden Por Longitud:");
        lista.forEach(palabra -> System.out.println(palabra));

        /*   --------------------------------------------------------------     */

        //Referencias de la interfaz con los métodos de la clase metodos
        Ordenamiento longitud = Main::ordenarLong;
        Ordenamiento alfabetico = Main::ordenarAlf;

        //Método de Referencia (Alfabéticamente)
        alfabetico.ordernar(lista);
        System.out.println("\nMétodo de Referencia - Orden Alfabético:");
        lista.forEach(System.out::println);

        //Método de Referencia (Longitud)
        longitud.ordernar(lista);
        System.out.println("\nMétodo de Referencia - Orden Por Longitud:");
        lista.forEach(System.out::println);
    }
}
