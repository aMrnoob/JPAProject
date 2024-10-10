package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="categoryId")
    private String categoryId;

    @Column(name="categoryName", columnDefinition = "nvarchar(50) NOT NULL")
    private String categoryName;

    @Column(name="image", columnDefinition = "varbinary(MAX) NOT NULL")
    private byte[] image;

    @Column(name="status")
    private boolean status;

    public Category() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}