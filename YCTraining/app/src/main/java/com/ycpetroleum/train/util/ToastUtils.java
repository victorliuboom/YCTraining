package com.ycpetroleum.train.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ycpetroleum.train.enity.Constant;


public class ToastUtils {

	/**
	 * 显示Toast()
	 */
	public static void showToast(Context context, CharSequence text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	/** 显示本地string */
	public static void showToast(Context context, int res_id) {
		Toast.makeText(context, context.getResources().getString(res_id),
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示Log.e()
	 */
	public static void Log_e(String context, String text) {
		if (Constant.DEBUG) {
			Log.e(context, text);
		}
	}

	/**
	 * 显示Log.d()
	 */
	public static void Log_d(String context, String text) {
		if (Constant.DEBUG) {
			Log.d(context, text);
		}
	}

	/**
	 * 显示Log.i()
	 */
	public static void Log_i(String context, String text) {
		if (Constant.DEBUG) {
			Log.i(context, text);
		}
	}

	/**
	 * 显示System.out.println()
	 */
	public static void system_out(String text) {
		if (Constant.DEBUG) {
			System.out.println(text);
		}
	}

	/**
	 * 显示System.err.println()
	 */
	public static void system_err(String text) {
		if (true) {
			System.err.println(text);
				}
	}
}
