package com.gloria.mygoals;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

//import com.fourmob.datetimepicker.date.DatePickerDialog;
//import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;

public class DatePickerFragment extends DialogFragment
	implements DatePickerDialog.OnDateSetListener {

	// For log purpose
	private static final  String TAG = "DatePickerFragment"; 	
	
	private Date mDate;
	//private TextView mTextView;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Log.d(TAG,"onCreateDialog method");
		
		mDate = ((usesDatePickerDialogInterface) getActivity()).getCurrentDate();
		//mTextView = ((usesDatePickerDialogInterface) getActivity()).getCurrentDateTextView();

		final Calendar c = Calendar.getInstance();
		// Use the current date as the default date in the picker
		if (mDate != null) {
			c.setTime(mDate);
		} 
	
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        //return DatePickerDialog.newInstance(getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	}
	
	public void onDateSet(DatePicker d, int year, int month, int day) {
		Log.d(TAG,"onDateSet method");
		((usesDatePickerDialogInterface) getActivity()).DatePickerCallBack(year, month, day);
		/*if (mTextView != null) {
			// Format the date to the user's locales and set the destination view
			final Calendar c = Calendar.getInstance();
			c.set(year, month, day);
			mDate.setTime(c.getTimeInMillis());
			mTextView.setText(SimpleDateFormat.getDateInstance().format(mDate));
			return;
		}
		Log.w(TAG,"Setting a date in this DatePicker dialog should update a View parameter");*/
	}
}
