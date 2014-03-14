package br.liveo.miniprojetoum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTres extends Activity {

	private Button btnEnviar;
	private EditText edtInformacao;
	
	private int REQUESTCODE = 0;	
	private String INFORMACAO = "INFORMACAO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tres);
		
		edtInformacao = (EditText) findViewById(R.id.edtInformacao);
		btnEnviar = (Button) findViewById(R.id.btnEnviar);
		btnEnviar.setOnClickListener(onClickEnviar);
	}
	
	private OnClickListener onClickEnviar = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (!edtInformacao.getText().toString().equals("")){
				Intent intencao = new Intent();
				intencao.putExtra(INFORMACAO, edtInformacao.getText().toString());
				setResult(REQUESTCODE, intencao);
				finish();
			}else{
				Toast.makeText(getApplicationContext(), "Informe um texto", Toast.LENGTH_LONG).show();				
			}
		}
	};
}
