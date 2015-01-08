package com.efun.os.ui.view.component;

import android.content.Context;
import android.graphics.Color;
import android.opengl.Visibility;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.efun.os.ui.view.base.EfunBaseLinearLayout;
import com.efun.os.util.Constant;

public class EfunUnLineTextView extends EfunBaseLinearLayout {

	private TextView itemNo1;
	private TextView itemNo2;
	private int mode;
	public static final int MODE_1_BLUE = 1;
	public static final int MODE_2_BLUE = 2;
	public static final int MODE_0_BLUE = 0;
	private String[] values;

	public EfunUnLineTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public EfunUnLineTextView(Context context, int mode, String[] values) {
		super(context);
		this.mode = mode;
		this.values = values;
		init();
	}

	private void init() {
		this.itemNo1 = new TextView(this.mContext);
		this.itemNo2 = new TextView(this.mContext);
		this.itemNo1.getPaint().setFakeBoldText(true);
		this.itemNo2.getPaint().setFakeBoldText(true);
		setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		addView(this.itemNo1, params);
		addView(this.itemNo2, params);
		if ((this.values != null) && (this.values.length == 2)) {
			switch (this.mode) {
			case 0:
				this.itemNo1.setTextColor(Color.WHITE);
				this.itemNo2.setTextColor(Color.WHITE);
				break;
			case 1:
				this.itemNo1
						.setTextColor(color(Constant.ViewColor.COLORS_UNLINE_TEXT));
				this.itemNo2.setTextColor(-1);
				this.values[0] = ("<u>" + this.values[0] + "</u>");
				this.itemNo1.setText(Html.fromHtml(this.values[0]));
				this.itemNo2.setText(this.values[1]);
				break;
			case 2:
				this.itemNo1.setTextColor(Color.WHITE);
				this.itemNo2
						.setTextColor(color(Constant.ViewColor.COLORS_UNLINE_TEXT));
				this.values[1] = ("<u>" + this.values[1] + "</u>");
				this.itemNo1.setText(this.values[0]);
				this.itemNo2.setText(Html.fromHtml(this.values[1]));
			}
		}
		this.itemNo1.setVisibility(View.GONE);
	}
}
