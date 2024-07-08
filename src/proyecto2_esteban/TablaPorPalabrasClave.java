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
        this.total = 150;
        this.actuales = 0;
        this.articulos = new ListaPalabrasClave[150];
        for (int i = 0; i < 150; i++) {
            this.articulos[i] = new ListaPalabrasClave();
        }
    }
    
    public int hash(String palabra){
        int valor = 21;
        //Convertimos cada caracter del titulo en un numero usando su valor ASCII
        for (Character c : palabra.toCharArray()){
            valor = (valor * 31 + c) % 127; 
        }
        return valor % total;
    }
    
    
    public void insertar(Articulo articulo){
        //Usamos la funcion de hash para calcular el indice que tendra el articulo
        for (int i = 0; i < articulo.getPalabras_claves().length; i++) {   
            int hash = this.hash(articulo.getPalabras_claves()[i].toLowerCase());
            //Validamos si ya hay un articulo en esa posicion
            if(!this.articulos[hash].clave.equals("")){
                //Comprobamos que el articulo que esta en esa posicion no sea igual al que queremos insertar
                if(this.articulos[hash].clave.toLowerCase().equals(articulo.getPalabras_claves()[i].toLowerCase())){
                    this.articulos[hash].insertar(articulo);
                    return;
                }
                else{
                    //Buscamos una posicion vacia eb el arreglo para insertarlo, y seguimos buscando que no este ya insertado
                    while(!this.articulos[hash].clave.equals("")){
                        //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                        if(this.articulos[hash].clave.toLowerCase().equals(articulo.getPalabras_claves()[i].toLowerCase())){
                            this.articulos[hash].insertar(articulo);
                            return;
                        }
                        //Movemos el hash
                        hash += 1;
                        if(hash == this.total){
                            hash = 0;
                        }
                        System.out.println("dsf");
                    }
                }
            }
            this.articulos[hash].clave = articulo.getPalabras_claves()[i].toLowerCase();
            
            //Al llegar a este punto, podremos insertar en la posicion hash con la seguridad de que estara vacias
            this.articulos[hash].insertar(articulo);
        }
    }
    
    public ListaPalabrasClave buscarPalabraClave(String palabra){
        int hash = this.hash(palabra);
        if(this.articulos[hash].clave.toLowerCase().equals(palabra)){
            return this.articulos[hash];
        }else{
            while(!this.articulos[hash].clave.equals("")){
                 //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                if(this.articulos[hash].clave.toLowerCase().equals(palabra)){
                    return this.articulos[hash];
                }
                hash += 1;
                if(this.total == hash){
                    hash = 0;
                }
            }
            return null;
        }
    }
    
}
