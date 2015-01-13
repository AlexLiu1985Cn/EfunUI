package com.efun.os.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBaseButtonView.ButtonViewConfiguration;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.ui.view.component.EfunInputView;
import com.efun.os.ui.view.component.EfunInputView.InputViewBuilder;
import com.efun.os.ui.view.component.EfunInputView.InputViewConfiguration;
import com.efun.os.ui.view.component.EfunUnLineTextView;
import com.efun.os.util.Constant;

public class EfunNormalLoginView extends EfunBasePageLayout {

	private EfunInputView mInputView;
	private EfunBaseButtonView mLoginBtn;
	private EfunBaseButtonView mResetPwdBtn;
	private EfunBaseButtonView mRetrievePwdBtn;
	private EfunBaseButtonView mBindAccountBtn;
	private EfunUnLineTextView registerIV;
	private LinearLayout mFunctionContainer;
	private int mInputHeight;

	public EfunNormalLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public EfunNormalLoginView(Context context) {
		super(context);
		init(context);
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new EfunBaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("efun_ui_title_login")
					.setBackGroundColor(Color.WHITE)
					.setBackSize(new int[] { width, height })
					.setHasButton(false).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return mTitleView;
	}

	private void init(Context context) {
		mInputView = new InputViewBuilder(mContext).setInputViewConfiguration(
				new InputViewConfiguration(2, new String[] {
						"efun_ui_hint_account", "efun_ui_hint_password" },
						"efun_ui_input_2_bg", new int[] { 5, 6 },
						new boolean[] { false, true })).build();

		mInputHeight = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				mInputHeight * 2);
		if (this.mIsPortrait) {
			this.mParams.topMargin = (this.mMarginSize * 3);
			// this.mParams.leftMargin = this.mParams.rightMargin =
			// (mScreanWidth / 15);
		}
		this.mContentContainer.addView(this.mInputView, this.mParams);
		initButtonViews(context);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				mInputHeight);
		this.mParams.setMargins(0, this.mMarginSize, 0, this.mMarginSize);
		this.mContentContainer.addView(this.mLoginBtn, this.mParams);
		setFunctionContainer(context);
		// if (this.isPortrait) {
		// tempLayout = new LinearLayout(this.mContext);
		// tempLayout.setOrientation(0);
		// tempText = new TextView(this.mContext);
		// this.params = new LinearLayout.LayoutParams(-2, -2, 1.0F);
		// tempLayout.addView(tempText, this.params);
		// this.params = new LinearLayout.LayoutParams(-1, -2);
		// this.params.topMargin = this.marginSize;
		// this.mContainerLayout.addView(tempLayout, this.params);
		// }
		initOnClickListener();

	}

	private void initOnClickListener() {
		registerIV.setOnClickListener(mOnClickListener);
		mLoginBtn.setOnClickListener(mOnClickListener);
		mResetPwdBtn.setOnClickListener(mOnClickListener);
		mRetrievePwdBtn.setOnClickListener(mOnClickListener);
		mBindAccountBtn.setOnClickListener(mOnClickListener);
		mTitleView.getBackButton().setOnClickListener(mOnClickListener);
	}

	private void setFunctionContainer(Context context) {
		mFunctionContainer = new LinearLayout(context);
		mFunctionContainer.setOrientation(LinearLayout.VERTICAL);
		LinearLayout registContainer = new LinearLayout(context);
		String str1 = createString("efun_ui_button_register_text_1");
		String str2 = createString("efun_ui_button_register_text_2");
		this.registerIV = new EfunUnLineTextView(this.mContext, 2,
				new String[] { str1, str2 });
		registContainer.setOrientation(LinearLayout.HORIZONTAL);
		TextView tempText = new TextView(this.mContext);
		LinearLayout.LayoutParams param = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0F);
		registContainer.addView(tempText, param);
		param = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		registContainer.addView(this.registerIV, param);

		if (this.mIsPortrait) {
			param = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					mInputHeight);
		} else {
			param = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT);
		}
		this.mFunctionContainer.addView(registContainer, param);
		mContentContainer.addView(mFunctionContainer, param);
		LinearLayout tempLayout = new LinearLayout(this.mContext);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.THIRD_LOGIN_BUTTON_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				height, 1.0F);
		if (this.mIsPortrait) {
			tempLayout.setOrientation(LinearLayout.VERTICAL);
			this.mParams.setMargins(0, this.mMarginSize / 8, 0,
					this.mMarginSize / 8);
		} else {
			tempLayout.setOrientation(LinearLayout.HORIZONTAL);
			this.mParams.setMargins(this.mMarginSize / 10, 0,
					this.mMarginSize / 10, 0);
		}
		tempLayout.addView(this.mResetPwdBtn, this.mParams);
		tempLayout.addView(this.mRetrievePwdBtn, this.mParams);
		tempLayout.addView(this.mBindAccountBtn, this.mParams);

		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		if (!this.mIsPortrait) {
			this.mParams.topMargin = this.mMarginSize;
		}
		this.mContentContainer.addView(tempLayout, this.mParams);
	}

	private void initButtonViews(Context context) {
		EfunBaseButtonView.ButtonBuilder buttonViewBuilder = new EfunBaseButtonView.ButtonBuilder(
				mContext);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.COMMON_BUTTON_HEIGHT[mIndex]) / 2;
		mLoginBtn = buttonViewBuilder
				.setButtonType(ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
				.setButtonContentName("efun_ui_button_login")
				.setButtonRightResourceName("efun_ui_button_right_arrow")
				.setButtonBackGorundResource("efun_ui_btn_selecter")
				.setButtonRightSize(new int[] { height, height }).build();
		mResetPwdBtn = buttonViewBuilder
				.setButtonContentName("efun_ui_button_reset")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
		mRetrievePwdBtn = buttonViewBuilder
				.setButtonContentName("efun_ui_button_retrieve")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
		mBindAccountBtn = buttonViewBuilder
				.setButtonContentName("efun_ui_button_bind")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
	}

	public EfunBaseButtonView getLoginBtn() {
		return mLoginBtn;
	}

	public EfunBaseButtonView getResetBtn() {
		return mResetPwdBtn;
	}

	public EfunBaseButtonView getRetrieveBtn() {
		return mRetrievePwdBtn;
	}

	public EfunBaseButtonView getBindBtn() {
		return mBindAccountBtn;
	}

	public EfunUnLineTextView getRegisterBtn() {
		return registerIV;
	}

	public EfunBaseTitleView getTitleView() {
		return mTitleView;
	}
}
