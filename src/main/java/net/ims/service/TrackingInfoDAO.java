package net.ims.service;

import net.ims.entity.ShippingList;
import net.ims.entity.TrackingInfo;
import net.ims.exceptionalhandler.RecordNotFoundException;

import java.util.List;

public interface TrackingInfoDAO {
    public List<TrackingInfo> getAllTrackingList();
    public TrackingInfo saveTrackingInfo(TrackingInfo tr);
    public TrackingInfo saveOrUpdateTrackingInfo(TrackingInfo tr);
    public boolean deleteTracking(Integer id);
    TrackingInfo getTrackingInfoById(Integer id ) throws RecordNotFoundException;
}
