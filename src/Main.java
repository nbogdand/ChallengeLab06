import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        /*
        FileSystemUserRepository repository = new FileSystemUserRepository("G:\\JavaFacultate\\lab29Mar\\src\\user_input.txt");

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("In main, gaseste admin");

        ArrayList<User> users = null;
        try {
            users = repository.findByUserType(UserType.ADMIN);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        for(User user : users){
            System.out.println(user);
        }

        try {
            repository.login(12,"das");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        */

        ListaOrdonata listaOrdonata = new ListaOrdonata();

        listaOrdonata.addElement(3);
        listaOrdonata.addElement(21);
        listaOrdonata.addElement(1);
        listaOrdonata.addElement(7);
        listaOrdonata.addElement(2);
        listaOrdonata.addElement(2);
        listaOrdonata.addElement(2);
        listaOrdonata.addElement(2);


        listaOrdonata.print();

        System.out.println();
        System.out.println(listaOrdonata.size());

        listaOrdonata.removeAll(2);

        listaOrdonata.print();

        System.out.println();
        System.out.println(listaOrdonata.size());


        /*
        listaOrdonata.removeElement(5);
        listaOrdonata.removeElement(7);
        listaOrdonata.removeElement(13);
        listaOrdonata.removeElement(21);
        listaOrdonata.removeElement(1);

        listaOrdonata.print();

        System.out.println();
        System.out.println(listaOrdonata.size());

        */

    }

}
