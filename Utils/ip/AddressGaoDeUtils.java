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
public class AddressGaoDeUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressGaoDeUtils.class);

    // IP地址查询
    public static final String IP_URL = "https://restapi.amap.com/v3/ip?key=71f460a8e4ca19c2525c06148e90bcd2";

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
                String rspStr = HttpUtil.get(IP_URL+"&ip=" + "183.130.222.76");
                JSONObject obj = new JSONObject(rspStr);
                JSONObject obj2=null;
                if(obj!=null) {
                    if(obj.getStr("ciry")!=null&& StringUtils.isNotBlank(obj.getStr("ciry"))) {


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
