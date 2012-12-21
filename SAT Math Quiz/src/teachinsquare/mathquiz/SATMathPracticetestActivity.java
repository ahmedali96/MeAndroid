package teachinsquare.mathquiz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SATMathPracticetestActivity extends Activity implements
		OnClickListener, OnCheckedChangeListener, OnGestureListener {
	int slideNum = 1, correct = 0, incorrect = 0, choicesStart = 1, rights = 0,
			myValuemin, myValuesec, it = 0;
	Boolean breaker = false, dialogStarted = false;;

	String[] choices = new String[100];
	String[] correctAns = new String[100];
	String[] selectedAns = new String[100];
	String[] rightOrWrong = new String[100];

	TextView section, quesView, number, timerView, ansExp;
	RadioButton ch1, ch2, ch3, ch4, ch5;
	ImageView drawing;
	RadioGroup ansGroup;
	String myValue = null;
	private GestureDetector gd;
	Boolean timeOver = false, closer = true, finishedIt = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay);

		Bundle TheBasket = getIntent().getExtras();
		finishedIt = TheBasket.getBoolean("finishedIt");

		if (slideNum == TheBasket.getInt("Slide")) {
			slideNum = 1;

		} else {
			closer = true;
			slideNum = TheBasket.getInt("Slide");
		}

		initialize();
		imageShower();
		gd = new GestureDetector(this);
		quesView.setText(getQuestionAsString(slideNum, R.array.questions));
		ch1.setText(getQuestionAsString(1, R.array.choices));
		ch2.setText(getQuestionAsString(2, R.array.choices));
		ch3.setText(getQuestionAsString(3, R.array.choices));
		ch4.setText(getQuestionAsString(4, R.array.choices));
		ch5.setText(getQuestionAsString(5, R.array.choices));
		if (finishedIt == false) {
			Toast.makeText(this,
					"Swipe right and left to navigate between questions",
					Toast.LENGTH_LONG).show();
			new Thread(new Runnable() {
				public void run() {
					while (it <= 1500) {
						try {
							Thread.sleep(1000);
							myValuesec = it % 60;
							myValuemin = it / 60;

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						timerView.post(new Runnable() {
							public void run() {
								timerView.setText(String.format("%02d:%02d",
										myValuemin, myValuesec));
								if (myValuemin >= 0 && myValuemin < 8) {
									timerView
											.setTextColor(android.graphics.Color
													.argb(1000, 118, 215, 247));
								} else if (myValuemin >= 8 && myValuemin < 10) {
									timerView
											.setTextColor(android.graphics.Color
													.argb(1000, 249, 137, 0));
								} else if (myValuemin >= 10 && myValuemin < 25) {
									timerView
											.setTextColor(android.graphics.Color
													.argb(1000, 234, 14, 14));
								} else {
									timeOver = true;

								}
							}

						});
						if (breaker == true) {
							break;
						}
						if (timeOver == true) {
							Intent i = new Intent("com.teachinsquare.ALERT");
							startActivity(i);
							break;
						}
						it++;
					}
				}
			}).start();
		}
	}

	private void initialize() {
		// TODO Auto-generated method stub
		section = (TextView) findViewById(R.id.tvSection);
		section.setText(" The First Section\n20 questions in 25 min");
		timerView = (TextView) findViewById(R.id.tvTimer);
		ansExp = (TextView) findViewById(R.id.tvExp);
		quesView = (TextView) findViewById(R.id.tvQues);
		drawing = (ImageView) findViewById(R.id.ivPic);
		ansGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		ch1 = (RadioButton) findViewById(R.id.radio0);
		ch2 = (RadioButton) findViewById(R.id.radio1);
		ch3 = (RadioButton) findViewById(R.id.radio2);
		ch4 = (RadioButton) findViewById(R.id.radio3);
		ch5 = (RadioButton) findViewById(R.id.radio4);
		number = (TextView) findViewById(R.id.tvNum);
		ansGroup.setOnCheckedChangeListener(this);
		while (choicesStart < 13) {
			correctAns[choicesStart] = getQuestionAsString(choicesStart,
					R.array.rightAnswers);
			choicesStart++;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflate = getMenuInflater();
		if (finishedIt == true) {
			inflate.inflate(R.menu.mymenux, menu);
		} else {
			inflate.inflate(R.menu.mymenu2, menu);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.iS:
			breaker = true;
			Bundle basket = new Bundle();
			basket.putStringArray("key", selectedAns);
			basket.putStringArray("rights", rightOrWrong);
			basket.putStringArray("corrects", correctAns);
			basket.putString("source", "first");
			basket.putInt("Slide", 1);
			slideNum = 12;
			if (finishedIt == false) {
				Intent a = new Intent(SATMathPracticetestActivity.this,
						Trans.class);
				a.putExtras(basket);
				startActivity(a);
			}
			break;
		case R.id.iA:
			Intent i = new Intent("com.teachinsquare.ABOUT");
			startActivity(i);
			break;
		case R.id.iC:
			moveTaskToBack(true);
			break;
		case R.id.iR:
			finish();
			break;
		case R.id.iF:
			Intent imail = new Intent(Intent.ACTION_SEND);
			imail.setType("message/rfc822");
			imail.putExtra(Intent.EXTRA_EMAIL,
					new String[] { "engahmedali3@gmail.com" });
			imail.putExtra(Intent.EXTRA_SUBJECT,
					"SAT Math Practice Test Feedback");
			imail.putExtra(Intent.EXTRA_TEXT, "");
			try {
				startActivity(Intent.createChooser(imail, "Send mail..."));
			} catch (android.content.ActivityNotFoundException ex) {
				Toast.makeText(SATMathPracticetestActivity.this,
						"There are no email clients installed.",
						Toast.LENGTH_SHORT).show();
			}
			break;
		}
		return false;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
	}

	private void previousFunction() {
		// TODO Auto-generated method stub
		correctIT();
		resetChoices();
		slideNum--;
		getTheSelectedChoice();
		getTheQuestion();
		imageShower();
	}

	private void nextFunction() {
		// TODO Auto-generated method stub
		correctIT();

		resetChoices();
		slideNum++;
		getTheSelectedChoice();
		imageShower();
		if (slideNum < 13) {
			getTheQuestion();
		}
		;
		checkForEnd();

	}

	private void checkForEnd() {
		// TODO Auto-generated method stub
		if (slideNum == 13) {
			breaker = true;
			Bundle basket = new Bundle();
			basket.putStringArray("key", selectedAns);
			basket.putStringArray("rights", rightOrWrong);
			basket.putStringArray("corrects", correctAns);
			basket.putString("source", "first");
			basket.putInt("Slide", 1);
			slideNum = 12;
			if (finishedIt == false) {
				Intent a = new Intent(SATMathPracticetestActivity.this,
						Trans.class);
				a.putExtras(basket);
				startActivity(a);
			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Bundle TheBasket = getIntent().getExtras();
		if (!closer) {
			if (slideNum == TheBasket.getInt("Slide")) {
				slideNum = 1;
			} else {
				slideNum = TheBasket.getInt("Slide");
			}
		}
		getTheQuestion();
		number.setText(slideNum + ")");
		getTheSelectedChoice();
	}

	private void getTheQuestion() {
		// TODO Auto-generated method stub
		quesView.setText(getQuestionAsString(slideNum, R.array.questions));
		ansExp.setText(getQuestionAsString(slideNum,
				teachinsquare.mathquiz.R.array.expAnswers));
		ch1.setText(getQuestionAsString(((slideNum * 5) - 4), R.array.choices));
		ch2.setText(getQuestionAsString(((slideNum * 5) - 3), R.array.choices));
		ch3.setText(getQuestionAsString(((slideNum * 5) - 2), R.array.choices));
		ch4.setText(getQuestionAsString(((slideNum * 5) - 1), R.array.choices));
		ch5.setText(getQuestionAsString((slideNum * 5), R.array.choices));
		number.setText(slideNum + ") ");
	}

	private void correctIT() {
		// TODO Auto-generated method stub
		if (ch1.isChecked() || ch2.isChecked() || ch3.isChecked()
				|| ch4.isChecked() || ch5.isChecked()) {
			if (selectedAns[slideNum].equals(getQuestionAsString(slideNum,
					R.array.rightAnswers))) {

				rightOrWrong[slideNum] = "Right";
			} else {
				rightOrWrong[slideNum] = "Wrong";
			}
		} else {
			rightOrWrong[slideNum] = "Left";
		}

	}

	private void resetChoices() {
		// TODO Auto-generated method stub
		ansGroup.clearCheck();
	}

	private String getQuestionAsString(int slide, int x) {

		try {
			String[] bases = getResources().getStringArray(x);

			return bases[slide];

		} catch (Exception e) {
			return "";
		}

	}

	private void getTheSelectedChoice() {
		// TODO Auto-generated method stub
		if (selectedAns[slideNum] == null) {
		} else {
			String xv = selectedAns[slideNum];

			if (xv.equals(getQuestionAsString((slideNum) * 5 - 4,
					R.array.choices))) {
				ch1.setChecked(true);
			} else if (xv.equals(getQuestionAsString((slideNum) * 5 - 3,
					R.array.choices))) {
				ch2.setChecked(true);
			} else if (xv.equals(getQuestionAsString((slideNum) * 5 - 2,
					R.array.choices))) {
				ch3.setChecked(true);
			} else if (xv.equals(getQuestionAsString((slideNum) * 5 - 1,
					R.array.choices))) {
				ch4.setChecked(true);
			} else if (xv.equals(getQuestionAsString((slideNum) * 5,
					R.array.choices))) {
				ch5.setChecked(true);
			}
		}
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {

		case R.id.radio0:
			selectedAns[slideNum] = getQuestionAsString(slideNum * 5 - 4,
					R.array.choices);
			break;
		case R.id.radio1:
			selectedAns[slideNum] = getQuestionAsString(slideNum * 5 - 3,
					R.array.choices);
			break;
		case R.id.radio2:
			selectedAns[slideNum] = getQuestionAsString(slideNum * 5 - 2,
					R.array.choices);
			break;
		case R.id.radio3:
			selectedAns[slideNum] = getQuestionAsString(slideNum * 5 - 1,
					R.array.choices);
			break;
		case R.id.radio4:
			selectedAns[slideNum] = getQuestionAsString(slideNum * 5,
					R.array.choices);
			break;
		}
	}

	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onFling(MotionEvent start, MotionEvent end, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (start.getRawX() > end.getRawX()) {
			float ress = -start.getRawX() + end.getRawY();
			nextFunction();
		}
		if (start.getRawX() < end.getRawX()) {
			float ress = -start.getRawX() + end.getRawY();
			if (slideNum > 1) {
				previousFunction();
			}
		}

		return true;
	}

	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return gd.onTouchEvent(me);
	}

	private void imageShower() {
		// TODO Auto-generated method stub
		drawing.setImageResource(R.drawable.resitter);
		switch (slideNum) {
		}
	}
}
