package com.example.projetandroid;
import org.apache.http.client.HttpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.projetandroid.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;


public class InscriptionActivity extends Activity {

	EditText txtNomM, txtPrenomM, txtAgeM, txtPoidsM, 
	txtGrpSM, txtDateGM, txtNumM;
	Button btnValiderM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inscription);
		
		txtNomM = (EditText) findViewById(R.id.txtNomM);
		txtPrenomM = (EditText) findViewById(R.id.txtPrenomM);
		txtAgeM = (EditText) findViewById(R.id.txtAgeM);
		txtPoidsM = (EditText) findViewById(R.id.txtPoidsM);
		txtGrpSM = (EditText) findViewById(R.id.txtGrpSM);
		txtDateGM = (EditText) findViewById(R.id.txtDateGM);
		txtNumM = (EditText) findViewById(R.id.txtNumM);
		btnValiderM = (Button) findViewById(R.id.btnValiderM);
		
		btnValiderM.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				final String NomM = txtNomM.getText().toString();
				final String PrenomM = txtPrenomM.getText().toString();
				final String AgeM = txtAgeM.getText().toString();
				final String PoidsM = txtPoidsM.getText().toString();
				final String GrpSM = txtGrpSM.getText().toString();
				final String DateGM = txtDateGM.getText().toString();
				final String NumM = txtNumM.getText().toString();
				
				if(NomM.equals("") || PrenomM.equals("") || AgeM.equals("") || PoidsM.equals("") || GrpSM.equals("") || DateGM.equals("") || NumM.equals("")){
				Toast.makeText(InscriptionActivity.this, "Veuillez saisir tous les champs", Toast.LENGTH_LONG).show();
			}else{
String url = "http://10.0.2.2/groupe4/inscription.php?nom_m="+NomM+"&prenom_m="+PrenomM+"&age_m="+AgeM+"&poids_m="+PoidsM+"&grp_sm="+GrpSM+"&date_gm="+DateGM+"&num_m="+NumM;
				Downloader d = new Downloader();
				d.execute(url);
			}				
			}   });}
	
	public class Downloader extends AsyncTask<String, Void, String>{
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}
		
		@Override
    	protected void onPostExecute(String result) {
if(result.contains("Enregistrement avec succes !")){
	Toast.makeText(InscriptionActivity.this, "Enregistrement reussi", Toast.LENGTH_LONG).show();
	Intent intent = new Intent(InscriptionActivity.this, MenuActivity.class);
	startActivity(intent);
}else {
	Toast.makeText(InscriptionActivity.this, "Echec enregistrement", Toast.LENGTH_LONG).show();	
} 	
    	}

		@Override
		protected String doInBackground(String... url) {
			// TODO Auto-generated method stub
			try {
	        	HttpClient client = new DefaultHttpClient();
	        	HttpGet get = new HttpGet(url[0]);
	        	ResponseHandler<String> tunnel = new BasicResponseHandler();
				String result = client.execute(get, tunnel);
				return result;	
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
	} 
	}
