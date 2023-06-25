package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.Feedback;
import net.ims.exceptionalhandler.RecordNotFoundException;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	Feedback findByEmail(String email)throws RecordNotFoundException;
}
