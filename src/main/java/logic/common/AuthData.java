package logic.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthData {

    BASIC_USER ("google-translate20.p.rapidapi.com",
            "49c70b6db2msh13112efcbf59d34p16829bjsn73169fd076b7",
            "application/x-www-form-urlencoded; charset=utf-8");

    private String xRapidApiHost;
    private String xRapidApiKey;
    private String contentType;

    public String getHost() {
        return xRapidApiHost;
    }

    public String getKey() {
        return xRapidApiKey;
    }

    public String getContentType() { return contentType; }

}
