package Ks.Controller;

import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderController {
    public static final String URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consul")
    public Dto<String> order90(){

        return restTemplate.getForObject(URL+"/payment/consul", Dto.class);
    }
}