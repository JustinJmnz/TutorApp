package com.example.tutorapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class UniActivity extends Activity {
	private ArrayList<String> justSchoolNames = new ArrayList<String>();
	private TextView lblDescription;
	private ArrayAdapter<String> adapter;
	private ListView schoolList;
	private Button btnNext;
	private TextView lblSelected;
	private Intent toTutors;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uni);
		justSchoolNames.add("UB");
		justSchoolNames.add("UNH");
		justSchoolNames.add("Brandeis");
		justSchoolNames.add("Harvard");
		justSchoolNames.add("MIT");
		justSchoolNames.add("Yale");
		justSchoolNames.add("UCONN");
		justSchoolNames.add("BU");
		toTutors = new Intent();
		lblSelected = (TextView)findViewById(R.id.lblSelectedUni);
		btnNext = (Button)findViewById(R.id.btnUni);
		lblDescription = (TextView)findViewById(R.id.lblSchoolUni);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,justSchoolNames);
		schoolList = (ListView)findViewById(R.id.schoolList);
		schoolList.setAdapter(adapter);
		schoolList.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String school = String.valueOf(parent.getItemAtPosition(position));
				lblSelected.setText("Selected: " + school);
			}
			
		});
	}
	public void ButtonOnClick(View v){
		switch(v.getId()){
		case R.id.btnUni:
			lblDescription.setText("Next");
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uni, menu);
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
