package net.ims.service;

import java.util.List;

import net.ims.entity.Feedback;
import net.ims.exceptionalhandler.RecordNotFoundException;

public interface FeedbackDAO {
	public Feedback addFeedback(Feedback feedback);
	
	public List<Feedback> getAllFeedbacks();
	
    
			
	
	public boolean deleteFeedback(Integer id);
			
	 Feedback getFeedbackById(Integer id)throws RecordNotFoundException;

}
