/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2_esteban;

/**
 *
 * @author andre
 */
public class Proyecto2_Esteban {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FuncionesTXT f = new FuncionesTXT();
        TablaDeDispersion tabladd = new TablaDeDispersion();
        TablaPorPalabrasClave tablapc = new TablaPorPalabrasClave();
        String[] archivos =  {"archivo1.txt", "archivo2.txt", "archivo3.txt", "archivo4.txt"};
        for(String dir: archivos){
            f.leerTXT(tabladd, tablapc, dir);
        }
        
//        for (int i = 0; i < tabladd.total; i++) {
//            try{
//                System.out.println(tabladd.articulos[i].getTitulo());
//            }catch(Exception e){
//                
//            }
//        }
        Menu menu = new Menu(tabladd, tablapc);
    }
}
