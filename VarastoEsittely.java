public class  VarastoEsittely {
    public static void main(String[] args) {
  
      Varasto mehua  = new Varasto(100.0);
      Varasto olutta = new Varasto(100.0, 20.2);
  
      System.out.println("Luonnin jälkeen:");
      System.out.println("Mehuvarasto: " + mehua);
      System.out.println("Olutvarasto: " + olutta);
  
  /* Tulostus:
  Luonnin jälkeen:
  Mehuvarasto: saldo = 0.0, vielä tilaa 100.0
  Olutvarasto: saldo = 20.2, vielä tilaa 79.8
  */
  
      System.out.println("Olutgetterit:");
      System.out.println("getSaldo()     = " + olutta.getSaldo());
      System.out.println("getTilavuus    = " + olutta.getTilavuus());
      System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());
  
  /* Tulostus:
  Olutgetterit:
  getSaldo()     = 20.2
  getTilavuus    = 100.0
  paljonkoMahtuu = 79.8
  */
  
      System.out.println("Mehusetterit:");
      System.out.println("Lisätään 50.7");
      mehua.lisaaVarastoon(50.7);
      System.out.println("Mehuvarasto: " + mehua);
      System.out.println("Otetaan 3.14");
      mehua.otaVarastosta(3.14);
      System.out.println("Mehuvarasto: " + mehua);
  
  /* Tulostus:
  Mehusetterit:
  Lisätään 50.7
  Mehuvarasto: saldo = 50.7, vielä tilaa 49.3
  Otetaan 3.14
  Mehuvarasto: saldo = 47.56, vielä tilaa 52.44
  */
  
      System.out.println("Virhetilanteita:");
      System.out.println("new Varasto(-100.0);");
      Varasto huono =  new Varasto(-100.0);
      System.out.println(huono);
  
      System.out.println("new Varasto(100.0, -50.7)");
      huono =  new Varasto(100.0, -50.7);
      System.out.println(huono);
  
  /* Tulostus:
  Virhetilanteita:
  new Varasto(-100.0);
  saldo = 0.0, vielä tilaa 0.0
  new Varasto(100.0, -50.7)
  saldo = 0.0, vielä tilaa 100.0
  */
  
      System.out.println("Olutvarasto: " + olutta);
      System.out.println("olutta.lisaaVarastoon(1000.0)");
      olutta.lisaaVarastoon(1000.0);
      System.out.println("Olutvarasto: " + olutta);
  
  /* Tulostus:
  Olutvarasto: saldo = 20.2, vielä tilaa 79.8
  olutta.lisaaVarastoon(1000.0)
  Olutvarasto: saldo = 100.0, vielä tilaa 0.0
  */
  
      System.out.println("Mehuvarasto: " + mehua);
      System.out.println("mehua.lisaaVarastoon(-666.0)");
      mehua.lisaaVarastoon(-666.0);
      System.out.println("Mehuvarasto: " + mehua);
  
  /* Tulostus:
  Mehuvarasto: saldo = 47.56, vielä tilaa 52.44
  mehua.lisaaVarastoon(-666.0)
  Mehuvarasto: saldo = 47.56, vielä tilaa 52.44
  */
  
      System.out.println("Olutvarasto: " + olutta);
      System.out.println("olutta.otaVarastosta(1000.0)");
      double saatiin = olutta.otaVarastosta(1000.0);
      System.out.println("saatiin " + saatiin);
      System.out.println("Olutvarasto: " + olutta);
  
  /* Tulostus:
  Olutvarasto: saldo = 100.0, vielä tilaa 0.0
  olutta.otaVarastosta(1000.0)
  saatiin 100.0
  Olutvarasto: saldo = 0.0, vielä tilaa 100.0
  */
  
      System.out.println("Mehuvarasto: " + mehua);
      System.out.println("mehua.otaVarastosta(-32.9)");
      saatiin = mehua.otaVarastosta(-32.9);
      System.out.println("saatiin " + saatiin);
      System.out.println("Mehuvarasto: " + mehua);
  /* Tulostus:
  Mehuvarasto: saldo = 47.56, vielä tilaa 52.44
  mehua.otaVarastosta(-32.9)
  saatiin 0.0
  Mehuvarasto: saldo = 47.56, vielä tilaa 52.44
  */
    }
  }
  