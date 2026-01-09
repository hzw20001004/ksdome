package utils.ip;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取地址类
 *
 * @author ruoyi
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    // IP地址查询
    public static final String IP_URL = "https://restapi.amap.com/v3/ip?key=GC7BZ-MKLCF-FXQJY-JAPRC-RVCRF-NUB3E";

    public static JSONObject getRealAddressByIP(String ip)
    {
//        ip="112.12.135.16";
        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return null;
        }
            try
            {
                String rspStr = HttpUtil.get(IP_URL+"&ip=" + ip);

//                {
//                    "status":0, "message":"Success", "request_id":"1068945d83314aedbac82ba49e347bfc", "result":{
//                    "ip":"112.12.135.16", "location":{
//                        "lat":28.01469, "lng":120.65523
//                    },"ad_info":{
//                        "nation":"中国", "province":"浙江省", "city":"温州市", "district":"鹿城区", "adcode":
//                        330302, "nation_code":156
//                    }
//                }
//                }
                JSONObject obj = new JSONObject(rspStr);
                JSONObject obj2=null;
                JSONObject obj1=null;
                if(obj!=null) {
                    if(obj.getStr("result")!=null&& StringUtils.isNotBlank(obj.getStr("result"))) {
                        obj1 = new JSONObject(obj.getStr("result"));
                        if(obj1.getStr("ad_info")!=null&& StringUtils.isNotBlank(obj1.getStr("ad_info")))
                            obj2 = new JSONObject(obj1.getStr("ad_info"));
                    }
                }
                return obj2;
            }
            catch (Exception e)
            {
                log.error("获取地理位置异常 {}", e);
                return null;
            }
    }


    public static void main(String[] args) {
        System.out.println(getRealAddressByIP("112.12.135.16"));
    }
}
