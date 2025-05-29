package com.agecalculator.derra.gui;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private double user_age = 0;
	private double user_yob = 0;
	private double user_mob = 0;
	private double user_dob = 0;
	
	private LinearLayout container;
	private TextView main_title;
	private LinearLayout age_parameters_container;
	private TextView dgui_err_msg;
	private Button button_calc;
	private TextView dgui_ageresult;
	private LinearLayout dgui_bottom_section;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView title_year;
	private EditText input_year;
	private TextView title_month;
	private EditText input_month;
	private TextView title_day;
	private EditText input_day;
	private TextView textview3;
	private LinearLayout github_projectlink;
	private LinearLayout dgui_github;
	private TextView textview2;
	private ImageView dgui_link_img;
	private LinearLayout dgui_projectlink_r_section;
	private ImageView imageview4;
	private TextView textview1;
	private ImageView dgui_github_img;
	private LinearLayout dgui_github_r_section;
	private ImageView imageview2;
	private TextView github_title;
	private TextView dgui_halimouv;
	
	private Calendar calendar_dgui = Calendar.getInstance();
	private Intent dgui_intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		container = findViewById(R.id.container);
		main_title = findViewById(R.id.main_title);
		age_parameters_container = findViewById(R.id.age_parameters_container);
		dgui_err_msg = findViewById(R.id.dgui_err_msg);
		button_calc = findViewById(R.id.button_calc);
		dgui_ageresult = findViewById(R.id.dgui_ageresult);
		dgui_bottom_section = findViewById(R.id.dgui_bottom_section);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		title_year = findViewById(R.id.title_year);
		input_year = findViewById(R.id.input_year);
		title_month = findViewById(R.id.title_month);
		input_month = findViewById(R.id.input_month);
		title_day = findViewById(R.id.title_day);
		input_day = findViewById(R.id.input_day);
		textview3 = findViewById(R.id.textview3);
		github_projectlink = findViewById(R.id.github_projectlink);
		dgui_github = findViewById(R.id.dgui_github);
		textview2 = findViewById(R.id.textview2);
		dgui_link_img = findViewById(R.id.dgui_link_img);
		dgui_projectlink_r_section = findViewById(R.id.dgui_projectlink_r_section);
		imageview4 = findViewById(R.id.imageview4);
		textview1 = findViewById(R.id.textview1);
		dgui_github_img = findViewById(R.id.dgui_github_img);
		dgui_github_r_section = findViewById(R.id.dgui_github_r_section);
		imageview2 = findViewById(R.id.imageview2);
		github_title = findViewById(R.id.github_title);
		dgui_halimouv = findViewById(R.id.dgui_halimouv);
		
		button_calc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!input_year.getText().toString().equals("-") && !input_year.getText().toString().equals("")) {
					if (!input_month.getText().toString().equals("-") && !input_month.getText().toString().equals("")) {
						if (!input_day.getText().toString().equals("-") && !input_day.getText().toString().equals("")) {
							if ((Double.parseDouble(new SimpleDateFormat("MM").format(calendar_dgui.getTime())) < user_mob) || ((user_mob == Double.parseDouble(new SimpleDateFormat("MM").format(calendar_dgui.getTime()))) && (Double.parseDouble(new SimpleDateFormat("dd").format(calendar_dgui.getTime())) < user_dob))) {
								user_age = (Double.parseDouble(new SimpleDateFormat("yyyy").format(calendar_dgui.getTime())) - user_yob) - 1;
								if (user_age == -1) {
									dgui_ageresult.setVisibility(View.VISIBLE);
									dgui_ageresult.setText("Your age is : ".concat("🙂"));
								}
								else {
									dgui_ageresult.setVisibility(View.VISIBLE);
									dgui_ageresult.setText("Your age is : ".concat(String.valueOf((long)(user_age))));
								}
							}
							else {
								if ((Double.parseDouble(new SimpleDateFormat("MM").format(calendar_dgui.getTime())) == user_mob) && (Double.parseDouble(new SimpleDateFormat("dd").format(calendar_dgui.getTime())) == user_dob)) {
									user_age = Double.parseDouble(new SimpleDateFormat("yyyy").format(calendar_dgui.getTime())) - user_yob;
									dgui_ageresult.setVisibility(View.VISIBLE);
									dgui_ageresult.setText("Your age is : ".concat(String.valueOf((long)(user_age)).concat(" Happy Birthday 🎉🎂")));
								}
								else {
									user_age = Double.parseDouble(new SimpleDateFormat("yyyy").format(calendar_dgui.getTime())) - user_yob;
									dgui_ageresult.setVisibility(View.VISIBLE);
									dgui_ageresult.setText("Your age is : ".concat(String.valueOf((long)(user_age))));
								}
							}
						}
						else {
							dgui_err_msg.setVisibility(View.VISIBLE);
							dgui_err_msg.setText("ERR MESSAGE: [DGUI-#0003] Day of birth is empty !");
						}
					}
					else {
						dgui_err_msg.setVisibility(View.VISIBLE);
						dgui_err_msg.setText("ERR MESSAGE: [DGUI-#0002] Month of birth is empty !");
					}
				}
				else {
					dgui_err_msg.setVisibility(View.VISIBLE);
					dgui_err_msg.setText("ERR MESSAGE: [DGUI-#0001] Year of birth is empty !");
				}
			}
		});
		
		input_year.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!input_year.getText().toString().equals("-") && !input_year.getText().toString().equals("")) {
					dgui_err_msg.setVisibility(View.INVISIBLE);
					if (Double.parseDouble(input_year.getText().toString()) > Double.parseDouble(new SimpleDateFormat("yyyy").format(calendar_dgui.getTime()))) {
						input_year.setText(new SimpleDateFormat("yyyy").format(calendar_dgui.getTime()));
					}
					if (Double.parseDouble(input_year.getText().toString()) < 0) {
						input_year.setText("1900");
					}
					user_yob = Double.parseDouble(input_year.getText().toString());
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		input_month.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!input_month.getText().toString().equals("-") && !input_month.getText().toString().equals("")) {
					dgui_err_msg.setVisibility(View.INVISIBLE);
					if (Double.parseDouble(input_month.getText().toString()) > 12) {
						input_month.setText("12");
					}
					if (Double.parseDouble(input_month.getText().toString()) < 1) {
						input_month.setText("1");
					}
					user_mob = Double.parseDouble(input_month.getText().toString());
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		input_day.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!input_day.getText().toString().equals("-") && !input_day.getText().toString().equals("")) {
					dgui_err_msg.setVisibility(View.INVISIBLE);
					if (Double.parseDouble(input_day.getText().toString()) > 31) {
						input_day.setText("31");
					}
					if (Double.parseDouble(input_day.getText().toString()) < 1) {
						input_day.setText("1");
					}
					user_dob = Double.parseDouble(input_day.getText().toString());
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		github_projectlink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dgui_intent.setAction(Intent.ACTION_VIEW);
				dgui_intent.setData(Uri.parse("https://github.com/halimouv/age-calculator-app"));
				startActivity(dgui_intent);
			}
		});
		
		dgui_github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dgui_intent.setAction(Intent.ACTION_VIEW);
				dgui_intent.setData(Uri.parse("https://github.com/halimouv"));
				startActivity(dgui_intent);
			}
		});
	}
	
	private void initializeLogic() {
		calendar_dgui = Calendar.getInstance();
		dgui_err_msg.setVisibility(View.INVISIBLE);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}