package com.efun.os.ui.fragments;

import com.efun.os.ui.view.EfunBindAccountView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EfunBindAccountFragment extends EfunBaseFragment implements OnClickListener{
	
	private EfunBindAccountView mBindAccoutView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mBindAccoutView = new EfunBindAccountView(mContext);
		mBindAccoutView.setClickListener(this);
		return mBindAccoutView;
	}

	@Override
	public void onClick(View view) {
		if(view == mBindAccoutView.getBindFbBtn()){
			Log.d("alex", EfunBindAccountFragment.class + ": FB bind");
		}else if(view == mBindAccoutView.getBindMacBtn()){
			Log.d("alex", EfunBindAccountFragment.class + ": MAC bind");
		}else if(view == mBindAccoutView.getTitleView().getBackButton()){
			Log.d("alex", EfunBindAccountFragment.class + ": back");
			finishFragment();
		}
	}

	
	
}
