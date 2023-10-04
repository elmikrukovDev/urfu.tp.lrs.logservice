package com.edu.SpringLr1.service;

import com.edu.SpringLr1.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyUid")
public class ModifyUid implements ModifyService {

    @Override
    public Response modify(Response response) {
        response.setUid("New Uid");
        return response;
    }
}
