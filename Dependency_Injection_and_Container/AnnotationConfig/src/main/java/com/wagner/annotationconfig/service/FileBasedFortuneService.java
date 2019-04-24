package com.wagner.annotationconfig.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class FileBasedFortuneService implements FortuneService {

	private List<String> lines = new ArrayList<>();
	private Random rnd = new Random();
	
	@Override
	public String getFortune() {
		if (! lines.isEmpty()) {
			return lines.get(rnd.nextInt(lines.size()));
		}
		
		return "empty file";
	}
	
	@PostConstruct
	private void init() {
		try {
			lines = Files.readAllLines(ResourceUtils.getFile("classpath:fortunes.txt").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}