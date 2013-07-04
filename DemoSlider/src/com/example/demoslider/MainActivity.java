package com.example.demoslider;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivityBase;
import com.slidingmenu.lib.app.SlidingActivityHelper;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements
		SlidingActivityBase {

	private SlidingActivityHelper mHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper = new SlidingActivityHelper(this);
		mHelper.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setBehindLeftContentView(R.layout.activity_left);
		setBehindRightContentView(R.layout.activity_right);

		this.setSlidingActionBarEnabled(true);
		
		Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// customize the SlidingMenu
				getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);
				getSlidingMenu().setShadowDrawable(R.drawable.shadow, SlidingMenu.LEFT);
				getSlidingMenu().setBehindOffsetRes(R.dimen.actionbar_home_width, SlidingMenu.LEFT);
				getSlidingMenu().setBehindScrollScale(0.25f, SlidingMenu.LEFT);
				showBehind(SlidingMenu.LEFT);
			}
		});
		Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// customize the SlidingMenu
				getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);
				getSlidingMenu().setShadowDrawable(R.drawable.shadow, SlidingMenu.RIGHT);
				getSlidingMenu().setBehindOffsetRes(R.dimen.actionbar_home_width, SlidingMenu.RIGHT);
				getSlidingMenu().setBehindScrollScale(0.25f, SlidingMenu.RIGHT);
				
				showBehind(SlidingMenu.RIGHT);
			}
		});
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mHelper.onPostCreate(savedInstanceState);
	}

	@Override
	public View findViewById(int id) {
		View v = super.findViewById(id);
		if (v != null)
			return v;
		return mHelper.findViewById(id);
	}

	@Override
	public void setContentView(int id) {
		setContentView(getLayoutInflater().inflate(id, null));
	}

	@Override
	public void setContentView(View v) {
		setContentView(v, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
	}

	@Override
	public void setContentView(View v, LayoutParams params) {
		super.setContentView(v, params);
		mHelper.registerAboveContentView(v, params);
	}

	// behind left view
	public void setBehindLeftContentView(int id) {
		setBehindLeftContentView(getLayoutInflater().inflate(id, null));
	}

	public void setBehindLeftContentView(View v) {
		setBehindLeftContentView(v, new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
	}

	public void setBehindLeftContentView(View v, LayoutParams params) {
		mHelper.setBehindLeftContentView(v);
	}

	// behind right view
	public void setBehindRightContentView(int id) {
		setBehindRightContentView(getLayoutInflater().inflate(id, null));
	}

	public void setBehindRightContentView(View v) {
		setBehindRightContentView(v, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	public void setBehindRightContentView(View v, LayoutParams params) {
		mHelper.setBehindRightContentView(v);
	}

	public SlidingMenu getSlidingMenu() {
		return mHelper.getSlidingMenu();
	}

	public void toggle(int side) {
		mHelper.toggle(side);
	}

	public void showAbove() {
		mHelper.showAbove();
	}

	public void showBehind(int side) {
		mHelper.showBehind(side);
	}

	public void setSlidingActionBarEnabled(boolean b) {
		mHelper.setSlidingActionBarEnabled(b);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		boolean b = mHelper.onKeyUp(keyCode, event);
		if (b)
			return b;
		return super.onKeyUp(keyCode, event);
	}

}
