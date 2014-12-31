package com.efun.os.ui.fragments;

import com.efun.os.R;
import com.efun.os.ui.view.EfunLoginView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EfunLoginFragment extends BaseFragment{

	private EfunLoginView mEfunLoginView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mEfunLoginView = new EfunLoginView(getActivity());
		return mEfunLoginView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
