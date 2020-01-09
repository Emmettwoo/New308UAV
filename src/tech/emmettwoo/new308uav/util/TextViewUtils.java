package tech.emmettwoo.new308uav.util;

import tech.emmettwoo.new308uav.ControlPage;
import tech.emmettwoo.new308uav.R;
import android.widget.TextView;

public class TextViewUtils{
	public void updateSeekBarText() {
		TextView textView = (TextView) ControlPage.self.findViewById(R.id.speedSeekBarText);
		textView.setText(ControlPage.speedController.getSpeed() + " + " + ControlPage.dataController.getDirection5()
				+ " + " + ControlPage.dataController.getDirection7() + " + " + ControlPage.dataController.getDirection9() );
	}
}
