package EspaceDeTravail;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {
    @org.junit.jupiter.api.Test
    void setSaListe() {
    }

    @org.junit.jupiter.api.Test
    void setTitreCarte() throws Exception {
        Carte c1 = new Carte();
        c1.setTitreCarte("carte test");
        String titreCarte = c1.getTitreCarte();
        assertEquals("carte test", titreCarte);
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        Carte c1 = new Carte();
        c1.setDescription("description test");
        String description = c1.getDescription();
        assertEquals("description test", description);
    }

    @org.junit.jupiter.api.Test
    void setDateDebut() {
        Carte c1 = new Carte();
        c1.setDateDebut("dateDebut test");
        String dateDebut = c1.getDateDebut();
        assertEquals("dateDebut test", dateDebut);
    }

    @org.junit.jupiter.api.Test
    void setDateLimite() {
        Carte c1 = new Carte();
        c1.setDateLimite("dateLimite test");
        String dateLimite = c1.getDateLimite();
        assertEquals("dateLimite test", dateLimite);
    }


    @org.junit.jupiter.api.Test
    void ajouterMembre() {
        Carte c1 = new Carte();
        Membre m1 = new Membre();
        c1.ajouterMembre(m1);
        assertTrue(c1.getSesMembres().contains(m1));
        assertTrue(m1.getSesCartes().contains(c1));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        //Generate a test of a toString

    }
}