package com.efun.os.ui.view.base;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EfunBaseButtonView extends EfunBaseRelativeLayout {

	private ButtonViewConfiguration mButtonConfig;

	private ImageView leftIV;
	private TextView contentIV;
	private ImageView rightIV;

	private EfunBaseButtonView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private EfunBaseButtonView(Context context) {
		super(context);
	}

	private void invalid(Context context) {
		if (!(mButtonConfig.getBackgroundResourceName() == null || mButtonConfig
				.getBackgroundResourceName().equals(""))) {
			setBackgroundResource(getDrawableID(mButtonConfig
					.getBackgroundResourceName()));
		}
		RelativeLayout.LayoutParams params = null;
		if (!(mButtonConfig.getContentName() == null || mButtonConfig
				.getContentName().equals(""))) {
			// contentIV = new ImageView(mContext);
			// contentIV.setBackgroundResource(createDrawable(mContentName));
			// params = new LayoutParams(mContentSize[0], mContentSize[1]);
			contentIV = new TextView(mContext);
			contentIV.setText(createString(mButtonConfig.getContentName()));
			contentIV.setPadding(mMarginSize, 0, mMarginSize, 0);
			// contentIV.setText(mContentName);
			contentIV.setTextColor(Color.WHITE);
			contentIV.getPaint().setFakeBoldText(true);
			params = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.CENTER_IN_PARENT);
			this.addView(contentIV, params);
		}
		if (mButtonConfig.getButtonType() == ButtonViewConfiguration.BUTTON_TYPE_RIGHT
				|| mButtonConfig.getButtonType() == ButtonViewConfiguration.BUTTON_TYPE_ALL) {
			if (mButtonConfig.getRightResouceName() != null
					&& mButtonConfig.getRightSize() != null) {
				rightIV = new ImageView(mContext);
				rightIV.setBackgroundResource(getDrawableID(mButtonConfig
						.getRightResouceName()));
				params = new LayoutParams(mButtonConfig.getRightSize()[0],
						mButtonConfig.getRightSize()[1]);
				params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				params.addRule(RelativeLayout.CENTER_VERTICAL);
				params.rightMargin = mMarginSize;
				this.addView(rightIV, params);
			}
		}
		if (mButtonConfig.getButtonType() == ButtonViewConfiguration.BUTTON_TYPE_LEFT
				|| mButtonConfig.getButtonType() == ButtonViewConfiguration.BUTTON_TYPE_ALL) {
			if (mButtonConfig.getLeftResouceName() != null
					&& mButtonConfig.getLeftSize() != null) {
				leftIV = new ImageView(mContext);
				leftIV.setBackgroundResource(getDrawableID(mButtonConfig
						.getLeftResouceName()));
				params = new LayoutParams(mButtonConfig.getLeftSize()[0],
						mButtonConfig.getLeftSize()[1]);
				params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				params.addRule(RelativeLayout.CENTER_VERTICAL);
				params.leftMargin = mMarginSize;
				this.addView(leftIV, params);
			}
		}
	}

	public ButtonViewConfiguration getConifguration() {
		if (mButtonConfig == null) {
			mButtonConfig = new ButtonViewConfiguration();
		}
		return mButtonConfig;
	}

	public void setConifguration(ButtonViewConfiguration config) {
		mButtonConfig = config;
	}

	public static class ButtonBuilder {

		private Context mContext = null;
		private EfunBaseButtonView mBaseButtonView = null;

		public ButtonBuilder(Context context) {
			mContext = context;
		}

		public ButtonBuilder setMember(EfunBaseButtonView buttonView) {
			mBaseButtonView = buttonView;
			return this;
		}

		public ButtonBuilder setButtonViewConfiguration(
				ButtonViewConfiguration Config) {
			checkMember();
			mBaseButtonView.setConifguration(Config);
			return this;
		}

		public ButtonBuilder setButtonType(int buttonType) {
			checkMember();
			mBaseButtonView.getConifguration().setButtonType(buttonType);
			return this;
		}

		public ButtonBuilder setButtonContentName(String buttonContentName) {
			checkMember();
			mBaseButtonView.getConifguration()
					.setContentName(buttonContentName);
			return this;
		}

		public ButtonBuilder setButtonLeftResourceName(
				String buttonLeftResourceName) {
			checkMember();
			mBaseButtonView.getConifguration().setLeftResouceName(
					buttonLeftResourceName);
			return this;
		}

		public ButtonBuilder setButtonLeftSize(int[] leftSize) {
			checkMember();
			mBaseButtonView.getConifguration().setLeftSize(leftSize);
			return this;
		}

		public ButtonBuilder setButtonRightResourceName(
				String buttonRightResourceName) {
			checkMember();
			mBaseButtonView.getConifguration().setRightResouceName(
					buttonRightResourceName);
			return this;
		}

		public ButtonBuilder setButtonRightSize(int[] rightSize) {
			checkMember();
			mBaseButtonView.getConifguration().setRightSize(rightSize);
			return this;
		}

		public ButtonBuilder setButtonBackGorundResource(String resourceName) {
			checkMember();
			mBaseButtonView.getConifguration().setBackgroundResourceName(
					resourceName);
			return this;
		}

		public EfunBaseButtonView build() {
			EfunBaseButtonView retButtonView = null;
			checkMember();
			retButtonView = mBaseButtonView;
			mBaseButtonView = null;
			retButtonView.invalid(mContext);
			return retButtonView;
		}

		private void checkMember() {
			if (mBaseButtonView == null) {
				mBaseButtonView = new EfunBaseButtonView(mContext);
			}
		}
	}

	public static class ButtonViewConfiguration {
		public static final int BUTTON_TYPE_RIGHT = 2;
		public static final int BUTTON_TYPE_LEFT = 1;
		public static final int BUTTON_TYPE_ALL = 3;

		private int mBtnType = 0;
		private String mContentName = null;
		private int[] mLeftSize;
		private int[] mRightSize;
		private String mLeftResourceName;
		private String mRightResourceName;
		private String mBackgroundResourceName = null;

		public ButtonViewConfiguration() {

		}

		public ButtonViewConfiguration setButtonType(int btnType) {
			mBtnType = btnType;
			return this;
		}

		public int getButtonType() {
			return mBtnType;
		}

		public ButtonViewConfiguration setContentName(String contentName) {
			mContentName = contentName;
			return this;
		}

		public String getContentName() {
			return mContentName;
		}

		public ButtonViewConfiguration setLeftResouceName(
				String leftResourceName) {
			mLeftResourceName = leftResourceName;
			return this;
		}

		public String getLeftResouceName() {
			return mLeftResourceName;
		}

		public ButtonViewConfiguration setRightResouceName(
				String rightResourceName) {
			mRightResourceName = rightResourceName;
			return this;
		}

		public String getRightResouceName() {
			return mRightResourceName;
		}

		public int[] getLeftSize() {
			return mLeftSize;
		}

		public ButtonViewConfiguration setLeftSize(int[] leftSize) {
			mLeftSize = leftSize;
			return this;
		}

		public int[] getRightSize() {
			return mRightSize;
		}

		public ButtonViewConfiguration setRightSize(int[] rightSize) {
			mRightSize = rightSize;
			return this;
		}

		public String getBackgroundResourceName() {
			return mBackgroundResourceName;
		}

		public ButtonViewConfiguration setBackgroundResourceName(
				String backgroundResourceName) {
			mBackgroundResourceName = backgroundResourceName;
			return this;
		}
	}
}
