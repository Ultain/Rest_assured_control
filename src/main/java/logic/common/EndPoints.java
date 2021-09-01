package logic.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EndPoints {

    TRANSLATE_TEXT ("https://google-translate20.p.rapidapi.com/translate"),
    GET_SUPPORTED_LANGUAGES ("https://google-translate20.p.rapidapi.com/languages");

    private String URI;

    public String getURI() {
        return URI;
    }
}
