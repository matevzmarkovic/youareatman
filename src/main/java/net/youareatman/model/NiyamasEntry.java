/*
    Copyright (C) 2018  Matevž Markovič.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software Foundation,
    Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package net.youareatman.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Niyamas")
public class NiyamasEntry implements Serializable
{
    private static final long serialVersionUID = -3009157732234241656L;

    @Id
    @Column(name = "entryDate")
    private Date entryDate;

    @Id
    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "ishvaraPranidhana")
    private boolean ishvaraPranidhana;

    @Column(name = "santosha")
    private boolean santosha;

    @Column(name = "shaucha")
    private boolean shaucha;

    @Column(name = "svadhyaya")
    private boolean svadhyaya;

    @Column(name = "tapas")
    private boolean tapas;

    private static Logger logger = LogManager.getLogger(NiyamasEntry.class);

    protected NiyamasEntry(){

    }

    public NiyamasEntry(Date entryDate, String userEmail, boolean ishvaraPranidhana, boolean santosha, boolean shaucha, boolean svadhyaya, boolean tapas) {
        this.entryDate = entryDate;
        this.userEmail = userEmail;
        this.ishvaraPranidhana = ishvaraPranidhana;
        this.santosha = santosha;
        this.shaucha = shaucha;
        this.svadhyaya = svadhyaya;
        this.tapas = tapas;
    }

    @Override
    public String toString() {
        return String.format("Niyamas entry[entryDate='%s', userEmail='%s', ishvaraPranidhana='%b', santosha='%b', shaucha='%b', svadhyaya='%b', tapas='%b']", entryDate.toString(), userEmail, ishvaraPranidhana, santosha, shaucha, svadhyaya, tapas);
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public boolean isIshvaraPranidhana() {
        return ishvaraPranidhana;
    }

    public boolean isSantosha() {
        return santosha;
    }

    public boolean isShaucha() {
        return shaucha;
    }

    public boolean isSvadhyaya() {
        return svadhyaya;
    }

    public boolean isTapas() {
        return tapas;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
