package com.efun.os.ui.fragments;

import com.efun.os.R;
import com.efun.os.ui.view.EfunResetPasswordView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EfunResetPasswordFragment extends EfunBaseFragment implements
		OnClickListener {

	private EfunResetPasswordView mResetPasswordView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mResetPasswordView = new EfunResetPasswordView(mContext);
		mResetPasswordView.setClickListener(this);
		return mResetPasswordView;
	}

	@Override
	public void onClick(View view) {
		if (view == mResetPasswordView.getResetPasswordBtn()) {
			Log.d("alex", EfunResetPasswordView.class + ": Reset Password");
		}else if(view == mResetPasswordView.getTitleView().getBackButton()){
			Log.d("alex", EfunResetPasswordView.class + ": Back");
			finishFragment();
		}
	}

}
