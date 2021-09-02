package logic.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JacksonHandler {

    @SneakyThrows
    public String toJson(Object obj){
        return new ObjectMapper().writeValueAsString(obj);
    }

}
