package com.study.datepickerdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Field;


/**
 * Created by Administrator on 2017/10/18.
 */

public class DateTimePickerDialog implements View.OnClickListener {
    private final Context context;
    private Dialog dialog;
    private TimePicker tp;
    private DatePicker dp;
    private OnSelectedListener listener;

    public DateTimePickerDialog(Context context, int style) {
        this.context = context;
        initDialog(context, style);
    }

    private void initDialog(Context context, int style) {
        dialog = new Dialog(context, style);
        dialog.setContentView(R.layout.time_layout);

        TextView tvOk = (TextView) dialog.findViewById(R.id.tv_ok);
        TextView tvCancel = (TextView) dialog.findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(this);
        tvOk.setOnClickListener(this);

        tp = (TimePicker) dialog.findViewById(R.id.tp);
        dp = (DatePicker) dialog.findViewById(R.id.dp);
        tp.setIs24HourView(true);
        set_time_picker_text_colour(tp, 55, false);
        set_date_picker_text_colour(dp, 55, true);

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        lp.width = metrics.widthPixels;
        window.setAttributes(lp);

    }

    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }


    @Override
    public void onClick(View v) {
        if (listener == null) {
            return;
        }
        switch (v.getId()) {
            case R.id.tv_ok:
                listener.ok(this, formatUtils(dp.getYear()), formatUtils(dp.getMonth() + 1), formatUtils(dp.getDayOfMonth()),
                        formatUtils(tp.getCurrentHour()), formatUtils(tp.getCurrentMinute()));
                break;
            case R.id.tv_cancel:
                listener.cancel(this);
                break;
        }
    }


    private void set_date_picker_text_colour(DatePicker time_picker, int dpVal, boolean isDate) {
        Resources system = Resources.getSystem();
        int hour_numberpicker_id = system.getIdentifier("year", "id", "android");
        int minute_numberpicker_id = system.getIdentifier("month", "id", "android");
        int ampm_numberpicker_id = system.getIdentifier("day", "id", "android");

        NumberPicker hour_numberpicker = (NumberPicker) time_picker.findViewById(hour_numberpicker_id);
        NumberPicker minute_numberpicker = (NumberPicker) time_picker.findViewById(minute_numberpicker_id);
        NumberPicker ampm_numberpicker = (NumberPicker) time_picker.findViewById(ampm_numberpicker_id);

        set_numberpicker_text_colour(hour_numberpicker, dpVal, isDate);
        set_numberpicker_text_colour(minute_numberpicker, dpVal, isDate);
        set_numberpicker_text_colour(ampm_numberpicker, dpVal, isDate);
    }

    private void set_time_picker_text_colour(TimePicker time_picker, int dpVal, boolean isDate) {
        Resources system = Resources.getSystem();
        int hour_numberpicker_id = system.getIdentifier("hour", "id", "android");
        int minute_numberpicker_id = system.getIdentifier("minute", "id", "android");
        int ampm_numberpicker_id = system.getIdentifier("amPm", "id", "android");
        int divider = system.getIdentifier("divider", "id", "android");

        NumberPicker hour_numberpicker = (NumberPicker) time_picker.findViewById(hour_numberpicker_id);
        NumberPicker minute_numberpicker = (NumberPicker) time_picker.findViewById(minute_numberpicker_id);
        NumberPicker ampm_numberpicker = (NumberPicker) time_picker.findViewById(ampm_numberpicker_id);
        TextView divider_tv = (TextView) time_picker.findViewById(divider);
        divider_tv.setTextColor(Color.BLACK);

        set_numberpicker_text_colour(hour_numberpicker, dpVal, isDate);
        set_numberpicker_text_colour(minute_numberpicker, dpVal, isDate);
        set_numberpicker_text_colour(ampm_numberpicker, dpVal, isDate);
    }

    private void set_numberpicker_text_colour(NumberPicker number_picker, int dpVal, boolean isDate) {
        final int count = number_picker.getChildCount();
        //这里就是要设置的颜色，修改一下作为参数传入会更好
        final int color = context.getResources().getColor(android.R.color.black);

        for (int i = 0; i < count; i++) {
            View child = number_picker.getChildAt(i);

            try {
                Field wheelpaint_field = number_picker.getClass().getDeclaredField("mSelectorWheelPaint");
                Field divider = number_picker.getClass().getDeclaredField("mSelectionDivider");

                wheelpaint_field.setAccessible(true);
                divider.setAccessible(true);
                divider.set(number_picker, new ColorDrawable(Color.parseColor("#76CEED")));//设置分割线颜色

                ((Paint) wheelpaint_field.get(number_picker)).setColor(color);
                if (child instanceof EditText) {
                    ((EditText) child).setTextColor(color);
                }
                number_picker.invalidate();
                if (isDate) {
                    setPickerSize(number_picker, dpVal, 0, 0, 30, 0);
                } else {
                    setPickerSize(number_picker, dpVal, 0, 0, 0, 0);
                }
            } catch (NoSuchFieldException e) {
                Log.w("setColor", e);
            } catch (IllegalAccessException e) {
                Log.w("setColor", e);
            } catch (IllegalArgumentException e) {
                Log.w("setColor", e);
            }
        }
    }


    //这个方法是改变NumberPicker大小的方法，传入的参数为要修改的NumberPicker和NumberPicker的宽度值
    private void setPickerSize(NumberPicker np, int widthDpValue, int left, int top, int right, int bottom) {
        int widthPxValue = dp2px(context, widthDpValue);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthPxValue, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(left, top, right, bottom);//这儿参数可根据需要进行更改
        np.setLayoutParams(params);
    }

    //此方法将dp值转换为px值，以保证适配不同分辨率机型
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public String formatUtils(int count) {
        String str = count + "";
        if (str.length() == 1) {
            str = "0" + str;
        }
        return str;
    }


    public void setOnSelectedListener(OnSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnSelectedListener {
        void ok(DateTimePickerDialog dialog, String year, String month, String day, String hour, String minute);

        void cancel(DateTimePickerDialog dialog);
    }
}
