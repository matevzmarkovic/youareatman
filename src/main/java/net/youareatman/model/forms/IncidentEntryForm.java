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

package net.youareatman.model.forms;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.youareatman.model.AtmanUser;
import net.youareatman.model.IncidentEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class IncidentEntryForm implements Serializable
{
    private static final long serialVersionUID = -3029133732242241606L;

    private Date date;

    private AtmanUser atmanUser;

    private String antarayahType;

    private String sahabhuvaType;

    private String description;

    private static Logger logger = LogManager.getLogger(IncidentEntryForm.class);

    protected IncidentEntryForm() {

    }

    public IncidentEntryForm(IncidentEntry incidentEntry) {
        this.date = incidentEntry.getDate();
        this.atmanUser = incidentEntry.getUser();
        this.antarayahType = incidentEntry.getAntarayahType();
        this.sahabhuvaType = incidentEntry.getSahabhuvaType();
        this.description = incidentEntry.getDescription();
    }

    public IncidentEntryForm(Date date, AtmanUser atmanUser, String antarayahType, String sahabhuvaType, String description) {
        this.date = date;
        this.atmanUser = atmanUser;
        this.antarayahType = antarayahType;
        this.sahabhuvaType = sahabhuvaType;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("IncidentEntryForm[incidentId=%d, entryDate='%s', userEmail='%s', antarayahType='%s', sahabhuvaType='%s', description='%s']", date.toString(), atmanUser.getUserEmail(), antarayahType, sahabhuvaType, description);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setEntryDate(Date date) {
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
