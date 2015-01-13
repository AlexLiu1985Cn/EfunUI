package com.efun.os.ui.fragments;

import com.efun.os.ui.view.EfunRtrievePasswordView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EfunRtrievePasswordFragment extends EfunBaseFragment implements OnClickListener{
	
	private EfunRtrievePasswordView mRetrievePasswordView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRetrievePasswordView = new EfunRtrievePasswordView(mContext);
		mRetrievePasswordView.setClickListener(this);
		return mRetrievePasswordView;
	}

	@Override
	public void onClick(View view) {
		if(view == mRetrievePasswordView.getRetrieveBtn()){
			Log.d("alex", EfunRtrievePasswordFragment.class + ": Retrieve");
		}else if(view == mRetrievePasswordView.getTitleView().getBackButton()){
			Log.d("alex", EfunRtrievePasswordFragment.class + ": Back");
			finishFragment();
		}
	}

}
