package com.efun.os.ui.view.component;

import java.util.ArrayList;

import com.efun.os.ui.view.LoginView;
import com.efun.os.ui.view.base.EfunBaseLinearLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EfunInputView extends EfunBaseLinearLayout {

	private ArrayList<EditText> mViewOfArray;
	private InputViewConfiguration mConfiguration;

	private EfunInputView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private EfunInputView(Context context) {
		super(context);
	}

	private void invalid() {
		setOrientation(LinearLayout.VERTICAL);
		Drawable drawable = getResources().getDrawable(
				createDrawable(mConfiguration.mInputViewBackgorund));
		Bitmap bm = ((BitmapDrawable) drawable).getBitmap();
		Bitmap mBm = null;
		if (mConfiguration.mInputViewBackgroundCornerPixel != 0) {
			mBm = toRoundCorner(bm,
					mConfiguration.mInputViewBackgroundCornerPixel);
		} else {
			if (this.mIsPhone)
				mBm = toRoundCorner(bm, 45);
			else {
				mBm = toRoundCorner(bm, 15);
			}
		}
		BitmapDrawable mDrawable = new BitmapDrawable(mBm);
		setBackgroundDrawable(mDrawable);
		if (mConfiguration.mInputNumbers == 0) {
			return;
		}
		createInputs();

	}

	private void createInputs() {
		this.mViewOfArray = new ArrayList();
		EditText itemInputView = null;
		LinearLayout.LayoutParams params;
		if (mConfiguration.mLayoutParams == null) {
			params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT, 1.0F);
			params.gravity = Gravity.CENTER_VERTICAL;
		} else {
			params = mConfiguration.mLayoutParams;
		}
		for (int i = 0; i < mConfiguration.mInputNumbers; i++) {
			itemInputView = new EditText(this.mContext);
			itemInputView.setBackgroundResource(0);
			itemInputView.setHint(createString(mConfiguration.mInputHints[i]));
			itemInputView.setSingleLine(true);
			itemInputView.setImeOptions(mConfiguration.mInputViewImeOptions[i]);
			// if (Controls.instance().isLeftOfEditText())
			// itemInputView.setGravity(5);
			// else {
			// itemInputView.setGravity(16);
			// }
			if (mConfiguration.mInputTextColor != 0) {
				itemInputView.setTextColor(mConfiguration.mInputTextColor);
			} else {
				itemInputView.setTextColor(-16777216);
			}
			if (mConfiguration.mInputTextSize != 0) {
				itemInputView.setTextSize(2, mConfiguration.mInputTextSize);
			} else {
				if ((this.mIsPhone) && (this.mIsPortrait))
					itemInputView.setTextSize(2, 15.0F);
				else {
					itemInputView.setTextSize(2, 20.0F);
				}
			}

			if (mConfiguration.mInputHintTextColor != 0) {
				itemInputView
						.setHintTextColor(mConfiguration.mInputHintTextColor);
			} else {
				itemInputView.setHintTextColor(-7829368);
			}

			itemInputView
					.setFilters(new InputFilter[] { new InputFilter.LengthFilter(
							60) });
			if (mConfiguration.mInputPasswordType != null) {
				if (mConfiguration.mInputPasswordType[i] == true) {
					itemInputView.setInputType(InputType.TYPE_CLASS_TEXT
							| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
			addView(itemInputView, params);
			this.mViewOfArray.add(itemInputView);
		}
	}

	public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		Paint paint = new Paint();
		Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		RectF rectF = new RectF(rect);
		float roundPx = pixels;
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	public static class InputViewBuilder {

		private EfunInputView mInputView;
		private Context mContext;

		public InputViewBuilder(Context context) {
			mContext = context;
		}

		public InputViewBuilder setInputViewConfiguration(
				InputViewConfiguration config) {
			checkMember(mContext);
			mInputView.mConfiguration = config;
			return this;
		}

		public EfunInputView build() {
			EfunInputView inputView;
			checkMember(mContext);
			mInputView.invalid();
			inputView = mInputView;
			mInputView = null;
			return inputView;
		}
		
		private void checkMember(Context context){
			if(mInputView == null){
				mInputView = new EfunInputView(context);
			}
		}
	}

	public static class InputViewConfiguration {

		private int mInputNumbers;
		private String[] mInputHints;
		private String mInputViewBackgorund;
		private int mInputViewBackgroundCornerPixel;
		private int[] mInputViewImeOptions;
		private int mInputTextColor;
		private int mInputHintTextColor;
		private float mInputTextSize;
		private boolean[] mInputPasswordType;
		private LinearLayout.LayoutParams mLayoutParams;

		public InputViewConfiguration() {
			mInputNumbers = 0;
			mInputHints = null;
			mInputViewBackgorund = null;
			mInputViewBackgroundCornerPixel = 0;
			mInputViewImeOptions = null;
			mInputTextColor = 0;
			mInputHintTextColor = 0;
			mInputTextSize = 0;
			mInputPasswordType = null;
			mLayoutParams = null;
		}

		public InputViewConfiguration(int inputNumbers, String[] inputHints,
				String inputBackground, int[] inputImeOptions,
				boolean[] inputPasswordType) {
			mInputNumbers = inputNumbers;
			mInputHints = inputHints;
			mInputViewBackgorund = inputBackground;
			mInputViewBackgroundCornerPixel = 0;
			mInputViewImeOptions = inputImeOptions;
			mInputTextColor = 0;
			mInputHintTextColor = 0;
			mInputTextSize = 0;
			mInputPasswordType = inputPasswordType;
			mLayoutParams = null;
		}

		public InputViewConfiguration setInputNumbers(int inputNumbers) {
			mInputNumbers = inputNumbers;
			return this;
		}

		public InputViewConfiguration setInputHints(String[] inputHints) {
			mInputHints = inputHints;
			return this;
		}

		public InputViewConfiguration setInputViewBackgorund(
				String inputBackground) {
			mInputViewBackgorund = inputBackground;
			return this;
		}

		public InputViewConfiguration setInputViewBackgroundCornerPixel(
				int inputViewBackgroundCornerPixel) {
			mInputViewBackgroundCornerPixel = inputViewBackgroundCornerPixel;
			return this;
		}

		public InputViewConfiguration setInputViewImeOptions(
				int[] inputImeOptions) {
			mInputViewImeOptions = inputImeOptions;
			return this;
		}

		public InputViewConfiguration setInputTextColor(int inputTextColor) {
			mInputTextColor = inputTextColor;
			return this;
		}

		public InputViewConfiguration setInputHintTextColor(
				int inputHintTextColor) {
			mInputHintTextColor = inputHintTextColor;
			return this;
		}

		public InputViewConfiguration setInputTextSize(float inputTextSize) {
			mInputTextSize = inputTextSize;
			return this;
		}

		public InputViewConfiguration setInputPasswordType(
				boolean[] inputPasswordType) {
			mInputPasswordType = inputPasswordType;
			return this;
		}

		public InputViewConfiguration setLayoutParams(LayoutParams layoutParams) {
			mLayoutParams = layoutParams;
			return this;
		}
	}
}
