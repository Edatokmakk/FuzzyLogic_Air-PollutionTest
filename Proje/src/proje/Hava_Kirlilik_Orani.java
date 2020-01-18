/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev1;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;


public class Hava_Kirlilik_Orani {
    private FIS fis;
    private double dogalgaz_kullanimi;
    private double mevsim;
    private double nufus;
    

    public Hava_Kirlilik_Orani(double dogalgaz_kullanimi, double mevsim, double nufus)throws URISyntaxException
    {
        this.dogalgaz_kullanimi=dogalgaz_kullanimi;
        this.mevsim=mevsim;
        this.nufus=nufus;
        //hata fırlattığınfan yakamak gerek
        File dosya=new File(getClass().getResource("Hava_Kirlilik_Orani.fcl").toURI());
        //2 . değişken eğer daha önce yüklenmişse onun üstüne yazmak için
        fis=FIS.load(dosya.getPath(),true);
        fis.setVariable("dogalgaz_kullanimi",dogalgaz_kullanimi );
        fis.setVariable("mevsim", mevsim);
        fis.setVariable("nufus", nufus);
        fis.evaluate();//hesaplandı  
    }

    
    @Override
    public String toString() {
        String cikti="Doğalgaz Kullanımı(0-100):"+dogalgaz_kullanimi+"\nMevsimler:(kis:1 ilkbahar:2 yaz:3 sonbahar:4)"+mevsim+"\n Nufus(0-100):"+nufus+"\nHava Kirlilik Oranı :"+fis.getVariable("hava_kirlilik_oran").getValue();
        return cikti;
    }
   public Hava_Kirlilik_Orani() throws URISyntaxException{
        File dosya=new File(getClass().getResource("Hava_Kirlilik_Orani.fcl").toURI());
        fis=FIS.load(dosya.getPath(),true);
    }
   FIS getModel() {
        return fis;
    }
}
