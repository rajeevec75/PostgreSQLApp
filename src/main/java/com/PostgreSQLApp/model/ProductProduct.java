package com.PostgreSQLApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

@Entity
@Table(name = "product_product")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ProductProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String description;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductProductType productProductType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @Column(name = "seo_description", length = 300)
    private String seoDescription;

    @Column(name = "seo_title", length = 70)
    private String seoTitle;

    @Column(name = "charge_taxes", nullable = false)
    private boolean chargeTaxes;

    private Double weight;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    @Type(type = "jsonb")
    @Column(name = "private_metadata", columnDefinition = "jsonb")
    private Map<String, Object> privateMetadata;

    @Column(nullable = false, unique = true, length = 255)
    private String slug;

    @OneToOne
    @JoinColumn(name = "default_variant_id", unique = true)
    private ProductProductVariant productProductVariant;

    @Column(name = "description_plaintext", nullable = false, columnDefinition = "text")
    private String descriptionPlaintext;

    private Double rating;

    @Column(name = "search_document", nullable = false, columnDefinition = "text")
    private String searchDocument;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "search_index_dirty", nullable = false)
    private boolean searchIndexDirty;

    @ManyToOne
    @JoinColumn(name = "tax_class_id")
    private TaxTaxClass taxTaxClass;

    @Column(name = "external_reference", length = 250, unique = true)
    private String externalReference;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    private Integer gst;

    @Column(name = "sno_pattern", length = 255)
    private String snoPattern;

    @Column(name = "tracking_serial_no", nullable = false)
    private boolean trackingSerialNo = true;

    @Column(name = "is_batch", nullable = false)
    private boolean isBatch = false;

    @Column(name = "is_product_service", nullable = false)
    private boolean isProductService = false;

    // === GETTERS & SETTERS === //
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProductProductType getProductProductType() {
        return productProductType;
    }

    public void setProductProductType(ProductProductType productProductType) {
        this.productProductType = productProductType;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
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

    public boolean isChargeTaxes() {
        return chargeTaxes;
    }

    public void setChargeTaxes(boolean chargeTaxes) {
        this.chargeTaxes = chargeTaxes;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getPrivateMetadata() {
        return privateMetadata;
    }

    public void setPrivateMetadata(Map<String, Object> privateMetadata) {
        this.privateMetadata = privateMetadata;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public ProductProductVariant getProductProductVariant() {
        return productProductVariant;
    }

    public void setProductProductVariant(ProductProductVariant productProductVariant) {
        this.productProductVariant = productProductVariant;
    }

    public String getDescriptionPlaintext() {
        return descriptionPlaintext;
    }

    public void setDescriptionPlaintext(String descriptionPlaintext) {
        this.descriptionPlaintext = descriptionPlaintext;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSearchDocument() {
        return searchDocument;
    }

    public void setSearchDocument(String searchDocument) {
        this.searchDocument = searchDocument;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSearchIndexDirty() {
        return searchIndexDirty;
    }

    public void setSearchIndexDirty(boolean searchIndexDirty) {
        this.searchIndexDirty = searchIndexDirty;
    }

    public TaxTaxClass getTaxTaxClass() {
        return taxTaxClass;
    }

    public void setTaxTaxClass(TaxTaxClass taxTaxClass) {
        this.taxTaxClass = taxTaxClass;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getGst() {
        return gst;
    }

    public void setGst(Integer gst) {
        this.gst = gst;
    }

    public String getSnoPattern() {
        return snoPattern;
    }

    public void setSnoPattern(String snoPattern) {
        this.snoPattern = snoPattern;
    }

    public boolean isTrackingSerialNo() {
        return trackingSerialNo;
    }

    public void setTrackingSerialNo(boolean trackingSerialNo) {
        this.trackingSerialNo = trackingSerialNo;
    }

    public boolean isIsBatch() {
        return isBatch;
    }

    public void setIsBatch(boolean isBatch) {
        this.isBatch = isBatch;
    }

    public boolean isIsProductService() {
        return isProductService;
    }

    public void setIsProductService(boolean isProductService) {
        this.isProductService = isProductService;
    }

}
