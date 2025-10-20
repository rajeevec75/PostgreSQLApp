package com.PostgreSQLApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "tax_taxclass")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class TaxTaxClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "jsonb")
    @Column(name = "private_metadata", columnDefinition = "jsonb")
    private Map<String, Object> privateMetadata;

    @Type(type = "jsonb")
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    @Column(nullable = false, length = 255)
    private String name;

    // === Getters and Setters === //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getPrivateMetadata() {
        return privateMetadata;
    }

    public void setPrivateMetadata(Map<String, Object> privateMetadata) {
        this.privateMetadata = privateMetadata;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
