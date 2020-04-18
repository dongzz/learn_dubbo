package com.dongz.starter;

/**
 * @author dong
 * @date 2020/4/17 17:07
 * @desc
 */
public class TestService {

    TestProperties testProperties;

    public String testStarter(String name) {
        return testProperties.getPrefix()+ "-" + name + "-" + testProperties.getSuffix();
    }

    public TestProperties getTestProperties() {
        return testProperties;
    }

    public void setTestProperties(TestProperties testProperties) {
        this.testProperties = testProperties;
    }
}
