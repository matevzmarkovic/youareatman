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

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Yamas")
public class YamasEntry implements Serializable
{
    private static final long serialVersionUID = -3309157342242245606L;

    @EmbeddedId
    YamasNiyamasEntryId entryId;

    @Column(name = "ahimsa")
    private boolean ahimsa;

    @Column(name = "aparigraha")
    private boolean aparigraha;

    @Column(name = "asteya")
    private boolean asteya;

    @Column(name = "brahmacharya")
    private boolean brahmacharya;

    @Column(name = "satya")
    private boolean satya;

    private static Logger logger = LogManager.getLogger(YamasEntry.class);

    protected YamasEntry(){

    }

    public YamasEntry(YamasNiyamasEntryId entryId, boolean ahimsa, boolean aparigraha, boolean asteya, boolean brahmacharya, boolean satya) {
        this.entryId = entryId;
        this.ahimsa = ahimsa;
        this.aparigraha = aparigraha;
        this.asteya = asteya;
        this.brahmacharya = brahmacharya;
        this.satya = satya;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public YamasNiyamasEntryId getEntryId() {
        return entryId;
    }

    public boolean isAhimsa() {
        return ahimsa;
    }

    public boolean isAparigraha() {
        return aparigraha;
    }

    public boolean isAsteya() {
        return asteya;
    }

    public boolean isBrahmacharya() {
        return brahmacharya;
    }

    public boolean isSatya() {
        return satya;
    }

    public void setEntryId(YamasNiyamasEntryId entryId) {
        this.entryId = entryId;
    }

    public void setAhimsa(boolean ahimsa) {
        this.ahimsa = ahimsa;
    }

    public void setAparigraha(boolean aparigraha) {
        this.aparigraha = aparigraha;
    }

    public void setAsteya(boolean asteya) {
        this.asteya = asteya;
    }

    public void setBrahmacharya(boolean brahmacharya) {
        this.brahmacharya = brahmacharya;
    }

    public void setSatya(boolean satya) {
        this.satya = satya;
    }
}
