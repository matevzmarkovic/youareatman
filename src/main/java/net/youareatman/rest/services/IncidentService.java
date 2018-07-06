package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.model.IncidentEntry;
import net.youareatman.model.forms.IncidentEntryForm;
import net.youareatman.rest.repositories.IncidentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static net.youareatman.helpers.YouAreAtmanHelpers.*;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    private static Logger logger = LogManager.getLogger(IncidentService.class);

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<IncidentEntry>listIncidentEntries(){
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findAll().forEach(incidents::add);

        return incidents;
    }

    public List<IncidentEntry>listIncidentEntriesByUser(String userEmail) throws IncidentManagementException {
        validateUserEmail_Incident(userEmail);

        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByAtmanUser(userEmail).forEach(incidents::add);
        return incidents;
    }

    public List<IncidentEntry> listIncidentEntriesByDate(Date date) throws IncidentManagementException {
        validateDate_Incident(date);

        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByDate(date).forEach(incidents::add);;
        return incidents;
    }

    public IncidentEntry listIncidentEntry(String incidentId) throws IncidentManagementException{
        validateIncidentId(incidentId);

        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        return incidentRepository.findById(incidentId).orElseThrow(() -> new IncidentManagementException("Error while reading incident from database", ErrorTypesEnum.IncidentNotFoundError));
    }

    //Ignore incidentId in the sourceIncidentEntry, as it is used just as a placeholder for data
    //  destined to be associated with the existing incident entry in the database.
    public IncidentEntry changeIncidentEntry(String incidentId, IncidentEntryForm incidentEntryForm) throws IncidentManagementException {
        validateIncidentId(incidentId);

        IncidentEntry targetIncidentEntry = listIncidentEntry(incidentId);
        copyIncidentEntryValues(incidentEntryForm,targetIncidentEntry);
        return incidentRepository.save(targetIncidentEntry);
    }

    //IncidentId is erased before insertion into database, due to it being automatically generated
    public IncidentEntry createIncidentEntry(IncidentEntry incidentEntry){
        //incidentEntry->incidentId should be erased, as incidentId is created automatically.
        incidentEntry.setIncidentId(null);
        return incidentRepository.save(incidentEntry);
    }

    public void deleteIncidentEntry(String incidentId) throws IncidentManagementException{
        validateIncidentId(incidentId);

        if (incidentRepository.existsById(incidentId)) {
            incidentRepository.deleteById(incidentId);
        }
    }

    /**
     * Copy all non-null fields from the form to the target incident entry.
     * Preserve incidentId in the target incident entry.
     * @param form
     * @param target
     */
    private void copyIncidentEntryValues(IncidentEntryForm form, IncidentEntry target) {
        if (form.getAntarayahType() != null) {
            target.setAntarayahType(form.getAntarayahType());
        }
        if (form.getDescription() != null) {
            target.setDescription(form.getDescription());
        }
        if (form.getDate() != null) {
            target.setDate(form.getDate());
        }
        if (form.getSahabhuvaType() != null) {
            target.setSahabhuvaType(form.getSahabhuvaType());
        }
        if (form.getUser() != null) {
            target.setUser(form.getUser());
        }
    }

}
