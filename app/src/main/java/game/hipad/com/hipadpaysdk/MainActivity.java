package game.hipad.com.hipadpaysdk;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import game.hipad.com.paysdklibrary.bean.PayReq;
import game.hipad.com.paysdklibrary.payapi.PayAPI;
import game.hipad.com.paysdklibrary.util.CommonUtil;

public class MainActivity extends Activity {
    private PayAPI payAPI;
    PayReq request;
    private Button pay_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pay_btn= (Button) findViewById(R.id.pay_btn);
        request = new PayReq();
        request.setAppId("wxd930ea5d5a258f4f");
        request.setPartnerId("1900000109");
        request.setPrepayId("1101000000140415649af9fc314aa427");
        request.setTimeStamp("1398746574");
        request.setNoncestr("adfasdfgasdkgjasdfig");//随机字符串
        request.setSign("我是签名");
        payAPI=PayAPI.getInstance(MainActivity.this, new PayAPI.PayMoneyListener() {
            @Override
            public void onResp(String message) {
                pay_btn.setText(message);
                Log.e("tjj","=====message====="+message);
                Toast.makeText(MainActivity.this,"支付成功",Toast.LENGTH_SHORT).show();

            }
        });
        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CommonUtil.isAppInstalled(MainActivity.this)){
                    payAPI.sendReq(request);
                }

            }
        });


    }
}
