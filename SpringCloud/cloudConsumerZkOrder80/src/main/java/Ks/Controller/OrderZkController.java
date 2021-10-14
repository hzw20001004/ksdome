package Ks.Controller;

import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderZkController
 * @Date 2021/10/14 19:10
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderZkController {
    public static final String URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("order")
    public Dto<String> order90(){

        return restTemplate.getForObject(URL+"/payment/zk", Dto.class);
    }



}
