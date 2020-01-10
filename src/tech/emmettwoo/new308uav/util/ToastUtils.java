package tech.emmettwoo.new308uav.util;

import android.app.Activity;
import android.widget.Toast;

public class ToastUtils {

    private static Toast toast;
    
    //��ʾ֪ͨ��˾�����Ѵ�����˾ʱֱ�Ӹ�����˾���֣������ӳ���˾�Ǹ����⣩
    public static void showExistToast(Activity activity, String content) {
        if (toast == null) {
            toast = Toast.makeText(activity, content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
    
    //����ķ����������������еĵط�������������Ϸ���
    public static void showNewToast(Activity activity, String content) {
    	Toast.makeText(activity, content, Toast.LENGTH_SHORT).show();
    }

}