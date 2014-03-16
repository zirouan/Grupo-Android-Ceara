package br.liveo.miniprojetodois;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private Button btnTitulo;
	private Button btnSubTitulo;
	private Button btnIcone;
	private Button btnHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTitulo = (Button) findViewById(R.id.btnTitulo);
		btnTitulo.setOnClickListener(onClickTitulo);
		
		btnSubTitulo = (Button) findViewById(R.id.btnSubTitulo);
		btnSubTitulo.setOnClickListener(onClickSubTitulo);
		
		btnIcone = (Button) findViewById(R.id.btnIcone);
		btnIcone.setOnClickListener(onClickIcone);
		
		btnHome = (Button) findViewById(R.id.btnHome);
		btnHome.setOnClickListener(onClickHome);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
		case android.R.id.home:
			toastMsg(this, "Botão home estar ativo.");
			break;

		case R.id.menu_add:
			toastMsg(this, "Adicionar novo registro");			
			break;
			
		case R.id.menu_delete:
			toastMsg(this, "Excluir registro");			
			break;

		case R.id.menu_settings:
			toastMsg(this, "Configurações");			
			break;			
		}
		
		return super.onOptionsItemSelected(item);		
	}
	
	private OnClickListener onClickTitulo = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Alterando o título
			getSupportActionBar().setTitle("AcitonBarCompat");			
		}
	};
	
	private OnClickListener onClickSubTitulo = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Alterando o sub título
			getSupportActionBar().setSubtitle("Android 2.+");			
		}
	};

	private OnClickListener onClickIcone = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Alterando o icone
			getSupportActionBar().setIcon(R.drawable.ic_launcher_dois);
		}
	};

	private OnClickListener onClickHome = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Habilitando o botão home			
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
	};
	
	private void toastMsg(Context context, String msg){
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
