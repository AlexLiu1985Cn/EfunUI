package com.efun.os.ui;

import com.efun.os.ui.fragments.EfunLoginFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class PageContainer extends FragmentActivity {

	private FragmentManager fm;

	public static int ROOT_LAYOUT_ID = 500001;
	public static String TAG_EFUN_LOGIN = "tag_efun_login";
	public static String TAG_EFUN_REGIST = "tag_efun_regist";

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		init();
		EfunLoginFragment lf = new EfunLoginFragment();
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(ROOT_LAYOUT_ID, lf);
		ft.commit();
	}

	private void init() {
		LinearLayout ll = new LinearLayout(this);
		LinearLayout.LayoutParams lp = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.setLayoutParams(lp);
		ll.setId(ROOT_LAYOUT_ID);
		setContentView(ll);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Log.d("alex", "onBackPressed");
		fm.popBackStack();
	}

}
