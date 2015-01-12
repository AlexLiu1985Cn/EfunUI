package com.efun.os.ui;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.ui.fragments.EfunBaseFragment;
import com.efun.os.ui.fragments.EfunLoginFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class PageContainer extends FragmentActivity {

	private FragmentManager fm;
	private EfunLoginFragment lf;

	public static int ROOT_LAYOUT_ID = 500001;
	public static String TAG_EFUN_NORMAL_LOGIN = "tag_efun_normal_login";
	public static String TAG_EFUN_LOGIN = "tag_efun_login";
	public static String TAG_EFUN_REGIST = "tag_efun_regist";

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		init();
		lf = new EfunLoginFragment();
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(ROOT_LAYOUT_ID, lf);
		// startFragment(lf, TAG_EFUN_NORMAL_LOGIN);
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

	protected void startFragment(Fragment fgt, String tag, String values) {
		Bundle bundle = new Bundle();
		bundle.putString("data", values);
		fgt.setArguments(bundle);
		startFragment(fgt, tag);
	}

	public void startFragment(Fragment fgt, String tag) {
		Log.d("alex", "fragment manager = " + lf);
		FragmentTransaction ft = fm.beginTransaction();
		ft.setCustomAnimations(EfunResourceUtil.findAnimIdByName(this,
				"efun_ui_fragment_enter_go"), EfunResourceUtil
				.findAnimIdByName(this, "efun_ui_fragment_exit_go"),
				EfunResourceUtil.findAnimIdByName(this,
						"efun_ui_fragment_enter_back"), EfunResourceUtil
						.findAnimIdByName(this, "efun_ui_fragment_exit_back"));
		ft.addToBackStack(null);
		ft.replace(ROOT_LAYOUT_ID, fgt, tag);
		ft.commitAllowingStateLoss();
		Log.d("alex",
				EfunBaseFragment.class + ": stack count = "
						+ fm.getBackStackEntryCount());
	}

	@Override
	public void onBackPressed() {
		Log.d("alex", "onBackPressed");
		fm.popBackStack();
	}

}
