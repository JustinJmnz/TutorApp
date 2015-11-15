package com.example.tutorapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tutor extends Activity {
	private ArrayList<String> justSubjectNames = new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	private ListView subjectList;
	private TextView lblSelected;
	private ArrayList<String> classesKnown;
	private Button btnNext;
	private AlertDialog.Builder dialog;
	private Intent toLogin;		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_tutor);
		justSubjectNames.add("Physics 1");
		justSubjectNames.add("Physics 2");
		justSubjectNames.add("Calc 1");
		justSubjectNames.add("Calc 2");
		justSubjectNames.add("Calc 3");
		justSubjectNames.add("Robotics");
		justSubjectNames.add("Shell programming");
		toLogin = new Intent(Tutor.this, Login.class);
		btnNext = (Button)findViewById(R.id.btnNextTutor);
		dialog = new AlertDialog.Builder(this);
		classesKnown = new ArrayList<String>();
		lblSelected = (TextView)findViewById(R.id.lblSelectedTutor);
		subjectList = (ListView)findViewById(R.id.subjectList);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,justSubjectNames);
		subjectList.setAdapter(adapter);
		subjectList.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String school = String.valueOf(parent.getItemAtPosition(position));
				classesKnown.add(school);
				updateList();
			}
			
		});
		
	}
	public void OnButtonClicked(View v){
		switch(v.getId()){
		case R.id.btnNextTutor:
			CharSequence[] schools={"UB","Harvard", "Yale", "Brandeis"};
			dialog.setTitle("Select your school ").setItems(schools, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which){
					case 0:
						// Add it to Database
						Tutor.this.startActivity(toLogin);
						break;
					case 1:
						// Add it to Database
						Tutor.this.startActivity(toLogin);
						break;
					case 2:
						// Add it to Database
						Tutor.this.startActivity(toLogin);
						break;
					case 3:
						// Add it to Database
						Tutor.this.startActivity(toLogin);
						break;
						
					}	
				}
			}).show();
			break;
		}
	}
	public void updateList(){
		String classes = "";
		for (String subjects : classesKnown){
			classes += subjects+" | ";
		}
		lblSelected.setText("Your subjects: " + classes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutor, menu);
		return true;
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
