package com.efun.os.ui.view.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BasePageLayout extends LinearLayout{
	
	protected BaseTitleView titleView;
	private LinearLayout.LayoutParams mLp;

	public BasePageLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public BasePageLayout(Context context) {
		super(context);
		init();
	}
	
	private void init(){
//		setOrientation(LinearLayout.HORIZONTAL);
		
	}

}
