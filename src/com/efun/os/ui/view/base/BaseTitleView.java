package com.efun.os.ui.view.base;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseTitleView extends BaseRelativeLayout {

	private ImageView mBackIV;
	protected ImageView mSettingIV;
	private TextView mTitleIV;

	private TitleViewConfiguration mTitleViewConfig;

	private BaseTitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTitleViewConfig = new TitleViewConfiguration();
	}

	private BaseTitleView(Context context) {
		super(context);
		mTitleViewConfig = new TitleViewConfiguration();
	}

	private TitleViewConfiguration getTitleViewConfig() {
		return mTitleViewConfig;
	}

	public void invalid() {
		setBackgroundColor(mTitleViewConfig.getTitleBackGorundColor());
		mBackIV = new ImageView(mContext);
		mBackIV.setBackgroundResource(getDrawableID("efun_ui_back_selecter"));
		LayoutParams params = new LayoutParams(mTitleViewConfig.getBackSize()[0], mTitleViewConfig.getBackSize()[1]);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		params.setMargins(mMarginSize, 0, 0, 0);
		this.addView(mBackIV, params);

		mTitleIV = new TextView(mContext);
		mTitleIV.setText(createString(mTitleViewConfig.getTitleName()));
		// titleIV.setTextColor(color(ViewColor.COLORS_COMMON_BUTTON));
		mTitleIV.setTextColor(Color.parseColor("#8C0000"));
		if (mIsPhone && mIsPortrait) {
			mTitleIV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
		} else {
			mTitleIV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		}
		TextPaint paint = mTitleIV.getPaint();
		paint.setFakeBoldText(true);

		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		this.addView(mTitleIV, params);

		if (mTitleViewConfig.isHasButton()) {
			// mSettingIV = new ImageView(mContext);
			// if (AppUiConfiguration.getChannelEnable(this.mContext))
			// this.settingIV
			// .setBackgroundResource(createDrawable(ViewSelecter.EFUN_MORE_SELECTER));
			// else {
			// this.settingIV
			// .setBackgroundResource(createDrawable(ViewSelecter.EFUN_WEBSITE_SELECTER));
			// }
			// params = new LayoutParams(getBackSize()[0], getBackSize()[1]);
			// params.addRule(RelativeLayout.CENTER_VERTICAL);
			// params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			// params.setMargins(0, 0, marginSize, 0);
			// this.addView(settingIV, params);
		}
	}
	
	public ImageView getBackButton(){
		return mBackIV;
	}
	
	public ImageView getSetButton(){
		return mSettingIV;
	}

	public static class TitleViewBuilder {

		private Context mContext = null;
		private BaseTitleView mTitleView = null;

		public TitleViewBuilder(Context context) {
			this.mContext = context;
		}
		
		public TitleViewBuilder setMember(BaseTitleView titleView){
			mTitleView = titleView;
			return this;
		}
		
		public TitleViewBuilder setTitleName(String titleName){
			checkMember();
			this.mTitleView.getTitleViewConfig().setTitleName(titleName);
			return this;
		}
		
		public TitleViewBuilder setBackSize(int[] backSize){
			checkMember();
			this.mTitleView.getTitleViewConfig().setBackSize(backSize);
			return this;
		}
		
		public TitleViewBuilder setHasButton(boolean hasButton){
			checkMember();
			this.mTitleView.getTitleViewConfig().setHasButton(hasButton);
			return this;
		}
		
		public TitleViewBuilder setBackGroundColor(int color){
			checkMember();
			this.mTitleView.getTitleViewConfig().setTitleBackGorundColor(color);
			return this;
		}

		public BaseTitleView build() throws Exception {
			BaseTitleView retTitleView = null;
			checkMember();
			retTitleView = mTitleView;
			mTitleView = null;
			if(!retTitleView.getTitleViewConfig().checkConfiged()){
				throw new Exception("TitleView is not configurated properly!");
			}
			retTitleView.invalid();
			return retTitleView;
		}

		private void checkMember() {
			if (this.mTitleView == null) {
				this.mTitleView = new BaseTitleView(mContext);
			}
		}
	}

	public static class TitleViewConfiguration {

		private String mTitleName = "";
		private int[] mBackSize = null;
		private boolean mHasButton = false;
		private int mTitleBackGorundColor = Color.WHITE;

		private boolean mIsTitleNameConfiged = false;
		private boolean mIsBackSizeConfiged = false;
		private boolean mIsHasButtonConfiged = false;
		private boolean mIsTitleBackGroundColorConfiged = false;

		public String getTitleName() {
			return mTitleName;
		}

		public void setTitleName(String titleName) {
			mIsTitleNameConfiged = true;
			this.mTitleName = titleName;
		}

		public int[] getBackSize() {
			return mBackSize;
		}

		public void setBackSize(int[] backSize) {
			mIsBackSizeConfiged = true;
			this.mBackSize = backSize;
		}

		public boolean isHasButton() {
			return mHasButton;
		}

		public void setHasButton(boolean hasButton) {
			mIsHasButtonConfiged = true;
			this.mHasButton = hasButton;
		}

		public int getTitleBackGorundColor() {
			return mTitleBackGorundColor;
		}

		public void setTitleBackGorundColor(int titleBackGorundColor) {
			mIsTitleBackGroundColorConfiged = true;
			this.mTitleBackGorundColor = titleBackGorundColor;
		}

		public boolean checkConfiged() {
			Log.d("alex", "mIsTitleNameConfiged: " + mIsTitleNameConfiged
					+ "; mIsBackSizeConfiged: " + mIsBackSizeConfiged
					+ "; mIsHasButtonConfiged: " + mIsHasButtonConfiged
					+ "; mIsTitleBackGroundColorConfiged: "
					+ mIsTitleBackGroundColorConfiged);
			return mIsTitleNameConfiged && mIsBackSizeConfiged;
		}
	}
}
