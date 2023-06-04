package EspaceDeTravail;

import Views.LogView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * La class Logs représente les logs de l'application.
 * Elle stock les logs dans une liste sous un format 'horaire : activite'.
 */
public class Log {
    /////////////////////////////////
    //          Attributs          //
    /////////////////////////////////
    private static Log instance;
    private LogView vue;
    private List<String> activities;

    /////////////////////////////////
    //          Constructeur       //
    /////////////////////////////////

    /**
     * Constructeur de la classe Logs.
     */
    private Log() {
        activities = new ArrayList<>();
    }

    /////////////////////////////////
    //          Getters            //
    /////////////////////////////////
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    /**
     * Recupère toutes les activités de la liste.
     *
     * @return Une liste d'activités.
     */
    public List<String> getActivities() {
        return activities;
    }

    //////////////////////////////////
    //           Méthodes           //
    //////////////////////////////////
    /**
     * Ajoute une activité dans la liste des logs avec la date et l'heure actuelle.
     *
     * @param activity L'activité a ajouter.
     */
    public void addActivity(String activity) {
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.toString();
        String logEntry = formattedTimestamp + ": " + activity;
        activities.add(logEntry);
        System.out.println("> " + logEntry);
        if (vue != null) {
            vue.redessiner();
        }
    }


    /**
     * Efface toutes les activités de la liste.
     */
    public void clearLog() {
        activities.clear();
    }

    /**
     * Attribue une vue au modèle pour l'actualiser a chaque ajout de donnée
     * @param vue
     */
    public void setVue(LogView vue) {
        this.vue = vue;
    }


}
