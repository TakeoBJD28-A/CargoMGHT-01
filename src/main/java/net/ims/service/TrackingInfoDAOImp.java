package net.ims.service;

import net.ims.entity.TrackingInfo;

import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.repo.TrackingInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackingInfoDAOImp {
    @Autowired
    private TrackingInfoRepo trinfo;
    public List<TrackingInfo> getAllTrackingList(){

        return trinfo.findAll();

    }
    public TrackingInfo addTrackingInfo(TrackingInfo tr){
       return trinfo.save(tr);
    }
    public TrackingInfo saveOrUpdateTrackingInfo(TrackingInfo tr){
       // Optional<TrackingInfo> trOptional = trinfo.findById(tr.);
        //TrackingInfo b= trOptional.get();
       // if (b!=null)
          //  b=trinfo.saveTrackingInfo(b);

        return null;
    }
    public boolean deleteTracking(Integer id) throws RecordNotFoundException {
        Optional<TrackingInfo> userOptional = trinfo.findById(id);
        TrackingInfo trrr=userOptional.get();
        boolean flag =false;
        if (trrr!=null) {
            trinfo.deleteById(id);
            flag=true;
        } else {


        }return flag;
    }

    TrackingInfo getTrackingInfoById(Integer id ) throws RecordNotFoundException {
////
        return null;
    }
}
