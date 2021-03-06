package com.efun.os.ui.fragments;

import com.efun.os.control.EfunSdkManager;
import com.efun.os.ui.EfunPageContainer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

abstract public class EfunBaseFragment extends Fragment {

	protected FragmentManager mFm;
	protected Context mContext;
	protected EfunSdkManager mSdkManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mFm = getActivity().getSupportFragmentManager();
		mContext = getActivity();
		mSdkManager = ((EfunPageContainer)mContext).getSdkManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	protected void finishFragment(){
		mFm.popBackStack();
	}
}
