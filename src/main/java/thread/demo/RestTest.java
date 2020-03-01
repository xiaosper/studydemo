package thread.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @Date 2020/1/16
 * @since 1.0.0
 */
@Component
public class RestTest {

    @Resource
    private RestTemplate restTemplate;

    @PostConstruct
    public void init(){
        Map<String, String> postParam=new HashMap<>();
        postParam.put("username","gateway_test");
        postParam.put("password","m4ZH+yS8rhFflbCvUmAVGkO52lU=");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
        HttpEntity<Map> strEntity = new HttpEntity<Map>(postParam,headers);
        //String authResult=restTemplate.getForObject(authUrl, String.class,username,password);
        String authResult=restTemplate.postForObject("http://chainet.jd.com/gateway/user/auth"
                , strEntity, String.class);
        System.out.println(authResult);
    }
}
