package com.efun.os.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.efun.os.ui.view.base.EfunBaseButtonView;
import com.efun.os.ui.view.base.EfunBaseButtonView.ButtonViewConfiguration;
import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.ui.view.component.EfunInputView;
import com.efun.os.ui.view.component.EfunInputView.InputViewConfiguration;
import com.efun.os.util.Constant;

public class EfunRegistView extends EfunBasePageLayout {

	private EfunInputView mInputLayoutView;
	private EfunBaseButtonView mRegisterBtn;

	public EfunRegistView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public EfunRegistView(Context context) {
		super(context);
		init(context);
	}

	@Override
	protected EfunBaseTitleView initTitleView() {
		int height = (int) (this.mScreanHeight * Constant.ViewSize.TITLE_BACK_HEIGHT[mIndex]);
		int width = height;
		try {
			mTitleView = new EfunBaseTitleView.TitleViewBuilder(mContext)
					.setTitleName("efun_ui_title_regist")
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
		mInputLayoutView = new EfunInputView.InputViewBuilder(context)
				.setInputViewConfiguration(
						new InputViewConfiguration()
								.setInputHints(
										new String[] {
												"efun_ui_hint_account",
												"efun_ui_hint_password",
												"efun_ui_hint_confirn_password",
												"efun_ui_hint_email" })
								.setInputNumbers(4)
								.setInputViewBackgorund("efun_ui_input_4_bg")
								.setInputViewImeOptions(
										new int[] { 5, 5, 5, 6 })
								.setInputPasswordType(
										new boolean[] { false, true, true, false }))
				.build();
		int height = (int) (this.mScreanHeight * Constant.ViewSize.INPUT_ITEM_HEIGHT[this.mIndex]);
		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				height * 4);
		if (this.mIsPortrait) {
			this.mParams.topMargin = (this.mMarginSize * 3);
		}
		this.mContentContainer.addView(this.mInputLayoutView, this.mParams);

		initButtonViews();

		this.mParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				height);
		this.mParams.topMargin = this.mMarginSize;
		this.mContentContainer.addView(this.mRegisterBtn, this.mParams);
	}

	private void initButtonViews() {
		EfunBaseButtonView.ButtonBuilder buttonViewBuilder = new EfunBaseButtonView.ButtonBuilder(
				mContext);
		int height = (int) (this.mScreanHeight * Constant.ViewSize.COMMON_BUTTON_HEIGHT[mIndex]) / 2;
		mRegisterBtn = buttonViewBuilder.setButtonViewConfiguration(
				new ButtonViewConfiguration()
						.setButtonType(
								ButtonViewConfiguration.BUTTON_TYPE_RIGHT)
						.setContentName("efun_ui_button_register")
						.setRightResouceName("efun_ui_button_right_arrow")
						.setBackgroundResourceName("efun_ui_btn_selecter")
						.setRightSize(new int[] { height, height })).build();
		mRegisterBtn.setOnClickListener(mOnClickListener);
	}
	
	public EfunBaseButtonView getRegistBtn(){
		return mRegisterBtn;
	}

}
