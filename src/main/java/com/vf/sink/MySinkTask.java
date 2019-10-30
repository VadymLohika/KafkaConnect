package com.vf.sink;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

public class MySinkTask extends SinkTask {

    private static Logger LOGGER = LoggerFactory.getLogger(MySinkTask.class);
    @Override
    public String version() {
        return "Some version";
    }

    @Override
    public void start(Map<String, String> map) {
        LOGGER.info("Starting task");
    }

    @Override
    public void put(Collection<SinkRecord> collection) {
        System.out.println("Put ...");
        for(SinkRecord record: collection){
            System.out.println(record);
        }
    }

    @Override
    public void stop() {

    }
}
