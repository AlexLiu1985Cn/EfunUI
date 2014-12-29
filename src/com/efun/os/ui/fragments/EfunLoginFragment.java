package com.efun.os.ui.fragments;

import com.efun.os.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EfunLoginFragment extends BaseFragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.testfragment1, null);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	

}
