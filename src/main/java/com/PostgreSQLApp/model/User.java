package com.PostgreSQLApp.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "account_user")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_superuser", nullable = false)
    private boolean isSuperuser;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(name = "date_joined", nullable = false)
    private ZonedDateTime dateJoined;

    @Column(name = "last_login")
    private ZonedDateTime lastLogin;

    @Column(name = "default_billing_address_id")
    private Integer defaultBillingAddressId;

    @Column(name = "default_shipping_address_id")
    private Integer defaultShippingAddressId;

    private String note;

    @Column(name = "first_name", nullable = false, length = 256)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 256)
    private String lastName;

    private String avatar;

    @Type(type = "jsonb")
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    @Type(type = "jsonb")
    @Column(name = "private_metadata", columnDefinition = "jsonb")
    private Map<String, Object> privateMetadata;

    @Column(name = "jwt_token_key", nullable = false, length = 12)
    private String jwtTokenKey;

    @Column(name = "language_code", nullable = false, length = 35)
    private String languageCode;

    @Column(name = "search_document", nullable = false)
    private String searchDocument;

    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(nullable = false)
    private UUID uuid;

    @Column(name = "external_reference", length = 250)
    private String externalReference;

    @Column(name = "last_password_reset_request")
    private ZonedDateTime lastPasswordResetRequest;

    @Column(nullable = false, length = 512)
    private String age;

    @Column(name = "country_code", nullable = false, length = 20)
    private String countryCode;

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified;

    @Column(nullable = false, length = 512)
    private String gender;

    @Column(name = "language_preference", nullable = false, length = 512)
    private String languagePreference;

    @Column(name = "mobile_no", nullable = false, length = 20)
    private String mobileNo;

    @Column(name = "mobile_verified", nullable = false)
    private boolean mobileVerified;

    @Column(name = "user_type", nullable = false, length = 15)
    private String userType;

    @Column(name = "pan_number", length = 20)
    private String panNumber;

    @Column(name = "gst_number", length = 20)
    private String gstNumber;

    @Column(name = "dealer_type", length = 50)
    private String dealerType;

    @Column(name = "place_of_supply", length = 256)
    private String placeOfSupply;

    @Column(name = "party_type", length = 256)
    private String partyType;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "tin_number")
    private String tinNumber;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "user_code", length = 256)
    private String userCode;

    // === Getters and Setters ===
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZonedDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(ZonedDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public ZonedDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getDefaultBillingAddressId() {
        return defaultBillingAddressId;
    }

    public void setDefaultBillingAddressId(Integer defaultBillingAddressId) {
        this.defaultBillingAddressId = defaultBillingAddressId;
    }

    public Integer getDefaultShippingAddressId() {
        return defaultShippingAddressId;
    }

    public void setDefaultShippingAddressId(Integer defaultShippingAddressId) {
        this.defaultShippingAddressId = defaultShippingAddressId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getJwtTokenKey() {
        return jwtTokenKey;
    }

    public void setJwtTokenKey(String jwtTokenKey) {
        this.jwtTokenKey = jwtTokenKey;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getSearchDocument() {
        return searchDocument;
    }

    public void setSearchDocument(String searchDocument) {
        this.searchDocument = searchDocument;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public ZonedDateTime getLastPasswordResetRequest() {
        return lastPasswordResetRequest;
    }

    public void setLastPasswordResetRequest(ZonedDateTime lastPasswordResetRequest) {
        this.lastPasswordResetRequest = lastPasswordResetRequest;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getDealerType() {
        return dealerType;
    }

    public void setDealerType(String dealerType) {
        this.dealerType = dealerType;
    }

    public String getPlaceOfSupply() {
        return placeOfSupply;
    }

    public void setPlaceOfSupply(String placeOfSupply) {
        this.placeOfSupply = placeOfSupply;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

}
