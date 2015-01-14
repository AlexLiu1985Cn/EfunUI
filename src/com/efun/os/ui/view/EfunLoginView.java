package com.efun.os.ui.view;

import java.util.HashMap;
import java.util.Map;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBaseButtonView.ButtonViewConfiguration;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.util.Constant;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class EfunLoginView extends EfunBasePageLayout {

	private Map<String, EfunBaseButtonView> mBtns;
	private String[] mBtnTags;
	private Context mContext;

	private EfunLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mBtns = new HashMap<String, EfunBaseButtonView>();
		mContext = context;
	}

	private EfunLoginView(Context context) {
		super(context);
		mBtns = new HashMap<String, EfunBaseButtonView>();
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
			mBtns.get(mBtnTags[i]).setOnClickListener(mOnClickListener);
		}
	}

	public Map<String, EfunBaseButtonView> getViewButtons() {
		return mBtns;
	}

	public void setButtonTags(String[] tags) {
		mBtnTags = tags;
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
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
		private EfunLoginView mLoginView;

		public LoginViewBuilder(Context context) {
			mContext = context;
		}

		public LoginViewBuilder setLoginButtons(String[] btnTags) {
			checkMember(mContext);
			mLoginView.setButtonTags(btnTags);
			EfunBaseButtonView.ButtonBuilder buttonBuilder = new EfunBaseButtonView.ButtonBuilder(
					mContext);
			for (int i = 0; i < btnTags.length; i++) {
				EfunBaseButtonView button = buttonBuilder
						.setButtonBackGorundResource("efun_ui_btn_selecter")
						.setButtonContentName(btnTags[i])
						.setButtonType(
								ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
						.build();
				mLoginView.getViewButtons().put(btnTags[i], button);
			}
			return this;
		}

		public EfunLoginView build() {
			EfunLoginView loginView;
			checkMember(mContext);
			mLoginView.invalide(mContext);
			loginView = mLoginView;
			mLoginView = null;
			return loginView;
		}

		private void checkMember(Context context) {
			if (mLoginView == null) {
				mLoginView = new EfunLoginView(context);
			}
		}
	}

}
