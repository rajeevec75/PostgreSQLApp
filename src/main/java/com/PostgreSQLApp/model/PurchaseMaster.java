package com.PostgreSQLApp.model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "purchase_master")
public class PurchaseMaster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    @Column(nullable = false)
    private Integer userId;

    private String purchaseStatus;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal subTotalAmount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal gstAmount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal shippingAmount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal grandTotal = BigDecimal.ZERO;

    private String referenceNo;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date purchaseDate;

    private Integer channelId;

    private String remarks;

    private Integer autoPurchaseId;

    private Integer purchaseUserId;

    private ZonedDateTime currentTimestamp;

    private String companyName;

    private Integer purSeqId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public BigDecimal getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(BigDecimal subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public BigDecimal getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(BigDecimal gstAmount) {
        this.gstAmount = gstAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAutoPurchaseId() {
        return autoPurchaseId;
    }

    public void setAutoPurchaseId(Integer autoPurchaseId) {
        this.autoPurchaseId = autoPurchaseId;
    }

    public Integer getPurchaseUserId() {
        return purchaseUserId;
    }

    public void setPurchaseUserId(Integer purchaseUserId) {
        this.purchaseUserId = purchaseUserId;
    }

    public ZonedDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(ZonedDateTime currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPurSeqId() {
        return purSeqId;
    }

    public void setPurSeqId(Integer purSeqId) {
        this.purSeqId = purSeqId;
    }

}
