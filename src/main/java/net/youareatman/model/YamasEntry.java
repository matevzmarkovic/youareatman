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

import java.util.Date;

public class YamasEntry
{
    private final Date entryDate;
    private final String userEmail;
    private final boolean ahimsa;
    private final boolean aparigraha;
    private final boolean asteya;
    private final boolean brahmacharya;
    private final boolean satya;

    private static Logger logger = LogManager.getLogger(YamasEntry.class);

    public YamasEntry(Date entryDate, String userEmail, boolean ahimsa, boolean aparigraha, boolean asteya, boolean brahmacharya, boolean satya) {
        this.entryDate = entryDate;
        this.userEmail = userEmail;
        this.ahimsa = ahimsa;
        this.aparigraha = aparigraha;
        this.asteya = asteya;
        this.brahmacharya = brahmacharya;
        this.satya = satya;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public String getUserEmail() {
        return userEmail;
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
}
