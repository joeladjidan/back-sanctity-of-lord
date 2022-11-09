package com.joeladjidan.sanctityoflord.utils;

public interface Constants {

  String APP_ROOT = "sanctityoflord/v1";

  String ENTREPRISE_ENDPOINT = APP_ROOT + "/entreprises";

  String GALERIE_ENDPOINT = APP_ROOT + "/galerie";

  String ENSEIGNEMENT_ENDPOINT = APP_ROOT + "/enseignement";

  String EMISSION_ENDPOINT = APP_ROOT + "/emission";

  String UTILISATEUR_ENDPOINT = APP_ROOT + "/utilisateurs";

  String AUTHENTICATION_ENDPOINT = APP_ROOT + "/auth";

  String TYPE_ENSEIGNEMENT_ENDPOINT = APP_ROOT + "/type-enseignement";

  String TYPE_EMISSION_ENDPOINT = APP_ROOT + "/type-emission";

  String TITRE_MESSAGE_ENDPOINT = APP_ROOT + "/titre-message";

  String ARCHIVRE_ENDPOINT = APP_ROOT + "/archivre";

  String FICHIER_REPERTOIRE = System.getProperty("user.home") +
          System.getProperty("file.separator") + "sanctity" +
          System.getProperty("file.separator");

}
