package com.vf.sink;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class MySinkConnectorConfig extends AbstractConfig {

    public static final String MY_SETTING_CONFIG = "some.property";
    private static final String MY_SETTING_DOC = "Some test property";

    public MySinkConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }

    public MySinkConnectorConfig(Map<String, String> parsedConfig) {
        this(conf(), parsedConfig);
    }

    public static ConfigDef conf() {
        return new ConfigDef()
                .define(MY_SETTING_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.LOW, MY_SETTING_DOC);
    }

}
