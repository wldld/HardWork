package domain;

import java.sql.Timestamp;

public class Information {
    private int id;
    private String title;
    private String content;
    private Timestamp publishingtime;
    private String publishinguser;
    private String type;


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

    public String getPublishinguser() {
        return publishinguser;
    }

    public void setPublishinguser(String publishuser) {
        this.publishinguser = publishuser;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

}
