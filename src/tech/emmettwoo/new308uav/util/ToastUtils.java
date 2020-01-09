package tech.emmettwoo.new308uav.util;

import tech.emmettwoo.new308uav.ControlPage;
import android.widget.Toast;

public class ToastUtils {

    private static Toast toast;
    
    //��ʾ֪ͨ��˾�����Ѵ�����˾ʱֱ�Ӹ�����˾���֣������ӳ���˾�Ǹ����⣩
    public static void showToast(String content) {
        if (toast == null) {
            toast = Toast.makeText(ControlPage.self, content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}