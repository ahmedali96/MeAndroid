package teachinsquare.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Trans extends Activity {
	String source, message;
	String[] correctAns = new String[100];
	String[] selectedAns = new String[100];
	String[] rightOrWrong = new String[100];
	String[] selectedAnsFromOne, rightsOrWrongsFromOne, correctsFromOne;
	String[] selectedAnsFromTwo, rightsOrWrongsFromTwo, correctsFromTwo;

	Button bTrans;
	TextView tvTrans;
	Intent a;
	Bundle basket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trans);
		bTrans = (Button) findViewById(R.id.bTrans);
		tvTrans = (TextView) findViewById(R.id.tvTrans1);

		Bundle TheBasket = getIntent().getExtras();
		source = TheBasket.getString("source");
		basket = new Bundle();
		if (source.equalsIgnoreCase("first")) {
			message = "Great! You have finished the first section, when you're ready to start the next section click Continue.";
			tvTrans.setText(message);

			selectedAnsFromOne = TheBasket.getStringArray("key");
			rightsOrWrongsFromOne = TheBasket.getStringArray("rights");
			correctsFromOne = TheBasket.getStringArray("corrects");

			basket.putStringArray("key", selectedAnsFromOne);
			basket.putStringArray("rights", rightsOrWrongsFromOne);
			basket.putStringArray("corrects", correctsFromOne);
			basket.putInt("Slide", 1);
			a = new Intent(Trans.this, SecondSec.class);
			a.putExtras(basket);

		} else if (source.equalsIgnoreCase("second")) {

			message = "Great! You have finished the second section, when you\'re ready to start the next section click Continue.";
			tvTrans.setText(message);
			selectedAnsFromOne = TheBasket.getStringArray("key1");
			rightsOrWrongsFromOne = TheBasket.getStringArray("rights1");
			correctsFromOne = TheBasket.getStringArray("corrects1");

			selectedAnsFromTwo = TheBasket.getStringArray("key2");
			rightsOrWrongsFromTwo = TheBasket.getStringArray("rights2");
			correctsFromTwo = TheBasket.getStringArray("corrects2");

			basket.putStringArray("key2", selectedAnsFromTwo);
			basket.putStringArray("rights2", rightsOrWrongsFromTwo);
			basket.putStringArray("corrects2", correctsFromTwo);

			basket.putStringArray("key1", selectedAnsFromOne);
			basket.putStringArray("rights1", rightsOrWrongsFromOne);
			basket.putStringArray("corrects1", correctsFromOne);
			basket.putInt("Slide", 1);
			a = new Intent(Trans.this, ThirdSec.class);
			a.putExtras(basket);

		} else if (source.equalsIgnoreCase("third")) {
			message = "That\'s it, no more questions.\n Click the button below to check your score or hit back it you want to review any questions.";
			tvTrans.setText(message);
			selectedAns = TheBasket.getStringArray("key3");
			rightOrWrong = TheBasket.getStringArray("rights3");
			correctAns = TheBasket.getStringArray("corrects3");

			selectedAnsFromOne = TheBasket.getStringArray("key1");
			rightsOrWrongsFromOne = TheBasket.getStringArray("rights1");
			correctsFromOne = TheBasket.getStringArray("corrects1");

			selectedAnsFromTwo = TheBasket.getStringArray("key2");
			rightsOrWrongsFromTwo = TheBasket.getStringArray("rights2");
			correctsFromTwo = TheBasket.getStringArray("corrects2");

			basket.putStringArray("key3", selectedAns);
			basket.putStringArray("rights3", rightOrWrong);
			basket.putStringArray("corrects3", correctAns);

			basket.putStringArray("key2", selectedAnsFromTwo);
			basket.putStringArray("rights2", rightsOrWrongsFromTwo);
			basket.putStringArray("corrects2", correctsFromTwo);

			basket.putStringArray("key1", selectedAnsFromOne);
			basket.putStringArray("rights1", rightsOrWrongsFromOne);
			basket.putStringArray("corrects1", correctsFromOne);
			basket.putInt("Slide", 1);
			a = new Intent(Trans.this, ReportMenu.class);
			a.putExtras(basket);

		}
		bTrans.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(a);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.mymenu3, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.iS:
			startActivity(a);
			break;
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
			    Toast.makeText(Trans.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		return false;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		finish();
	}
}
