package logic.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ResponceTranslate {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("data")
    @Expose
    private ResponceTranslateData data;

    @SerializedName("message")
    @Expose
    private String message;

    public class ResponceTranslateData {
        @SerializedName("translation")
        @Expose
        private String translation;

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        public String getPronunciation() {
            return pronunciation;
        }

        public void setPronunciation(String pronunciation) {
            this.pronunciation = pronunciation;
        }

        public List<Pairs> getListOfPairs() {
            return listOfPairs;
        }

        public void setListOfPairs(List<Pairs> listOfPairs) {
            this.listOfPairs = listOfPairs;
        }

        public ResponceTranslateDataSource getSource() {
            return source;
        }

        public void setSource(ResponceTranslateDataSource source) {
            this.source = source;
        }

        @SerializedName("pronunciation")
        @Expose
        private String pronunciation;

        @SerializedName("pairs")
        @Expose
        private List<Pairs> listOfPairs;

        @SerializedName("source")
        @Expose
        private ResponceTranslateDataSource source;

        public class ResponceTranslateDataSource {
            @SerializedName("language")
            @Expose
            private ResponceTranslateDataSourceLanguage language;

            @SerializedName("text")
            @Expose
            private ResponceTranslateDataSourceText text;

            public class ResponceTranslateDataSourceLanguage {
                @SerializedName("didYouMean")
                @Expose
                private Boolean didYouMean;

                @SerializedName("iso")
                @Expose
                private String iso;
            }

            public class ResponceTranslateDataSourceText {
                @SerializedName("autoCorrected")
                @Expose
                private Boolean autoCorrected;

                @SerializedName("value")
                @Expose
                private String value;

                @SerializedName("didYouMean")
                @Expose
                private Boolean didYouMean;
            }
        }
    }
}
