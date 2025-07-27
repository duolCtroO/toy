package oort.cloud;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExceptionChecker {
    private final Map<String, ExceptionRule> exceptionIpTypeMap;
    private final Clock clock;

    public ExceptionChecker(Clock clock, ExceptionRule... exceptionRules){
        this.clock = clock;
        this.exceptionIpTypeMap = new ConcurrentHashMap<>();
        Arrays.stream(exceptionRules).forEach(r -> this.exceptionIpTypeMap.put(r.getIp(), r));
    }

    public boolean check(String ip){
        if(!this.exceptionIpTypeMap.containsKey(ip)){
            return false;
        }

        ExceptionRule exceptionRule = this.exceptionIpTypeMap.get(ip);

        if(exceptionRule == null){
            return false;
        }

        return exceptionRule.isActiveAt(LocalDateTime.now(clock));
    }
}
