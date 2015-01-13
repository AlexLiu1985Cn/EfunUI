package com.efun.os.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.efun.os.ui.view.EfunRegistView;

public class EfunRegistFragment extends EfunBaseFragment implements OnClickListener{

	private EfunRegistView mRegistView;
	
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
		Log.d("alex", EfunRegistFragment.class + ": onCreateView");
		mRegistView = new EfunRegistView(getActivity());
		mRegistView.setClickListener(this);
		return mRegistView;
	}

	@Override
	public void onClick(View view) {
		if(view == mRegistView.getRegistBtn()){
			Log.d("alex", EfunRegistFragment.class + ": Regist");
		}else if(view == mRegistView.getTitleView().getBackButton()){
			Log.d("alex", EfunRegistFragment.class + ": back");
			finishFragment();
		}
	}
}