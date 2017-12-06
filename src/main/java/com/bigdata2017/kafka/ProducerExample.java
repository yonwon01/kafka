package com.bigdata2017.kafka;

import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerExample {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("metadata.broker.list",
				"redis.poptok.com:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		ProducerConfig producerConfig = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(producerConfig);
		KeyedMessage<String, String> message = new KeyedMessage<String, String>("test", "Hello, World!");
		producer.send(message);
		producer.close();

	}

}
