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
        intent.setClassName("com.jkrm.haipai.paixin.tc", "com.jkrm.haipai.activity.GetPayInformationActivity");
        intent.putExtra("prepayId",payReq.getPrepayId());//商品预支付ID
        context.startActivity(intent);

    }
    public interface PayMoneyListener{
        public void onResp(String message);
    }
    public static class MyPayMoneyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("PAY_MONEY_STATE")){
                if(payMoneyListener!=null){
                    payMoneyListener.onResp("支付成功");
                }
            }

        }
    }
}
