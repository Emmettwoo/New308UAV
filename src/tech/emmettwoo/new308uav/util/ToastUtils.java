package tech.emmettwoo.new308uav.util;

import tech.emmettwoo.new308uav.ControlPage;
import android.widget.Toast;

public class ToastUtils {

    private static Toast toast;
    
    //显示通知吐司，当已存在吐司时直接更新吐司文字（不会延长吐司是个问题）
    public static void showToast(String content) {
        if (toast == null) {
            toast = Toast.makeText(ControlPage.self, content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}