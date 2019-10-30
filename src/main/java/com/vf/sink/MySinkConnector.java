package com.vf.sink;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySinkConnector extends SinkConnector {

    private static Logger LOGGER = LoggerFactory.getLogger(MySinkConnector.class);
    private MySinkConnectorConfig config;

    @Override
    public void start(Map<String, String> map) {
        LOGGER.info("Starting connector");
        config = new MySinkConnectorConfig(map);
    }

    @Override
    public Class<? extends Task> taskClass() {
        return MySinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        LOGGER.info("Max tasks: {}", maxTasks);
        List<Map<String, String>> configs = new ArrayList<>(maxTasks);
        Map<String, String> taskConfig = new HashMap<>(config.originalsStrings());
        configs.add(taskConfig);
        return configs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return MySinkConnectorConfig.conf();
    }

    @Override
    public String version() {
        return "1";
    }
}
