package com.example.maylight.myapplication;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";
	private TextView textView;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN); // 强制显示状态栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels;  // 宽度（PX）
		int height = metric.heightPixels;  // 高度（PX）
		float density = metric.density;  // 密度（0.75 / 1.0 / 1.5）
		int densityDpi = metric.densityDpi;  // 密度DPI（120 / 160 / 240）
		Log.e(TAG, "width: " + width + " height: " + height + " density: " + density + " densityDpi: " + densityDpi);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textview);
		imageView = (ImageView) findViewById(R.id.imageView);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//创建缩放动画对象
/*				Animation animation = new ScaleAnimation(0, 1.0f, 0f, 2.0f);
				animation.setDuration(1500);//动画时间
//				animation.setRepeatCount(3);//动画的反复次数
				animation.setFillAfter(true);//设置为true，动画转化结束后被应用
				imageView.startAnimation(animation);//開始动*/

//				呈现view放大显示效果
//				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_in);

				//呈现view缩小的效果
//				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
//				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_out);
//				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_show);
				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_show_suofang);
//				Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale_packup_suofang);
				imageView.startAnimation(animation);//開始动画
				animation.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {
						//动画开始
						Log.e(TAG,"动画开始");
					}

					@Override
					public void onAnimationEnd(Animation animation) {
						//动画结束
						Log.e(TAG,"动画结束");
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						//动画重复
						Log.e(TAG,"动画重复");
					}
				});
//				ObjectscaleAnim();
//				ScaleAnimation(v);
			}
		});
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ScaleAnimation(v);
			}
		});
		System.out.println("newtest2020613");

		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高（像素，如：800p）

		Log.e(TAG, "getDefaultDisplay " + "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

		DisplayMetrics dm = new DisplayMetrics();
		dm = getResources().getDisplayMetrics();

		float density1 = dm.density;        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
		int densityDPI = dm.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）
		float xdpi = dm.xdpi;
		float ydpi = dm.ydpi;

		Log.e(TAG + "  DisplayMetrics", "xdpi=" + xdpi + "; ydpi=" + ydpi);
		Log.e(TAG + "  DisplayMetrics", "density=" + density1 + "; densityDPI=" + densityDPI);
	}

	//实现使图片可以横向放大2倍再还原按钮功能
	private void ObjectscaleAnim() {
		ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "ScaleX", 1.0F, 2.0F, 1.0F);//图片默认X轴不变然后放大2倍然后恢复原样
		animator.setDuration(4000);//缩放动画持续时间为4000毫秒
		animator.start();//开始执行动画(图片横向放大2倍动画)
	}

	private void ScaleAnimation(View view) {
//true代表是用animation的动画，false代表用自己的动画
		AnimationSet animationSet = new AnimationSet(true);
//		ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.2f, 1, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

		//从相对位置 的起点开始缩放动画
		ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 2);
		//从相对位置的100px x 100px的位置开始动画
//		ScaleAnimation scaleAnimation=new ScaleAnimation(0, 1, 0,1,100,100);
		//从按钮自身的中心点开始缩放动画
//		ScaleAnimation scaleAnimation=new ScaleAnimation(0, 1, 0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		scaleAnimation.setFillAfter(true);//设置为true，动画转化结束后被应用
		scaleAnimation.setDuration(2000);
		scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				//动画开始
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				//动画结束
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				//动画重复
			}
		});
		animationSet.addAnimation(scaleAnimation);
		view.startAnimation(animationSet);


	}
}
