package teachinsquare.mathquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		
		
		//<----------------- Frame work of a thread------------------------->
		Thread timer = new Thread(){
			@Override
			public void run(){
				try{
					sleep(1000);//It was 6000
				} catch (InterruptedException e){
					e.printStackTrace();
				} finally {
					//Go to an activity ( page ) code
					Intent ebayActivityIntent = new Intent("com.teachinsquare.INTRO");	
					startActivity(ebayActivityIntent);
				}
			}
		};
		timer.start();
		//<-------------------------end of the thread( we ran it )------------------>
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		finish();
	}
	
	
	
}

