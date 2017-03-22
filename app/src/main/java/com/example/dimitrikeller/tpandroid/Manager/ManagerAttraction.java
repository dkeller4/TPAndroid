package com.example.dimitrikeller.tpandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.Voyageur;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;


import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerAttraction {

    public static String ATTRACTION_ID = "idAttraction";
    public static String ATTRACTION_NOM = "nom";
    public static String ATTRACTION_DESCRIPTION = "description";
    public static String ATTRACTION_DUREE = "duree";
    public static String ATTRACTION_VILLE = "ville";
    public static String ATTRACTION_TELEPHONE ="telephone";
    public static String ATTRACTION_WEB ="web";
    public static String ATTRACTION_GRATUIT = "gratuit";
    public static String ATTRACTION_IMG = "ressImgAtt";
    public static String ATTRACTION_TABLE = "Attraction";

    public static String ATTRACTION_TABLE_CREATE = "create table " + ATTRACTION_TABLE + "(" +
            ATTRACTION_ID + " INTEGER PRIMARY KEY, "+
            ATTRACTION_NOM + " TEXT, "+
            ATTRACTION_DESCRIPTION+ " TEXT, "+
            ATTRACTION_DUREE+ " TEXT, "+
            ATTRACTION_VILLE + " TEXT, "+
            ATTRACTION_TELEPHONE + " TEXT, "+
            ATTRACTION_WEB + " TEXT, "+
            ATTRACTION_GRATUIT + " TEXT, "+
            ATTRACTION_IMG + " TEXT); ";

    public static String queryINSERT =
          "INSERT INTO `Attraction` (idAttraction,nom,description,duree,ville,telephone,web,gratuit,ressImgAtt) VALUES (1,'Bundestag','Monuments','2 à 3 heures','Berlin','+49 30 22732152','http://www.bundestag.de/en/','oui','R.drawable.att_reichstag'),\n" +
                  " (2,'Englischer Garten','Nature','Plus de 3 heures','Munich','+49 89 38666390','http://www.muenchen.de/sehenswuerdigkeiten/orte/120242.html','oui','R.drawable.att_englischer_garten'),\n" +
                  " (3,'Miniatur Wunderland','Musée','Plus de 3 heures','Hambourg','+49 40 3006800','http://www.miniatur-wunderland.de/','non','R.drawable.att_miniatur_wunderland'),\n" +
                  " (4,'Frauenkirche','Monuments','Moins d''une heure','Dresde','+49 35 165606100','http://www.frauenkirche-dresden.de/startseite/','oui','R.drawable.att_frauenkirche'),\n" +
                  " (5,'Koelner Zoo','Zoo','2 à 3 heures','Cologne','+49 180 5 280101','http://www.koelnerzoo.de/','non','R.drawable.att_zoo'),\n" +
                  " (6,'Sydney Opera House','Spectacle','Une à deux heures','Sydney','+61 2 9250 7111','https://www.sydneyoperahouse.com/','non','R.drawable.att_opera_house'),\n" +
                  " (7,'Surfer''s Paradise Beach','Sport','Infini','Surfers Paradise','+61 7 5539 9299','http://www.surfersparadise.com/about/beach-and-weather-info/surfers-paradise-beach','oui','R.drawable.att_surfer_paradise'),\n" +
                  " (8,'Royal Botanic Gardens','Nature','Une à deux heures','Melbourne','+61 3 9252 2300','https://www.rbg.vic.gov.au/','oui','R.drawable.att_royal_botanic_gardens'),\n" +
                  " (9,'Lone Pine Koala Sanctuary','Zoo','Plus de 3 heures','Brisbane','+61 7 3378 1366','http://www.koala.net/','non','R.drawable.att_koala'),\n" +
                  " (10,'Cairns Esplanade Swimming Lagoon','Plage','Infini','Cairns','+61 7 4044 3715','http://www.cairns.qld.gov.au/esplanade/facilities/lagoon','non','R.drawable.att_cairns'),\n" +
                  " (11,'Grand-Place','Histoire','Plus de 3 heures','Bruxelles','00 32 (0)2 279 43 65','http://www.brussels.info/grand-place/','oui','R.drawable.att_grande_place'),\n" +
                  " (12,'Grote Markt van Antwerpen','Histoire','Une à deux heures','Anvers','215474845','http://www.visitantwerpen.be/fr','oui','R.drawable.att_grote_markt'),\n" +
                  " (13,'De Halve Maan Brewery','Brasserie','Une à deux heures','Bruges','+32 50 44 42 22','http://www.halvemaan.be/en/home','non','R.drawable.att_brasserie'),\n" +
                  " (14,'Ghent City Center','Histoire','Une à deux heures','Gand','+32 9 264 83 03','https://visit.gent.be/en/home','oui','R.drawable.att_ghent_city_center'),\n" +
                  " (15,'Coteaux de la Citadelle','Histoire','Une à deux heures','Liège','+32 4 221 93 67','http://www.lanocturnedescoteaux.eu/fr/la_nocturne_coteaux_liege.php','oui','R.drawable.att_coteaux_de_la_citadelle'),\n" +
                  " (16,'Statue du Christ Rédempteur','Monuments','Moins d''une heure','Rio de Janeiro','(21) 2491-1700','http://www.parquedatijuca.com.br/#atracao?id=1','non','R.drawable.att_statue_christ'),\n" +
                  " (17,'Mini Mundo','Parc','Une à deux heures','Gramado','+55(54)3286-4055','http://www.minimundo.com.br/','non','R.drawable.att_mini_mundo'),\n" +
                  " (18,'Duna do Por do Sol','Nature','Infini','Jericoacoara','8633230541','http://www.jericoacoarabeach.com.br/','oui','R.drawable.att_duna'),\n" +
                  " (19,'Natural Pools of Porto de Galinhas','Nature','2 à 3 heures','Galinhas','81-9442-7826','https://www.facebook.com/catamaraaguaviva','non','R.drawable.att_natural_pool'),\n" +
                  " (20,'Parc d Ibirapuera','Nature','Plus de 3 heures','Sao Paulo','+55 11 5574 5045','http://parqueibirapuera.org/','non','R.drawable.att_parque_do_ibirapuera'),\n" +
                  " (21,'Stanley Park','Parc','2 à 3 heures','Vancouver','+1 604-681-5115','http://vancouver.ca/parks-recreation-culture/stanley-park.aspx','oui','R.drawable.att_stanley'),\n" +
                  " (22,'Vieux-Québec','Histoire','2 à 3 heures','Québec','4182625515','http://whc.unesco.org/en/list/300','oui','R.drawable.att_quebec'),\n" +
                  " (23,'Basilique Notre-Dame de Montréal','Histoire','2 à 3 heures','Montréal','+1 514-842-2925','http://www.basiliquenddm.org/en/','non','R.drawable.att_notre_dame_basilique'),\n" +
                  " (24,'Tour CN','Monuments','Une à deux heures','Toronto','+1 416-868-6937','http://www.cntower.ca/intro.html','non','R.drawable.att_cn_tower'),\n" +
                  " (25,'Niagara Falls','Nature','2 à 3 heures','Niagara Falls','+1 877-642-7275','https://www.niagarafallstourism.com/','non','R.drawable.att_niagara'),\n" +
                  " (26,'Victoria Peak','Monuments','2 à 3 heures','Hong Kong','852-28497654','http://www.thepeak.com.hk/tc/home.asp','non','R.drawable.att_victoria_peak_views'),\n" +
                  " (27,'Grande Muraille de Mutianyu','Monuments','Plus de 3 heures','Beijing','+86 10 6162 6022','http://www.mutianyugreatwall.com/','non','R.drawable.att_the_wall_at_mutianyu'),\n" +
                  " (28,'Le Bund','Histoire','2 à 3 heures','Shanghai','+86 10 6862 3004','https://www.travelchinaguide.com/attraction/shanghai/bund.htm','oui','R.drawable.att_le_bund'),\n" +
                  " (29,'Historic Centre of Macau','Histoire','2 à 3 heures','Macau','0753152081','http://www.macauheritage.net/wh/mhfileE.asp','oui','R.drawable.att_senada_square'),\n" +
                  " (30,'Mausolée de l empereur Qin','Musée','Une à deux heures','Xian','+86 29 8139 9127','http://www.bmy.com.cn/','non','R.drawable.att_soldat'),\n" +
                  " (31,'Makadi Water World','Parc','Infini','Hurghada','+20 120 565 6543','https://fr.tripadvisor.ca/Attraction_Review-g297549-d2324325-Reviews-Makadi_Water_World-Hurghada_Red_Sea_and_Sinai.html','non','R.drawable.att_makadi_water_world'),\n" +
                  " (32,'Pyramide de Khéops','Histoire','Infini','Le Caire','','https://fr.tripadvisor.ca/Attraction_Review-g294201-d553185-Reviews-Keops_Pyramid-Cairo_Cairo_Governorate.html','non','R.drawable.att_pyramid'),\n" +
                  " (33,'Temple de Karnak','Histoire','Infini','Louxor','+20 100 016 1564','https://fr.tripadvisor.ca/Attraction_Review-g294205-d459885-Reviews-Temple_of_Karnak-Luxor_Nile_River_Valley.html','non','R.drawable.att_temple_of_karnak'),\n" +
                  " (34,'Marsa Mubarak','Nature','Infini','Marsa Alam','','https://fr.tripadvisor.ca/Attraction_Review-g311425-d1946585-Reviews-Marsa_Mubarak-Marsa_Alam_Red_Sea_and_Sinai.html','oui','R.drawable.att_marsa'),\n" +
                  " (35,'Zeytuna Beach','Nature','Infini','El Gouna','','https://fr.tripadvisor.ca/Attraction_Review-g297548-d546092-Reviews-Zeytuna_Beach-El_Gouna_Hurghada_Red_Sea_and_Sinai.html','oui','R.drawable.att_gouna'),\n" +
                  " (36,'Central Park','Parc','Plus de 3 heures','New-Yorl','(212) 310-6600','http://www.centralparknyc.org/','oui','R.drawable.att_central_park'),\n" +
                  " (37,'Red Rock Canyon National Conservation Area','Nature','2 à 3 heures','Las Vegas','+1 702-515-5350','http://www.redrockcanyonlv.org/','non','R.drawable.att_canyon'),\n" +
                  " (38,'The Wizarding World of Harry Potter','Parc Attraction','Plus de 3 heures','Orlando','+1 407-363-8000','https://www.universalorlando.com/','non','R.drawable.att_orlando'),\n" +
                  " (39,'Institut d art de Chicago','Musée','2 à 3 heures','Chicago','+1 312-443-3600','http://www.artic.edu/','non','R.drawable.att_chicago_art'),\n" +
                  " (40,'Île d Alcatraz','Histoire','2 à 3 heures','San Francisco','415 981 7625','https://www.nps.gov/alca/index.htm','non','R.drawable.att_alcatraz'),\n" +
                  " (41,'Musée d''Orsay','Musée','Plus de 3 heures','Paris','+33 1 40 49 48 14','http://www.musee-orsay.fr/','non','R.drawable.att_musee_orsay'),\n" +
                  " (42,'Vieille Ville de Nice','Histoire','Plus de 3 heures','Nice','625632830','https://fr.tripadvisor.ca/Attraction_Review-g187234-d254286-Reviews-Old_Town_Vieille_Ville-Nice_French_Riviera_Cote_d_Azur_Provence.html','oui','R.drawable.att_nice'),\n" +
                  " (43,'Basilique Notre-Dame de Fourvière','Histoire','Une à deux heures','Lyon','+33 4 78 25 13 01','http://www.fourviere.org/fr_FR/','oui','R.drawable.att_lyon'),\n" +
                  " (44,'Place de la Bourse','Monuments','Une à deux heures','Bordeaux','','http://www.bordeaux.fr/l3293','oui','R.drawable.att_bordeaux'),\n" +
                  " (45,'Parc National des Calanques','Parc','Une à deux heures','Marseille','+33 4 91 33 36 79','http://www.calanques-parcnational.fr/fr','oui','R.drawable.att_marseille'),\n" +
                  " (46,'Colisée','Histoire','2 à 3 heures','Rome','(+39) 06 39967700','http://archeoroma.beniculturali.it/en/archaeological-site/colosseum','non','R.drawable.att_rome'),\n" +
                  " (47,'Le Duomo','Monuments','Moins d''une heure','Florence','+39 055 230 2885','https://www.ilgrandemuseodelduomo.it/','oui','R.drawable.att_florence'),\n" +
                  " (48,'Palazzo Ducale','Musée','2 à 3 heures','Venise','+39 041 271 5911','http://palazzoducale.visitmuve.it/','oui','R.drawable.att_palazzo_ducale'),\n" +
                  " (49,'Basilica San Nicola','Histoire','Plus de 3 heures','Bari','+39 080 573 7111','http://www.basilicasannicola.it/','oui','R.drawable.att_bari'),\n" +
                  " (50,'Grotte de Neptune','Nature','2 à 3 heures','Alghero','+39 079 976202','http://www.grottedinettuno.it/index.php','non','R.drawable.att_alghero'),\n" +
                  " (51,'Akihabara','Technologie','Infini','Tokyo','+81 80-3604-3373','https://fr.tripadvisor.ca/Attraction_Review-g1066443-d321038-Reviews-Akihabara-Chiyoda_Tokyo_Tokyo_Prefecture_Kanto.html','oui','R.drawable.att_tokyo'),\n" +
                  " (52,'Temple du Pavillon d or','Histoire','Une à deux heures','Kyoto','+81 75-461-0013','http://www.shokoku-ji.jp/k_about.html','non','R.drawable.att_kyoto'),\n" +
                  " (53,'Osaka Aquarium Kaiyukan','Zoo','2 à 3 heures','Osaka','+81 6-6576-5501','http://www.kaiyukan.com/','non','R.drawable.att_osaka'),\n" +
                  " (54,'Le parc Moerenuma','Parc','2 à 3 heures','Sapporo','+81 11-790-1231','http://moerenumapark.jp/','oui','R.drawable.att_sapporo'),\n" +
                  " (55,'Mémorial de la paix d Hiroshima','Musée','2 à 3 heures','Hiroshima','+81 82-241-4004','http://www.pcf.city.hiroshima.jp/','non','R.drawable.att_hiroshima');";



    public static String DROP_ATTRACTION_TABLE = "drop table if exists " + ATTRACTION_TABLE;

    public static String queryGetAll = "select * from "+ ATTRACTION_TABLE;


    public static ArrayList<Attraction> getAll(Context ctx){
        ArrayList<Attraction> listeAttraction = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Attraction e = new Attraction();
            e.setIdAttraction((c.getInt(0)));
            e.setNom(c.getString(1));
            e.setDescription(c.getString(2));
            e.setDuree(c.getString(3));
            e.setVille(c.getString(4));
            e.setTelephone(c.getString(5));
            e.setWeb(c.getString(6));
            e.setGratuit(c.getString(7));
            e.setRessImgAttraction(c.getString(8));

            listeAttraction.add(e);
        }

        c.close();
        ConnexionBD.close();

        return listeAttraction;
    }

    public static Attraction getById(Context ctx, int idCompare){

        ArrayList<Attraction> listeAttraction = getAll(ctx);

        Attraction retour = null;
        for (Attraction a :
                listeAttraction) {
            if(a.getIdAttraction() == idCompare)
                retour = a;
        }
        return  retour;
    }


/* Méthode de modification de la base de données

    //Ajout
    public static long add(Attraction entiteToAdd, Context ctx){
        long retour = -1;
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_ID, entiteToAdd.getIdAttraction());
        cv.put(ATTRACTION_NOM, entiteToAdd.getNom());
        cv.put(ATTRACTION_DESCRIPTION, entiteToAdd.getDescription());
        cv.put(ATTRACTION_DUREE, entiteToAdd.getDuree());
        cv.put(ATTRACTION_VILLE, entiteToAdd.getVille());
        cv.put(ATTRACTION_TELEPHONE, entiteToAdd.getTelephone());
        cv.put(ATTRACTION_WEB, entiteToAdd.getWeb());
        cv.put(ATTRACTION_GRATUIT, entiteToAdd.getGratuit());
        cv.put(ATTRACTION_IMG, entiteToAdd.getRessImgAttraction());


        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        retour = bd.insert(ATTRACTION_TABLE,null,cv);

        ConnexionBD.close();

        return retour;
    }

    //Supression

    public static void delete(int id, Context ctx){
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.delete(ATTRACTION_TABLE, ATTRACTION_ID + " = ?", new String[]{String.valueOf(id)});

    }

    // Modification

    public static void update(Attraction entite, Context ctx){
        ContentValues cv = new ContentValues();
        cv.put(ATTRACTION_ID, entite.getIdAttraction());
        cv.put(ATTRACTION_NOM, entite.getNom());
        cv.put(ATTRACTION_DESCRIPTION, entite.getDescription());
        cv.put(ATTRACTION_DUREE, entite.getDuree());
        cv.put(ATTRACTION_VILLE, entite.getVille());
        cv.put(ATTRACTION_TELEPHONE, entite.getTelephone());
        cv.put(ATTRACTION_WEB, entite.getWeb());
        cv.put(ATTRACTION_GRATUIT, entite.getGratuit());
        cv.put(ATTRACTION_IMG, entite.getIdAttraction());

        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        bd.update(ATTRACTION_TABLE, cv, ATTRACTION_ID + " = ?", new String[]{String.valueOf(entite.getIdAttraction())});

    }

*/

}
