package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "video")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name="videoId")
    private String videoId; 

    @Column(name = "title", columnDefinition = "nvarchar(50) NOT NULL")
    private String title;

    @Column(name = "description", columnDefinition = "nvarchar(100) NULL")
    private String description;

    @Lob
    @Column(name = "poster", columnDefinition = "varbinary(MAX) NOT NULL")
    private byte[] poster; 

    @Column(name = "views")
    private int views;

    @Column(name = "active", nullable = false)
    private boolean active; 

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    public Video() {
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }  
}
