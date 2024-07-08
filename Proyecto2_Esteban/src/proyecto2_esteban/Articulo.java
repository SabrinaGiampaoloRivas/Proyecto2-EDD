/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_esteban;

/**
 *
 * @author esteban
 */


public class Articulo {
    private String titulo;
    private String[] autores;
    private String resumen;
    private String[] palabras_claves;

    public Articulo(String titulo, String[] autores, String resumen, String[] palabras_claves) {
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
        this.palabras_claves = palabras_claves;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String[] getPalabras_claves() {
        return palabras_claves;
    }

    public void setPalabras_claves(String[] palabras_claves) {
        this.palabras_claves = palabras_claves;
    }
    
    
    public String analisis(){
        String analisis = "Titulo: " + this.titulo + "\nAutores: ";
        //Recorremos el arreglo de autores y lo vamos sunamdo al analisis
        for (int i = 0; i < this.autores.length; i++) {
            analisis += this.autores[i] + ", ";
        }
        //Recorremos el arreglo de palabras clave
        for (int i = 0; i < this.palabras_claves.length; i++) {
            //Por cada palabra clave creamos un indice y un contador de cuantas veces aparece
            int indice_pc = 0;
            int aparece = 0;
            //Ahora recorremos el resumen completo
            for (int j = 0; j < this.resumen.length(); j++) {
                //Primero verificamos si el caracter del resumen j es igual al caracter de la PC indice_pc
                //Si son diferentes, regresamos el indice_pc a la posicion 0
                if(!String.valueOf(this.palabras_claves[i].charAt(indice_pc)).toLowerCase().equals(String.valueOf(this.resumen.charAt(j)).toLowerCase())){
                    indice_pc = 0;
                }
                /*Ahora volvemos a comprobar si el caracter del resumen actual es igual al caracter acual de la PC
                Aunque parezca redundante, se comprueba dos veces lo mismo por si se da el siguiente caso:
                Ejemplo : Supongamos que la palabra clave es MASA
                Resumen:  ..... mas masa ....
                Si solo comprobamos una vez si los caracteres son iguales o no, el programa no seria capaz de encontrar masa
                ya que: 
                Iteracion:      0      1    2   3  | 4   5   6   
                PC: masa        m      a    s   a  | m   m   m
                Resumen:        m      a    s   m  | a   s   a
                Si solo comprobamos una sola vez, en 3 al no coincidir "a" con "m", se reiniciaria el indice_pc a 0 y pasaria
                a la siguiente letra del resumen, lo que seria la iteracion 4.
                En cambio, si comprobamos de nuevo si la letra actual del resumen es igual a la letra acual de la PC(que ahora
                seria la primera) se daria cuenta que son iguales.
*/
                if(String.valueOf(this.palabras_claves[i].charAt(indice_pc)).toLowerCase().equals(String.valueOf(this.resumen.charAt(j)).toLowerCase())){
                    indice_pc += 1;
                }
                //Si indice PC llega a ser igual a la longitud de la palabra querra decir que ya encontro todas sus letras,
                //por lo que le sumamos 1 a sus apariciones y reiniciamos el indice_pc a 0
                if(indice_pc == this.palabras_claves[i].length()){
                    aparece +=1;
                    indice_pc = 0;
                }
            }
            //Agregamos la palabra clave con su frecuencia al analisis
            analisis += "\n" + this.palabras_claves[i] + ": Aparece un total de " + aparece + " veces.";
        }
        return analisis;
    }
}
