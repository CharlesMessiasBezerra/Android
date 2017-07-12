package com.agenda.charles.agenda;
import Entity.Contato;
import DataAccess.daoContato;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    private FormularioHelper frmContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Contato contato = (Contato) intent.getSerializableExtra("ContatoAtual");
        frmContato = new FormularioHelper(this);

        if(contato != null) {
            frmContato.PreencheCampos(contato);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_formulario_ok) {

            Contato contato =  frmContato.getContato();
            daoContato dao = new daoContato(this);

            if (contato.getId() != null) {
                dao.Alterar(contato);
                Toast.makeText(Formulario.this, "Contato  Editado", Toast.LENGTH_SHORT).show();
            }else{
                dao.insere(contato);
                Toast.makeText(Formulario.this, "Contato  Adicionado", Toast.LENGTH_SHORT).show();
            }
            dao.close();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}