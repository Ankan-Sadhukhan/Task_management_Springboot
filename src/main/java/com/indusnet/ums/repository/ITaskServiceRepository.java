package com.indusnet.ums.repository;
import com.indusnet.ums.model.TaskModel;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITaskServiceRepository extends MongoRepository<TaskModel, String> {
	 
	Optional<TaskModel> findByTitle(String title);
    List<TaskModel> findByAssignedUser(String assignedUser);
    List<TaskModel> findByCompleted(String completed);
}