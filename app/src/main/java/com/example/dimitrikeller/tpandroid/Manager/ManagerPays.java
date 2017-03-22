package com.example.dimitrikeller.tpandroid.Manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Pays;
import com.example.dimitrikeller.tpandroid.R;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerPays {

    public static String PAYS_ID = "idPays";
    public static String PAYS_NOM = "nom";
    public static String PAYS_POPULATION = "population";
    public static String PAYS_CONTINENT = "continent";
    public static String PAYS_CAPITALE = "capitale";
    public static String PAYS_DEVISE = "devise";
    public static String PAYS_IMG_DRAPEAU = "imgDrapeau";
    public static String PAYS_IMG_PAYS ="imgPays";
    public static String PAYS_TABLE = "pays";

    public static String PAYS_TABLE_CREATE = "create table " + PAYS_TABLE + "(" +
            PAYS_ID + " INTEGER PRIMARY KEY, " +
            PAYS_NOM + " TEXT, " +
            PAYS_POPULATION + " INTEGER, " +
            PAYS_CONTINENT + " TEXT, "+
            PAYS_CAPITALE +  " TEXT, "+
            PAYS_DEVISE + " TEXT, "+
            PAYS_IMG_DRAPEAU + " TEXT, "+
            PAYS_IMG_PAYS + " TEXT);";

    public static String queryINSERT =
            "INSERT INTO `Pays` (idPays,nom,population,continent,capitale,devise,imgDrapeau,imgPays) VALUES (1,'Afghanistan',29121286,'Asie','Kaboul','Afghani','drap_afghanistan','R.drawable.pays_enconstruction1'),\n" +
            " (2,'Afrique du Sud',49000000,'Afrique','Pretoria','Rand','drap_south_africa','R.drawable.pays_enconstruction2'),\n" +
            " (3,'Albanie',2986952,'Europe','Tirana','Lek','drap_albania','R.drawable.pays_enconstruction4'),\n" +
            " (4,'Algérie',34586184,'Afrique','Alger','Dinar','drap_algeria','R.drawable.pays_enconstruction4'),\n" +
            " (5,'Allemagne',81802257,'Europe','Berlin','Euro','drap_germany','R.drawable.pays_allemagne'),\n" +
            " (6,'Andorre',84000,'Europe','Andorre-la-Vieille','Euro','drap_andorra','R.drawable.pays_enconstruction1'),\n" +
            " (7,'Angola',13068161,'Afrique','Luanda','Kwanza','drap_angola','R.drawable.pays_enconstruction2'),\n" +
            " (8,'Anguilla',13254,'Amérique centrale et Caraïbes','La vallée','Dollar','drap_anguilla','R.drawable.pays_enconstruction4'),\n" +
            " (9,'Antigua-et-Barbuda',86754,'Amérique centrale et Caraïbes','St. John''s','Dollar','drap_antigua_and_barbuda','R.drawable.pays_enconstruction1'),\n" +
            " (10,'Antilles néerlandaises',300000,'Amérique centrale et Caraïbes','Willemstad','Guilder','drap_netherlands_antilles','R.drawable.pays_enconstruction2'),\n" +
            " (11,'Arabie Saoudite',25731776,'Moyen-Orient','Riyad','Rial','drap_saudi_arabia','R.drawable.pays_enconstruction4'),\n" +
            " (12,'Argentine',41343201,'Amérique du sud','Buenos Aires','Peso','drap_argentina','R.drawable.pays_enconstruction1'),\n" +
            " (13,'Arménie',2968000,'Communauté des États indépendants','Yerevan','Dram','drap_armenia','R.drawable.pays_enconstruction2'),\n" +
            " (14,'Aruba',71566,'Amérique centrale et Caraïbes','Oranjestad','Guilder','drap_aruba','R.drawable.pays_enconstruction4'),\n" +
            " (15,'Australie',21515754,'Océanie','Canberra','Dollar','drap_australia','R.drawable.pays_australie'),\n" +
            " (16,'Autriche',8205000,'Europe','Vienne','Euro','drap_austria','R.drawable.pays_enconstruction1'),\n" +
            " (17,'Azerbaïdjan',8303512,'Communauté des États indépendants','Bakou','Manat','drap_azerbaijan','R.drawable.pays_enconstruction2'),\n" +
            " (18,'Bahamas',301790,'Amérique centrale et Caraïbes','Nassau','Dollar','drap_bahamas','R.drawable.pays_enconstruction4'),\n" +
            " (19,'Bahreïn',738004,'Moyen-Orient','Manama','Dinar','drap_bahrain','R.drawable.pays_enconstruction1'),\n" +
            " (20,'Bande de Gaza','','Moyen-Orient','','','drap_gaza_strip','R.drawable.pays_enconstruction2'),\n" +
            " (21,'Bangladesh',156118464,'Asie','Dhaka','Taka','drap_bangladesh','R.drawable.pays_enconstruction4'),\n" +
            " (22,'Banque de l''Ouest',3800000,'Moyen-Orient','Jérusalem Est','Shekel','drap_west_bank','R.drawable.pays_enconstruction1'),\n" +
            " (23,'Barbade',285653,'Amérique centrale et Caraïbes','Bridgetown','Dollar','drap_barbados','R.drawable.pays_enconstruction2'),\n" +
            " (24,'Belgique',10403000,'Europe','Bruxelles','Euro','drap_belgium','R.drawable.pays_belgique'),\n" +
            " (25,'Belize',314522,'Amérique centrale et Caraïbes','Belmopan','Dollar','drap_belize','R.drawable.pays_enconstruction1'),\n" +
            " (26,'Bénin',9056010,'Afrique','Porto-Novo','Franc','drap_benin','R.drawable.pays_enconstruction2'),\n" +
            " (27,'Bermudes',65365,'Amérique du Nord','Hamilton','Dollar','drap_bermuda','R.drawable.pays_enconstruction4'),\n" +
            " (28,'Bhoutan',699847,'Asie','Thimphu','Ngultrum','drap_bhutan','R.drawable.pays_enconstruction1'),\n" +
            " (29,'Biélorussie',9685000,'Communauté des États indépendants','Minsk','Ruble','drap_belarus','R.drawable.pays_enconstruction2'),\n" +
            " (30,'Birmanie',53414374,'Asie du sud est','Nay Pyi Taw','Kyat','drap_burma','R.drawable.pays_enconstruction4'),\n" +
            " (31,'Bolivie',9947418,'Amérique du sud','Sucre','Boliviano','drap_bolivia','R.drawable.pays_enconstruction1'),\n" +
            " (32,'Bosnie Herzégovine',4590000,'Europe','Sarajevo','Marka','drap_bosnia_and_herzegovina','R.drawable.pays_enconstruction2'),\n" +
            " (33,'Botswana',2029307,'Afrique','Gaborone','Pula','drap_botswana','R.drawable.pays_enconstruction4'),\n" +
            " (34,'Brésil',201103330,'Amérique du sud','Brasilia','Real','drap_brazil','R.drawable.pays_brésil'),\n" +
            " (35,'Brunei',395027,'Asie du sud est','Bandar Seri Begawan','Dollar','drap_brunei','R.drawable.pays_enconstruction1'),\n" +
            " (36,'Bulgarie',7148785,'Europe','Sofia','Lev','drap_bulgaria','R.drawable.pays_enconstruction2'),\n" +
            " (37,'Burkina Faso',16241811,'Afrique','Ouagadougou','Franc','drap_burkina_faso','R.drawable.pays_enconstruction4'),\n" +
            " (38,'Burundi',9863117,'Afrique','Bujumbura','Franc','drap_burundi','R.drawable.pays_enconstruction1'),\n" +
            " (39,'Cambodge',14453680,'Asie du sud est','Phnom Penh','Riels','drap_cambodia','R.drawable.pays_enconstruction2'),\n" +
            " (40,'Cameroun',19294149,'Afrique','Yaoundé','Franc','drap_cameroon','R.drawable.pays_enconstruction4'),\n" +
            " (41,'Canada',33679000,'Amérique du Nord','Ottawa','Dollar','drap_canada','R.drawable.pays_canada'),\n" +
            " (42,'Cap-Vert',508659,'Afrique','Praia','Escudo','drap_cape_verde','R.drawable.pays_enconstruction1'),\n" +
            " (43,'Chili',16746491,'Amérique du sud','Santiago','Peso','drap_chile','R.drawable.pays_enconstruction2'),\n" +
            " (44,'Chine',1330044000,'Asie','Pékin','Yuan Renminbi','drap_china','R.drawable.pays_chine'),\n" +
            " (45,'Chypre',1102677,'Moyen-Orient','Nicosie','Euro','drap_cyprus','R.drawable.pays_enconstruction1'),\n" +
            " (46,'Colombie',47790000,'Amérique du Sud','Bogota','Peso','drap_colombia','R.drawable.pays_enconstruction2'),\n" +
            " (47,'Comores',773407,'Afrique','Moroni','Franc','drap_comoros','R.drawable.pays_enconstruction4'),\n" +
            " (48,'Corée du Nord',22912177,'Asie','Pyongyang','Won','drap_north_korea','R.drawable.pays_enconstruction1'),\n" +
            " (49,'Corée du Sud',48422644,'Asie','Séoul','Won','drap_south_korea','R.drawable.pays_enconstruction2'),\n" +
            " (50,'Costa Rica',4516220,'Amérique centrale et Caraïbes','San Jose','Colon','drap_costa_rica','R.drawable.pays_enconstruction4'),\n" +
            " (51,'Côte d''Ivoire',21058798,'Afrique','Yamoussoukro','Franc','drap_cote_ivoire','R.drawable.pays_enconstruction1'),\n" +
            " (52,'Croatie',4284889,'Europe','Zagreb','Kuna','drap_croatia','R.drawable.pays_enconstruction2'),\n" +
            " (53,'Cuba',11423000,'Amérique centrale et Caraïbes','La Havane','Peso','drap_cuba','R.drawable.pays_enconstruction4'),\n" +
            " (54,'Danemark',5484000,'Europe','Copenhague','Krone','drap_denmark','R.drawable.pays_enconstruction1'),\n" +
            " (55,'Djibouti',740528,'Afrique','Djibouti','Franc','drap_djibouti','R.drawable.pays_enconstruction2'),\n" +
            " (56,'Dominique',72813,'Amérique centrale et Caraïbes','Roseau','Dollar','drap_dominica','R.drawable.pays_enconstruction4'),\n" +
            " (57,'Egypte',80471869,'Afrique','Caire','Pound','drap_egypt','R.drawable.pays_egypte'),\n" +
            " (58,'Emirats Arabes Unis',4975593,'Moyen-Orient','Abu Dhabi','Dirham','drap_united_arab_emirates','R.drawable.pays_enconstruction1'),\n" +
            " (59,'Équateur',14790608,'Amérique du sud','Quito','Dollar','drap_ecuador','R.drawable.pays_enconstruction2'),\n" +
            " (60,'Érythrée',5792984,'Afrique','Asmara','Nakfa','drap_eritrea','R.drawable.pays_enconstruction4'),\n" +
            " (61,'Espagne',46505963,'Europe','Madrid','Euro','drap_spain','R.drawable.pays_enconstruction1'),\n" +
            " (62,'Estonie',1291170,'Europe','Tallinn','Euro','drap_estonia','R.drawable.pays_enconstruction2'),\n" +
            " (63,'États-Unis',310232863,'Amérique du Nord','Washington','Dollar','drap_united_states','R.drawable.pays_etats_unis'),\n" +
            " (64,'Ethiopie',88013491,'Afrique','Addis Ababa','Birr','drap_ethiopia','R.drawable.pays_enconstruction1'),\n" +
            " (65,'Fidji',875983,'Océanie','Suva','Dollar','drap_fiji','R.drawable.pays_enconstruction2'),\n" +
            " (66,'Finlande',5244000,'Europe','Helsinki','Euro','drap_finland','R.drawable.pays_enconstruction4'),\n" +
            " (67,'France',64768389,'Europe','Paris','Euro','drap_france','R.drawable.pays_france'),\n" +
            " (68,'Gabon',1545255,'Afrique','Libreville','Franc','drap_gabon','R.drawable.pays_enconstruction1'),\n" +
            " (69,'Gambie',1593256,'Afrique','Banjul','Dalasi','drap_the_gambia','R.drawable.pays_enconstruction2'),\n" +
            " (70,'Géorgie',4630000,'Communauté des États indépendants','Tbilissi','Lari','drap_georgia','R.drawable.pays_enconstruction4'),\n" +
            " (71,'Ghana',24339838,'Afrique','Accra','Cedi','drap_ghana','R.drawable.pays_enconstruction1'),\n" +
            " (72,'Gibraltar',27884,'Europe','Gibraltar','Pound','drap_gibraltar','R.drawable.pays_enconstruction2'),\n" +
            " (73,'Grèce',11000000,'Europe','Athènes','Euro','drap_greece','R.drawable.pays_enconstruction4'),\n" +
            " (74,'Grenade',107818,'Amérique centrale et Caraïbes','Saint-George''s','Dollar','drap_grenada','R.drawable.pays_enconstruction1'),\n" +
            " (75,'Groenland',56375,'Région de l''Arctique','Nuuk','Krone','drap_greenland','R.drawable.pays_enconstruction2'),\n" +
            " (76,'Guadeloupe',443000,'Amérique centrale et Caraïbes','Basse-Terre','Euro','drap_guadeloupe','R.drawable.pays_enconstruction4'),\n" +
            " (77,'Guam',159358,'Océanie','Hagatna','Dollar','drap_guam','R.drawable.pays_enconstruction1'),\n" +
            " (78,'Guatemala',13550440,'Amérique centrale et Caraïbes','Guatemala City','Quetzal','drap_guatemala','R.drawable.pays_enconstruction2'),\n" +
            " (79,'Guernesey',65228,'Europe','St Peter Port','Pound','drap_guernsey','R.drawable.pays_enconstruction4'),\n" +
            " (80,'Guinée',10324025,'Afrique','Conakry','Franc','drap_guinea','R.drawable.pays_enconstruction1'),\n" +
            " (81,'Guinée Équatoriale',1014999,'Afrique','Malabo','Franc','drap_equatorial_guinea','R.drawable.pays_enconstruction2'),\n" +
            " (82,'Guinée Française',195506,'Amérique du sud','Cayenne','Euro','drap_french_polynesia','R.drawable.pays_enconstruction4'),\n" +
            " (83,'Guinée-Bissau',1565126,'Afrique','Bissau','Franc','drap_guinea_bissau','R.drawable.pays_enconstruction1'),\n" +
            " (84,'Guyane',748486,'Amérique du sud','Georgetown','Dollar','drap_guyana','R.drawable.pays_enconstruction2'),\n" +
            " (85,'Haïti',9648924,'Amérique centrale et Caraïbes','Port-au-Prince','Gourde','drap_haiti','R.drawable.pays_enconstruction4'),\n" +
            " (86,'Honduras',7989415,'Amérique centrale et Caraïbes','Tegucigalpa','Lempira','drap_honduras','R.drawable.pays_enconstruction1'),\n" +
            " (87,'Hong Kong',6898686,'Asie du sud est','Hong Kong','Dollar','drap_hong_kong','R.drawable.pays_enconstruction2'),\n" +
            " (88,'Hongrie',9982000,'Europe','Budapest','Forint','drap_hungary','R.drawable.pays_enconstruction4'),\n" +
            " (89,'Île de Mans',75049,'Europe','Douglas','Pound','drap_man_isle','R.drawable.pays_enconstruction1'),\n" +
            " (90,'Ile Maurice',1294104,'Afrique','Port Louis','Rupee','drap_mauritius','R.drawable.pays_enconstruction2'),\n" +
            " (91,'Île Norfolk',1828,'Océanie','Kingston','Dollar','drap_norfolk_island','R.drawable.pays_enconstruction4'),\n" +
            " (92,'Îles Caïmans',44270,'Afrique','George Town','Dollar','drap_cayman_islands','R.drawable.pays_enconstruction1'),\n" +
            " (93,'Îles Falkland',2638,'Amérique du sud','Stanley','Pound','drap_falkland_islands','R.drawable.pays_enconstruction2'),\n" +
            " (94,'Îles Féroé',48228,'Europe','Torshavn','Krone','drap_faroe_islands','R.drawable.pays_enconstruction4'),\n" +
            " (95,'Iles Marshall',65859,'Océanie','Majuro','Dollar','drap_marshall_islands','R.drawable.pays_enconstruction1'),\n" +
            " (96,'îles Turques et Caïques',20556,'Amérique centrale et Caraïbes','Cockburn Town','Dollar','drap_turks_and_aicos_islands','R.drawable.pays_enconstruction2'),\n" +
            " (97,'Îles Vierges britanniques',21730,'Amérique centrale et Caraïbes','Road Town','Dollar','drap_british_virgin_islands','R.drawable.pays_enconstruction4'),\n" +
            " (98,'Inde',1173108018,'Asie','New Delhi','Rupee','drap_india','R.drawable.pays_enconstruction1'),\n" +
            " (99,'Indonésie',242968342,'Asie du sud est','Jakarta','Rupiah','drap_indonesia','R.drawable.pays_enconstruction2'),\n" +
            " (100,'Irak',29671605,'Moyen-Orient','Bagdad','Dinar','drap_iraq','R.drawable.pays_enconstruction4'),\n" +
            " (101,'Iran',76923300,'Moyen-Orient','Téhéran','Rial','drap_iran','R.drawable.pays_enconstruction1'),\n" +
            " (102,'Irlande',4622917,'Europe','Dublin','Euro','drap_ireland','R.drawable.pays_enconstruction2'),\n" +
            " (103,'Islande',308910,'Région de l''Arctique','Reykjavik','Krona','drap_iceland','R.drawable.pays_enconstruction4'),\n" +
            " (104,'Israël',7353985,'Moyen-Orient','Jérusalem','Shekel','drap_israel','R.drawable.pays_enconstruction1'),\n" +
            " (105,'Italie',60340328,'Europe','Rome','Euro','drap_italy','R.drawable.pays_italie'),\n" +
            " (106,'Jamaïque',2847232,'Amérique centrale et Caraïbes','Kingston','Dollar','drap_jamaica','R.drawable.pays_enconstruction1'),\n" +
            " (107,'Japon',127288000,'Asie','Tokyo','Yen','drap_japan','R.drawable.pays_japon'),\n" +
            " (108,'Jersey',90812,'Europe','Saint Helier','Pound','drap_jersey','R.drawable.pays_enconstruction1'),\n" +
            " (109,'Jordan',6407085,'Moyen-Orient','Amman','Dinar','drap_jordan','R.drawable.pays_enconstruction2'),\n" +
            " (110,'Kazakhstan',15340000,'Communauté des États indépendants','Astana','Tenge','drap_kazakhstan','R.drawable.pays_enconstruction4'),\n" +
            " (111,'Kenya',40046566,'Afrique','Nairobi','Shilling','drap_kenya','R.drawable.pays_enconstruction1'),\n" +
            " (112,'Kirghizistan',5776500,'Communauté des États indépendants','Bishkek','Som','drap_kyrgyzstan','R.drawable.pays_enconstruction2'),\n" +
            " (113,'Kiribati',92533,'Océanie','Tarawa','Dollar','drap_kiribati','R.drawable.pays_enconstruction4'),\n" +
            " (114,'Koweit',2789132,'Moyen-Orient','Kuwait City','Dinar','drap_kuwait','R.drawable.pays_enconstruction1'),\n" +
            " (115,'Laos',6368162,'Asie du sud est','Vientiane','Kip','drap_laos','R.drawable.pays_enconstruction2'),\n" +
            " (116,'Le Salvador',6052064,'Amérique centrale et Caraïbes','San Salvador','Dollar','drap_el_salvador','R.drawable.pays_enconstruction4'),\n" +
            " (117,'les Îles Cook',21388,'Océanie','Avarua','Dollar','drap_cook_islands','R.drawable.pays_enconstruction1'),\n" +
            " (118,'Les îles Salomon',559198,'Océanie','Honiara','Dollar','drap_solomon_islands','R.drawable.pays_enconstruction2'),\n" +
            " (119,'Les iles vierges',108708,'Amérique centrale et Caraïbes','Charlotte Amalie','Dollar','drap_virgin_islands','R.drawable.pays_enconstruction4'),\n" +
            " (120,'Les Seychelles',88340,'Afrique','Victoria','Rupee','drap_seychelles','R.drawable.pays_enconstruction1'),\n" +
            " (121,'Lesotho',1919552,'Afrique','Maseru','Loti','drap_lesotho','R.drawable.pays_enconstruction2'),\n" +
            " (122,'Lettonie',2217969,'Europe','Riga','Euro','drap_latvia','R.drawable.pays_enconstruction4'),\n" +
            " (123,'Liban',4125247,'Moyen-Orient','Beyrouth','Pound','drap_lebanon','R.drawable.pays_enconstruction1'),\n" +
            " (124,'Libéria',3685076,'Afrique','Monrovia','Dollar','drap_liberia','R.drawable.pays_enconstruction2'),\n" +
            " (125,'Libye',6461454,'Afrique','Tripoli','Dinar','drap_libya','R.drawable.pays_enconstruction4'),\n" +
            " (126,'Liechtenstein',35000,'Europe','Vaduz','Franc','drap_liechtenstein','R.drawable.pays_enconstruction1'),\n" +
            " (127,'L''île de noël','','Asie du sud est','','','drap_christmas_island','R.drawable.pays_enconstruction2'),\n" +
            " (128,'Lituanie',2944459,'Europe','Vilnius','Euro','drap_lithuania','R.drawable.pays_enconstruction4'),\n" +
            " (129,'Luxembourg',497538,'Europe','Luxembourg','Euro','drap_luxembourg','R.drawable.pays_enconstruction1'),\n" +
            " (130,'Macao',449198,'Asie du sud est','Macao','Pataca','drap_macao','R.drawable.pays_enconstruction2'),\n" +
            " (131,'Macédoine',2062294,'Europe','Skopje','Denar','drap_macedonia','R.drawable.pays_enconstruction4'),\n" +
            " (132,'Madagascar',21281844,'Afrique','Antananarivo','Ariary','drap_madagascar','R.drawable.pays_enconstruction1'),\n" +
            " (133,'Malaisie',28274729,'Asie du sud est','Kuala Lumpur','Ringgit','drap_malaysia','R.drawable.pays_enconstruction2'),\n" +
            " (134,'Malawi',15447500,'Afrique','Lilongwe','Kwacha','drap_malawi','R.drawable.pays_enconstruction4'),\n" +
            " (135,'Maldives',395650,'Asie','Mâle','Rufiyaa','drap_maldives','R.drawable.pays_enconstruction1'),\n" +
            " (136,'Mali',13796354,'Afrique','Bamako','Franc','drap_mali','R.drawable.pays_enconstruction2'),\n" +
            " (137,'Malte',403000,'Europe','La Valette','Euro','drap_malta','R.drawable.pays_enconstruction4'),\n" +
            " (138,'Maroc',33848242,'Afrique','Rabat','Dirham','drap_morocco','R.drawable.pays_enconstruction1'),\n" +
            " (139,'Martinique',432900,'Amérique centrale et Caraïbes','Fort-de-France','Euro','drap_martinique','R.drawable.pays_enconstruction2'),\n" +
            " (140,'Mauritanie',3205060,'Afrique','Nouakchott','Ouguiya','drap_mauritania','R.drawable.pays_enconstruction4'),\n" +
            " (141,'Mayotte',159042,'Afrique','Mamoudzou','Euro','drap_mayotte','R.drawable.pays_enconstruction1'),\n" +
            " (142,'Mexique',112468855,'Amérique du Nord','Mexique Ville','Peso','drap_mexico','R.drawable.pays_enconstruction2'),\n" +
            " (143,'Micronésie',107708,'Océanie','Palikir','Dollar','drap_micronesia','R.drawable.pays_enconstruction4'),\n" +
            " (144,'Moldavie',4324000,'Communauté des États indépendants','Chisinau','Leu','drap_moldova','R.drawable.pays_enconstruction1'),\n" +
            " (145,'Monaco',32965,'Europe','Monaco','Euro','drap_monaco','R.drawable.pays_enconstruction2'),\n" +
            " (146,'Mongolie',3086918,'Asie','Ulan Bator','Tugrik','drap_mongolia','R.drawable.pays_enconstruction4'),\n" +
            " (147,'Montserrat',9341,'Amérique centrale et Caraïbes','Plymouth','Dollar','drap_montserrat','R.drawable.pays_enconstruction1'),\n" +
            " (148,'Mozambique',22061451,'Afrique','Maputo','Metical','drap_mozambique','R.drawable.pays_enconstruction2'),\n" +
            " (149,'Namibie',2128471,'Afrique','Windhoek','Dollar','drap_namibia','R.drawable.pays_enconstruction4'),\n" +
            " (150,'Nauru',10065,'Océanie','Yaren','Dollar','drap_nauru','R.drawable.pays_enconstruction1'),\n" +
            " (151,'Népal',28951852,'Asie','Katmandou','Rupee','drap_nepal','R.drawable.pays_enconstruction2'),\n" +
            " (152,'Nicaragua',5995928,'Amérique centrale et Caraïbes','Managua','Cordoba','drap_nicaragua','R.drawable.pays_enconstruction4'),\n" +
            " (153,'Niger',15878271,'Afrique','Niamey','Franc','drap_niger','R.drawable.pays_enconstruction1'),\n" +
            " (154,'Nigeria',154000000,'Afrique','Abuja','Naira','drap_nigeria','R.drawable.pays_enconstruction2'),\n" +
            " (155,'Niue',2166,'Océanie','Alofi','Dollar','drap_niue','R.drawable.pays_enconstruction4'),\n" +
            " (156,'Norvège',5009150,'Europe','Oslo','Krone','drap_norway','R.drawable.pays_enconstruction1'),\n" +
            " (157,'Nouvelle Calédonie',216494,'Océanie','Nouméa','Franc','drap_northern_mariana_islands','R.drawable.pays_enconstruction2'),\n" +
            " (158,'Nouvelle-Zélande',4252277,'Océanie','Wellington','Dollar','drap_new_zealand','R.drawable.pays_enconstruction4'),\n" +
            " (159,'Oman',2967717,'Moyen-Orient','Muscat','Rial','drap_oman','R.drawable.pays_enconstruction1'),\n" +
            " (160,'Ouganda',33398682,'Afrique','Kampala','Shilling','drap_uganda','R.drawable.pays_enconstruction2'),\n" +
            " (161,'Ouzbékistan',27865738,'Communauté des États indépendants','Tachkent','Som','drap_uzbekistan','R.drawable.pays_enconstruction4'),\n" +
            " (162,'Pakistan',184404791,'Asie','Islamabad','Rupee','drap_pakistan','R.drawable.pays_enconstruction1'),\n" +
            " (163,'Palaos',19907,'Océanie','Melekeok','Dollar','drap_palau','R.drawable.pays_enconstruction2'),\n" +
            " (164,'Panama',3410676,'Amérique centrale et Caraïbes','Ville de Panama','Balboa','drap_panama','R.drawable.pays_enconstruction4'),\n" +
            " (165,'Papouasie Nouvelle Guinée',6064515,'Océanie','Port Moresby','Kina','drap_papua_new_guinea','R.drawable.pays_enconstruction1'),\n" +
            " (166,'Paraguay',6375830,'Amérique du sud','Asuncion','Guarani','drap_paraguay','R.drawable.pays_enconstruction2'),\n" +
            " (167,'Pays-Bas',16645000,'Europe','Amsterdam','Euro','drap_netherlands','R.drawable.pays_enconstruction4'),\n" +
            " (168,'Pérou',29907003,'Amérique du sud','Lima','Sol','drap_peru','R.drawable.pays_enconstruction1'),\n" +
            " (169,'Philippines',99900177,'Asie du sud est','Manille','Peso','drap_philippines','R.drawable.pays_enconstruction2'),\n" +
            " (170,'Pologne',38500000,'Europe','Varsovie','Zloty','drap_poland','R.drawable.pays_enconstruction4'),\n" +
            " (171,'Polynésie française',270485,'Océanie','Papeete','Franc','drap_french_polynesia','R.drawable.pays_enconstruction1'),\n" +
            " (172,'Porto Rico',3916632,'Amérique centrale et Caraïbes','San Juan','Dollar','drap_puerto_rico','R.drawable.pays_enconstruction2'),\n" +
            " (173,'Portugal',10676000,'Europe','Lisbonne','Euro','drap_portugal','R.drawable.pays_enconstruction4'),\n" +
            " (174,'Qatar',840926,'Moyen-Orient','Doha','Rial','drap_qatar','R.drawable.pays_enconstruction1'),\n" +
            " (175,'République centrafricaine',4844927,'Afrique','Bangui','Franc','drap_central_african_republic','R.drawable.pays_enconstruction2'),\n" +
            " (176,'République Démocratique du Congo',70916439,'Afrique','Kinshasa','Franc','drap_congo_democratic_republic_of_the','R.drawable.pays_enconstruction4'),\n" +
            " (177,'République Dominicaine',9823821,'Amérique centrale et Caraïbes','Santo Domingo','Peso','drap_dominican_republic','R.drawable.pays_enconstruction1'),\n" +
            " (178,'République du Congo',3039126,'Afrique','Brazzaville','Franc','drap_congo_republicofthe','R.drawable.pays_enconstruction2'),\n" +
            " (179,'République Tchèque',10476000,'Europe','Prague','Koruna','drap_czech_republic','R.drawable.pays_enconstruction4'),\n" +
            " (180,'Réunion',776948,'Afrique','Saint-Denis','Euro','drap_reunion','R.drawable.pays_enconstruction1'),\n" +
            " (181,'Roumanie',21959278,'Europe','Bucarest','Leu','drap_romania','R.drawable.pays_enconstruction2'),\n" +
            " (182,'Royaume-Uni',62348447,'Europe','Londres','Pound','drap_united_kingdom','R.drawable.pays_enconstruction4'),\n" +
            " (183,'Russie',140702000,'Asie','Moscou','Ruble','drap_russia','R.drawable.pays_enconstruction1'),\n" +
            " (184,'Rwanda',11055976,'Afrique','Kigali','Franc','drap_rwanda','R.drawable.pays_enconstruction2'),\n" +
            " (185,'Sahara occidental',273008,'Afrique','El-Aaiun','Dirham','drap_western_sahara','R.drawable.pays_enconstruction4'),\n" +
            " (186,'Saint Marin',31477,'Europe','Saint Marin','Euro','drap_san_marino','R.drawable.pays_enconstruction1'),\n" +
            " (187,'Saint Pierre et Miquelon',7012,'Amérique du Nord','Saint-Pierre','Euro','drap_saint_pierre_and_miquelon','R.drawable.pays_enconstruction2'),\n" +
            " (188,'Saint-Christophe-et-Niévès',51134,'Amérique centrale et Caraïbes','Basseterre','Dollar','drap_saint_kitts_and_nevis','R.drawable.pays_enconstruction4'),\n" +
            " (189,'Sainte-Hélène',7460,'Afrique','Jamestown','Pound','drap_saint_helena','R.drawable.pays_enconstruction1'),\n" +
            " (190,'Sainte-Lucie',160922,'Amérique centrale et Caraïbes','Castries','Dollar','drap_saint_lucia','R.drawable.pays_enconstruction2'),\n" +
            " (191,'Saint-Vincent-et-les-Grenadines',104217,'Amérique centrale et Caraïbes','Kingstown','Dollar','drap_saint_vincent_and_the_grenadines','R.drawable.pays_enconstruction4'),\n" +
            " (192,'Samoa',192001,'Océanie','Apia','Tala','drap_samoa','R.drawable.pays_enconstruction1'),\n" +
            " (193,'Samoa américaines',57881,'Océanie','Pago Pago','Dollar','drap_american_samoa','R.drawable.pays_enconstruction2'),\n" +
            " (194,'Sao Tomé et Principe',175808,'Afrique','Sao Tomé','Dobra','drap_sao_tome_and_principe','R.drawable.pays_enconstruction4'),\n" +
            " (195,'Sénégal',12323252,'Afrique','Dakar','Franc','drap_senegal','R.drawable.pays_enconstruction1'),\n" +
            " (196,'Serbie et Monténégro',10829175,'Europe','Belgrade','Dinar','drap_serbia','R.drawable.pays_enconstruction2'),\n" +
            " (197,'Sierra Leone',5245695,'Afrique','Freetown','Leone','drap_sierra_leone','R.drawable.pays_enconstruction4'),\n" +
            " (198,'Singapour',4701069,'Asie du sud est','Singapour','Dollar','drap_singapore','R.drawable.pays_enconstruction1'),\n" +
            " (199,'Slovaquie',5455000,'Europe','Bratislava','Euro','drap_slovakia','R.drawable.pays_enconstruction2'),\n" +
            " (200,'Slovénie',2007000,'Europe','Ljubljana','Euro','drap_slovenia','R.drawable.pays_enconstruction4'),\n" +
            " (201,'Somalie',10112453,'Afrique','Mogadiscio','Shilling','drap_somalia','R.drawable.pays_enconstruction1'),\n" +
            " (202,'Soudan',35000000,'Afrique','Khartoum','Pound','drap_sudan','R.drawable.pays_enconstruction2'),\n" +
            " (203,'Sri Lanka',21513990,'Asie','Colombo','Rupee','drap_sri_lanka','R.drawable.pays_enconstruction4'),\n" +
            " (204,'Suède',9828655,'Europe','Stockholm','Krona','drap_sweden','R.drawable.pays_enconstruction1'),\n" +
            " (205,'Suisse',7581000,'Europe','Bern','Franc','drap_switzerland','R.drawable.pays_enconstruction2'),\n" +
            " (206,'Suriname',492829,'Amérique du sud','Paramaribo','Dollar','drap_suriname','R.drawable.pays_enconstruction4'),\n" +
            " (207,'Svalbard',2550,'Région de l''Arctique','Longyearbyen','Krone','drap_svalbard','R.drawable.pays_enconstruction1'),\n" +
            " (208,'Swaziland',1354051,'Afrique','Mbabane','Lilangeni','drap_swaziland','R.drawable.pays_enconstruction2'),\n" +
            " (209,'Syrie',22198110,'Moyen-Orient','Damas','Pound','drap_syria','R.drawable.pays_enconstruction4'),\n" +
            " (210,'Tadjikistan',7487489,'Communauté des États indépendants','Dushanbe','Somoni','drap_tajikistan','R.drawable.pays_enconstruction1'),\n" +
            " (211,'Taïwan',22894384,'Asie du sud est','Taipei','Dollar','drap_taiwan','R.drawable.pays_enconstruction2'),\n" +
            " (212,'Tanzanie',41892895,'Afrique','Dodoma','Shilling','drap_tanzania','R.drawable.pays_enconstruction4'),\n" +
            " (213,'Tchad',10543464,'Afrique','N''Djamena','Franc','drap_chad','R.drawable.pays_enconstruction1'),\n" +
            " (214,'Thaïlande',67089500,'Asie du sud est','Bangkok','Baht','drap_thailand','R.drawable.pays_enconstruction2'),\n" +
            " (215,'Togo',6587239,'Afrique','Lome','Franc','drap_togo','R.drawable.pays_enconstruction4'),\n" +
            " (216,'Tokélaou',1466,'Océanie','','Dollar','drap_togo','R.drawable.pays_enconstruction1'),\n" +
            " (217,'Tonga',122580,'Océanie','Nuku''alofa','Pa''anga','drap_tonga','R.drawable.pays_enconstruction2'),\n" +
            " (218,'Trinité et Tobago',1228691,'Amérique centrale et Caraïbes','Port d''Espagne','Dollar','drap_trinidad_and_tobago','R.drawable.pays_enconstruction4'),\n" +
            " (219,'Tunisie',10589025,'Moyen-Orient','Tunis','Dinar','drap_tunisia','R.drawable.pays_enconstruction1'),\n" +
            " (220,'Turkménistan',4940916,'Communauté des États indépendants','Ashgabat','Manat','drap_turkmenistan','R.drawable.pays_enconstruction2'),\n" +
            " (221,'Turquie',77804122,'Europe','Ankara','Lira','drap_turkey','R.drawable.pays_enconstruction4'),\n" +
            " (222,'Tuvalu',10472,'Océanie','Funafuti','Dollar','drap_tuvalu','R.drawable.pays_enconstruction1'),\n" +
            " (223,'Ukraine',45415596,'Communauté des États indépendants','Kiev','Hryvnia','drap_ukraine','R.drawable.pays_enconstruction2'),\n" +
            " (224,'Uruguay',3477000,'Amérique du sud','Montevideo','Peso','drap_uruguay','R.drawable.pays_enconstruction4'),\n" +
            " (225,'Vanuatu',221552,'Océanie','Port Vila','Vatu','drap_vanuatu','R.drawable.pays_enconstruction1'),\n" +
            " (226,'Vatican',921,'Europe','Cité du Vatican','Euro','drap_vatican_city','R.drawable.pays_enconstruction2'),\n" +
            " (227,'Venezuela',27223228,'Amérique du Sud','Caracas','Bolivar','drap_venezuela','R.drawable.pays_enconstruction4'),\n" +
            " (228,'Vietnam',89571130,'Asie du sud est','Hanoi','Dong','drap_vietnam','R.drawable.pays_enconstruction1'),\n" +
            " (229,'Wallis et Futuna',16025,'Océanie','Mata Utu','Franc','drap_wallis_and_futuna','R.drawable.pays_enconstruction2'),\n" +
            " (230,'Yémen',23495361,'Moyen-Orient','Sanaa','Rial','drap_yemen','R.drawable.pays_enconstruction4'),\n" +
            " (231,'Zambie',13460305,'Afrique','Lusaka','Kwacha','drap_zambia','R.drawable.pays_enconstruction1'),\n" +
            " (232,'Zimbabwe',13061000,'Afrique','Harare','Dollar','drap_zimbabwe','R.drawable.pays_enconstruction2');";


    public static String DROP_PAYS_TABLE = "drop table if exists "+ PAYS_TABLE ;

    public static String queryGetAll = "select * from "+ PAYS_TABLE;


    public static ArrayList<Pays> getAll(Context ctx){
        ArrayList<Pays> listePays = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Pays e = new Pays();
            e.setIdPays(c.getInt(0));
            e.setNom(c.getString(1));
            e.setPopulation(c.getInt(2));
            e.setContinent(c.getString(3));
            e.setCapitale(c.getString(4));
            e.setDevise(c.getString(5));
            e.setRessImgDrapeau(c.getString(6));
            e.setRessImgPays(c.getString(7));
            e.setListeLanguePays(ManagerLanguePays.getAllByIdPays(ctx, c.getInt(0)));
            e.setListePreferencePays(ManagerPreferencePays.getAllByIdPays(ctx,c.getInt(0)));
            e.setListeAttractionPays(ManagerAttractionPays.getAllByIdPays(ctx, c.getInt(0)));
            listePays.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listePays;
    }

    public static Pays getById(Context ctx, int idCompare){

        Pays retour = null;
        ArrayList<Pays> listePays = getAll(ctx);


        for (Pays p :
                listePays) {
            if(p.getIdPays() == idCompare)
                retour = p;
        }
        return  retour;
    }


}
