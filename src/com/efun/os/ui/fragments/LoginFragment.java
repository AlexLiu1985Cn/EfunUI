package com.efun.os.ui.fragments;

import com.efun.os.ui.view.LoginView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class LoginFragment extends Fragment  implements View.OnClickListener{
	
	private LoginView mView;
	private String[] mButtonTags;

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
//		mView.setOnClickListener(this);
		mButtonTags = new String[]{"FB µÇÂ½","MAC µÇÂ½", "Efun µÇÂ½"};
		mView = new LoginView.LoginViewBuilder(getActivity()).setLoginButtons(mButtonTags).build();
		mView.setOnClickListener(this);
		return mView ;
	}

	@Override
	public void onClick(View view) {
		Log.d("alex","onclick");
		if(view == mView.getViewButtons().get(mButtonTags[0])){
			Toast.makeText(getActivity(), "FB Login", Toast.LENGTH_SHORT).show();
			Log.i("alex","FB Login");
		}else if(view == mView.getViewButtons().get(mButtonTags[1])){
			Toast.makeText(getActivity(), "MAC Login", Toast.LENGTH_SHORT).show();
			Log.i("alex","MAC Login");
		}else if(view == mView.getViewButtons().get(mButtonTags[2])){
			Toast.makeText(getActivity(), "EFUN Login", Toast.LENGTH_SHORT).show();
			Log.i("alex","EFUN Login");
		}
	}
	
	

}
