package de.uni_hamburg.informatik.swt.se2.kino.entwurfsmuster.beobachter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testet Beobachter und Beobachtbar
 * 
 * @author Oliver Pola, SE2 Übungsgruppe "No Pascha"
 * @version 10.06.2016
 */
public class BeobachterTestOliver
{
    private static final int ANZAHLTESTAENDERUNGEN = 3;
    private static final int ANZAHLBEOBACHTER = 4;
    private static final int ANZAHLBEOBACHTETE = 5;

    private class MyBeobachter implements Beobachter
    {
        int _counter = 0;

        /**
         * Wird aufgerufen sobald beobachtete Subwerkzeuge eine Änderung melden.
         * 
         * @param quelle Die Quelle der Änderung
         */
        @Override
        public void beachteAenderung(Beobachtbar quelle)
        {
            _counter++;
        }

        /**
         * Gibt die Anzahl der Aufrufe zu Testzwecken zurück
         * 
         * @return Die Anzahl der Aufrufe
         */
        public int getCounter()
        {
            return _counter;
        }
    }

    private class MyBeobachtbar extends Beobachtbar
    {
        /**
         * Meldet eine Änderung an die Beobachter
         */
        public void change()
        {
            meldeAenderung();
        }
    }

    MyBeobachter[] _beobachter = new MyBeobachter[ANZAHLBEOBACHTER];
    MyBeobachtbar[] _beobachtete = new MyBeobachtbar[ANZAHLBEOBACHTETE];;

    public BeobachterTestOliver()
    {
        for (int i = 0; i < ANZAHLBEOBACHTER; i++)
        {
            _beobachter[i] = new MyBeobachter();
        }
        for (int j = 0; j < ANZAHLBEOBACHTETE; j++)
        {
            _beobachtete[j] = new MyBeobachtbar();

            // Jeder beobachtet jeden, Stasi / USA Prinzip :-)
            for (int i = 0; i < ANZAHLBEOBACHTER; i++)
            {
                _beobachtete[j].setzeBeobachter(_beobachter[i]);
            }
        }
    }

    @Test
    public void testJedeAenderungKommtAn()
    {
        assertEquals(0, _beobachter[0].getCounter());

        for (int i = 0; i < ANZAHLTESTAENDERUNGEN; i++)
        {
            _beobachtete[0].change();
        }

        assertEquals(ANZAHLTESTAENDERUNGEN, _beobachter[0].getCounter());
    }

    @Test
    public void testAenderungenKommenAnAllenBeobachternAn()
    {
        _beobachtete[0].change();

        int angekommenBei = 0;
        for (int i = 0; i < ANZAHLBEOBACHTER; i++)
        {
            angekommenBei += _beobachter[i].getCounter();
        }

        assertEquals(ANZAHLBEOBACHTER, angekommenBei);
    }

    @Test
    public void testAenderungenVonAllenBeobachtetenKommenAn()
    {
        for (int i = 0; i < ANZAHLBEOBACHTETE; i++)
        {
            _beobachtete[i].change();
        }

        assertEquals(ANZAHLBEOBACHTETE, _beobachter[0].getCounter());
    }
}
