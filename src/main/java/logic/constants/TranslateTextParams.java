package logic.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TranslateTextParams {

    TEXT_LABEL("text"),
    TARGET_LANG("tl"),
    SOURCE_LANG("sl"),

    ENGLISH_TEXT("HMS Royal Oak was a Royal Navy battleship under Captain WH Benn. She had been moored off the cliffs of" +
            " Gaitnip, in the north-east corner of Scapa Flow, so her anti-aircraft guns could help defend against" +
            " any air attack on the vital Netherbutton Radar Station which stood above the cliffs.\n" +
            "On the night of 13/14 October 1939, German submarine U-47, under the command of Kapitänleutnant Günther" +
            " Prien – one of the three recognised U-boat aces of World War II – crept into Scapa Flow through Kirk" +
            " Sound, between the blockships which were meant to have made the Sound impassable to enemy vessels."),

    DEUTSCH_TEXT("Die Bismarck war ein Schlachtschiff der deutschen Kriegsmarine und bildete mit ihrem Schwesterschiff " +
            "Tirpitz die Bismarck-Klasse. Zum Zeitpunkt ihrer Indienststellung im August 1940 unter dem Kommando von " +
            "Kapitän zur See Ernst Lindemann galt sie als das größte und kampfstärkste Schlachtschiff der Welt.\n" +
            "Im Mai 1941 wurde die Bismarck zusammen mit dem Schweren Kreuzer Prinz Eugen in den Nordatlantik " +
            "geschickt, um dort Handelskrieg zu führen. Bald nach dem Beginn dieser Mission gelang ihr in der " +
            "Dänemarkstraße die Versenkung des britischen Schlachtkreuzers Hood. Drei Tage darauf sank sie selbst nach " +
            "einem schweren Gefecht gegen Einheiten der britischen Royal Navy mit dem Großteil ihrer Besatzung im Nordatlantik."),

    AFRIKAANS("af"),
    AMHARIC("am"),
    ARABIC("ar"),
    DETECT_LANGUAGE("auto"),
    AZERBAIJANI("az"),
    BELARUSIAN("be"),
    BULGARIAN("bg"),
    BENGALI("bn"),
    BOSNIAN("bs"),
    CATALAN("ca"),
    CEBUANO("ceb"),
    CORSICAN("co"),
    CZECH("cs"),
    WELSH("cy"),
    DANISH("da"),
    GERMAN("de"),
    GREEK("el"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    SPANISH("es"),
    ESTONIAN("et"),
    BASQUE("eu"),
    PERSIAN("fa"),
    FINNISH("fi"),
    FRENCH("fr"),
    FRISIAN("fy"),
    IRISH("ga"),
    SCOTS_GAELIC("gd"),
    GALICIAN("gl"),
    GUJARATI("gu"),
    HAUSA("ha"),
    HAWAIIAN("haw"),
    HEBREW("he"),
    HINDI("hi"),
    HMONG("hmn"),
    CROATIAN("hr"),
    HAITIAN_CREOLE("ht"),
    HUNGARIAN("hu"),
    ARMENIAN("hy"),
    INDONESIAN("id"),
    IGBO("ig"),
    ICELANDIC("is"),
    ITALIAN("it"),
    JAPANESE("ja"),
    JAVANESE("jw"),
    GEORGIAN("ka"),
    KAZAKH("kk"),
    KHMER("km"),
    KINYARWANDA("rw"),
    KANNADA("kn"),
    KOREAN("ko"),
    KURDISH("ku"),
    KYRGYZ("ky"),
    LATIN("la"),
    LUXEMBOURGISH("lb"),
    LAO("lo"),
    LITHUANIAN("lt"),
    LATVIAN("lv"),
    MALAGASY("mg"),
    MAORI("mi"),
    MACEDONIAN("mk"),
    MALAYALAM("ml"),
    MONGOLIAN("mn"),
    MARATHI("mr"),
    MALAY("ms"),
    MALTESE("mt"),
    MYANMAR("my"),
    NEPALI("ne"),
    DUTCH("nl"),
    NORWEGIAN("no"),
    ODIA_Oriya("or"),
    CHICHEWA("ny"),
    PUNJABI("pa"),
    POLISH("pl"),
    PASHTO("ps"),
    PORTUGUESE("pt"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SINDHI("sd"),
    SINHALA("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SAMOAN("sm"),
    SHONA("sn"),
    SOMALI("so"),
    ALBANIAN("sq"),
    SERBIAN("sr"),
    SESOTHO("st"),
    SUNDANESE("su"),
    SWEDISH("sv"),
    SWAHILI("sw"),
    TAMIL("ta"),
    TATAR("tt"),
    TELUGU("te"),
    TAJIK("tg"),
    THAI("th"),
    FILIPINO("tl"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    URDU("ur"),
    UYGHUR("ug"),
    UZBEK("uz"),
    VIETNAMESE("vi"),
    XHOSA("xh"),
    YIDDISH("yi"),
    YORUBA("yo"),
    CHINESE_SIMPLIFIED("zh-CN"),
    CHINESE_TRADITIONAL("zh-TW"),
    ZULU("zu");

    private String param;

    public String getParam() {
        return param;
    }
}
