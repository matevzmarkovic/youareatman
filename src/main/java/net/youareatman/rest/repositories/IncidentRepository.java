package net.youareatman.rest.repositories;

import net.youareatman.model.AtmanUser;
import net.youareatman.model.IncidentEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IncidentRepository extends CrudRepository<IncidentEntry, String> {


    /**
     * Finds incidents by using the user email as a search criteria.
     * @param Email
     * @return  A list of incidents of which user email is an exact match with the given user email.
     *          If no incident is found, this method returns an empty list.
     */
    public List<IncidentEntry> findByAtmanUser(String Email);

    /**
     * Finds incidents by using the date as a search criteria.
     * @param date
     * @return  A list of incidents of which date is an exact match with the given date.
     *          If no incident is found, this method returns an empty list.
     */
    public List<IncidentEntry> findByDate(Date date);

}
