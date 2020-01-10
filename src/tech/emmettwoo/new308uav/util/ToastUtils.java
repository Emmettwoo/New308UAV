package tech.emmettwoo.new308uav.util;

import android.app.Activity;
import android.widget.Toast;

public class ToastUtils {

    private static Toast toast;
    
    //显示通知吐司，当已存在吐司时直接更新吐司文字（不会延长吐司是个问题）
    public static void showExistToast(Activity activity, String content) {
        if (toast == null) {
            toast = Toast.makeText(activity, content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
    
    //上面的方案不完美，所以有的地方还是用下面的老方案
    public static void showNewToast(Activity activity, String content) {
    	Toast.makeText(activity, content, Toast.LENGTH_SHORT).show();
    }

}