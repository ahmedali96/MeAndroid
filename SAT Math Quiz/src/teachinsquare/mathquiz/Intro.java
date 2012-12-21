package teachinsquare.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Intro extends Activity implements OnClickListener {
	Button startButton;
//	LinearLayout linear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		startButton = (Button) findViewById(R.id.bStart);
		startButton.setOnClickListener(this);
		/*
		 * linear = (LinearLayout) findViewById(R.id.linear); AdView ad = new
		 * AdView(Intro.this, AdSize.BANNER,"a150ab4bf595665");
		 * linear.addView(ad); ad.loadAd(new AdRequest());
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflate = getMenuInflater();
		inflate.inflate(R.menu.mymenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.iS:
			Intent ebayActivityIntent = new Intent("com.teachinsquare.ACTIVITY");
			Bundle xb = new Bundle();
			xb.putInt("Slide", 1);
			ebayActivityIntent.putExtras(xb);
			startActivity(ebayActivityIntent);
			break;
		case R.id.iA:
			Intent i = new Intent("com.teachinsquare.ABOUT");
			startActivity(i);
			break;
		case R.id.iC:
			 moveTaskToBack(true);
			break;
		}
		return false;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bStart:
			Intent ebayActivityIntent = new Intent("com.teachinsquare.ACTIVITY");
			Bundle xb = new Bundle();
			xb.putInt("Slide", 1);
			ebayActivityIntent.putExtras(xb);
			startActivity(ebayActivityIntent);
		
		}
	}

}
