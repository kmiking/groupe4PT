package com.example.projetandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MenuActivity extends Activity {
	Button maman,bebe,consul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		maman =(Button) findViewById(R.id.carma);
		bebe =(Button) findViewById(R.id.carbe);
		consul =(Button) findViewById(R.id.cons);
		
	maman.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
	Intent intent=new Intent(MenuActivity.this, CarnetMamaActivity.class);
				startActivity(intent);
			}	});	
				
		bebe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(MenuActivity.this, CarnetBebeActivity.class);
				startActivity(intent);
			}	});
						
		consul.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
	Intent intent=new Intent(MenuActivity.this, ProchainsRVActivity.class);
				startActivity(intent);
			}	});		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);		
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.menuAide){
			Intent intent = new Intent(MenuActivity.this, AideActivity.class);
	 		startActivity(intent);
		}else if(item.getItemId() == R.id.menuApropos){
	AlertDialog dialog = new AlertDialog.Builder(MenuActivity.this).create();
	dialog.setTitle("A propos");
	dialog.setMessage("Copyright Tous droits reservés by Groupe4");
	dialog.setIcon(R.drawable.infos);
	dialog.setButton("OK", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
	});
dialog.show();	
}
		return super.onOptionsItemSelected(item);
	}
}
