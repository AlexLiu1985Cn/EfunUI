package com.efun.os.ui.view.component;

import java.util.ArrayList;

import com.efun.os.ui.view.base.BaseLinearLayout;

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
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

public class InputView extends BaseLinearLayout {

	private ArrayList<EditText> mViewOfArray;
	private InputViewConfiguration mConfiguration;

	private InputView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private InputView(Context context) {
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

		private InputView mInputView;

		public InputViewBuilder(Context context) {
			mInputView = new InputView(context);
		}

		public InputViewBuilder setInputViewConfiguration(
				InputViewConfiguration config) {
			mInputView.mConfiguration = config;
			return this;
		}

		public InputView build() {
			mInputView.invalid();
			return mInputView;
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

		public void setInputNumbers(int inputNumbers) {
			mInputNumbers = inputNumbers;
		}

		public void setInputHints(String[] inputHints) {
			mInputHints = inputHints;
		}

		public void setInputViewBackgorund(String inputBackground) {
			mInputViewBackgorund = inputBackground;
		}

		public void setInputViewBackgroundCornerPixel(
				int inputViewBackgroundCornerPixel) {
			mInputViewBackgroundCornerPixel = inputViewBackgroundCornerPixel;
		}

		public void setInputViewImeOptions(int[] inputImeOptions) {
			mInputViewImeOptions = inputImeOptions;
		}

		public void setInputTextColor(int inputTextColor) {
			mInputTextColor = inputTextColor;
		}

		public void setInputHintTextColor(int inputHintTextColor) {
			mInputHintTextColor = inputHintTextColor;
		}

		public void setInputTextSize(float inputTextSize) {
			mInputTextSize = inputTextSize;
		}

		public void setInputPasswordType(boolean[] inputPasswordType) {
			mInputPasswordType = inputPasswordType;
		}

		public void setLayoutParams(LayoutParams layoutParams) {
			mLayoutParams = layoutParams;
		}
	}
}
