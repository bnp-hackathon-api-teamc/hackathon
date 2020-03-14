package com.bnpparibas.hackathon.findmyspot.api.service;

import org.springframework.stereotype.Service;

@Service
public interface FindMySpotService {

    String assign(String building, long userId);
}
