package edu.support.dto;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Notification implements Serializable{
    private String titre ;
    private String message ;
    private boolean success ;

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public static void enregistrementNotification(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("notification", Notification.getEnregistrementNotification(true));
    }
    public static void modificationNotification(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("notification", Notification.getModificationNotification(true));
    }
    public static void suppressionNotification(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("notification", Notification.getSuppressionNotification(true));
    }
    
    public static Notification getEnregistrementNotification(boolean succes){
        Notification notification = new Notification();
        notification.setTitre("Enregistrement");
        notification.setSuccess(succes);
        if(succes)
            notification.setMessage("L'élément a bien été enregistré");
        else
            notification.setMessage("L'opération ne s'est pas terminée correctement ! l'élément n'a pas été enregistré");
        return notification;
    }
    
    public static Notification getModificationNotification(boolean succes){
        Notification notification = new Notification();
        notification.setTitre("Modification");
        notification.setSuccess(succes);
        if(succes)
            notification.setMessage("L'élément a bien été modifié");
        else
            notification.setMessage("L'opération ne s'est pas terminée correctement ! l'élément n'a pas été modifié");
        return notification;
    }
    
    public static Notification getSuppressionNotification(boolean succes){
        Notification notification = new Notification();
        notification.setTitre("Suppression");
        notification.setSuccess(succes);
        if(succes)
            notification.setMessage("L'élément a bien été supprimé");
        else
            notification.setMessage("L'opération ne s'est pas terminée correctement ! l'élément n'a pas été supprimé");
        return notification;
    }
    
    public static Notification getExceptionNotification(){
        Notification notification = new Notification();
        notification.setTitre("Erreur");
        notification.setMessage("L'opération a entrainé une erreur interne du serveur ! \nBien vouloir reéssayer ultérieurement ou contacter un adminisatrateur");
        notification.setSuccess(false);
        return notification;
    }
}
