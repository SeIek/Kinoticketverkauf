package de.uni_hamburg.informatik.swt.se2.kino.entwurfsmuster.beobachter;

public class BeobachterTestklasse implements Beobachter
{
    private BeobachtbarTestklasse _beobachtbarTestklasse;
    private int _aenderungen_beobachter;
    
    public BeobachterTestklasse()
    {
        _beobachtbarTestklasse = new BeobachtbarTestklasse();
        _aenderungen_beobachter = 0;
        
        registriereAlsBeobachter();
    }
    
    /**
     * Traegt die Testklasse bei der BeobachtbarTestklasse als Beobachter ein.
     */
    private void registriereAlsBeobachter()
    {
        _beobachtbarTestklasse.setzeBeobachter(this);
    }
    
    /**
     *  Nimmt eine Aenderung in der BeobachtbarTestklasse vor.
     */
    public void veraendereBeobachtbarTestklasse()
    {
        _beobachtbarTestklasse.meldeAenderung();
    }
    
    /**
     * Wird aufgerufen sobald beobachtete Subwerkzeuge eine Änderung melden.
     * 
     * @param quelle Die Quelle der Änderung
     * 
     * @require quelle != null
     */
    @Override
    public void beachteAenderung(Beobachtbar quelle)
    {
        assert quelle != null : "Vorbedingung verletzt: quelle != null";
        
        if (quelle == _beobachtbarTestklasse)
        {
            _aenderungen_beobachter++; 
        }
    }
    
    public int getAnzahlAenderungen()
    {
        return _aenderungen_beobachter;
    }
}