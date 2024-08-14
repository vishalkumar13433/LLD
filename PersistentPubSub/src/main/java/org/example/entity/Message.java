package org.example.entity;

import java.util.UUID;

public class Message {
    private String id;
    private String content;
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Message(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.source = "";
    }

    public Message(String content, String source) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(MessageDTO dto) {
        this.id = UUID.randomUUID().toString();
        this.content = dto.getBody();
        if (dto.getSource() != null) {
            this.source = dto.getSource();
        }
    }
}
