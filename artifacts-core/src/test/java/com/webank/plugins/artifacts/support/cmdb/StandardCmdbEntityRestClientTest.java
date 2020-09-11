package com.webank.plugins.artifacts.support.cmdb;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.webank.plugins.artifacts.interceptor.AuthorizationStorage;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StandardCmdbEntityRestClientTest {
    
    @Autowired
    private StandardCmdbEntityRestClient client;
    
    @Before
    public void setUp() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJTWVNfU0FMVFNUQUNLIiwiaWF0IjoxNTkwMTE4MjYxLCJ0eXBlIjoiYWNjZXNzVG9rZW4iLCJjbGllbnRUeXBlIjoiU1VCX1NZU1RFTSIsImV4cCI6MTc0NTYzODI2MSwiYXV0aG9yaXR5IjoiW1NVQl9TWVNURU1dIn0.N2sD9F4TKh1yaatRfr-sqRqlP7fiSqZ1znmr7AtQanr2ZmbldZt2ICeuUnIUcpGGK3YZKKqOPic2JNeECblgnw";
        token = String.format("Bearer %s", token);
        
        AuthorizationStorage.getIntance().set(token);
    }

    @Test
    public void testQueryDiffConfigurations() {
        List<Map<String,Object>> results = client.queryDiffConfigurations();
        for(Map<String,Object> result : results) {
            System.out.println("==========================");
            result.entrySet().forEach(e -> {
                System.out.println(String.format("k:%s, v:%s", e.getKey(), e.getValue()));
            } );
        }
    }

}
