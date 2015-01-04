package com.efun.os.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.efun.os.ui.view.base.BaseButtonView;
import com.efun.os.ui.view.base.BaseButtonView.ButtonViewConfiguration;
import com.efun.os.ui.view.base.BasePageLayout;
import com.efun.os.ui.view.base.BaseTitleView;
import com.efun.os.ui.view.component.InputView;
import com.efun.os.ui.view.component.InputView.InputViewBuilder;
import com.efun.os.ui.view.component.InputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunLoginView extends BasePageLayout {

	private InputView mInputView;
	private BaseButtonView mLoginBtn;
	private BaseButtonView mResetPwdBtn;
	private BaseButtonView mRetrievePwdBtn;
	private BaseButtonView mBindAccountBtn;
	private Button registerIV;
	private LinearLayout mFunctionContainer;
	private BaseTitleView mTitleView;
	private int mInputHeight;

	public EfunLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public EfunLoginView(Context context) {
		super(context);
		init(context);
	}

	@Override
	protected BaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new BaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("title_login")
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

	private void init(Context context) {
		mInputView = new InputViewBuilder(mContext).setInputViewConfiguration(
				new InputViewConfiguration(2, new String[] { "hint_account",
						"hint_password" }, "efun_ui_input_2_bg", new int[] { 5,
						6 }, new boolean[] { false, true })).build();

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
		// String str1 = createString("button_register_text_1");
		// String str2 = createString("button_register_text_2");
		setFunctionContainer(context);

		// this.registerIV = new UnLineTextView(this.mContext, 2, new String[] {
		// str1, str2 });
		// LinearLayout tempLayout = new LinearLayout(this.mContext);
		// tempLayout.setOrientation(0);
		// TextView tempText = new TextView(this.mContext);
		// this.params = new LinearLayout.LayoutParams(-2, -2, 1.0F);
		// tempLayout.addView(tempText, this.params);

		// this.params = new LinearLayout.LayoutParams(-1, -2);
		// if (!this.isPortrait) {
		// this.params.topMargin = this.marginSize;
		// }
		// this.mContainerLayout.addView(tempLayout, this.params);
		//
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
	}

	private void setFunctionContainer(Context context) {
		mFunctionContainer = new LinearLayout(context);
		mFunctionContainer.setOrientation(LinearLayout.VERTICAL);
		LinearLayout registContainer = new LinearLayout(context);
		LinearLayout space = new LinearLayout(context);
		registContainer.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams param = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0F);
		registContainer.addView(space, param);
		param = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		registContainer.addView(this.registerIV, param);
		if (this.mIsPortrait) {
			param = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					mInputHeight);
		}
		mFunctionContainer.addView(registContainer, param);
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
		BaseButtonView.ButtonBuilder buttonViewBuilder = new BaseButtonView.ButtonBuilder(
				mContext);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.COMMON_BUTTON_HEIGHT[mIndex]) / 2;
		mLoginBtn = buttonViewBuilder
				.setButtonType(ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
				.setButtonContentName("button_login_btn")
				.setButtonRightResourceName("efun_ui_button_right_arrow")
				.setButtonBackGorundResource("efun_ui_btn_selecter")
				.setButtonRightSize(new int[] { height, height }).build();
		mLoginBtn.setOnClickListener(mOnClickListener);
		mResetPwdBtn = buttonViewBuilder
				.setButtonContentName("button_reset_pwd_btn")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
		mResetPwdBtn.setOnClickListener(mOnClickListener);
		mRetrievePwdBtn = buttonViewBuilder
				.setButtonContentName("button_retrieve_pwd_btn")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
		mRetrievePwdBtn.setOnClickListener(mOnClickListener);
		mBindAccountBtn = buttonViewBuilder
				.setButtonContentName("button_bind_account_btn")
				.setButtonBackGorundResource("efun_ui_third_btn_selecter")
				.build();
		mBindAccountBtn.setOnClickListener(mOnClickListener);
		 registerIV = new Button(context);
		 registerIV.setText("Á¢¼´×¢²á");
	}

	public BaseButtonView getLoginBtn() {
		return mLoginBtn;
	}

	public BaseButtonView getResetBtn() {
		return mResetPwdBtn;
	}

	public BaseButtonView getRetrieveBtn() {
		return mRetrievePwdBtn;
	}

	public BaseButtonView getBindBtn() {
		return mBindAccountBtn;
	}

	public Button getRegisterBtn() {
		return registerIV;
	}

	public BaseTitleView getTitleView() {
		return mTitleView;
	}
}
