import java.util.Scanner;
import repository.CiclaRepository;

import model.Cicla;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CiclaRepository ciclaRepository = new CiclaRepository();

        // INSERTAR CICLA
        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese color: ");
        String color = scanner.nextLine();

        Cicla cicla = new Cicla(marca, modelo, color);
        ciclaRepository.insertarCicla(cicla);

        // LISTAR CICLAS
        System.out.println("\nLista de ciclas:");
        for (Cicla c : ciclaRepository.listarCiclas()) {
            System.out.println("ID: " + c.getId() + 
                               "Marca: " + c.getMarca() + 
                               "Modelo: " + c.getModelo() + 
                               "Color: " + c.getColor());
        }

        // ACTUALIZAR
        System.out.print("\nIngrese ID de la cicla que desea actualizar: ");
        long idActualizar = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nueva marca: ");
        String nuevaMarca = scanner.nextLine();

        System.out.print("Nuevo modelo: ");
        String nuevoModelo = scanner.nextLine();

        System.out.print("Nuevo color: ");
        String nuevoColor = scanner.nextLine();

        ciclaRepository.actualizarCicla(idActualizar, nuevaMarca, nuevoModelo, nuevoColor);

        // ELIMINAR
        System.out.print("\nIngrese ID de la cicla que desea eliminar: ");
        long idEliminar = scanner.nextLong();

        ciclaRepository.eliminarCicla(idEliminar);

        // LISTA FINAL
        System.out.println("\nLista de ciclas:");
        for (Cicla c : ciclaRepository.listarCiclas()) {
            System.out.println("ID: " + c.getId() + 
                               "Marca: " + c.getMarca() + 
                               "Modelo: " + c.getModelo() + 
                               "Color: " + c.getColor());
        }

        scanner.close();
    }
}