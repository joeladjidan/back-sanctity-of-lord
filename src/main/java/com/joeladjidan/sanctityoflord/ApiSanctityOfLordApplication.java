package com.joeladjidan.sanctityoflord;

import com.joeladjidan.sanctityoflord.model.*;
import com.joeladjidan.sanctityoflord.repository.*;
import com.joeladjidan.sanctityoflord.utils.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.mail.MessagingException;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://51.83.42.44:80")
@EnableScheduling
public class ApiSanctityOfLordApplication {

    @Autowired
    MailSenderService mailSenderService;

    private static final Logger LOG = LoggerFactory.getLogger(ApiSanctityOfLordApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ApiSanctityOfLordApplication.class, args);
  }


  @Component
  class DBInitCommandLineRunner implements CommandLineRunner {

      @Autowired
      private UtilisateurRepository utilisateurRepository;

      @Autowired
      private EntrepriseRepository entrepriseRepository;

      @Autowired
      private RolesRepository roleRepository;

      @Autowired
      private GalerieRepository galerieRepository;

      @Autowired
      private PasswordEncoder passwordEncoder;

      @Autowired
      private EnseignementRepository enseignementRepository;

      @Autowired
      private EmissionRepository emissionRepository;

      @Autowired
      private TitreMessageRepository titreMessageRepository;

      @Autowired
      private TypeEnseignementRepository typeEnseignementRepository;

      @Autowired
      private PaysRepository paysRepository;

      @Autowired
      private VilleRepository villeRepository;

      @Autowired
      private DonneeRepository donneeRepository;

      @Autowired
      private CodePostaleRepository codePostaleRepository;

      @Autowired
      private TypeEmissionRepository typeEmissionRepository;

      @Autowired
      private AdresseRepository adresseRepository;

      @Autowired
      private ParametreRepository parametreRepository;

      @Autowired
      private ArchivreRepository archivreRepository;

      @Autowired
      private AnneeRepository anneeRepository;

      @Autowired
      private MoisRepository moisRepository;

      @Autowired
      private CiviliteRepository civiliteRepository;

      @Override
      public void run(String... args) throws Exception {
          Entreprise entrepriseRs = null;
          Utilisateur utilisateurRs = null;

         /* if (parametreRepository.findAll().isEmpty()) {
              Parametre parametre = new Parametre();
              parametre.setChemin(Constants.FICHIER_REPERTOIRE);
              parametreRepository.save(parametre);

              FonctionUtils fonctionUtils = new FonctionUtils();
              //    fonctionUtils.creerRepertoire(Constants.FICHIER_REPERTOIRE);

              Parametre parametre1 = new Parametre();
              parametre1.setChemin("mp3");
              parametreRepository.save(parametre1);

              Parametre parametre2 = new Parametre();
              parametre2.setChemin("youtube");
              parametreRepository.save(parametre2);
          } else {
              //     FonctionUtils fonctionUtils = new FonctionUtils();
              //     fonctionUtils.creerRepertoire(Constants.FICHIER_REPERTOIRE);
          }


          if (adresseRepository.findAll().isEmpty()) {
              Adresse adresse = new Adresse();
              adresse.setPays(paysRepository.findByIntitule("FRANCE").get());
              adresse.setCodePostale(codePostaleRepository.findByCode("94400").get());
              adresse.setAdresse1("67 AVENUE JEAN JAURES");
              adresse.setVille(villeRepository.findByIntitule("PARIS").get());
              adresseRepository.save(adresse);
          }*/

          if (codePostaleRepository.findAll().isEmpty()) {
              CodePostale codePostale = new CodePostale();
              codePostale.setCode("94400");
              codePostaleRepository.save(codePostale);

              CodePostale codePostale1 = new CodePostale();
              codePostale1.setCode("93100");
              codePostaleRepository.save(codePostale1);

              CodePostale codePostale2 = new CodePostale();
              codePostale1.setCode("93200");
              codePostaleRepository.save(codePostale2);
          }

          if (paysRepository.findAll().isEmpty()) {
              Pays pays = new Pays();
              pays.setDescription("");
              pays.setIntitule("FRANCE");
              paysRepository.save(pays);

              Pays pays1 = new Pays();
              pays1.setDescription("");
              pays1.setIntitule("COTE D'IVOIRE");
              paysRepository.save(pays1);

              Pays pays2 = new Pays();
              pays2.setDescription("");
              pays2.setIntitule("CAMEROUN");
              paysRepository.save(pays2);

              Pays pays3 = new Pays();
              pays3.setDescription("");
              pays3.setIntitule("LUXEMBOURG");
              paysRepository.save(pays3);
          }

          if (villeRepository.findAll().isEmpty()) {
              Ville ville = new Ville();
              ville.setDescription("");
              ville.setIntitule("VITRY-SUR-SEINE");
              villeRepository.save(ville);

              Ville ville1 = new Ville();
              ville1.setDescription("");
              ville1.setIntitule("NOISY-LE-GRAND");
              villeRepository.save(ville1);

              Ville ville2 = new Ville();
              ville2.setDescription("");
              ville2.setIntitule("PARIS");
              villeRepository.save(ville2);

              Ville ville3 = new Ville();
              ville3.setDescription("");
              ville3.setIntitule("TOULOUSE");
              villeRepository.save(ville3);
          }

          if (civiliteRepository.findAll().isEmpty()) {
              Civilite civilite = new Civilite();
              civilite.setIntitule("Monsieur");
              civiliteRepository.save(civilite);

              Civilite civilite1 = new Civilite();
              civilite1.setIntitule("Mademoiselle");
              civiliteRepository.save(civilite1);

              Civilite civilite2 = new Civilite();
              civilite2.setIntitule("Madame");
              civiliteRepository.save(civilite2);
          }

          if (entrepriseRepository.findAll().isEmpty()) {
              Entreprise entreprise = new Entreprise();
              entreprise.setNom("SANCTITY OF THE LORD");
              entreprise.setAdresse(adresseRepository.findByAdresse1("67 AVENUE JEAN JAURES").get());
              entreprise.setCodeFiscal("123456789");
              entreprise.setNumTel("+330650599343");
              entreprise.setEmail("ansgroup@gmail.com");
              entreprise.setCreationDate(new Date());
              entreprise.setLastModifiedDate(new Date());
              entrepriseRs = entrepriseRepository.save(entreprise);
          }
          if (utilisateurRepository.findAll().isEmpty()) {
              Utilisateur utulisateur = new Utilisateur();
              utulisateur.setLastModifiedDate(new Date());
              utulisateur.setCreationDate(new Date());
              utulisateur.setPrenom("Anagkazo");
              utulisateur.setNumTel("+330650599343");
              utulisateur.setDateDeNaissance(new Date(2023, 06, 01));
              utulisateur.setEmail("anagkazo@gmail.com");
              utulisateur.setNom("ANAGKAZO");
              utulisateur.setAdresse(null);
              utulisateur.setEntreprise(entrepriseRs);
              utulisateur.setMoteDePasse(passwordEncoder.encode("Anagkazo2023*"));
              utilisateurRs = utilisateurRepository.save(utulisateur);
          }

          if (roleRepository.findAll().isEmpty()) {
              Roles role = new Roles();
              role.setRoleName("ADMIN");
              role.setUtilisateur(utilisateurRs);
              role.setCreationDate(new Date());
              role.setLastModifiedDate(new Date());
              roleRepository.save(role);
          }
/*
              if (donneeRepository.findAll().isEmpty()) {
                  Donnee donnee = new Donnee(
                          "test",
                          Constants.FICHIER_REPERTOIRE + "test.mp3",
                          new Date(),
                          4L,
                          "mp3"
                  );
                  Donnee donnee1 = new Donnee(
                          "test1",
                          Constants.FICHIER_REPERTOIRE + "test1.mp3",
                          new Date(),
                          4L,
                          "mp3"
                  );
                  Donnee donnee2 = new Donnee(
                          "test2",
                          Constants.FICHIER_REPERTOIRE + "test2.mp3",
                          new Date(),
                          4L,
                          "mp3"
                  );
                  Donnee donnee3 = new Donnee(
                          "test3",
                          Constants.FICHIER_REPERTOIRE + "test3.mp3",
                          new Date(),
                          4L,
                          "mp3"
                  );
                  Donnee donnee4 = new Donnee(
                          "test4",
                          Constants.FICHIER_REPERTOIRE + "test4.mp3",
                          new Date(),
                          4L,
                          "mp3"
                  );
                  Donnee donnee5 = new Donnee(
                          "test5",
                          "https://youtu.be/F2fiVmf8N9g",
                          new Date(),
                          4L,
                          "mp4"
                  );
                  Donnee donnee6 = new Donnee(
                          "gallery-1",
                          Constants.FICHIER_REPERTOIRE + "gallery-1.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee7 = new Donnee(
                          "gallery-2",
                          Constants.FICHIER_REPERTOIRE + "gallery-2.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee8 = new Donnee(
                          "gallery-3",
                          Constants.FICHIER_REPERTOIRE + "gallery-3.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee9 = new Donnee(
                          "gallery-4",
                          Constants.FICHIER_REPERTOIRE + "gallery-4.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee10 = new Donnee(
                          "gallery-5",
                          Constants.FICHIER_REPERTOIRE + "gallery-5.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee11 = new Donnee(
                          "gallery-6",
                          Constants.FICHIER_REPERTOIRE + "gallery-6.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  Donnee donnee12 = new Donnee(
                          "gallery-7",
                          Constants.FICHIER_REPERTOIRE + "gallery-7.jpg",
                          new Date(),
                          2L,
                          "jpg"
                  );
                  List<Donnee> listDonnee = new ArrayList<>();
                  listDonnee.add(donnee);
                  listDonnee.add(donnee1);
                  listDonnee.add(donnee2);
                  listDonnee.add(donnee3);
                  listDonnee.add(donnee4);
                  listDonnee.add(donnee5);
                  listDonnee.add(donnee6);
                  listDonnee.add(donnee7);
                  listDonnee.add(donnee8);
                  listDonnee.add(donnee9);
                  listDonnee.add(donnee10);
                  listDonnee.add(donnee11);
                  listDonnee.add(donnee12);
                  listDonnee.forEach(donnees -> donneeRepository.save(donnees));
              }

              if (galerieRepository.findAll().isEmpty()) {
                  Galerie galerie = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-1").get()
                  );
                  Galerie galerie1 = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-2").get()
                  );
                  Galerie galerie2 = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-3").get()
                  );
                  Galerie galerie3 = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-4").get()
                  );
                  Galerie galerie4 = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-5").get()
                  );
                  Galerie galerie5 = new Galerie(
                          "",
                          donneeRepository.findByFormatAndFileName("jpg", "gallery-6").get()
                  );

                  List<Galerie> listGalerie = new ArrayList<>();
                  listGalerie.add(galerie);
                  listGalerie.add(galerie1);
                  listGalerie.add(galerie2);
                  listGalerie.add(galerie3);
                  listGalerie.add(galerie4);
                  listGalerie.add(galerie5);

                  listGalerie.forEach(galeries -> galerieRepository.save(galeries));
              }

              if (typeEnseignementRepository.findAll().isEmpty()) {
                  TypeEnseignement typeEnseignement = new TypeEnseignement(
                          "Thématique", ""
                  );
                  TypeEnseignement typeEnseignement1 = new TypeEnseignement(
                          "Bible", ""
                  );
                  List<TypeEnseignement> listTypeEnseignement = new ArrayList<>();
                  listTypeEnseignement.add(typeEnseignement);
                  listTypeEnseignement.add(typeEnseignement1);
                  listTypeEnseignement.forEach(typeEnseignements -> typeEnseignementRepository.save(typeEnseignements));
              }

              if (titreMessageRepository.findAll().isEmpty()) {
                  TitreMessage titreMessage = new TitreMessage(
                          "LA LUMIERE SUR LA VOLONTE DE DIEU",
                          ""
                  );
                  TitreMessage titreMessage1 = new TitreMessage(
                          "LA GRACE DE DIEU",
                          ""
                  );
                  TitreMessage titreMessage2 = new TitreMessage(
                          "HUMILITE",
                          ""
                  );
                  TitreMessage titreMessage3 = new TitreMessage(
                          "ENLEVE TES IDOLES",
                          ""
                  );
                  TitreMessage titreMessage4 = new TitreMessage(
                          "LA DELIVRANCE DE LA PEUR",
                          ""
                  );
                  TitreMessage titreMessage5 = new TitreMessage(
                          "ACTIONS DE GRACES",
                          ""
                  );
                  TitreMessage titreMessage6 = new TitreMessage(
                          "LA MONTAGNE DE DIEU",
                          ""
                  );
                  TitreMessage titreMessage7 = new TitreMessage(
                          "LA CHARITE",
                          ""
                  );
                  TitreMessage titreMessage8 = new TitreMessage(
                          "LA SANCTIFICATION",
                          ""
                  );
                  TitreMessage titreMessage9 = new TitreMessage(
                          "LE PROTOCOLE CELESTE",
                          ""
                  );

                  List<TitreMessage> listTitreMessage = new ArrayList<>();
                  listTitreMessage.add(titreMessage);
                  listTitreMessage.add(titreMessage1);
                  listTitreMessage.add(titreMessage2);
                  listTitreMessage.add(titreMessage3);
                  listTitreMessage.add(titreMessage4);
                  listTitreMessage.add(titreMessage5);
                  listTitreMessage.add(titreMessage6);
                  listTitreMessage.add(titreMessage7);
                  listTitreMessage.add(titreMessage8);
                  listTitreMessage.add(titreMessage9);
                  listTitreMessage.forEach(titreMessages -> titreMessageRepository.save(titreMessages));
              }

              if (typeEmissionRepository.findAll().isEmpty()) {
                  TypeEmission typeEmission = new TypeEmission(
                          "Les témoignages", ""
                  );
                  TypeEmission typeEmission1 = new TypeEmission(
                          "ANAKAGZO", ""
                  );
                  TypeEmission typeEmission2 = new TypeEmission(
                          "Bible", ""
                  );
                  List<TypeEmission> listTypeEmission = new ArrayList<>();
                  listTypeEmission.add(typeEmission);
                  listTypeEmission.add(typeEmission1);
                  listTypeEmission.add(typeEmission2);
                  listTypeEmission.forEach(typeEmissions -> typeEmissionRepository.save(typeEmissions));
              }

              if (enseignementRepository.findAll().isEmpty()) {
                  Enseignement enseignement = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp3", "test").get(),
                          typeEmissionRepository.findByIntitule("Les témoignages").get(),
                          titreMessageRepository.findByIntitule("HUMILITE").get(),
                          typeEnseignementRepository.findByIntitule("Bible").get()
                  );

                  Enseignement enseignement1 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                          typeEmissionRepository.findByIntitule("ANAKAGZO").get(),
                          titreMessageRepository.findByIntitule("ACTIONS DE GRACES").get(),
                          typeEnseignementRepository.findByIntitule("Thématique").get()
                  );

                  Enseignement enseignement2 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp4", "test5").get(),
                          typeEmissionRepository.findByIntitule("Les témoignages").get(),
                          titreMessageRepository.findByIntitule("ENLEVE TES IDOLES").get(),
                          typeEnseignementRepository.findByIntitule("Thématique").get()
                  );

                  Enseignement enseignement3 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp3", "test").get(),
                          typeEmissionRepository.findByIntitule("ANAKAGZO").get(),
                          titreMessageRepository.findByIntitule("LA MONTAGNE DE DIEU").get(),
                          typeEnseignementRepository.findByIntitule("Bible").get()
                  );


                  Enseignement enseignement4 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp3", "test").get(),
                          typeEmissionRepository.findByIntitule("ANAKAGZO").get(),
                          titreMessageRepository.findByIntitule("LA CHARITE").get(),
                          typeEnseignementRepository.findByIntitule("Bible").get()
                  );

                  Enseignement enseignement5 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp4", "test5").get(),
                          typeEmissionRepository.findByIntitule("Bible").get(),
                          titreMessageRepository.findByIntitule("LA SANCTIFICATION").get(),
                          typeEnseignementRepository.findByIntitule("Thématique").get()
                  );

                  Enseignement enseignement6 = new Enseignement(
                          "",
                          false,
                          donneeRepository.findByFormatAndFileName("mp4", "test5").get(),
                          typeEmissionRepository.findByIntitule("ANAKAGZO").get(),
                          titreMessageRepository.findByIntitule("LE PROTOCOLE CELESTE").get(),
                          typeEnseignementRepository.findByIntitule("Bible").get()
                  );

                  List<Enseignement> listEnseignement = new ArrayList<>();
                  listEnseignement.add(enseignement);
                  listEnseignement.add(enseignement1);
                  listEnseignement.add(enseignement2);
                  listEnseignement.add(enseignement3);
                  listEnseignement.add(enseignement4);
                  listEnseignement.add(enseignement5);
                  listEnseignement.add(enseignement6);

                  //  listEnseignement.forEach(enseignements -> System.out.println(enseignements));
                  listEnseignement.forEach(enseignements -> enseignementRepository.save(enseignements));

              }

          if (emissionRepository.findAll().isEmpty()) {
              Emission emission = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("Les témoignages").get()
              );
              Emission emission1 = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("ANAKAGZO").get()
              );
              Emission emission2 = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("ANAKAGZO").get()
              );
              Emission emission3 = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("ANAKAGZO").get()
              );
              Emission emission4 = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("ANAKAGZO").get()
              );
              Emission emission5 = new Emission(
                      "",
                      false,
                      new Date(),
                      donneeRepository.findByFormatAndFileName("mp3", "test1").get(),
                      typeEmissionRepository.findByIntitule("ANAKAGZO").get()
              );
              List<Emission> listEmission = new ArrayList<>();
              listEmission.add(emission);
              listEmission.add(emission1);
              listEmission.add(emission2);
              listEmission.add(emission3);
              listEmission.add(emission4);
              listEmission.add(emission5);

              listEmission.forEach(emissions -> emissionRepository.save(emissions));
          }

          if (moisRepository.findAll().isEmpty()) {
              Mois janvier = new Mois("JANVIER");
              Mois fevrier = new Mois("FEVRIER");
              Mois mars = new Mois("MARS");
              Mois avril = new Mois("AVRIL");
              Mois mai = new Mois("MAI");
              Mois juin = new Mois("JUIN");
              Mois juillet = new Mois("JUILLET");
              Mois aout = new Mois("AOUT");
              Mois septembre = new Mois("SEPTEMBRE");
              Mois octobre = new Mois("OCTOBRE");
              Mois novembre = new Mois("NOVEMBRE");
              Mois decembre = new Mois("DECEMBRE");

              List<Mois> listMois = new ArrayList<>();
              listMois.add(janvier);
              listMois.add(fevrier);
              listMois.add(mars);
              listMois.add(avril);
              listMois.add(mai);
              listMois.add(juin);
              listMois.add(juillet);
              listMois.add(aout);
              listMois.add(septembre);
              listMois.add(octobre);
              listMois.add(novembre);
              listMois.add(decembre);
              listMois.forEach(mois -> moisRepository.save(mois));
          }

          if (anneeRepository.findAll().isEmpty()) {
              Annee un = new Annee("2022");
              Annee deux = new Annee("2023");
              Annee trois = new Annee("2024");
              Annee quatre = new Annee("2025");
              Annee cinq = new Annee("2026");
              Annee six = new Annee("2027");
              Annee sept = new Annee("2028");
              Annee huit = new Annee("2029");
              Annee dix = new Annee("2030");

              List<Annee> listAnnee = new ArrayList<>();
              listAnnee.add(un);
              listAnnee.add(deux);
              listAnnee.add(trois);
              listAnnee.add(quatre);
              listAnnee.add(cinq);
              listAnnee.add(six);
              listAnnee.add(sept);
              listAnnee.add(huit);
              listAnnee.add(dix);
              listAnnee.forEach(annee -> anneeRepository.save(annee));
          }


          if (archivreRepository.findAll().isEmpty()) {
              Archivre archivre = new Archivre(
                      new Date(),
                      emissionRepository.findById(1).get(),
                      enseignementRepository.findById(2).get(),
                      moisRepository.findById(1).get(),
                      anneeRepository.findById(1).get(),
                      donneeRepository.findById(2).get()
              );
              Archivre archivre1 = new Archivre(
                      new Date(),
                      emissionRepository.findById(2).get(),
                      enseignementRepository.findById(2).get(),
                      moisRepository.findById(2).get(),
                      anneeRepository.findById(2).get(),
                      donneeRepository.findById(2).get()
              );
              List<Archivre> listArchivre = new ArrayList<>();
              listArchivre.add(archivre);
              listArchivre.add(archivre1);

              listArchivre.forEach(archivres -> archivreRepository.save(archivres));
          }
      }
   }*/
      }
   }

    //@Scheduled(fixedDelay = 60000)
    @Scheduled(cron = "0 0 9-17 * * MON-FRI")
    public void run() throws MessagingException {
        mailSenderService.sendEmailWithAttachment();
    }
}
