/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_esteban;

/**
 *
 * @author esteban
 */

public class ListaPalabrasClave {
    public Articulo[] articulos;
    public String clave;
    public int agregados;
    
    public ListaPalabrasClave(){
        this.articulos = new Articulo[3];
        for (int i = 0; i < this.articulos.length; i++) {
            this.articulos[i] = null;
        }
        this.clave = "";
        this.agregados  = 0;
    }
    
    public void insertar(Articulo articulo){
        if(articulos.length != agregados){
            for (int i = 0; i < this.articulos.length; i++) {
                if(this.articulos[i] == null){
                    this.articulos[i] = articulo;
                    this.agregados ++;
                    return;
                }
            }
        }else{
            Articulo[] nuevoArreglo = new Articulo[this.articulos.length + 3];
            for (int i = 0; i < this.articulos.length; i++) {
                nuevoArreglo[i] = this.articulos[i];
            }
            nuevoArreglo[this.articulos.length] = articulo;
            this.agregados += 1;
            this.articulos = nuevoArreglo;
            return;
        }
    }
}
