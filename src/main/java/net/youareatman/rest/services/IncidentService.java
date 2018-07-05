package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
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
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByAtmanUser(userEmail).forEach(incidents::add);
        return incidents;
    }

    public List<IncidentEntry> listIncidentEntriesByDate(Date date){
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByDate(date).forEach(incidents::add);;
        return incidents;
    }

    public IncidentEntry listIncidentEntry(String incidentId) throws IncidentManagementException{
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        return incidentRepository.findById(incidentId).orElseThrow(() -> new IncidentManagementException("Error while reading incident from database", ErrorTypesEnum.InvalidIncidentIdError));
    }

    //Ignore incidentId in the sourceIncidentEntry, as it is used just as a placeholder for data
    //  destined to be associated with the existing incident entry in the database.
    public IncidentEntry changeIncidentEntry(String incidentId, IncidentEntryForm incidentEntryForm) throws IncidentManagementException {
        IncidentEntry targetIncidentEntry = listIncidentEntry(incidentId);
        copyIncidentEntryValues(incidentEntryForm,targetIncidentEntry);
        return incidentRepository.save(targetIncidentEntry);
    }

    public IncidentEntry createIncidentEntry(IncidentEntry incidentEntry){
        //incidentEntry->incidentId is ignored, as incidentId is created automatically.
        return incidentRepository.save(incidentEntry);
    }

    public boolean deleteIncidentEntry(String incidentId){
        if (incidentRepository.existsById(incidentId)) {
            incidentRepository.deleteById(incidentId);
            return true;
        }
        return false;
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
