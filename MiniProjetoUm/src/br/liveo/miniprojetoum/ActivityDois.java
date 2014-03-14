package br.liveo.miniprojetoum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityDois extends Activity {

	private TextView txtRecebido;	
	private String INFORMACAO = "INFORMACAO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dois);
		
		txtRecebido = (TextView) findViewById(R.id.txtRecebido);
		
		Bundle extras = getIntent().getExtras();
		
		if (extras != null){
			txtRecebido.setText(extras.getString(INFORMACAO));
		}
	}

}
