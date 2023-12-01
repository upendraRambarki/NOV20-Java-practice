package com.upendra.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

//	@Value("${spring.kafka.topic.name}")
//	private String topicName;
//	
//	@Value("${spring.kafka.topic-json.name}")
//	private String topicNameJson;
	@Bean
	public NewTopic javaGuidesTopics()
	{
//		return TopicBuilder.name("topicName")
		return TopicBuilder.name("NewjavaGuides")
			//	.partitions(2) it will create two partitions
				.build();
	}
	
	@Bean
	public NewTopic javaGuidesJsonTopics()
	{
//		return TopicBuilder.name("topicNameJson")
		return TopicBuilder.name("NewjavaGuideJson")
			//	.partitions(2) it will create two partitions
				.build();
	}
}
