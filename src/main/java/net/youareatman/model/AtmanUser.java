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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class AtmanUser implements Serializable
{
    private static final long serialVersionUID = -3009157755542241606L;

    @Id
    private String userEmail;

    private Date joinDate;

    private String passHash;

    private static Logger logger = LogManager.getLogger(AtmanUser.class);

    private AtmanUser(){

    }

    public AtmanUser(String userEmail, String passHash){
        Date today = Calendar.getInstance(TimeZone.getDefault()).getTime();
        this.joinDate = today;
        this.userEmail = userEmail;
        this.passHash = passHash;
    }

    public AtmanUser(Date joinDate, String userEmail, String passHash) {
        this.joinDate = joinDate;
        this.userEmail = userEmail;
        this.passHash = passHash;
    }

    @Override
    public String toString() {
        return String.format("AtmanUser[joinDate=%s, userEmail='%s', passHash='%s']", joinDate.toString(), userEmail, passHash);
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
