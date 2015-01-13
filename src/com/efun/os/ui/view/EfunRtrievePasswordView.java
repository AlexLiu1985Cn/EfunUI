package com.efun.os.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBaseButtonView.ButtonBuilder;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.ui.view.component.EfunInputView;
import com.efun.os.ui.view.component.EfunInputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunRtrievePasswordView extends EfunBasePageLayout {

	private EfunInputView mInputView;
	private EfunBaseButtonView mRetrieveBtn;

	public EfunRtrievePasswordView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public EfunRtrievePasswordView(Context context) {
		super(context);
		init();
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new EfunBaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("efun_ui_title_retrieve")
					.setBackGroundColor(Color.WHITE)
					.setBackSize(new int[] { width, height })
					.setHasButton(false).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		mTitleView.getBackButton().setOnClickListener(mOnClickListener);
		return mTitleView;
	}

	private void init() {
		mInputView = new EfunInputView.InputViewBuilder(mContext)
				.setInputViewConfiguration(
						new InputViewConfiguration(2, new String[] {
								"efun_ui_hint_account", "efun_ui_hint_email" },
								"efun_ui_input_2_bg", new int[] { 5, 6 },
								new boolean[] { false, false })).build();
		int height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LayoutParams(LayoutParams.MATCH_PARENT, height * 2);
		if (this.mIsPortrait) {
			this.mParams.topMargin = (this.mMarginSize * 3);
		}
		this.mContentContainer.addView(this.mInputView, this.mParams);

		initButtonViews();

		height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LayoutParams(LayoutParams.MATCH_PARENT, height);
		this.mParams.setMargins(0, this.mMarginSize, 0, this.mMarginSize);
		if (this.mIsPortrait) {
			this.mParams.topMargin = this.mMarginSize;
		}
		this.mContentContainer.addView(this.mRetrieveBtn, this.mParams);
	}

	private void initButtonViews() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.COMMON_BUTTON_HEIGHT[this.mIndex]) / 2;
		EfunBaseButtonView.ButtonBuilder buttonBuilder = new EfunBaseButtonView.ButtonBuilder(
				mContext);
		mRetrieveBtn = buttonBuilder
				.setButtonBackGorundResource("efun_ui_btn_selecter")
				.setButtonContentName("efun_ui_button_retrieve")
				.setButtonType(
						EfunBaseButtonView.ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
				.setButtonRightResourceName("efun_ui_button_right_arrow")
				.setButtonRightSize(new int[] { height, height }).build();
		mRetrieveBtn.setOnClickListener(mOnClickListener);
	}

	public EfunBaseButtonView getRetrieveBtn() {
		return mRetrieveBtn;
	}
}
