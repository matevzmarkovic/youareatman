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

public class User
{
    private final Date joinDate;
    private final String userEmail;
    private final String passwordHash;

    private static Logger logger = LogManager.getLogger(User.class);

    public User(Date joinDate, String userEmail, String passwordHash) {
        this.joinDate = joinDate;
        this.userEmail = userEmail;
        this.passwordHash = passwordHash;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
