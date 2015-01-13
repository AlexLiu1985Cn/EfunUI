package com.efun.os.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.ui.view.component.EfunInputView;
import com.efun.os.ui.view.component.EfunInputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunResetPasswordView extends EfunBasePageLayout {

	private EfunInputView mInputLayoutView;
	private EfunBaseButtonView mResetPasswordBtn;

	public EfunResetPasswordView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public EfunResetPasswordView(Context context) {
		super(context);
		init();
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new EfunBaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("efun_ui_title_reset_password")
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
		mInputLayoutView = new EfunInputView.InputViewBuilder(mContext)
				.setInputViewConfiguration(
						new InputViewConfiguration()
								.setInputViewBackgorund("efun_ui_input_4_bg")
								.setInputHints(
										new String[] { "efun_ui_hint_account",
												"efun_ui_hint_old_password",
												"efun_ui_hint_new_password",
												"efun_ui_hint_confirm_new_password" })
								.setInputNumbers(4)
								.setInputPasswordType(
										new boolean[] { false, true, true, true })
								.setInputViewImeOptions(
										new int[] { 5, 5, 5, 6 })).build();
		int height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LayoutParams(LayoutParams.MATCH_PARENT, height * 4);
		if (this.mIsPortrait) {
			this.mParams.topMargin = (this.mMarginSize * 3);
		}
		this.mContentContainer.addView(this.mInputLayoutView, this.mParams);
		initButtonViews();
		this.mParams = new LayoutParams(LayoutParams.MATCH_PARENT, height);
		if (this.mIsPortrait)
			this.mParams.topMargin = this.mMarginSize;
		else {
			this.mParams.setMargins(0, this.mMarginSize, 0, this.mMarginSize);
		}
		this.mContentContainer.addView(this.mResetPasswordBtn, this.mParams);
	}

	private void initButtonViews() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.COMMON_BUTTON_HEIGHT[this.mIndex]) / 2;
		EfunBaseButtonView.ButtonBuilder buttonBuilder = new EfunBaseButtonView.ButtonBuilder(
				mContext);
		mResetPasswordBtn = buttonBuilder
				.setButtonContentName("efun_ui_button_reset")
				.setButtonBackGorundResource("efun_ui_btn_selecter")
				.setButtonType(
						EfunBaseButtonView.ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
				.setButtonRightResourceName("efun_ui_button_right_arrow")
				.setButtonRightSize(new int[] { height, height }).build();
		mResetPasswordBtn.setOnClickListener(mOnClickListener);
	}

	public EfunBaseButtonView getResetPasswordBtn() {
		return mResetPasswordBtn;
	}
}
