package com.efun.os.ui.fragments;

import com.efun.os.control.EfunSdkManager;
import com.efun.os.ui.EfunPageContainer;
import com.efun.os.ui.view.EfunLoginView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class EfunLoginFragment extends EfunBaseFragment implements
		View.OnClickListener {

	private EfunLoginView mView;
	private String[] mButtonTags;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("alex", EfunLoginFragment.class + ": onCreateView");
		mButtonTags = new String[] { "efun_ui_button_login_facebook",
				"efun_ui_button_login_mac", "efun_ui_button_login_efun" };
		mView = new EfunLoginView.LoginViewBuilder(getActivity())
				.setLoginButtons(mButtonTags).build();
		mView.setClickListener(this);
		return mView;
	}

	@Override
	public void onClick(View view) {
		if (view == (View) mView.getViewButtons().get(mButtonTags[0])) {
			Toast.makeText(getActivity(), "FB Login", Toast.LENGTH_SHORT)
					.show();
			Log.i("alex", "FB Login");
		} else if (view == (View) mView.getViewButtons().get(mButtonTags[1])) {
			Toast.makeText(getActivity(), "MAC Login", Toast.LENGTH_SHORT)
					.show();
			Log.i("alex", "MAC Login");
			EfunSdkManager.Request request = new EfunSdkManager.Request();
			request.setRequestType(EfunSdkManager.Request.REQUEST_TYPE_LOGIN_MAC);
			mSdkManager.excuteRequest(mContext, request);
		} else if (view == (View) mView.getViewButtons().get(mButtonTags[2])) {
			Toast.makeText(getActivity(), "EFUN Login", Toast.LENGTH_SHORT)
					.show();
			Log.i("alex", "EFUN Login");
			((EfunPageContainer) getActivity())
					.startFragment(new EfunNormalLoginFragment(),
							EfunPageContainer.TAG_EFUN_LOGIN);
		}
	}
}
