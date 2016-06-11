package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachter;

/**
 * Das Interface Beobachtber aus dem Entwurfsmuster Beobachter.
 * 
 * @author Oliver Pola, SE2 Übungsgruppe "No Pascha"
 * @version 09.06.2016
 */
public interface Beobachter
{
    /**
     * Wird aufgerufen sobald beobachtete Objekte eine Änderung melden.
     * 
     * @param quelle Die Quelle der Änderung
     */
    void beachteAenderung(Beobachtbar quelle);
}
