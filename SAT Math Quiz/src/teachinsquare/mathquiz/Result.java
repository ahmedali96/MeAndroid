package teachinsquare.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	String[] selectedAns, rightsOrWrongs, corrects;
	String theMessage;
	int x = 1, n;
	LinearLayout llOne, llTwo, llThree;
	TextView xy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		TextView tvMessage = (TextView) findViewById(R.id.tvMessage);
		TextView c1 = (TextView) findViewById(R.id.tvNumberC);
		TextView c2 = (TextView) findViewById(R.id.tvSelectedChoiceC);
		TextView c3 = (TextView) findViewById(R.id.tvCorrectAnsC);
		llOne = (LinearLayout) findViewById(R.id.llOne);
		llTwo = (LinearLayout) findViewById(R.id.llTwo);
		llThree = (LinearLayout) findViewById(R.id.llThree);

		Bundle TheBasket = getIntent().getExtras();
		selectedAns = TheBasket.getStringArray("key");
		theMessage = TheBasket.getString("message");
		rightsOrWrongs = TheBasket.getStringArray("rights");
		corrects = TheBasket.getStringArray("corrects");

		tvMessage.setText(theMessage);
		String theResult = "Number       ";
		String theChoices = "Selected";
		String theCorrect = "Correct";
		if (theMessage.equalsIgnoreCase("First Section's Report")) {
			n = 21;
		} else if (theMessage.equalsIgnoreCase("Second Section's Report")) {
			n = 19;
		} else if (theMessage.equalsIgnoreCase("Third Section's Report")) {
			n = 17;
		}


		c1.setText(theResult);
		c2.setText(theChoices);
		c3.setText(theCorrect);

		while (x < n) {

			if (selectedAns[x] == null) {
				selectedAns[x] = "-";
			}
			if ( rightsOrWrongs[x] == null){
				rightsOrWrongs[x] = "Left";
			}
			adderFunction(x, "  "+x + ") " + rightsOrWrongs[x], llOne);
			adderFunction2(x, selectedAns[x], llTwo);
			adderFunction2(x, corrects[x], llThree);
			x++;
		}

	}

	private void adderFunction(final int x, String str, LinearLayout ll) {
		// TODO Auto-generated method stub
		xy = new TextView(getApplicationContext());
		xy.setId(x);
		xy.setTextColor(Color.parseColor("#fc63f6"));
		xy.setText(str);
		xy.setGravity(Gravity.LEFT);
		xy.setPadding(0, 20, 0, 20);
		ll.addView(xy);
		xy.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (n == 21) {
					Intent i = new Intent(Result.this,
							SATMathPracticetestActivity.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					i.putExtras(basket);

					startActivity(i);
				} else if (n == 19) {
					Intent i = new Intent(Result.this, SecondSec.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					i.putExtras(basket);

					startActivity(i);
				} else if (n == 17) {
					Intent i = new Intent(Result.this, ThirdSec.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					i.putExtras(basket);
					startActivity(i);
				}

			}
		});
	}

	private void adderFunction2(final int x, String str, LinearLayout ll) {
		// TODO Auto-generated method stub
		xy = new TextView(getApplicationContext());
		xy.setId(x);
		xy.setTextColor(Color.parseColor("#fc63f6"));
		xy.setText(str);
		xy.setGravity(Gravity.CENTER);
		xy.setPadding(0, 20, 0, 20);
		ll.addView(xy);
		xy.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (n == 21) {
					Intent i = new Intent(Result.this,
							SATMathPracticetestActivity.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					basket.putBoolean("finishedIt", true);
					i.putExtras(basket);

					startActivity(i);
				} else if (n == 19) {
					Intent i = new Intent(Result.this, SecondSec.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					basket.putBoolean("finishedIt", true);
					i.putExtras(basket);
					startActivity(i);
				} else if (n == 17) {
					Intent i = new Intent(Result.this, ThirdSec.class);
					Bundle basket = new Bundle();
					basket.putInt("Slide", x);
					basket.putBoolean("finishedIt", true);
					i.putExtras(basket);
					startActivity(i);
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.mymenu4, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.iA:
			Intent i = new Intent("com.teachinsquare.ABOUT");
			startActivity(i);
			break;
		case R.id.iC:
			moveTaskToBack(true);
			break;
		case R.id.iF:
			Intent imail = new Intent(Intent.ACTION_SEND);
			imail.setType("message/rfc822");
			imail.putExtra(Intent.EXTRA_EMAIL  , new String[]{"engahmedali3@gmail.com"});
			imail.putExtra(Intent.EXTRA_SUBJECT, "SAT Math Practice Test Feedback");
			imail.putExtra(Intent.EXTRA_TEXT   , "");
			try {
			    startActivity(Intent.createChooser(imail, "Send mail..."));
			} catch (android.content.ActivityNotFoundException ex) {
			    Toast.makeText(Result.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		return false;
	}
}
