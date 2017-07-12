package com.agenda.charles.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import java.util.List;
import DataAccess.daoContato;
import Entity.Contato;

public class Agenda extends AppCompatActivity {

    private ListView lstVWContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button btn_NovoAluno = (Button) findViewById(R.id.btn_novoAuno);
        btn_NovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaFormulario = new Intent(Agenda.this, Formulario.class);
                startActivity(chamaFormulario);
            }
        });

        lstVWContatos = (ListView) findViewById(R.id.ListaAlunos);

        registerForContextMenu(lstVWContatos);

        lstVWContatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Item, int position, long id) {

                Contato contato = (Contato) lstVWContatos.getItemAtPosition(position);
                Intent EditaContato = new Intent(Agenda.this,Formulario.class);
                EditaContato.putExtra("ContatoAtual",contato);
                startActivity(EditaContato);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CarregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Contato contato = (Contato) lstVWContatos.getItemAtPosition(info.position);
                Toast.makeText(Agenda.this, "Contato " + contato.getNome() + " deletado ", Toast.LENGTH_SHORT).show();
                daoContato dao = new daoContato(Agenda.this);
                dao.deletarContato(contato);
                dao.close();
                CarregaLista();
                return false;
            }
        });

    }

    private void CarregaLista() {
        daoContato dao = new daoContato(this);
        List<Contato> lstContatos =  dao.BuscaContatos();
        dao.close();

        ArrayAdapter<Contato> adapter = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, lstContatos);
        lstVWContatos.setAdapter(adapter);
    }

}
