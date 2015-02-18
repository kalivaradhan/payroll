package com.fibrecat.webapp.model;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String office;

    private String interests;

    @Column(name="IS_FULLTIME_EMPLOYEE" , columnDefinition="boolean default true")
    private boolean fullTimeEmployee;

    private String certifications;

    private Blob profilePhoto;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", unique = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "OFFICE")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Column(name = "INTERESTS", length = 500)
    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public boolean isFullTimeEmployee() {
        return fullTimeEmployee;
    }

    public void setFullTimeEmployee(boolean fullTimeEmployee) {
        this.fullTimeEmployee = fullTimeEmployee;
    }

    @Column(name = "CERTIFICATIONS", length = 150)
    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    @Column(name="PROFILE_PHOTO" , columnDefinition="blob")
    public Blob getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Blob profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

}
