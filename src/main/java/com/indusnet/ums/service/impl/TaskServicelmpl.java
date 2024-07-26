package com.indusnet.ums.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.exception.CustomNotFoundException;
import com.indusnet.ums.exception.UnprocessableException;
import com.indusnet.ums.model.TaskModel;
import com.indusnet.ums.repository.ITaskServiceRepository;
import com.indusnet.ums.service.ITaskService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class TaskServicelmpl implements ITaskService {
    @Autowired
	Gson gson = new Gson();

	@Autowired
	ITaskServiceRepository repository;

    @Override
    public ResponseModel add(TaskModel model) {
        Long currentTimeInMilli = Instant.now().toEpochMilli();
        TaskModel saveModel = TaskModel.builder()
                .title(model.getTitle())
                .description(model.getDescription())
                .assignedUser(model.getAssignedUser())
                .dueDate(model.getDueDate())
                .completed(model.getCompleted())
                .build();

        repository.save(saveModel);

        //log.info(gson.toJson(saveModel));

        return ResponseModel.builder()
                .messageEn("Task Added Successfully")
                .messageFr("Task Added Successfully")
                .messageTypeId(1)
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public List<TaskModel> getTasks() {
        return repository.findAll();
    }

    @Override
    public TaskModel getTaskById(String taskId) {
        return repository.findById(taskId).orElse(null);
    }

    @Override
    public void deleteTask(String taskId) {
        repository.deleteById(taskId);
    }

    @Override
    public ResponseModel updateTask(TaskModel user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTask'");
    }

    // @Override
    // public ResponseModel updateTask(TaskModel task) {
    //     TaskModel existingTask = repository.findById(task.getId()).orElse(null);
    //     if (existingTask != null) {
    //         existingTask.setTitle(task.getTitle());
    //         existingTask.setDescription(task.getDescription());
    //         existingTask.setAssignedUser(task.getAssignedUser());
    //         existingTask.setDueDate(task.getDueDate());
    //         existingTask.setCompleted(task.getCompleted());
    //         repository.save(existingTask);

    //         return ResponseModel.builder()
    //                 .messageEn("Task Updated Successfully")
    //                 .messageFr("Task Updated Successfully")
    //                 .messageTypeId(1)
    //                 .statusCode(HttpStatus.OK)
    //                 .build();
    //     } else {
    //         return ResponseModel.builder()
    //                 .messageEn("Task Not Found")
    //                 .messageFr("Task Not Found")
    //                 .messageTypeId(2)
    //                 .statusCode(HttpStatus.NOT_FOUND)
    //                 .build();
    //     }
    // }
}
