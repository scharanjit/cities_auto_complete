package org.imaginea.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Charanjit Singh
 */

public class HttpResponse {

    @JsonProperty
    private String message;

    @JsonProperty
    private Integer status = HttpStatus.OK.value();

    @JsonProperty
    private List<String> response = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }
}

