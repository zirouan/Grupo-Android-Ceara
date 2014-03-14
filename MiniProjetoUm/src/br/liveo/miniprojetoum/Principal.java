package br.liveo.miniprojetoum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends Activity {
 
	private TextView txtResultado;
	private EditText edtDigiteAqui;
	
	private Button btnChamarTela;
	private Button btnEnviarInformacao;
	private Button btnReceberInformacao;

	private int REQUESTCODE = 0;	
	private String INFORMACAO = "INFORMACAO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		txtResultado = (TextView) findViewById(R.id.txtResultado);
		edtDigiteAqui = (EditText) findViewById(R.id.edtDigiteAqui);
		
		btnChamarTela = (Button) findViewById(R.id.btnChamarTela);
		btnChamarTela.setOnClickListener(onClickChamarTela);
		
		btnEnviarInformacao = (Button) findViewById(R.id.btnEnviarInformacao);
		btnEnviarInformacao.setOnClickListener(onClickEnviarInformacao);
		
		btnReceberInformacao = (Button) findViewById(R.id.btnReceberInformacao);
		btnReceberInformacao.setOnClickListener(onClickReceberInformacao);
	}
	
	private OnClickListener onClickChamarTela = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Principal.this, ActivityUm.class));
		}
	};
	
	private OnClickListener onClickEnviarInformacao = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (!edtDigiteAqui.getText().toString().equals("")){
				
				Intent intencao = new Intent(Principal.this, ActivityDois.class);
				intencao.putExtra(INFORMACAO, edtDigiteAqui.getText().toString());
				startActivity(intencao);
			}else{
				Toast.makeText(getApplicationContext(), "Informe um texto", Toast.LENGTH_LONG).show();
			}
			
			/*
			 * Usando o putExtra da intencao sempre vai requerer um nome e um valor. É importante lembrar
			 * que o nome que você usar para enviar deve ser usando para receber.
			 * 
			 * No nosso exemplo estou enviando como "INFORMACAO" então caso eu queira esse valor vou ter que 
			 * da um get como "INFORMACAO"
			 * 
			 * 
			 */
		}
	};

	private OnClickListener onClickReceberInformacao = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intencao = new Intent(Principal.this, ActivityTres.class);			
			startActivityForResult(intencao, REQUESTCODE); 
			
			/*
			 * Quando se usar o startActivityForResult, estou dizendo que a Activity Principal é a tela Pai
			 * e a Activity ActivityTres é a filho. Portando a Activity Principal vai esperar um retorno da filho
			 * assim que ele for fechada e esse retorna vai passar pelo metodo onActivityResult
			 * */			
		}
	};
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (data != null){			
			if (resultCode == REQUESTCODE){
				txtResultado.setText(data.getStringExtra(INFORMACAO));				
			}
		}		
    }

}
