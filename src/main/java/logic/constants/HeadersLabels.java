package logic.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HeadersLabels {

    RAPIDAPI_HOST ("x-rapidapi-host"),
    RAPIDAPI_KEY ("x-rapidapi-key"),
    CONTENT_TYPE ("content-type");

    private String Label;

    public String getLabel() {
        return Label;
    }

}
