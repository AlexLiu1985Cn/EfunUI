package com.efun.os.ui.fragments;

import com.efun.core.tools.EfunResourceUtil;
import com.efun.os.ui.PageContainer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {

	protected FragmentManager mFm;
	protected Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mFm = getActivity().getSupportFragmentManager();
		mContext = getActivity();
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

	protected void startFragment(Fragment fgt, String tag, String values) {
		Bundle bundle = new Bundle();
		bundle.putString("data", values);
		fgt.setArguments(bundle);
		startFragment(fgt, tag);
	}

	protected void startFragment(Fragment fgt, String tag) {
		FragmentTransaction ft = mFm.beginTransaction();
		ft.setCustomAnimations(
				EfunResourceUtil.findAnimIdByName(mContext, "efun_ui_fragment_enter_go"),
				EfunResourceUtil.findAnimIdByName(mContext, "efun_ui_fragment_exit_go"),
				EfunResourceUtil.findAnimIdByName(mContext, "efun_ui_fragment_enter_back"), 
				EfunResourceUtil.findAnimIdByName(mContext, "efun_ui_fragment_exit_back"));
		ft.addToBackStack(null);
		ft.replace(PageContainer.ROOT_LAYOUT_ID, fgt, tag);
		ft.commitAllowingStateLoss();
	}
	
	
}
