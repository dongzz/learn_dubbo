package com.dongz.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dong
 * @date 2020/4/17 17:08
 * @desc
 */
@ConfigurationProperties(prefix = "dongz.test")
public class TestProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
