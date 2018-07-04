package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.model.IncidentEntry;
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

    public List<IncidentEntry>listIncidentEntriesByUser(String userEmail) throws GenericYouAreAtmanException {
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByAtmanUser(userEmail).forEach(incidents::add);
        return incidents;
    }

    public List<IncidentEntry> listIncidentEntriesByDate(Date date){
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        incidentRepository.findByEntryDate(date).forEach(incidents::add);;
        return incidents;
    }

    public IncidentEntry listIncidentEntry(String incidentId) throws GenericYouAreAtmanException{
        List<IncidentEntry> incidents = new ArrayList<IncidentEntry>();
        IncidentEntry incidentEntry =  incidentRepository.findById(incidentId).orElseThrow(() -> new GenericYouAreAtmanException("Error while reading incident from database", ErrorTypesEnum.CRUDError));

        return incidentEntry;
    }

    //Ignore incidentId in the sourceIncidentEntry, as it is used just as a placeholder for data
    //  destined to be associated with the existing incident entry in the database.
    public IncidentEntry changeIncidentEntry(String incidentId, IncidentEntry sourceIncidentEntry) throws GenericYouAreAtmanException{
        IncidentEntry targetIncidentEntry = listIncidentEntry(incidentId);
        copyIncidentEntryValues(sourceIncidentEntry,targetIncidentEntry);
        incidentRepository.save(targetIncidentEntry);

        return targetIncidentEntry;
    }

    public IncidentEntry createIncidentEntry(IncidentEntry incidentEntry){
        //incidentEntry->incidentId is ignored, as incidentId is created automatically.
        incidentRepository.save(incidentEntry);

        return incidentEntry;
    }

    public void deleteIncidentEntry(String incidentId){
        incidentRepository.deleteById(incidentId);
    }

    /**
     * Copy all non-null fields from the source to the destination incident entry. Ignore incidentId in the source incident entry.
     * @param source
     * @param destination
     */
    private void copyIncidentEntryValues(IncidentEntry source, IncidentEntry destination) {
        if (source.getAntarayahType() != null) {
            destination.setAntarayahType(source.getAntarayahType());
        }
        if (source.getDescription() != null) {
            destination.setDescription(source.getDescription());
        }
        if (source.getEntryDate() != null) {
            destination.setEntryDate(source.getEntryDate());
        }
        if (source.getSahabhuvaType() != null) {
            destination.setSahabhuvaType(source.getSahabhuvaType());
        }
        if (source.getAtmanUser() != null) {
            destination.setUser(source.getAtmanUser());
        }
    }

}
