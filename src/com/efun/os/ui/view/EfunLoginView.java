package com.efun.os.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.efun.os.ui.view.base.BasePageLayout;
import com.efun.os.ui.view.base.BaseTitleView;
import com.efun.os.ui.view.component.InputView;
import com.efun.os.ui.view.component.InputView.InputViewBuilder;
import com.efun.os.ui.view.component.InputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunLoginView extends BasePageLayout {

	private InputView mInputView;

	public EfunLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public EfunLoginView(Context context) {
		super(context);
		init();
	}

	@Override
	protected BaseTitleView initTitleView() {
		return null;
	}

	private void init() {
		mInputView = new InputViewBuilder(mContext).setInputViewConfiguration(
				new InputViewConfiguration(2, new String[]{"hint_account", "hint_password"},
						"efun_ui_input_2_bg", new int[]{5, 6}, new boolean[] {false, true}))
				.build();
		
		int height = (int)(this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
	    this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, height * 2);
	    if (this.mIsPortrait) {
	      this.mParams.topMargin = (this.mMarginSize * 3);
	    }
	    this.mContentContainer.addView(this.mInputView, this.mParams);

//	    initButtonViews();
//
//	    this.params = new LinearLayout.LayoutParams(-1, height);
//	    this.params.setMargins(0, this.marginSize, 0, this.marginSize);
//	    this.mContainerLayout.addView(this.mLoginBtn, this.params);
//
//	    String str1 = createString("button_register_text_1");
//	    String str2 = createString("button_register_text_2");
//	    this.registerIV = new UnLineTextView(this.mContext, 2, new String[] { str1, str2 });
//	    LinearLayout tempLayout = new LinearLayout(this.mContext);
//	    tempLayout.setOrientation(0);
//	    TextView tempText = new TextView(this.mContext);
//	    this.params = new LinearLayout.LayoutParams(-2, -2, 1.0F);
//	    tempLayout.addView(tempText, this.params);
//	    if (this.isPortrait) {
//	      this.params = new LinearLayout.LayoutParams(-2, -2);
//	      tempLayout.addView(this.registerIV, this.params);
//
//	      this.params = new LinearLayout.LayoutParams(-1, height);
//	      this.mContainerLayout.addView(tempLayout, this.params);
//	    }
//	    else {
//	      this.params = new LinearLayout.LayoutParams(-2, -2);
//	      tempLayout.addView(this.registerIV, this.params);
//
//	      this.params = new LinearLayout.LayoutParams(-1, -2);
//	      this.mContainerLayout.addView(tempLayout, this.params);
//	    }
//
//	    tempLayout = new LinearLayout(this.mContext);
//	    height = (int)(this.mHeight * com.efun.os.constant.Constant.ViewSize.THIRD_LOGIN_BUTTON_HEIGHT[this.index]);
//	    this.params = new LinearLayout.LayoutParams(-1, height, 1.0F);
//	    if (this.isPortrait) {
//	      tempLayout.setOrientation(1);
//	      this.params.setMargins(0, this.marginSize / 8, 0, this.marginSize / 8);
//	    } else {
//	      tempLayout.setOrientation(0);
//	      this.params.setMargins(this.marginSize / 10, 0, this.marginSize / 10, 0);
//	    }
//	    tempLayout.addView(this.mResetPwdBtn, this.params);
//	    tempLayout.addView(this.mRetrievePwdBtn, this.params);
//	    tempLayout.addView(this.mBindAccountBtn, this.params);
//
//	    this.params = new LinearLayout.LayoutParams(-1, -2);
//	    if (!this.isPortrait) {
//	      this.params.topMargin = this.marginSize;
//	    }
//	    this.mContainerLayout.addView(tempLayout, this.params);
//
//	    if (this.isPortrait) {
//	      tempLayout = new LinearLayout(this.mContext);
//	      tempLayout.setOrientation(0);
//	      tempText = new TextView(this.mContext);
//	      this.params = new LinearLayout.LayoutParams(-2, -2, 1.0F);
//	      tempLayout.addView(tempText, this.params);
//	      this.params = new LinearLayout.LayoutParams(-1, -2);
//	      this.params.topMargin = this.marginSize;
//	      this.mContainerLayout.addView(tempLayout, this.params);
//	    }
	}

}
