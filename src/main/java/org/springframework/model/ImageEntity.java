package org.springframework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 21.12.2014.
 */
@Entity
@Table(name = "image", schema = "", catalog = "kazgidro")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ImageEntity implements Serializable{
    private int idimage;

    private byte[] imagesrc;

    //private ArticleEntity articleByArticleid;




    private ArticleEntity articleEntity;

    @ManyToOne
    @JoinColumn(name = "articleid")
    public ArticleEntity getArticleEntity(){
        return this.articleEntity;
    }
    public void setArticleEntity(ArticleEntity articleEntity){
        this.articleEntity = articleEntity;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimage", nullable = false, insertable = true, updatable = true)
    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }


    @Column(name = "imagesrc", nullable = true, insertable = true, updatable = true)

    public byte[] getImagesrc() {
        return imagesrc;
    }



    @Column(name = "imagesrc", nullable = true, insertable = true, updatable = true)
    public void setImagesrc(byte[] imagesrc) {
        this.imagesrc = imagesrc;
    }





}
