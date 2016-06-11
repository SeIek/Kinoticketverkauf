package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachter;

import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse Beobachtbar aus dem Entwurfsmuster Beobachter.
 * 
 * @author Oliver Pola, SE2 Übungsgruppe "No Pascha"
 * @version 09.06.2016
 */
public abstract class Beobachtbar
{
    private Set<Beobachter> _beobachter;
   
    /**
     * Erzeugt ein neues Exemplar von Beobachtbar
     */
    protected Beobachtbar()
    {
        _beobachter = new HashSet<Beobachter>();
    }
    
    /**
     * Registriert einen neuen Beobachter.
     * Alle registrierten Beobachter werden bei Änderungen benachrichtigt.
     * 
     * @param beobachter Der zu registrierende Beobachter
     * 
     * @require beobachter != null
     */
    public void setzeBeobachter(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter != null";
        
        _beobachter.add(beobachter);
    }
    
    /**
     * Meldet eine Änderung an alle registrierten Beobachter
     */
    protected void meldeAenderung()
    {
        for (Beobachter beobachter : _beobachter)
        {
            beobachter.beachteAenderung(this);
        }
    }
}
