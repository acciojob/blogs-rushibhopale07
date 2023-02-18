package com.driver.models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String title;

    @CreationTimestamp
    private Date pubdate;

    @ManyToOne
    @JoinColumn
    private User uservariable;

    @OneToMany(mappedBy = "blog", cascade=CascadeType.ALL)
    private List<Image> images;

    public Blog() {
    }

    public Blog(int id, String content, String title, Date pubdate, User uservariable, List<Image> images) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.pubdate = pubdate;
        this.uservariable = uservariable;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public User getUservariable() {
        return uservariable;
    }

    public void setUservariable(User uservariable) {
        this.uservariable = uservariable;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}