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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Entity
@Table(name = "Incident")
public class IncidentEntry implements Serializable
{
    private static final long serialVersionUID = -3029141732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(columnDefinition = "serial")
    private String incidentId;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "userEmail", nullable = false)
    @JsonIgnore
    private AtmanUser atmanUser;

    private String antarayahType;

    private String sahabhuvaType;

    private String description;

    private static Logger logger = LogManager.getLogger(IncidentEntry.class);

    protected IncidentEntry() {

    }

    public IncidentEntry(String incidentId, Date date, AtmanUser atmanUser, String antarayahType, String sahabhuvaType, String description) {
        this.incidentId = incidentId;
        this.date = date;
        this.atmanUser = atmanUser;
        this.antarayahType = antarayahType;
        this.sahabhuvaType = sahabhuvaType;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Incident[incidentId=%d, date='%s', userEmail='%s', antarayahType='%s', sahabhuvaType='%s', description='%s']", incidentId, date.toString(), atmanUser.getUserEmail(), antarayahType, sahabhuvaType, description);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public Date getDate() {
        return date;
    }

    public AtmanUser getUser() {
        return atmanUser;
    }

    public String getAntarayahType() {
        return antarayahType;
    }

    public String getSahabhuvaType() {
        return sahabhuvaType;
    }

    public String getDescription() {
        return description;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(AtmanUser atmanUser) {
        this.atmanUser = atmanUser;
    }

    public void setAntarayahType(String antarayahType) {
        this.antarayahType = antarayahType;
    }

    public void setSahabhuvaType(String sahabhuvaType) {
        this.sahabhuvaType = sahabhuvaType;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
