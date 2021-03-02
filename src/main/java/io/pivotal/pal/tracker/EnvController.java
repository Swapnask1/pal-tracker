package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;
    private Map<String, String> EnvMap = new HashMap<String, String>();
    public EnvController(@Value("${PORT:NOT SET}") String s, @Value("${MEMORY_LIMIT:NOT SET}") String s1, @Value("${CF_INSTANCE_INDEX:NOT SET}") String s2, @Value("${CF_INSTANCE_ADDR:NOT SET}") String s3) {
        this.PORT = s;
        this.MEMORY_LIMIT = s1;
        this.CF_INSTANCE_INDEX = s2;
        this.CF_INSTANCE_ADDR = s3;
    }
    @GetMapping("/env")
    public Map<String, String> getEnv() {
        EnvMap.put("PORT",this.PORT);
        EnvMap.put("MEMORY_LIMIT",this.MEMORY_LIMIT);
        EnvMap.put("CF_INSTANCE_INDEX",this.CF_INSTANCE_INDEX);
        EnvMap.put("CF_INSTANCE_ADDR",this.CF_INSTANCE_ADDR);
        return EnvMap;
    }

}
