package domain;

import java.sql.Timestamp;

public class Information {
    private int id;
    private String title;
    private String content;
    private Timestamp publishingtime;
    private String publishuser;
    private String Type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishingtime() {
        return publishingtime;
    }

    public void setPublishingtime(Timestamp publishingtime) {
        this.publishingtime = publishingtime;
    }

    public String getPublishuser() {
        return publishuser;
    }

    public void setPublishuser(String publishuser) {
        this.publishuser = publishuser;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
