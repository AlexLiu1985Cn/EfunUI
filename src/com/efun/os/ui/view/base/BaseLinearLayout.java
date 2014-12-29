package com.efun.os.ui.view.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.efun.core.tools.EfunScreenUtil;

public class BaseLinearLayout extends LinearLayout {

	protected Context mContext;
	protected EfunScreenUtil mScreen;
	protected int mIndex;
	protected int mScreanWidth;
	protected int mScreanHeight;
	protected int mMarginSize;
	protected boolean mIsPortrait;
	protected boolean mIsPhone;

	public BaseLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public BaseLinearLayout(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		this.mContext = context;
		this.mScreen = EfunScreenUtil.getInStance((Activity) this.mContext);
		this.mIsPortrait = this.mScreen.isPortrait((Activity) this.mContext);
		this.mScreanWidth = this.mScreen.getPxWidth();
		this.mScreanHeight = this.mScreen.getPxHeight();
		this.mIsPhone = this.mScreen.isPhone(context);
		if (this.mIsPortrait) {
			this.mMarginSize = (this.mScreanWidth / 20);
			this.mIndex = 1;
		} else {
			this.mMarginSize = (this.mScreanWidth / 50);
			this.mIndex = 0;
		}

		Log.i("alex", "mScreanWidth = " + mScreanWidth + "; mScreanHeight = "
				+ mScreanHeight + "; mIsPhone = " + mIsPhone + "; "
				+ "mIsPortrait" + mIsPortrait + "; " + "mMarginSize = "
				+ mMarginSize);
	}

	protected void setBackground(BackgroundType type, int res) {
		switch (type) {
		case COLOR:
			setBackgroundColor(res);
			break;
		case RESOURCE:
			setBackgroundResource(res);
			break;
		}
	}

	public static enum BackgroundType {
		COLOR, RESOURCE
	}
}
