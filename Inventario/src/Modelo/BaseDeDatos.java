package Modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos 
{
    private List<Producto> productos;

    public BaseDeDatos() 
    {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) 
    {
        if (producto == null) return;
        productos.add(producto);
    }

    public Producto buscarProductoSku(String sku) 
    {
        if (sku == null) return null;
        String skuLower = sku.trim().toLowerCase();
        for (Producto p : productos) {
            if (p.getSku() != null && p.getSku().trim().toLowerCase().equals(skuLower)) 
            {
                return p;
            }
        }
        return null;
    }


    public List<Producto> buscarTodos() 
    {
        return new ArrayList<>(productos);
    }

  
    public boolean eliminarProducto(String sku) 
    {
        Producto encontrado = buscarProductoSku(sku);
        if (encontrado != null) 
        {
            return productos.remove(encontrado);
        }
        return false;
    }
}

