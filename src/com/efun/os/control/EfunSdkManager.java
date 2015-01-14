package com.efun.os.control;

import java.util.Observable;

import com.efun.platform.login.comm.callback.OnEfunLoginListener;

import android.content.Context;

abstract public class EfunSdkManager extends Observable {

	private Request mReqeust;
	private Response mResponse;
	private static OnEfunLoginListener mOnEfunLoginListener;

	abstract public void excuteRequest(Context context, Request request);

	public static OnEfunLoginListener getEfunLoginListener() {
		return mOnEfunLoginListener;
	}

	public static void setEfunLoginListener(
			OnEfunLoginListener efunLoginListener) {
		mOnEfunLoginListener = efunLoginListener;
	}

	public void sdkNotifyChange(String code) {
		mResponse = new Response();
		mResponse.setResponseCode(code);
		setChanged();
		notifyObservers(mResponse);
	}

	public void setRequest(Request request) {
		mReqeust = request;
	}

	public Request getRequest() {
		return this.mReqeust;
	}

	public void setResponse(Response response) {
		mResponse = response;
	}

	public Response getResponse() {
		return this.mResponse;
	}

	public static class Request {

		public static final int REQUEST_TYPE_LOGIN_FB = 0;
		public static final int REQUEST_TYPE_LOGIN_MAC = 1;
		public static final int REQUEST_TYPE_LOGIN_EFUN = 2;
		public static final int REQUEST_TYPE_REGIST = 3;
		public static final int REQUEST_TYPE_BIND_FB = 4;
		public static final int REQUEST_TYPE_BIND_MAC = 5;
		public static final int REQUEST_TYPE_BIND_EFUN = 6;
		public static final int REQUEST_TYPE_RETRIEVE = 7;
		public static final int REQUEST_TYPE_RESET = 8;
		public static final int REQUEST_TYPE_CLOSE_ACTIVITY = 9;

		private int mRequestType = -1;
		private String[] mRequestValues = null;

		public Request() {
		}

		public Request(int requestType, String[] requestValues) {
			mRequestType = requestType;
			mRequestValues = requestValues;
		}

		public int getRequestType() {
			return mRequestType;
		}

		public void setRequestType(int requestType) {
			this.mRequestType = requestType;
		}

		public String[] getRequestValues() {
			return mRequestValues;
		}

		public void setRequestVlaues(String[] requestValues) {
			this.mRequestValues = requestValues;
		}
	}

	public static class Response {
		private String mResponseCode = "-1";
		private String[] mResponseValues = null;
		private int mResponseType;

		public String getResponseCode() {
			return mResponseCode;
		}

		public void setResponseCode(String responseCode) {
			mResponseCode = responseCode;
		}

		public String[] getResponseValues() {
			return mResponseValues;
		}

		public void setResponseValues(String[] values) {
			mResponseValues = values;
		}

		public int getResponseType() {
			return mResponseType;
		}

		public void setResponseType(int type) {
			mResponseType = type;
		}

		@Override
		public String toString() {
			String responseStr = "reponse: responseCode = " + mResponseCode
					+ ", response type = " + mResponseType
					+ ", response value = ";
			String responseValue = "";
			String end = ", ";
			if (mResponseValues != null) {
				for (int i = 0; i < mResponseValues.length; i++) {
					if (i == mResponseValues.length - 1) {
						end = "";
					}
					responseValue = responseValue + mResponseValues[i] + end;
				}
			}
			return responseStr + responseValue;
		}

	}
}
