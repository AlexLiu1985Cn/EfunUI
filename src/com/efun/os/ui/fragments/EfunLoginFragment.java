package com.efun.os.ui.fragments;

import com.efun.os.ui.view.EfunLoginView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EfunLoginFragment extends BaseFragment implements OnClickListener{

	private EfunLoginView mEfunLoginView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mEfunLoginView = new EfunLoginView(getActivity());
		mEfunLoginView.setClickListener(this);
		return mEfunLoginView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View paramView) {
		if(paramView == mEfunLoginView.getLoginBtn()){
			Log.d("alex", "login");
		}else if(paramView == mEfunLoginView.getRegisterBtn()){
			Log.d("alex", "regist");
		}else if(paramView == mEfunLoginView.getResetBtn()){
			Log.d("alex", "reset");
		}else if(paramView == mEfunLoginView.getRetrieveBtn()){
			Log.d("alex", "retrieve");
		}else if(paramView == mEfunLoginView.getBindBtn()){
			Log.d("alex", "bind");
		}else if(paramView == mEfunLoginView.getTitleView().getBackButton()){
			Log.d("alex", "back");
		}
	}

}
