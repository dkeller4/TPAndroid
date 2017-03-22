package com.example.dimitrikeller.tpandroid.Manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dimitrikeller.tpandroid.Entite.Attraction;
import com.example.dimitrikeller.tpandroid.Entite.Langue;
import com.example.dimitrikeller.tpandroid.Service.ConnexionBD;

import java.util.ArrayList;

/**
 * Created by Marianne on 2017-03-13.
 */

public class ManagerLangue {

    public static String LANGUE_ID = "idLangue";
    public static String LANGUE_NOM = "Langue";
    public static String LANGUE_TABLE = "Langue";

    public static String LANGUE_TABLE_CREATE = "create table " + LANGUE_TABLE + "(" +
            LANGUE_ID + " INTEGER PRIMARY KEY, " +
            LANGUE_NOM + " TEXT);";


    public static String queryINSERT = "INSERT INTO `Langue` (idLangue,Langue) VALUES (1,'afar'),\n" +
            " (2,'abkhaze'),\n" +
            " (3,'avestique'),\n" +
            " (4,'afrikaans'),\n" +
            " (5,'akan'),\n" +
            " (6,'amharique'),\n" +
            " (7,'aragonais'),\n" +
            " (8,'arabe'),\n" +
            " (9,'assamais'),\n" +
            " (10,'avar'),\n" +
            " (11,'aymara'),\n" +
            " (12,'azéri'),\n" +
            " (13,'bachkir'),\n" +
            " (14,'biélorusse'),\n" +
            " (15,'bulgare'),\n" +
            " (16,'langues biharis'),\n" +
            " (17,'bichlamar'),\n" +
            " (18,'bambara'),\n" +
            " (19,'bengali'),\n" +
            " (20,'tibétain'),\n" +
            " (21,'breton'),\n" +
            " (22,'bosniaque'),\n" +
            " (23,'catalan'),\n" +
            " (24,'tchétchène'),\n" +
            " (25,'chamorro'),\n" +
            " (26,'corse'),\n" +
            " (27,'cree'),\n" +
            " (28,'tchèque'),\n" +
            " (29,'tchouvache'),\n" +
            " (30,'gallois'),\n" +
            " (31,'danois'),\n" +
            " (32,'allemand'),\n" +
            " (33,'maldivien'),\n" +
            " (34,'dzongkha'),\n" +
            " (35,'éwé'),\n" +
            " (36,'grec'),\n" +
            " (37,'anglais'),\n" +
            " (38,'espéranto'),\n" +
            " (39,'espagnol'),\n" +
            " (40,'estonien'),\n" +
            " (41,'basque'),\n" +
            " (42,'persan'),\n" +
            " (43,'peul'),\n" +
            " (44,'finnois'),\n" +
            " (45,'fidjien'),\n" +
            " (46,'féroïen'),\n" +
            " (47,'français'),\n" +
            " (48,'frison occidental'),\n" +
            " (49,'irlandais'),\n" +
            " (50,'gaélique'),\n" +
            " (51,'galicien'),\n" +
            " (52,'guarani'),\n" +
            " (53,'goudjrati'),\n" +
            " (54,'manx; mannois'),\n" +
            " (55,'haoussa'),\n" +
            " (56,'hébreu'),\n" +
            " (57,'hindi'),\n" +
            " (58,'hiri motu'),\n" +
            " (59,'croate'),\n" +
            " (60,'créole haïtien'),\n" +
            " (61,'hongrois'),\n" +
            " (62,'arménien'),\n" +
            " (63,'herero'),\n" +
            " (64,'indonésien'),\n" +
            " (65,'igbo'),\n" +
            " (66,'yi de Sichuan'),\n" +
            " (67,'inupiaq'),\n" +
            " (68,'ido'),\n" +
            " (69,'islandais'),\n" +
            " (70,'italien'),\n" +
            " (71,'inuktitut'),\n" +
            " (72,'japonais'),\n" +
            " (73,'javanais'),\n" +
            " (74,'géorgien'),\n" +
            " (75,'kongo'),\n" +
            " (76,'kikuyu'),\n" +
            " (77,'kuanyama'),\n" +
            " (78,'kazakh'),\n" +
            " (79,'groenlandais'),\n" +
            " (80,'khmer central'),\n" +
            " (81,'kannada'),\n" +
            " (82,'coréen'),\n" +
            " (83,'kanouri'),\n" +
            " (84,'kashmiri'),\n" +
            " (85,'kurde'),\n" +
            " (86,'kom'),\n" +
            " (87,'cornique'),\n" +
            " (88,'kirghiz'),\n" +
            " (89,'latin'),\n" +
            " (90,'luxembourgeois'),\n" +
            " (91,'ganda'),\n" +
            " (92,'limbourgeois'),\n" +
            " (93,'lingala'),\n" +
            " (94,'lao'),\n" +
            " (95,'lituanien'),\n" +
            " (96,'luba katanga'),\n" +
            " (97,'letton'),\n" +
            " (98,'malgache'),\n" +
            " (99,'marshall'),\n" +
            " (100,'maori'),\n" +
            " (101,'macédonien'),\n" +
            " (102,'malayalam'),\n" +
            " (103,'mongol'),\n" +
            " (104,'marathe'),\n" +
            " (105,'malais'),\n" +
            " (106,'maltais'),\n" +
            " (107,'birman'),\n" +
            " (108,'nauruan'),\n" +
            " (109,'norvégien bokmål'),\n" +
            " (110,'ndébélé du Nord'),\n" +
            " (111,'népalais'),\n" +
            " (112,'ndonga'),\n" +
            " (113,'néerlandais'),\n" +
            " (114,'norvégien nynorsk'),\n" +
            " (115,'norvégien'),\n" +
            " (116,'ndébélé du Sud'),\n" +
            " (117,'navaho'),\n" +
            " (118,'chichewa'),\n" +
            " (119,'occitan'),\n" +
            " (120,'ojibwa'),\n" +
            " (121,'galla'),\n" +
            " (122,'oriya'),\n" +
            " (123,'ossète'),\n" +
            " (124,'pendjabi'),\n" +
            " (125,'pali'),\n" +
            " (126,'polonais'),\n" +
            " (127,'pachto'),\n" +
            " (128,'portugais'),\n" +
            " (129,'quechua'),\n" +
            " (130,'romanche'),\n" +
            " (131,'rundi'),\n" +
            " (132,'roumain'),\n" +
            " (133,'russe'),\n" +
            " (134,'rwanda'),\n" +
            " (135,'sanskrit'),\n" +
            " (136,'sarde'),\n" +
            " (137,'sindhi'),\n" +
            " (138,'sami du Nord'),\n" +
            " (139,'sango'),\n" +
            " (140,'singhalais'),\n" +
            " (141,'slovaque'),\n" +
            " (142,'slovène'),\n" +
            " (143,'samoan'),\n" +
            " (144,'shona'),\n" +
            " (145,'somali'),\n" +
            " (146,'albanais'),\n" +
            " (147,'serbe'),\n" +
            " (148,'swati'),\n" +
            " (149,'sotho du Sud'),\n" +
            " (150,'soundanais'),\n" +
            " (151,'suédois'),\n" +
            " (152,'swahili'),\n" +
            " (153,'tamoul'),\n" +
            " (154,'télougou'),\n" +
            " (155,'tadjik'),\n" +
            " (156,'thaï'),\n" +
            " (157,'tigrigna'),\n" +
            " (158,'turkmène'),\n" +
            " (159,'tagalog'),\n" +
            " (160,'tswana'),\n" +
            " (161,'tongan (Îles Tonga)'),\n" +
            " (162,'turc'),\n" +
            " (163,'tsonga'),\n" +
            " (164,'tatar'),\n" +
            " (165,'twi'),\n" +
            " (166,'tahitien'),\n" +
            " (167,'ouïgour'),\n" +
            " (168,'ukrainien'),\n" +
            " (169,'ourdou'),\n" +
            " (170,'ouszbek'),\n" +
            " (171,'venda'),\n" +
            " (172,'vietnamien'),\n" +
            " (173,'volapük'),\n" +
            " (174,'wallon'),\n" +
            " (175,'wolof'),\n" +
            " (176,'xhosa'),\n" +
            " (177,'yiddish'),\n" +
            " (178,'yoruba'),\n" +
            " (179,'zhuang'),\n" +
            " (180,'chinois'),\n" +
            " (181,'zoulou');";


    public static String DROP_LANGUE_TABLE = "drop table if exists "+ LANGUE_TABLE ;

    public static String queryGetAll = "select * from "+ LANGUE_TABLE;



    public static ArrayList<Langue> getAll(Context ctx){
        ArrayList<Langue> listeLangue = new ArrayList<>();
        SQLiteDatabase bd = ConnexionBD.getBD(ctx);
        Cursor c = bd.rawQuery(queryGetAll,null);

        while (c.moveToNext()){
            Langue e = new Langue();
            e.setIdLangue(c.getInt(0));
            e.setLangue(c.getString(1));
            listeLangue.add(e);
        }

        c.close();
        ConnexionBD.close();
        return listeLangue;
    }

    public static Langue getById(Context ctx, int idCompare){
        ArrayList<Langue> listeLangue = getAll(ctx);

        Langue retour = null;
        for (Langue l :
                listeLangue) {
            if(l.getIdLangue() == idCompare)
                retour = l;
        }
        return  retour;
    }


}
