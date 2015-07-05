package com.example.projetandroid;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	EditText txtLog, txtPass;
    Button btnNewMam, btnConnect;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        txtLog = (EditText) findViewById(R.id.txtPrenom);
        txtPass = (EditText) findViewById(R.id.txtPass);
     btnNewMam = (Button) findViewById(R.id.btnNewMam);
    btnConnect = (Button) findViewById(R.id.btnConnect);
    
    btnNewMam.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(LoginActivity.this, InscriptionActivity.class);
			startActivity(intent);
		}
	});
    
   btnConnect.setOnClickListener(new OnClickListener() {
		
    	   public void onClick(View arg0) {
			     final  String login = txtLog.getText().toString();
			     final  String password = txtPass.getText().toString();
			
			if(login.equals("") || password.equals("")){
				Toast.makeText(LoginActivity.this, "Login ou Password incorrect", Toast.LENGTH_LONG).show();
			}
			else{				
				String url = "http://10.0.2.2/groupe4/connexion.php?login="+login+"&password="+password;
				Downloader d = new Downloader();
				d.execute(url);
			}
		}
	});   
       }

    protected class Downloader extends AsyncTask<String, Void, String>{	
    	@Override
    	protected void onPostExecute(String result) {
    		if(result.contains("OK!")){
	Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
	startActivity(intent);
}else {
	Toast.makeText(LoginActivity.this, "Login ou Password incorrect", Toast.LENGTH_LONG).show();	
}    	
    	}
    	
    	@Override
    			protected void onPreExecute() {
    				super.onPreExecute();
    			}
    	
    	@Override
		protected String doInBackground(String... url){	
    	    	try {
    		        	HttpClient client = new DefaultHttpClient();
        		        	HttpGet get = new HttpGet(url[0]);
        	ResponseHandler<String> tunnel = new BasicResponseHandler();
			String result = client.execute(get, tunnel);
			return result;
		} catch (Exception e) {
		}
			return null;
		}	
	}    
}
