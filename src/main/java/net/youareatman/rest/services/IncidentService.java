package net.youareatman.rest.services;

import net.youareatman.model.IncidentEntry;
import net.youareatman.model.forms.IncidentEntryForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncidentService {

    private static Logger logger = LogManager.getLogger(IncidentService.class);

    public List<IncidentEntry>listIncidentEntries(){
        return null;
    }

    public List<IncidentEntry>listIncidentEntriesByUser(String userEmail){
        return null;
    }

    public List<IncidentEntry> listIncidentEntriesByDate(Date date){
        return null;
    }

    public IncidentEntry listIncidentEntry(String incidentId){
        return null;
    }

    public IncidentEntry changeIncidentEntry(String incidentId, IncidentEntryForm incidentEntryForm){
        return null;
    }

    public IncidentEntry createIncidentEntry(String incidentId, IncidentEntryForm incidentEntryForm){
        return null;
    }

    public IncidentEntry deleteIncidentEntry(String incidentId){
        return null;
    }

}
