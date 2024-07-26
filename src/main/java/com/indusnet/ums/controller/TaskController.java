package com.indusnet.ums.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusnet.ums.util.ObjectIdTypeAdapter;
import com.indusnet.ums.common.MessageTypeConst;
import com.indusnet.ums.common.LoggingResponseModel;
import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.TaskModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indusnet.ums.service.ITaskService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tasks/")
@Slf4j
public class TaskController {

    
    @Autowired
    Gson gson;

    @Autowired
    private ITaskService taskService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> addTask(@RequestBody TaskModel taskModel) {
        ResponseModel response = taskService.add(taskModel);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<TaskModel>> getAllTasks() {
    //     List<TaskModel> tasks = taskService.getTasks();
    //     return new ResponseEntity<>(tasks, HttpStatus.OK);
    // }

    // @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<TaskModel> getTaskById(@PathVariable String id) {
    //     TaskModel task = taskService.getTaskById(id);
    //     if (task == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(task, HttpStatus.OK);
    // }

    // @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<ResponseModel> updateTask(@PathVariable String id, @RequestBody TaskModel taskModel) {
    //     taskModel.setId(id);
    //     ResponseModel response = taskService.updateTask(taskModel);
    //     return new ResponseEntity<>(response, response.getStatusCode());
    // }

    // @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Void> deleteTask(@PathVariable String id) {
    //     taskService.deleteTask(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }



    // @Autowired
    // Gson gson;

    // @Autowired
    // ITaskService service;

    // Gson customGson = new GsonBuilder().registerTypeHierarchyAdapter(ObjectId.class, new ObjectIdTypeAdapter())
    //         .create();

    // @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<ResponseModel> register(@RequestBody String request) {

    //     LoggingResponseModel msgStart = LoggingResponseModel.builder()
    //             .message("Start add register")
    //             .messageTypeId(MessageTypeConst.SUCCESS)
    //             .build();

    //     log.info(gson.toJson(msgStart));
    //     ResponseModel response = service.add(customGson.fromJson(request, TaskModel.class));
    //     HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;

    //     LoggingResponseModel msgEnd = LoggingResponseModel.builder()
    //             .message("End Add register")
    //             .messageTypeId(MessageTypeConst.SUCCESS)
    //             .build();

    //     log.info(gson.toJson(msgEnd));

    //     return new ResponseEntity<ResponseModel>(response, status);
    // }

    // @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<TaskModel>> getUsers() {
    //     List<TaskModel> users = service.getUsers();
    //     return new ResponseEntity<>(users, HttpStatus.OK);
    // }

    // @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<TaskModel> getUserById(@PathVariable("userId") String userId) {
    //     TaskModel user = service.getUserById(userId);
    //     if (user == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(user, HttpStatus.OK);
    // }

    // @DeleteMapping(value = "/users/{userId}")
    // public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
    //     service.deleteUser(userId);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No content to return after deletion
    // }

    // @PutMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<ResponseModel> updateUser(@PathVariable("userId") String userId,
    //         @RequestBody String request) {
    //     // ObjectId objectId = new ObjectId(userId);
    //     TaskModel userToUpdate = customGson.fromJson(request, TaskModel.class);
    //     ResponseModel response = service.updateUser(userToUpdate);
    //     HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.BAD_REQUEST;
    //     return new ResponseEntity<>(response, status);
    // }
}
