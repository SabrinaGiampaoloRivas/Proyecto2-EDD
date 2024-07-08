/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_esteban;

/**
 *
 * @author esteban
 */
public class TablaPorPalabrasClave {
    public ListaPalabrasClave[] articulos;
    int total;
    int actuales;
    
    public TablaPorPalabrasClave(){
        this.total = 10;
        this.actuales = 0;
        this.articulos = new ListaPalabrasClave[10];
        for (int i = 0; i < 10; i++) {
            this.articulos[i] = new ListaPalabrasClave();
        }
    }
    
    public int hash(String palabra){
        int valor = 21;
        //Convertimos cada caracter del titulo en un numero usando su valor ASCII
        for (Character c : palabra.toCharArray()){
            valor = c ^ valor + valor; 
        }
        return valor % total;
    }
    
    
    public void insertar(Articulo articulo){
        //Usamos la funcion de hash para calcular el indice que tendra el articulo
        for (int i = 0; i < articulo.getPalabras_claves().length; i++) {   
            int hash = this.hash(articulo.getPalabras_claves()[i]);
            //Validamos si ya hay un articulo en esa posicion
            if(!this.articulos[hash].clave.equals("")){
                //Comprobamos que el articulo que esta en esa posicion no sea igual al que queremos insertar
                if(this.articulos[hash].clave.equals(articulo.getPalabras_claves()[i])){
                    this.articulos[hash].insertar(articulo);
                    return;
                }
                else{
                    //Buscamos una posicion vacia eb el arreglo para insertarlo, y seguimos buscando que no este ya insertado
                    while(!this.articulos[hash].clave.equals("")){
                        //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                        if(this.articulos[hash].clave.equals(articulo.getPalabras_claves()[i])){
                            this.articulos[hash].insertar(articulo);
                            return;
                        }
                        //Movemos el hash
                        hash = (hash * 21 ) % this.total;
                    }
                }
            }
            //Al llegar a este punto, podremos insertar en la posicion hash con la seguridad de que estara vacias
            this.articulos[hash].insertar(articulo);
        }
    }
    
    public ListaPalabrasClave buscarPalabraClave(String palabra){
        int hash = this.hash(palabra);
        if(this.articulos[hash].clave.equals(palabra)){
            return this.articulos[hash];
        }else{
            while(!this.articulos[hash].clave.equals("")){
                 //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                if(this.articulos[hash].clave.equals(palabra)){
                    return this.articulos[hash];
                }
                        //Movemos el hash
                hash = (hash * 21 ) % this.total;
            }
            return null;
        }
    }
    
}
