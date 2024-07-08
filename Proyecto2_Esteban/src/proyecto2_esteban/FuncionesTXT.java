/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2_esteban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author esteban
 */
public class FuncionesTXT {

    public void leerTXT(TablaDeDispersion tabladd, TablaPorPalabrasClave tablapc, String direccion) {
        String linea;
        String datos_txt = "";
        String titulo = "";
        String autores = "";
        String resumen = "";
        String palabras = "";
        int estado = 1;
        try {
            FileReader fr = new FileReader(direccion);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    if (linea.toLowerCase().equals("autores")) {
                        estado = 2;
                    } else if (linea.toLowerCase().equals("resumen")) {
                        estado = 3;
                    } else if (linea.toLowerCase().contains("palabras claves:")) {
                        palabras += linea.toLowerCase().replace("palabras claves:", "");
                    } else if (estado == 1) {
                        titulo += linea;
                    } else if (estado == 2) {
                        autores += linea.replace("-", " ") + "\n";
                    } else if (estado == 3) {
                        resumen += linea + " ";
                    }
                }
            }
            String autoresL[] = autores.split("\n");
            String palabrasL[] = palabras.split(",");
            for (int i = 0; i < palabrasL.length; i++) {
                palabrasL[i] = palabrasL[i].replaceAll("^.", "");
//                System.out.println("+-+-+-++-+-+-+-");
//                System.out.println(palabrasL[i].charAt(0));
//                                System.out.println("+-+-+-++-+-+-+-");

            }

            palabrasL[palabrasL.length - 1] = palabrasL[palabrasL.length - 1].replace(".", "");
            Articulo art = new Articulo(titulo, autoresL, resumen, palabrasL);
            tabladd.insertar(art);
            tablapc.insertar(art);
            br.close();

            JOptionPane.showMessageDialog(null, "Se ha leido el archivo");

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
}
