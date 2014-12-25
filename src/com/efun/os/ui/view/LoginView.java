package com.efun.os.ui.view;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.ui.view.base.BasePageLayout;
import com.efun.os.ui.view.base.BaseTitleView;
import com.efun.os.util.Constant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginView extends BasePageLayout {

	private Button btn_fb;
	private Button btn_mac;
	private Button btn_efun;

	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public LoginView(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		initButton(context);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				height);
		this.mParams.setMargins(this.mMarginSize, this.mMarginSize,
				this.mMarginSize, 0);
		this.mContentContainer.addView(this.btn_fb, this.mParams);
		this.mContentContainer.addView(this.btn_mac, this.mParams);
		this.mContentContainer.addView(this.btn_efun, this.mParams);

		ImageView logoIV = new ImageView(this.mContext);
		logoIV.setBackgroundResource(EfunResourceUtil.findDrawableIdByName(
				this.mContext, "efun_logo"));
		if (!this.mIsPortrait)
			height = (int) (this.mScreanHeight * 0.5D * Constant.ViewSize.LOGO_HEIGHT[this.mIndex]);
		else {
			height = (int) (this.mScreanHeight * Constant.ViewSize.LOGO_HEIGHT[this.mIndex]);
		}
		int width = (int) (height * Constant.ViewSize.LOGO_WIDTH[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(width, height);
		this.mParams.gravity = Gravity.CENTER_HORIZONTAL;
		if (this.mIsPortrait)
			this.mParams.topMargin = (this.mMarginSize * 6);
		else {
			this.mParams.topMargin = (this.mMarginSize * 2);
		}

		this.mContentContainer.addView(logoIV, 0, this.mParams);
	}
	
	private void initButton(Context context){
		btn_fb = new Button(context);
		btn_fb.setText("fbµÇÂ½");
		btn_mac = new Button(context);
		btn_mac.setText("macµÇÂ½");
		btn_efun = new Button(context);
		btn_efun.setText("efun µÇÂ½");
	}

	@Override
	protected BaseTitleView initTitleView() {
		return null;
	}

}
