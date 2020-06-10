package com.berg.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public  class AppConstants {

    @Value("${spring.application.name}")
    String appName;
    @Value("${server.port}")
    String port;

    @Value("${snowflake.id.worker.workerId:0}")
    String workerId;
    @Value("${snowflake.id.worker.datacenterId:0}")
    String datacenterId;
}
