package com.team05.eduplat.config;

/**
 * @program: EduPlat
 * @description: TODO
 * @author: jian'jun'bin
 * @Date 2019-12-10 21:45
 **/
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101400686262";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC19tF3owMAV0Pzb2w3M1KiAZNQWiOGENjN1zTGWdnqdRjpoAXHSRK7759rbWkMs+/JcKvqjkcsTlTLxEqAxsVxT2VDa/h+JN/jUclBQWpn87HuJV6w9fpCWvfVLMTSxIu0rL3RZz6FH/nFKhhrYJY2Z9H47X7OkNpaDJ6/+vmBA5o1gWwZpUZufi9ocT1eFCVY1Uw1aw5TURt9YNs1Dj2G2R1ruITYawM4xNJzB8dcM1sd3pCNszHXb7hVXoAv5YJBbIfo8K5u1O5ot1htvXM7JY+rIvm3kr9LZQXY7rf42cm3LeZTa08ew2GCrnkIgI+4+EUGecdY1Otsl3nQGc7VAgMBAAECggEBAJetjvuf2S+ejljMZzM4R8gdchOHn5bwUhh7LFWurhRe2Y5cwpRU2BXqb0PYJrnc/6M1lUhmovNOtCZKkCP6DLkgCnQB+1gDGtFc6lrH0Y+nNokhg2YVFC/drjp3H/XkueO4Hl4AJsBHYCc2qLZRA8WEEyXhqlM7sZdgb6/t367mzTA4gXiG8EOzbSoPt/BIBDYCfcGFhyjzjRYaFM64SlANq0NSoFdyKZ1p3fqEeQ9ralf0tXq5ZBZ3Jhu+V2fXAcC7wVwOpKnba4CJ2ivljtXzkSnICxjqT1VY99o6H+LUhKQyLl+KztwAcsORjuSRDh/0mNzPwketF/HH/diEH4ECgYEA7qPL1VR+AkBYzXoTimI91bxYCMwlbzDmwLhw+PYDY8A2dLSosjjghV1xB3YYx7Was7AvpFRznaD6TISdgevN/libuVb3ydjv8gZkayocYxQ8fe7h2UoToxpn4bhHr763/VtWAfkNAhCPBs+Xcchsp/BdiC+H92I++LJeUVZel3UCgYEAwzOMEjBzS6WhYPymZAuiZ6Hk0uMeu5KNRCkDiIMSIzOhegWzYWorAZiPt7d8wb9FeJ8TO4jnfBuZ6Njmp7ihQxUWi7y0jSO3RU9rFwmppQr3CcWe/a4ZE8k3mZgxFMDd0ZXNctY8lj/biec0A8SVb9dmYoCwM3jBimGi8ME2zeECgYBLw7coUL386v8GpZZknhIxtK1ihaXw6l6omyZK9JhY6CKh5OWWR9aIoQUMsGLnrPGj0PEfRCy8w+oTtxrmr73j3a/7JPBgpj5v4bWqDGGc10TpWplbylf3tZ97m20vD+cMSh5BXBfUKvut1uSnHFHa88ZOQYDyer+xZ7foLPq1LQKBgBREAcLRrOapp3t+P3gbjRzdPfh3A/XNXUU6TNebZAKrlZQpi1oNv7FGuYUFU7p5tSi0uzZvHDlSVERMYIYBMRzZz6FqUgRlNN3JRQD7S9WKseMd1UfZD1lyhoc3ucDB1UWxG8dUXq3qq0xB6LCLdEhMQKDxY1m0q8NGJ7h/FsWBAoGAQGsqRC/O7lK7CY7PeWjusHjjeWiCjDJd6tRUgX9qmzv/dSXedH6lJZurTG4hM8wxEmBQ2kWWpnxp4RVMd3YJR/4NxgOlnTZpRU/dQpqe3cHdfBrgmzpQEM1gn7eHmPmKhHzdCp/zr8yBR/8ytCE7qpEMH/cpJ5ewehuu72UhKos=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoXzAvFeV7JNg6aSSL7cq5CUdQGjfM3C/ydBI/rtTViIcJLkGv2ME5YG/WcqfeAGRtOleGNl4kXLQEUnFodF09S/rsB+kp/xt5EVZ4dHsG8hZrLIIqM8AW9ORPCPwFat2LWuCkEbwcNOtrorqJmKCuGM+KpJJEo+Dftnxw5LulUEaRuhIqyakUKuo4H72XOFriJ0yMa1cNkWmQ22HypVwoEsjWkfu1/MzU7NXLWTfuYCfIAWphwslX/P5TBAG3eSZgWgg5eCt6x/Ks6t2o21UKH8Ir1ov1TS5pbvOu5TD4200ng7msIlT5QbnoZnIxFvuLxXLkHsbSA5KmB1wfvJUzQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //这里地址为，支付成功之后跳转的地址，异步地址
    public static String notify_url = "http://localhost:8080/pay/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //这里地址为，支付成功之后跳转的地址，同步
    public static String return_url = "http://localhost:8080/pay/return_url";

    // 签名方式
    public static String sign_type = "RSA2";
    public static String format = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
