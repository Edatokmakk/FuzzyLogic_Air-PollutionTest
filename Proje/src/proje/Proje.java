/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev1;

import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Eda
 */
public class Odev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in =new Scanner(System.in);
        System.out.println("Doğalgaz Kullanım Oranı(0-100):");
        double dogalgaz_kullanimi =in.nextDouble();
        System.out.println("Mevsim (1-12):");
        double mevsim =in.nextDouble();
        System.out.println("Nüfus (0-100):");
        double nufus =in.nextDouble();
        
        try
        {
                Hava_Kirlilik_Orani h=new Hava_Kirlilik_Orani(dogalgaz_kullanimi,mevsim,nufus);
                //çıktıyı sağlar
                JFuzzyChart.get().chart(h.getModel());
                System.out.println(h);

        }
        catch(URISyntaxException ex)
        {
            System.out.print("HATA");
        }
    }
    
}
