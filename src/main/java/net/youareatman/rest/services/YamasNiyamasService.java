package net.youareatman.rest.services;

import net.youareatman.model.NiyamasEntry;
import net.youareatman.model.YamasEntry;
import net.youareatman.model.forms.NiyamasEntryForm;
import net.youareatman.model.forms.YamasEntryForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class YamasNiyamasService {

    private static Logger logger = LogManager.getLogger(YamasNiyamasService.class);

    public List<YamasEntry> listAllYamasEntries(){
        return null;
    }

    public List<NiyamasEntry> listAllNiyamasEntries(){
        return null;
    }

    public List<YamasEntry> listYamasEntriesByUser(String userEmail){
        return null;
    }

    public List<NiyamasEntry> listNiyamasEntriesByUser(String userEmail){
        return null;
    }

    public List<YamasEntry> listYamasEntriesByDate(Date date){
        return null;
    }

    public List<NiyamasEntry> listNiyamasEntriesByDate(Date date){
        return null;
    }

    public YamasEntry listYamasEntry(YamasEntryForm yamasEntryForm){
        return null;
    }

    public NiyamasEntry listNiyamasEntry(NiyamasEntryForm niyamasEntryForm){
        return null;
    }

    public YamasEntry createYamasEntry(YamasEntry yamasEntry){
        return null;
    }

    public NiyamasEntry createNiyamasEntry(NiyamasEntry niyamasEntry){
        return null;
    }

    public YamasEntry changeYamasEntry(YamasEntry yamasEntry){
        return null;
    }

    public NiyamasEntry changeNiyamasEntry(NiyamasEntry niyamasEntry){
        return null;
    }

    public YamasEntryForm deleteYamasEntry(YamasEntryForm yamasEntryForm){
        return null;
    }

    public NiyamasEntryForm deleteNiyamasEntry(NiyamasEntryForm niyamasEntryForm){
        return null;
    }

}
