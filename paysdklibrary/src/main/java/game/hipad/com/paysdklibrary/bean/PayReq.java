package game.hipad.com.paysdklibrary.bean;

import java.io.Serializable;

/**
 * Created by tianjunjie on 2018/1/20.
 * 第三方APP调用叮咚支付所传的实体类
 */

public class PayReq implements Serializable {
    public String appId;//微信开放平台审核通过的应用APPID
    public String partnerId;//微信支付分配的商户号
    public String prepayId;//预支付交易会话ID
    public String timeStamp;//时间戳
    public String noncestr;//随机字符串，不长于32位
    public String sign;//签名

    public PayReq() {
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
