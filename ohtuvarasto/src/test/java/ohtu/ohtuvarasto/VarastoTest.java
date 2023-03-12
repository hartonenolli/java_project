package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    Varasto varasto2;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVarastonArvollaAlleNolla() {
        varasto2 = new Varasto(-10);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVarastonArvollaAlleNollaJaTilavuusAlleNolla() {
        varasto2 = new Varasto(-10, -10);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoUudenVarastonJaKuormittaa() {
        varasto2 = new Varasto(10, 10);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoUudenVarastonJaKuormittaaYlimaarainenYli() {
        varasto2 = new Varasto(10, 20);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoaPienempiNolla() {
        varasto.lisaaVarastoon(-1);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoaIsompiKuinTilaaOn() {
        varasto.lisaaVarastoon(12);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaranLiianIsollaMaaralla() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(9);

        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaranLiianPienellaMaaralla() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(-1);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void palautetaanOikeaTulostus() {
        varasto.lisaaVarastoon(8);

        String tulostus = varasto.toString();

        assertEquals("saldo = 8.0, vielä tilaa 2.0", tulostus);
    }

}