package com.efun.os;

import com.efun.os.ui.fragments.LoginFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class PageContainer extends FragmentActivity{
	
	private FragmentManager fm;
	
	private int REPLACED_LAYOUT_ID = 500001;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		init();
		LoginFragment lf = new LoginFragment();
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(REPLACED_LAYOUT_ID, lf);
		ft.commit();
	}
	
	private void init(){
		LinearLayout ll = new LinearLayout(this);
		LinearLayout.LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		ll.setId(REPLACED_LAYOUT_ID);
		setContentView(ll);
	}

}
