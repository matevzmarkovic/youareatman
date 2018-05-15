package net.youareatman.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

public class YamasNiyamasEntryId implements Serializable {

    private static final long serialVersionUID = 21415233534542L;

    @Column(name = "entryDate")
    private Date entryDate;

    @Column(name = "userEmail")
    @ManyToOne
    @JoinColumn(name = "Email")
    private String userEmail;

    public YamasNiyamasEntryId() {
    }

    public YamasNiyamasEntryId(Date entryDate, String userEmail) {
        this.entryDate = entryDate;
        this.userEmail = userEmail;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
