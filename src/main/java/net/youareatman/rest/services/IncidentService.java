package net.youareatman.rest.services;

import net.youareatman.model.IncidentEntry;
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

    public IncidentEntry changeIncidentEntry(String incidentId, IncidentEntry incidentEntry){
        //incidentEntry->incidentId is never overwritten by the supplied value in incidentEntry input.

        return null;
    }

    public IncidentEntry createIncidentEntry(IncidentEntry incidentEntry){
        //incidentEntry->incidentId is ignored, as incidentId is created automatically.

        return null;
    }

    public IncidentEntry deleteIncidentEntry(String incidentId){
        return null;
    }

}
