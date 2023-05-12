package org.soft.hotel.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000122675837";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYNOxb7dGhpAZQlhGmnkdRdzMjTDCM2Lo3+Ab+yXVbL2txGsumEr2+p5qaNjEmnl23ObFD8hoKM505JfHCGHSEPswF9Oi8CdG4cQywsvBAR4vahp5q7sLsnzRY2m/jqR/j0yBzlF5sNJrYDAXZKGEzN2KwU/EzpLOrq+lXSs/UtLqTWvOLKoqNMN8sWpZNR82xEwD918H5vT/H0+skcI3eTimuuA9VTeq7tastqDGll7s/NtmoqWhAtsrnk79bEsmDKXPYUFKTGakVLRlK3P2hLt8QJX5AW9tabF+YpYxllunpopQioXbAZuYmd15hs744TUUstU4LKFj4mPM5+XolAgMBAAECggEAXe6DU3RgI+4zC3ahq/8QKmFyyLzTVYjG25WQ05qGd2C7YNDVj0cPnGKZEcSR7rBbS6EqGbGGincx9zvIiC1JcvfCN4bePnWc3MO/viigBjthPtpHV9zDpP3Xc2JTHN+Z06LO6yVMZGDOkrhQv6Sg39e1avZS67kgPLjaR0nfGvf6W8I1eUzgjco940uGxPb7Myg9UYuM182kEzk7g7gsAXvUuhfcqa9H00VZIZokKcfmvuZMOT/HUlLj+oxQ4OXvbu1LfS+wQRhS4evBbo9Xo9X8fzp92XDoiyN4yJG19OdpzZ348tHAhLVmKELiM8Ubm1kg8mS7CO76Y7Wl1B6mAQKBgQDs5hy/yO/ZlSV3gEoARgevTejC8w0XpVDvMGj3jH7fRuYIDmnhsJQmrJuL0tvYQssgqScCdFqLnA3NQ3NKLOUjpGWwu6+/LuJXT+SErnXh5v1+tGQHhxxLFLQQJm4rlHLnvw1y7n2/ifGNTVgepmkKzaILxDV3F8CgDAsvGYG7gQKBgQCkeqjhJ4gyrUZEC7vbmzf9j688jlpWjjWKE9474K+FRirnadrFxYNkOcGJk/v7E1zQUbvXB6v8RX/0RUNx6bf91VD8NTxMuRk1sOkvZIBWNidfoRCSBgcVtLwDfatz/eA1M5qGdzWtSPdz1vHGN+z4UVBv6k76mEWQ3beM9augpQKBgGSSoNvvA5y9DAX6ye/pyzNqgQnaw9EpFv4k8DtAQ1CpOdlrvRnarFrq5rJq13itiq0YAv6wxQwGOXnOS/DOtIz4K0/nrooc7myg92Q46MT6Gt6i2OC1RJa/eF5u4lDQGiQ24Q/NHkel2Y3iqyl//pJekJAsQYKI6/dGhaz+SCyBAoGBAIG+pFMfrQdUufXZT7H26h7hZfkdzdMzULZ/37FaFvrJk/SCAuo5WOEJ0kplasLuzisiHkuMKLXSWRHmRUKpe9MGn2Cj2dInvOQmjnstCzN2em6sDfcyPAp6TElwq3vPCzrMXxutE7GCungtWQDkgtCKzCnMKcrxrQaOb0kJTf5lAoGARYS/ePhlhJqCLPN0u2Kk6sVEmEhwgAVFPg4x1THtAP6o+S2Ts/Ojvy07zrTzQnNY1xxuiokeE88nNMOWiCOv4EdHU+GB6ZgJljMFuwnLGA3PW6uQpiS9g/gQbW5gWFcKqfygFzXLOmWhva/r2He8683b2gyf17SDLrWh4F1aMdk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn3+KItRC/OYtEZC/pA3OvhoVzO6EyPh2ZBI5elb0y5Q4swKI2bobTIMEQpg+0HsXHSkNs8rfrnGDgSdM/8lmUlnia3VYNuH3lncYWsWBVHj6IiwPmS6Fbow186++CBi7zgNkGs+CzKjHIKEosvImHPNyh3Yv1d4whqGzsUwhoyUF1zdsDfuaIJljhOri2vh5NiNcWaNEc2URhKNaGlVhSMGOtHG2nolZk5K5qI1f/udyt4a8zjZ3eMrhUKhKtKzsYpreSBbi1yykjJ766nHgRnd+FVc7Enhtowr3OezgirKJupiFCktgbEzmEfOS/XWyTGLuGxNlHetNZ86tADpsvwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8099/callback/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8099/callback/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志目录
    public static String log_path = "./";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

