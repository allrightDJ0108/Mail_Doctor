package com.woori.maildoc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woori.maildoc.dto.response.ResultRes;
import com.woori.maildoc.dto.resquest.MailReq;
import com.woori.maildoc.service.MailService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailController {
	
	private final MailService mailService;
	
	@PostMapping()
	public ResponseEntity<List<ResultRes>> fix(@RequestBody MailReq mailReq) {
		System.out.println("ddddddddd");
		log.info("contents  :  " + mailReq.getContents());
		return new ResponseEntity<>(mailService.sendKakao(mailReq), HttpStatus.OK);
	}
}
