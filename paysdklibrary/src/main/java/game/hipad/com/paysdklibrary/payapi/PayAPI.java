package game.hipad.com.paysdklibrary.payapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import game.hipad.com.paysdklibrary.bean.PayReq;

/**
 * Created by tianjunjie on 2018/1/20.
 * 调起微信支付页面
 */

public class PayAPI {
    private static PayAPI instance;
    private static Context context;
    static PayMoneyListener payMoneyListener;
    public PayAPI(Context context,PayMoneyListener payMoneyListener) {
        this.context = context;
        this.payMoneyListener = payMoneyListener;
    }

    public static PayAPI getInstance(Context context, PayMoneyListener payMoneyListener) {
        if (instance == null) {
            instance = new PayAPI(context,payMoneyListener);
        }
        return instance;
    }

    public static void sendReq(PayReq payReq) {
        Intent intent = new Intent();
        intent.setClassName("com.jkrm.haipai.paixin.tc", "com.hipad.payment.activity.GetPayInformationActivity");
        intent.putExtra("prepayId",payReq.getPrepayId());//商品预支付ID
        intent.putExtra("appId",payReq.getAppId());
        intent.putExtra("timeStamp",payReq.getTimeStamp());
        intent.putExtra("partnerId",payReq.getPartnerId());
        intent.putExtra("noncestr",payReq.getNoncestr());
        intent.putExtra("packages",payReq.getPackages());
        intent.putExtra("sign",payReq.getSign());
        context.startActivity(intent);

    }
    public interface PayMoneyListener{
        public void onResp(String orderNumber,int rt);
    }
    public static class MyPayMoneyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("PAY_MONEY_STATE")){
                int rt=intent.getIntExtra("rt",-1);
                String orderNumber=intent.getStringExtra("orderNumber");
                if(payMoneyListener!=null){
                    payMoneyListener.onResp(orderNumber,rt);
                }
            }

        }
    }
}
