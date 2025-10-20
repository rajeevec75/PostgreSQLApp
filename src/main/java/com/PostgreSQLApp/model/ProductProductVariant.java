package com.PostgreSQLApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.time.ZonedDateTime;
import java.util.Map;

@Entity
@Table(name = "product_productvariant")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class ProductProductVariant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, unique = true)
    private String sku;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductProduct productProduct;

    @Column(name = "track_inventory", nullable = false)
    private boolean trackInventory;

    private Double weight;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    @Type(type = "jsonb")
    @Column(name = "private_metadata", columnDefinition = "jsonb")
    private Map<String, Object> privateMetadata;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "is_preorder", nullable = false)
    private boolean isPreorder;

    @Column(name = "preorder_end_date")
    private ZonedDateTime preorderEndDate;

    @Column(name = "preorder_global_threshold")
    private Integer preorderGlobalThreshold;

    @Column(name = "quantity_limit_per_customer")
    private Integer quantityLimitPerCustomer;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "external_reference", length = 250, unique = true)
    private String externalReference;

    // === Getters & Setters === //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductProduct getProductProduct() {
        return productProduct;
    }

    public void setProductProduct(ProductProduct productProduct) {
        this.productProduct = productProduct;
    }

    public boolean isIsPreorder() {
        return isPreorder;
    }

    public void setIsPreorder(boolean isPreorder) {
        this.isPreorder = isPreorder;
    }

    public boolean isTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(boolean trackInventory) {
        this.trackInventory = trackInventory;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isPreorder() {
        return isPreorder;
    }

    public void setPreorder(boolean preorder) {
        isPreorder = preorder;
    }

    public ZonedDateTime getPreorderEndDate() {
        return preorderEndDate;
    }

    public void setPreorderEndDate(ZonedDateTime preorderEndDate) {
        this.preorderEndDate = preorderEndDate;
    }

    public Integer getPreorderGlobalThreshold() {
        return preorderGlobalThreshold;
    }

    public void setPreorderGlobalThreshold(Integer preorderGlobalThreshold) {
        this.preorderGlobalThreshold = preorderGlobalThreshold;
    }

    public Integer getQuantityLimitPerCustomer() {
        return quantityLimitPerCustomer;
    }

    public void setQuantityLimitPerCustomer(Integer quantityLimitPerCustomer) {
        this.quantityLimitPerCustomer = quantityLimitPerCustomer;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}
