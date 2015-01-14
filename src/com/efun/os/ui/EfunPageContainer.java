package com.efun.os.ui;

import java.util.Observable;
import java.util.Observer;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.control.EfunLoginEventListener;
import com.efun.os.control.EfunSdkManager;
import com.efun.os.control.EfunSdkManager.Request;
import com.efun.os.control.EfunSdkManager.Response;
import com.efun.os.ui.fragments.EfunBaseFragment;
import com.efun.os.ui.fragments.EfunLoginFragment;
import com.efun.platform.login.comm.callback.OnEfunLoginListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class EfunPageContainer extends FragmentActivity implements Observer {

	private FragmentManager fm;
	private EfunLoginFragment lf;
	private EfunSdkManager mSdkManager;
	private EfunLoginEventListener mLoginEventListener;

	public static int ROOT_LAYOUT_ID = 500001;
	public static String TAG_EFUN_NORMAL_LOGIN = "tag_efun_normal_login";
	public static String TAG_EFUN_LOGIN = "tag_efun_login";
	public static String TAG_EFUN_REGIST = "tag_efun_regist";
	public static String TAG_EFUN_BIND = "tag_efun_bind";
	public static String TAG_EFUN_RESET = "tag_efun_reset";
	public static String TAG_EFUN_RETRIEVE = "tag_efun_retrieve";

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		init();
		initListener();
		lf = new EfunLoginFragment();
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

	private void initListener() {
		String managerClass = EfunResourceUtil.findStringByName(this,
				"efun_strings_config_LoginListenerName");
		try {
			if (!TextUtils.isEmpty(managerClass)
					&& managerClass.startsWith("com.efun.os.")) {
				Class cls = Class.forName(managerClass);
				if (cls != null) {
					mSdkManager = (EfunSdkManager) cls.newInstance();
					mSdkManager.addObserver(this);
				}
			}
			if (this.mLoginEventListener == null) {
				String eventlistener = EfunResourceUtil.findStringByName(this,
						"efun_strings_conifg_EventListenerName");
				if ((!TextUtils.isEmpty(eventlistener))
						&& (eventlistener.startsWith("com.efun.os."))) {
					Class clazz = Class.forName(eventlistener);
					if (clazz != null)
						this.mLoginEventListener = ((EfunLoginEventListener) clazz
								.newInstance());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

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

	public EfunSdkManager getSdkManager() {
		return this.mSdkManager;
	}

	@Override
	public void update(Observable observable, Object data) {
		Log.d("alex", EfunPageContainer.class + ": notify! ## " + data);
		Response response = (Response) data;
		String responseCode = response.getResponseCode();
		int responseType = response.getResponseType();
		String[] responseValue = response.getResponseValues();
		if (responseType == Request.REQUEST_TYPE_LOGIN_MAC) {
//			if (mLoginEventListener != null) {
//				if(response.equals("10000")){
//					mLoginEventListener.registerEvent(this, responseType);
//					mLoginEventListener.loginEvent(this, responseType);
//				}
//			}
			this.finish();
		}
		
	}

}
