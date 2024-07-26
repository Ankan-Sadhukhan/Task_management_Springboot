package com.indusnet.ums.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.TaskModel;

import jakarta.validation.Valid;
public interface ITaskService {

    ResponseModel add(@Valid TaskModel model);

	List<TaskModel> getTasks();

	TaskModel getTaskById(String userId);

	void deleteTask(String userId);

	ResponseModel updateTask(TaskModel user);
}
