package com.bev.bankappbackend.controller;

import com.bev.bankappbackend.model.Notice;
import com.bev.bankappbackend.repo.NoticeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepo noticeRepo;

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeRepo.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(notices);
        } else {
            return null;
        }
    }


}
