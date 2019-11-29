package models;

import java.util.Objects;

public class News {
    private int id;
    private String title;
    private String content;
    private String writtenBy;
    private String type;
    private int department_id;

    public News(String title, String content, String writtenBy, String type, int department_id) {
        this.title = title;
        this.content = content;
        this.writtenBy = writtenBy;
        this.type = "Organisation News";
        this.department_id = department_id;
    }

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

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                department_id == news.department_id &&
                Objects.equals(title, news.title) &&
                Objects.equals(content, news.content) &&
                Objects.equals(writtenBy, news.writtenBy) &&
                Objects.equals(type, news.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, writtenBy, type, department_id);
    }
}
