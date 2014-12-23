package org.springframework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 21.12.2014.
 */
@Entity
@Table(name = "article", schema = "", catalog = "kazgidro")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ArticleEntity implements Serializable{
    private int idArticle;
    private String textEng;
    private String textRus;
    private String textKz;


    //relationship with doc create uslugi
    private Set<ImageEntity> imageEntities = new HashSet<ImageEntity>();

    @OneToMany(mappedBy = "articleEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ImageEntity> getImageEntities(){
        return this.imageEntities;
    }
    public void setImageEntities(Set<ImageEntity> imageEntities1){
        this.imageEntities = imageEntities1;
    }

    public void addImage(ImageEntity imageEntity){
        imageEntity.setArticleEntity(this);
        getImageEntities().add(imageEntity);
    }

    public void removeDocUslugi(ImageEntity imageEntity){
        getImageEntities().remove(imageEntity);
    }









    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArticle", nullable = false, insertable = true, updatable = true)
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "textENG", nullable = true, insertable = true, updatable = true, length = 500)
    public String getTextEng() {
        return textEng;
    }

    public void setTextEng(String textEng) {
        this.textEng = textEng;
    }

    @Basic
    @Column(name = "textRUS", nullable = true, insertable = true, updatable = true, length = 500)
    public String getTextRus() {
        return textRus;
    }

    public void setTextRus(String textRus) {
        this.textRus = textRus;
    }

    @Basic
    @Column(name = "textKZ", nullable = true, insertable = true, updatable = true, length = 500)
    public String getTextKz() {
        return textKz;
    }

    public void setTextKz(String textKz) {
        this.textKz = textKz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (idArticle != that.idArticle) return false;
        if (textEng != null ? !textEng.equals(that.textEng) : that.textEng != null) return false;
        if (textKz != null ? !textKz.equals(that.textKz) : that.textKz != null) return false;
        if (textRus != null ? !textRus.equals(that.textRus) : that.textRus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + (textEng != null ? textEng.hashCode() : 0);
        result = 31 * result + (textRus != null ? textRus.hashCode() : 0);
        result = 31 * result + (textKz != null ? textKz.hashCode() : 0);
        return result;
    }
}
