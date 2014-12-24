package com.efun.os.ui.view;

import com.efun.os.ui.view.base.BasePageLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class LoginView extends BasePageLayout{
	
	private Button btn_fb;
	private Button btn_mac;
	private Button btn_efun;

	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public LoginView(Context context) {
		super(context);
	}


}
