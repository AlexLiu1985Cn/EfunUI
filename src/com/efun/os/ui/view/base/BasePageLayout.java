package com.efun.os.ui.view.base;

import com.efun.os.util.Constant;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

abstract public class BasePageLayout extends BaseLinearLayout {

	protected BaseTitleView mTitleView;
	protected LinearLayout.LayoutParams mParams;
	protected LinearLayout mContentContainer;

	public BasePageLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public BasePageLayout(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		setOrientation(LinearLayout.VERTICAL);
//		setBackgroundColor(Color.GREEN);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				height);
		this.mParams.setMargins(0, this.mMarginSize / 2, 0, this.mMarginSize);
		this.mTitleView = initTitleView();
		if (this.mTitleView != null) {
			addView(this.mTitleView, this.mParams);
		}
		mContentContainer = new LinearLayout(context);
		mContentContainer.setOrientation(LinearLayout.VERTICAL);
		mContentContainer.setBackgroundColor(Color.BLUE);
		height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		int width = (int) (height * Constant.ViewSize.INPUT_ITEM_WIDTH[this.mIndex]);
		if (this.mIsPortrait)
			this.mParams = new LinearLayout.LayoutParams(width * 4,
					LayoutParams.FILL_PARENT);
		else {
			this.mParams = new LinearLayout.LayoutParams(width * 2,
					LayoutParams.FILL_PARENT);
		}
		this.mParams.gravity = Gravity.CENTER_HORIZONTAL;
		addView(this.mContentContainer, this.mParams);
	}

	abstract protected BaseTitleView initTitleView();

}
