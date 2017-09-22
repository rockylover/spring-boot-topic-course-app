package com.example.demo.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private int startId = 1;
			
	public List<Topic> getAllTopics() {
		List<Topic> retVal = new ArrayList<>();
		topicRepository.findAll()
		.forEach(retVal::add);
		return retVal;
	}
	
	public Topic getTopic(int id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topic.setId(startId);
		startId++;
		topicRepository.save(topic);
	}

	public void updateTopic(int id, Topic topic) {
		topic.setId(id);
		topicRepository.save(topic);
	}

	public void deleteTopic(int id) {
		topicRepository.delete(id);
	}
	
}

