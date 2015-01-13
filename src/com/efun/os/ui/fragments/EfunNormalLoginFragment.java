package com.efun.os.ui.fragments;

import com.efun.os.ui.PageContainer;
import com.efun.os.ui.view.EfunNormalLoginView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EfunNormalLoginFragment extends EfunBaseFragment implements OnClickListener{

	private EfunNormalLoginView mEfunLoginView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("alex", EfunNormalLoginFragment.class + ": onCreateView");
		mEfunLoginView = new EfunNormalLoginView(getActivity());
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
			((PageContainer)getActivity()).startFragment(new EfunRegistFragment(), PageContainer.TAG_EFUN_REGIST);
		}else if(paramView == mEfunLoginView.getResetBtn()){
			Log.d("alex", "reset");
			((PageContainer)getActivity()).startFragment(new EfunResetPasswordFragment(), PageContainer.TAG_EFUN_RESET);
		}else if(paramView == mEfunLoginView.getRetrieveBtn()){
			Log.d("alex", "retrieve");
			((PageContainer)getActivity()).startFragment(new EfunRtrievePasswordFragment(), PageContainer.TAG_EFUN_RETRIEVE);
		}else if(paramView == mEfunLoginView.getBindBtn()){
			Log.d("alex", "bind");
			((PageContainer)getActivity()).startFragment(new EfunBindAccountFragment(), PageContainer.TAG_EFUN_BIND);
		}else if(paramView == mEfunLoginView.getTitleView().getBackButton()){
			Log.d("alex", "back");
			finishFragment();
		}
	}

}
