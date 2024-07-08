/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_esteban;

/**
 *
 * @author esteban
 */
public class TablaDeDispersion {
    public Articulo[] articulos;
    int total;
    int actuales;
    
    public TablaDeDispersion(){
        this.total = 20;
        this.actuales = 0;
        this.articulos = new Articulo[20];
        for (int i = 0; i < 20; i++) {
            this.articulos[i] = null;
        }
    }
    
    public int hash(String titulo){
        int valor = 21;
        //Convertimos cada caracter del titulo en un numero usando su valor ASCII
        for (Character c : titulo.toCharArray()){
            valor = (valor * 31 + c) % 127; 
        }
        return valor % total;
    }
    
    
    public void insertar(Articulo articulo){
        //Usamos la funcion de hash para calcular el indice que tendra el articulo
        int hash = this.hash(articulo.getTitulo().toLowerCase());
        
        //Validamos si ya hay un articulo en esa posicion
        if(this.articulos[hash] != null){
            //Comprobamos que el articulo que esta en esa posicion no sea igual al que queremos insertar
            if(this.articulos[hash].getTitulo().toLowerCase().equals(articulo.getTitulo().toLowerCase())){
                return;
            }
            else{
                //Buscamos una posicion vacia eb el arreglo para insertarlo, y seguimos buscando que no este ya insertado
                while(this.articulos[hash] != null){
                    //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                    if(this.articulos[hash].getTitulo().toLowerCase().equals(articulo.getTitulo().toLowerCase())){
                        return;
                    }
                    //Movemos el hash
                    hash+= 1;
                    if(hash == this.total){
                        hash = 0;
                    }
                }
            }
        }
        //Al llegar a este punto, podremos insertar en la posicion hash con la seguridad de que estara vacias
        this.articulos[hash] = articulo;
    }
    
    public Articulo busquedaPorTitulo(String titulo){
         int hash = this.hash(titulo);
        
        //Validamos si ya hay un articulo en esa posicion
        if(this.articulos[hash] != null){
            //Comprobamos que el articulo que esta en esa posicion no sea igual al que queremos insertar
            if(this.articulos[hash].getTitulo().toLowerCase().equals(titulo)){
                return this.articulos[hash];
            }
            else{
                //Buscamos una posicion vacia eb el arreglo para insertarlo, y seguimos buscando que no este ya insertado
                while(this.articulos[hash] != null){
                    //Si los articulos tienen el mismo titulo retornamos para no insertarlo otra vez
                    if(this.articulos[hash].getTitulo().toLowerCase().equals(titulo)){
                        return this.articulos[hash];
                    }
                    hash += 1;
                    if(hash == this.total){
                        hash = 0 ;
                    }
                    //Movemos el hash
                    
                }
            }
        }
        //Al llegar a este punto, podremos insertar en la posicion hash con la seguridad de que estara vacias
        return null;
}
    
    public Articulo[] busquedaPorAutor(String autor){
        Articulo[] portafolio = new Articulo[this.total];
        int indiceP = 0;
        //Recorremos los articulos
        for (int i = 0; i < this.total; i++) {
            if( this.articulos[i] != null){
                //Por cada articulo, recorremos el arreglo de sus autores
                for (int j = 0; j < this.articulos[i].getAutores().length; j++) {
                    //Si el autor es igual al que estamos buscando, agregamos al articulo al arreglo y pasamos al siguiente
                    if(this.articulos[i].getAutores()[j].toLowerCase().equals(autor)){
                        portafolio[indiceP] = this.articulos[i];
                        indiceP += 1;
                        break;
                    }
                }
            }
            
        }
        //Regresamos el arreglo de todos los articulos escritos por el autor
        return portafolio;
    }
    
    public String autores(){
        String autores = "";
        for (int i = 0; i < this.total; i++) {
            try{
                for (int j = 0; j < this.articulos[i].getAutores().length; j++) {
                    if(!autores.contains(this.articulos[i].getAutores()[j])){
                        autores += this.articulos[i].getAutores()[j] + ";";
                    }
                }
            }catch(Exception e){
                
            }
        }
        autores = autores.substring(0, autores.length() - 1);
        return autores;
    }
}
