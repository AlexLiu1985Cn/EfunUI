package com.efun.os.ui.view;

import java.util.HashMap;
import java.util.Map;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.ui.view.base.BasePageLayout;
import com.efun.os.ui.view.base.BaseTitleView;
import com.efun.os.util.Constant;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginView extends BasePageLayout {

	private Map<String, Button> mBtns;
	private String[] mBtnTags;
	private Context mContext;

	private LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mBtns = new HashMap<String, Button>();
		mContext = context;
	}

	private LoginView(Context context) {
		super(context);
		mBtns = new HashMap<String, Button>();
		mContext = context;
	}

	public void invalide(Context context) {
		int height = 0;
		ImageView logoIV = new ImageView(this.mContext);
		logoIV.setBackgroundResource(EfunResourceUtil.findDrawableIdByName(
				this.mContext, "efun_ui_logo"));
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

		height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				height);
		this.mParams.setMargins(this.mMarginSize, this.mMarginSize,
				this.mMarginSize, 0);
		for (int i = 0; i < mBtnTags.length; i++) {
			this.mContentContainer
					.addView(mBtns.get(mBtnTags[i]), this.mParams);
		}
	}

	public Map<String, Button> getViewButtons() {
		return mBtns;
	}

	public void setButtonTags(String[] tags) {
		mBtnTags = tags;
	}

	@Override
	protected BaseTitleView initTitleView() {
		return null;
	}

	@Override
	protected void setBackgroundImp() {
		setBackground(BackgroundType.COLOR, Color.GRAY);
	}

	@Override
	protected void setContentContainerAndParams(LinearLayout linearLayout,
			LayoutParams layoutParams) {
		super.setContentContainerAndParams(linearLayout, layoutParams);
	}

	public static class LoginViewBuilder {

		private Context mContext;
		private LoginView mLoginView;
		private View.OnClickListener mCallback;

		public LoginViewBuilder(Context context) {
			mContext = context;
			mLoginView = new LoginView(context);
		}

		public LoginViewBuilder setButtonClickCallback(OnClickListener callback){
			mCallback = callback;
			return this;
		}
		
		public LoginViewBuilder setLoginButtons(String[] btnTags) {
			mLoginView.setButtonTags(btnTags);
			for (int i = 0; i < btnTags.length; i++) {
				Button btn = new Button(mContext);
				btn.setText(btnTags[i]);
				mLoginView.getViewButtons().put(btnTags[i], btn);
				btn.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View paramView) {
						mCallback.onClick(paramView);
					}
				});
			}
			return this;
		}

		public LoginView build() {
			mLoginView.invalide(mContext);
			return mLoginView;
		}
	}
	
}
