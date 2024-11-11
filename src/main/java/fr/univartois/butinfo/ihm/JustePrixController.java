/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.text.NumberFormat;

/**
 * La classe HelloController illustre le fonctionnement du contrôleur associé à une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class JustePrixController {

    /**
     * Le label de l'application, où l'on va pouvoir afficher des messages.
     * Ce label sera initialisé automatiquement par JavaFX grâce à l'annotation
     * {@link FXML}.
     */
    static final java.util.Random random=new java.util.Random();
    @FXML
    private Label question;
    @FXML
    private Label hint;
    @FXML
    private Button submitButton;
    @FXML
    private TextField answerField;
    final int MAX=300;
    int valeur=random.nextInt(MAX);
    /**
     * Cette méthode exécute une action lorsque l'utilisateur clique sur le bouton de la
     * fenêtre.
     * Le lien avec le bouton de l'application sera réalisé automatiquement par JavaFX
     * grâce à l'annotation {@link FXML}.
     */
    @FXML
    protected void onSubmitButtonClick() {
        int valeurEntree;
        try{
            valeurEntree=Integer.parseInt(answerField.getText());
            if(valeurEntree<valeur) hint.setText("C'est plus !");
            if(valeurEntree>valeur) hint.setText("C'est moins !");
            if(valeurEntree==valeur) {
                hint.setText("C'est bon !");
                question.setText("Le juste prix etait "+valeur);
            }

        }
        catch(NumberFormatException e){
            System.err.println("Erreur, pas un entier");
            hint.setText("Merci d'entrer un nombre entier");
        }
    }

}
