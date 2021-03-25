package com.example.maylight.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("newtest2020613");
		textView = (TextView) findViewById(R.id.textview);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//自定义Toast控件
/*				View toastView = LayoutInflater.from(MainActivity.this).inflate(R.layout.toast_clear_layout, null);
				LinearLayout relativeLayout = (LinearLayout) toastView.findViewById(R.id.toast_linear);
				//动态设置toast控件的宽高度，宽高分别是130dp
				//这里用了一个将dp转换为px的工具类PxUtil
				RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) PxUtil.dpToPx(MainActivity.this, 130), (int) PxUtil.dpToPx(MainActivity.this, 130));
				relativeLayout.setLayoutParams(layoutParams);
				TextView textView = (TextView) toastView.findViewById(R.id.tv_toast_clear);
				textView.setText("已清空小纸条记录");
				Toast toast = new Toast(MainActivity.this);
				toast.setDuration(Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setView(toastView);
				toast.show();*/


				View llContent = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_text_center, null);
				TextView tvMessage = llContent.findViewById(R.id.message_text_center);
				tvMessage.setText("已清空小纸条记录");
				Toast toast = new Toast(MainActivity.this);
				toast.setDuration(Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
//				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setView(llContent);
				toast.show();
			}
		});
	}
}
