package id.bmri.introduction.be.day2.beintroductionday2.util;

import lombok.Data;

@Data
public class Response {
    private String message;
    private Object data;
    private Boolean result;

    public Response(Object data, String message, Boolean result) {
        this.data = data;
        this.message = message;
        this.result = result;
    }
}
