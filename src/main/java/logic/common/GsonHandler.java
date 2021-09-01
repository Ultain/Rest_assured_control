package logic.common;

import com.google.gson.Gson;

public class GsonHandler {

    public static <T> T getResponce(String responceBody, Class<T> classOfT){
        return new Gson().fromJson(responceBody, classOfT);
    }

}
