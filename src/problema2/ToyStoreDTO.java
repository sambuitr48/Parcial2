package problema2;

import java.io.Serializable;

public class ToyStoreDTO implements Serializable {
    private Integer Id;
    private String categoria;
    private int precio;
    private int cantidad;

    public ToyStoreDTO(Integer id, String categoria, int precio, int cantidad) {
        Id = id;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "Id=" + Id +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
