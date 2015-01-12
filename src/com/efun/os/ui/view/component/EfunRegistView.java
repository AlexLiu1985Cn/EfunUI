package com.efun.os.ui.view.component;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.efun.os.ui.view.base.EfunBasePageLayout;
import com.efun.os.ui.view.base.EfunBaseTitleView;
import com.efun.os.util.Constant;

public class EfunRegistView extends EfunBasePageLayout{
	
	private EfunInputView mInputLayoutView;

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
					.setTitleName("title_login")
					.setBackGroundColor(Color.WHITE)
					.setBackSize(new int[] { width, height })
					.setHasButton(false).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return mTitleView;
	}
	
	private void init(Context context){
		mInputLayoutView = new EfunInputView.InputViewBuilder(context).build();
	}

}
