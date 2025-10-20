package com.PostgreSQLApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.io.Serializable;
import javax.persistence.*;

import java.util.Map;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name = "product_category")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false, length = 255, unique = true)
    private String slug;

    @Column(columnDefinition = "jsonb")
    private String description;

    @Column(nullable = false)
    private Integer lft;

    @Column(nullable = false)
    private Integer rght;

    @Column(name = "tree_id", nullable = false)
    private Integer treeId;

    @Column(nullable = false)
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ProductCategory parent;

    @Column(name = "background_image", length = 100)
    private String backgroundImage;

    @Column(name = "seo_description", length = 300)
    private String seoDescription;

    @Column(name = "seo_title", length = 70)
    private String seoTitle;

    @Column(name = "background_image_alt", nullable = false, length = 128)
    private String backgroundImageAlt;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @Type(type = "jsonb")
    @Column(name = "private_metadata", columnDefinition = "jsonb")
    private Map<String, Object> privateMetadata;

    @Column(name = "description_plaintext", nullable = false, columnDefinition = "text")
    private String descriptionPlaintext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRght() {
        return rght;
    }

    public void setRght(Integer rght) {
        this.rght = rght;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getBackgroundImageAlt() {
        return backgroundImageAlt;
    }

    public void setBackgroundImageAlt(String backgroundImageAlt) {
        this.backgroundImageAlt = backgroundImageAlt;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getPrivateMetadata() {
        return privateMetadata;
    }

    public void setPrivateMetadata(Map<String, Object> privateMetadata) {
        this.privateMetadata = privateMetadata;
    }

    public String getDescriptionPlaintext() {
        return descriptionPlaintext;
    }

    public void setDescriptionPlaintext(String descriptionPlaintext) {
        this.descriptionPlaintext = descriptionPlaintext;
    }

}
