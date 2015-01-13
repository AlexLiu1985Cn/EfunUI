package com.efun.os.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.ui.view.component.EfunInputView;
import com.efun.os.ui.view.component.EfunInputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunBindAccountView extends EfunBasePageLayout {

	private EfunInputView mInputView;
	private EfunBaseButtonView mFbBindBtn;
	private EfunBaseButtonView mMacBindBtn;

	public EfunBindAccountView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public EfunBindAccountView(Context context) {
		super(context);
		init(context);
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new EfunBaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("efun_ui_title_bind_account")
					.setBackSize(new int[] { width, height }).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mTitleView.getBackButton().setOnClickListener(mOnClickListener);
		return mTitleView;
	}

	private void init(Context context) {
		mInputView = new EfunInputView.InputViewBuilder(context)
				.setInputViewConfiguration(
						new InputViewConfiguration(4, new String[] {
								"efun_ui_hint_account",
								"efun_ui_hint_password",
								"efun_ui_hint_confirn_password",
								"efun_ui_hint_email" },
								"efun_ui_input_4_bg", new int[] { 5, 5, 5, 6 },
								new boolean[] { false, true, true, false }))
				.build();
		int height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				height * 4);
		if (this.mIsPortrait) {
			this.mParams.topMargin = (this.mMarginSize * 3);
		}
		this.mContentContainer.addView(this.mInputView, this.mParams);

		initButtonViews();

		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				height);
		this.mParams.topMargin = this.mMarginSize;
		RelativeLayout bottomLayout = new RelativeLayout(this.mContext);
		this.mContentContainer.addView(bottomLayout, this.mParams);
		int width = 0;
		if (this.mIsPortrait)
			width = (int) (height
					* Constant.ViewSize.INPUT_ITEM_WIDTH[this.mIndex] * 1.8D);
		else {
			width = (int) (height
					* Constant.ViewSize.INPUT_ITEM_WIDTH[this.mIndex] * 0.95D);
		}

		RelativeLayout.LayoutParams mParams = new RelativeLayout.LayoutParams(
				width, height);
		bottomLayout.addView(this.mFbBindBtn, mParams);
		mParams = new RelativeLayout.LayoutParams(width, height);
		mParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		bottomLayout.addView(this.mMacBindBtn, mParams);
	}

	private void initButtonViews() {
		EfunBaseButtonView.ButtonBuilder buttonViewBuilder = new EfunBaseButtonView.ButtonBuilder(
				mContext);
		mFbBindBtn = buttonViewBuilder.setButtonType(2)
				.setButtonContentName("efun_ui_button_bind_fb_btn")
				.setButtonBackGorundResource("efun_ui_btn_selecter").build();
		mMacBindBtn = buttonViewBuilder.setButtonType(2)
				.setButtonContentName("efun_ui_button_bind_mac_btn")
				.setButtonBackGorundResource("efun_ui_btn_selecter").build();
		mFbBindBtn.setOnClickListener(mOnClickListener);
		mMacBindBtn.setOnClickListener(mOnClickListener);
	}

	
	public EfunBaseButtonView getBindFbBtn(){
		return mFbBindBtn;
	}
	
	public EfunBaseButtonView getBindMacBtn(){
		return mMacBindBtn;
	}
}
