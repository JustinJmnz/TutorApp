package com.example.tutorapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends Activity {
	private Intent loginIntent;
	private Intent signUpStudentIntent;
	private Intent signUpTutorIntent;
	private boolean toStudentSignUp;
	private AlertDialog.Builder choice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		loginIntent = new Intent(MainMenuActivity.this,Login.class);
		signUpStudentIntent = new Intent(MainMenuActivity.this,SignUp.class);
		signUpTutorIntent = new Intent(MainMenuActivity.this, Tutor.class);
		//Variables
		Button login = (Button)findViewById(R.id.btnLogin);
		Button signUp = (Button)findViewById(R.id.btnSignUp);
		//alert Message
		choice=new AlertDialog.Builder(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		
		
		return true;
	}
	public void ButtonOnClick(View v) {
		switch(v.getId()){
		case R.id.btnLogin:
			MainMenuActivity.this.startActivity(loginIntent);
			break;
		case R.id.btnSignUp:
			CharSequence[] ppl={"Students","Tutor"};
			choice.setTitle("Sign up as: ").setItems(ppl, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation).toBundle();
					switch (which){
					case 0: //to student
						MainMenuActivity.this.startActivity(signUpStudentIntent, bndlanimation);
						break;
					case 1://to tutors
						MainMenuActivity.this.startActivity(signUpTutorIntent,bndlanimation);//go to tutor
						break;
					}	
				}
			}).show();
			break;
		}
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
