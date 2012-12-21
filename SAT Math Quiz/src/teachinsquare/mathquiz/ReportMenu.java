package teachinsquare.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReportMenu extends Activity implements OnClickListener {
	String[] selectedAnsFromOne, rightsOrWrongsFromOne, correctsFromOne,
			selectedAnsFromTwo, rightsOrWrongsFromTwo, correctsFromTwo,
			selectedAns, rightsOrWrongs, corrects;
	String theMessage;
	Bundle basket = new Bundle();
	String message;
	Intent a;
	int rights = 0, theScore = 0, wrongs = 0, canceled = 0, finalRights;

	Button fLuncher, sLuncher, tLuncher, share;
	TextView score;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportmenu);
		initialize();

		Bundle TheBasket = getIntent().getExtras();

		selectedAns = TheBasket.getStringArray("key3");
		rightsOrWrongs = TheBasket.getStringArray("rights3");
		corrects = TheBasket.getStringArray("corrects3");

		selectedAnsFromOne = TheBasket.getStringArray("key1");
		rightsOrWrongsFromOne = TheBasket.getStringArray("rights1");
		correctsFromOne = TheBasket.getStringArray("corrects1");

		selectedAnsFromTwo = TheBasket.getStringArray("key2");
		rightsOrWrongsFromTwo = TheBasket.getStringArray("rights2");
		correctsFromTwo = TheBasket.getStringArray("corrects2");

		counter(rightsOrWrongs);
		counter(rightsOrWrongsFromOne);
		counter(rightsOrWrongsFromTwo);

		canceled = wrongs / 4;
		finalRights = rights - canceled;
		concertToScore(finalRights);
		score.setText(" " + theScore + " ");
	}

	private void concertToScore(int number) {
		// TODO Auto-generated method stub
		switch (number) {
		case -11:
			theScore = 200;
			break;
		case -10:
			theScore = 200;
			break;
		case -9:
			theScore = 200;
			break;
		case -8:
			theScore = 200;
			break;
		case -7:
			theScore = 200;
			break;
		case -6:
			theScore = 200;
			break;
		case -5:
			theScore = 200;
			break;
		case -4:
			theScore = 200;
			break;
		case -3:
			theScore = 240;
			break;
		case -2:
			theScore = 260;
			break;
		case -1:
			theScore = 270;
			break;
		case 0:
			theScore = 290;
			break;
		case 1:
			theScore = 300;
			break;
		case 2:
			theScore = 310;
			break;
		case 3:
			theScore = 320;
			break;
		case 4:
			theScore = 320;
			break;
		case 5:
			theScore = 330;
			break;
		case 6:
			theScore = 340;
			break;
		case 7:
			theScore = 350;
			break;
		case 8:
			theScore = 360;
			break;
		case 9:
			theScore = 370;
			break;
		case 10:
			theScore = 380;
			break;
		case 11:
			theScore = 390;
			break;
		case 12:
			theScore = 400;
			break;
		case 13:
			theScore = 420;
			break;
		case 14:
			theScore = 430;
			break;
		case 15:
			theScore = 440;
			break;
		case 16:
			theScore = 440;
			break;
		case 17:
			theScore = 450;
			break;
		case 18:
			theScore = 460;
			break;
		case 19:
			theScore = 470;
			break;
		case 20:
			theScore = 470;
			break;
		case 21:
			theScore = 480;
			break;
		case 22:
			theScore = 490;
			break;
		case 23:
			theScore = 500;
			break;
		case 24:
			theScore = 510;
			break;
		case 25:
			theScore = 520;
			break;
		case 26:
			theScore = 530;
			break;
		case 27:
			theScore = 540;
			break;
		case 28:
			theScore = 550;
			break;
		case 29:
			theScore = 560;
			break;
		case 30:
			theScore = 560;
			break;
		case 31:
			theScore = 570;
			break;
		case 32:
			theScore = 580;
			break;
		case 33:
			theScore = 590;
			break;
		case 34:
			theScore = 600;
			break;
		case 35:
			theScore = 600;
			break;
		case 36:
			theScore = 610;
			break;
		case 37:
			theScore = 620;
			break;
		case 38:
			theScore = 630;
			break;
		case 39:
			theScore = 630;
			break;
		case 40:
			theScore = 640;
			break;
		case 41:
			theScore = 650;
			break;
		case 42:
			theScore = 660;
			break;
		case 43:
			theScore = 670;
			break;
		case 44:
			theScore = 680;
			break;
		case 45:
			theScore = 690;
			break;
		case 46:
			theScore = 690;
			break;
		case 47:
			theScore = 700;
			break;
		case 48:
			theScore = 710;
			break;
		case 49:
			theScore = 720;
			break;
		case 50:
			theScore = 730;
			break;
		case 51:
			theScore = 750;
			break;
		case 52:
			theScore = 770;
			break;
		case 53:
			theScore = 780;
			break;
		case 54:
			theScore = 800;
			break;
		}
	}

	private void initialize() {
		// TODO Auto-generated method stub
		fLuncher = (Button) findViewById(R.id.bfLunch);
		sLuncher = (Button) findViewById(R.id.bsLunch);
		tLuncher = (Button) findViewById(R.id.btLunch);
		share = (Button) findViewById(R.id.btShare);
		score = (TextView) findViewById(R.id.tvScore);
		fLuncher.setOnClickListener(this);
		sLuncher.setOnClickListener(this);
		share.setOnClickListener(this);
		tLuncher.setOnClickListener(this);
		
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
			    Toast.makeText(ReportMenu.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		return false;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.bfLunch:
			basket.putStringArray("key", selectedAnsFromOne);
			basket.putStringArray("rights", rightsOrWrongsFromOne);
			basket.putStringArray("corrects", correctsFromOne);
			message = "First Section's Report";
			basket.putString("message", message);
			a = new Intent(ReportMenu.this, Result.class);
			a.putExtras(basket);
			startActivity(a);

			break;
		case R.id.bsLunch:
			basket.putStringArray("key", selectedAnsFromTwo);
			basket.putStringArray("rights", rightsOrWrongsFromTwo);
			basket.putStringArray("corrects", correctsFromTwo);
			message = "Second Section's Report";
			basket.putString("message", message);
			a = new Intent(ReportMenu.this, Result.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.btLunch:
			basket.putStringArray("key", selectedAns);
			basket.putStringArray("rights", rightsOrWrongs);
			basket.putStringArray("corrects", corrects);
			message = "Third Section's Report";
			basket.putString("message", message);
			a = new Intent(ReportMenu.this, Result.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.btShare:
		    a = new Intent(Intent.ACTION_SEND);
		    a.setType("text/plain");
		    a.putExtra(Intent.EXTRA_TEXT, "http://www.teachinsquare.com");
		    a.putExtra(Intent.EXTRA_SUBJECT,"I got " + theScore + " in the \"SAT Math Practice Test\" app!");
		    startActivity(Intent.createChooser(a, "Share"));  
			break;
		}

	}

	private void counter(String[] x) {
		// TODO Auto-generated method stub
		int ii = x.length;
		while (ii > 0) {
			if (x[ii - 1] != null) {
				if (x[ii - 1].equalsIgnoreCase("Right")) {
					rights++;
				} else if (x[ii - 1].equalsIgnoreCase("Wrong")) {
					wrongs++;
				}
			}
			ii--;
		}

	}

}
