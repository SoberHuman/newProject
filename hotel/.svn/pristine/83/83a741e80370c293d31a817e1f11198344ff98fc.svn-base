package org.soft.hotel.server;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
 
/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
@Controller("aliyunMessage")
public class aliyunMessage {
 
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
 
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI4FoGNkGvoW8x4zDQT4Dj";
    static final String accessKeySecret = "mWZs5tlzwEeIxMKJLK1lwKuYPUhNxT";
 
    public static String sendSms(String userPhone) throws ClientException {
 
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
 
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
 
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(userPhone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("wrada");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_181864808");
        String randomNumStr = "";
        for(int i = 1; i <= 6;i ++){
            int randomNum = (int)(Math.random() * 10);
            randomNumStr += randomNum;
        }
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
       // request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"147258\"}");
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":"+randomNumStr+"}");
 
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
 
        return randomNumStr;
    }
 
 
//    public static void main(String[] args) throws ClientException, InterruptedException {
// 
//        //发短信
//        SendSmsResponse response = sendSms();
//        System.out.println("短信接口返回的数据----------------");
//        System.out.println("Code=" + response.getCode());
//        System.out.println("Message=" + response.getMessage());
//        System.out.println("RequestId=" + response.getRequestId());
//        System.out.println("BizId=" + response.getBizId());
// 
//        Thread.sleep(3000L);      
//    }
}