package net.ims.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.ims.entity.Feedback;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.repo.FeedbackRepo;

@Service
public class FeedbackService implements FeedbackDAO {

	@Autowired
	private FeedbackRepo fRepo;
     
	
	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return fRepo.findAll();
		
	}

	

	@Override
	public boolean deleteFeedback(Integer id) {
		// TODO Auto-generated method stub
		Optional<Feedback> feedbackOptional = fRepo.findById(id);
		Feedback feedback = feedbackOptional.get();
		boolean flag = false;
		if(feedback!=null)
		{
			fRepo.deleteById(id);
		    flag=true;
		}
		
		    	return flag;
	}

	@Override
	public Feedback getFeedbackById(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		
     	Optional<Feedback> findById = fRepo.findById(id);
			
			Feedback f = findById.get();
			
			if(f!=null)
			return f;
			
			else
				throw new RecordNotFoundException("Not Found");
		}
	

	@Override
	public Feedback addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Feedback saveEnt = fRepo.save(feedback);
		if(saveEnt!=null)
			return saveEnt;
		else
			return null;
		
	}

	

	
}
