package problema2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainToyStore {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opt = "1";
        ToyStoreInterface repo = new ToyStoreService();
        Scanner s = new Scanner(System.in);
        while (!opt.equals("5")){
            System.out.println("Menu: \n Digita '1' para ingresar datos del producto \n Digita '2' para consultar los productos anteriores \n Digita '3' para editar un producto \n Digita '4' para eliminar un producto \n Digita '5' para salir de la tienda ");
            opt = s.next();
            if (opt.equals("1")) {
                System.out.println("REGISTRA TU COMPRA");
                System.out.println("ingrese el serial del juguete: ");
                Integer numerFactura = Integer.valueOf(s.next());
                System.out.println("Ingrese la categoria del juguete: ");
                String nombreProducto = s.next();
                System.out.println("Ingrese el precio del producto");
                int price = Integer.parseInt(s.next());
                System.out.println("Ingrese la cantidad de productos");
                int cantidadProducto = Integer.parseInt(s.next());
                repo.save(new ToyStoreDTO(numerFactura, nombreProducto, +0, cantidadProducto));
            } else if (opt.equals("2")) {
                System.out.println("CONSULTAR COMPRAS");
                List<ToyStoreDTO> toy = repo.findAll();
                if (!toy.isEmpty()){
                    toy.forEach(System.out::println);
                } else {
                    System.out.println("No hay registros de productos");
                }
            } else if (opt.equals("3")) {
                System.out.println("EDITAR PRODUCTO");
                System.out.println("Ingrese el serial del producto");
                int id = Integer.parseInt(s.next());
                boolean busqueda = repo.findById(id) == null;
                if (busqueda){
                    System.out.println("Ingrese el nombre/categoria del producto");
                    String name = s.next();
                    System.out.println("Ingrese el precio");
                    int precioNuevo = Integer.parseInt(s.next());
                    System.out.println("Ingrese la cantidad nueva");
                    int cantidadNueva = Integer.parseInt(s.next());
                    repo.update(new ToyStoreDTO(id, name, precioNuevo, cantidadNueva));
                    System.out.println("Has editado el producto exitosamente");
                } else {
                    System.out.println("NO ENCONTRAMOS ESTE PRODUCTO");
                }
            } else if (opt.equals("4")) {
                System.out.println("ELIMINAR");
                System.out.println("Ingresa el serial de producto que desees eliminar");
                int facturita = Integer.parseInt(s.next());
                repo.delete(repo.findById(facturita));
                repo.findAll().forEach(System.out::println);
            } else if (opt.equals("5")) {
                opt = "5";
            }
        }
    }
}
