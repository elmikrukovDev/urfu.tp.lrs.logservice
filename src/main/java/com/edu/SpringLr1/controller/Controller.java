package com.edu.SpringLr1.controller;

import com.edu.SpringLr1.model.Request;
import com.edu.SpringLr1.model.Response;
import com.edu.SpringLr1.service.ModifyRequestService;
import com.edu.SpringLr1.service.ModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    private final ModifyService modifyService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public Controller(@Qualifier("ModifyErrorMessage") ModifyService modifyService,
                      ModifyRequestService modifyRequestService) {
        this.modifyService = modifyService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {
        log.warn("Входящий запрос : " + String.valueOf(request));
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        modifyRequestService.modifyRq(request);
        Response responseAfterModify = modifyService.modify(response);
        log.warn("Исходящий запрос : " + String.valueOf(request));
        return  new ResponseEntity<>(responseAfterModify, HttpStatus.OK);
    }
}
