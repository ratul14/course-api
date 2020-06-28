package com.mukit.start.topiccontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topic =new ArrayList<>(Arrays.asList(
			new Topic("1","Spring", "Spring Boot Practice"),
			new Topic("2","Ember", "Ember JS Practice"),
			new Topic("3","Ember", "Ember JS Practice")
			));
	
	public List<Topic> getAllTopics(){
		return topic;
	}
	
	public Topic getTopicById(String id) {
		return topic.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic2) {
		topic.add(topic2);
	}

	public void updateTopic(Topic topic2, String id) {
		for(int i=0;i<topic.size();i++) {
			Topic t = topic.get(i);
			if(t.getId().equals(id)) {
				topic.set(i,topic2);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topic.removeIf(t-> t.getId().equals(id));
	}
}
