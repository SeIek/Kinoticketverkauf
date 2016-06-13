package de.uni_hamburg.informatik.swt.se2.kino.entwurfsmuster.beobachter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BeobachtungsTest
{
    BeobachtbarTestklasse _beobachtbar;
    BeobachterTestklasse _beobachter;
    
    public BeobachtungsTest()
    {
    _beobachtbar = new BeobachtbarTestklasse();
    _beobachter = new BeobachterTestklasse();
    }
        
    @Test
    public void aenderungenAnBeobachtbar()
    {
        assertEquals(0, _beobachter.getAnzahlAenderungen());
        _beobachter.veraendereBeobachtbarTestklasse();
        _beobachter.veraendereBeobachtbarTestklasse();
        _beobachter.veraendereBeobachtbarTestklasse();
        assertEquals(3, _beobachter.getAnzahlAenderungen());
    }
}