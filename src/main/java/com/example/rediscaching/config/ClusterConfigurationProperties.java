package com.example.rediscaching.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigurationProperties {

        List<String> nodes = new ArrayList<>();

        public ClusterConfigurationProperties() {
            nodes.add("127.0.0.1:7000");
            nodes.add("127.0.0.1:7001");
            nodes.add("127.0.0.1:7002");
            nodes.add("127.0.0.1:7003");
            nodes.add("127.0.0.1:7004");
            nodes.add("127.0.0.1:7005");
        }



        public List<String> getNodes() {
            return nodes;
        }

        public void setNodes(List<String> nodes) {
            this.nodes = nodes;
        }

}
