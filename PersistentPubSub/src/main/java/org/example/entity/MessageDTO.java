package org.example.entity;

public class MessageDTO {
    private  String body;
    private String source;

    public MessageDTO(String body) {
        this.body = body;
    }

    public MessageDTO(String body, String source) {
        this.body = body;
        this.source = source;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
