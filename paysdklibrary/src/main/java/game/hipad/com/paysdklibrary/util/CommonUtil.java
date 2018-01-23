package game.hipad.com.paysdklibrary.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;





/**
 * Created by tianjunjie on 2018/1/23.
 */

public class CommonUtil {
    //判断App是否安装
    public static  boolean isAppInstalled(Context context) {
       String packageName="com.jkrm.haipai.paixin.tc";
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<String>();
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        if(!pName.contains(packageName)){
            Toast.makeText(context,"您没有安装叮咚",Toast.LENGTH_SHORT).show();
        }
        return pName.contains(packageName);
    }
}
