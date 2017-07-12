package com.agenda.charles.agenda;
import android.widget.EditText;
import android.widget.RatingBar;
import Entity.Contato;

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoClassificacao;
    private Contato contato;
    private Long id;

    public FormularioHelper(Formulario formularioPrincipal){

         campoNome = (EditText) formularioPrincipal.findViewById(R.id.formulario_nome);
         campoEndereco = (EditText) formularioPrincipal.findViewById(R.id.formulario_endereco);
         campoTelefone = (EditText) formularioPrincipal.findViewById(R.id.formulario_fone);
         campoSite = (EditText) formularioPrincipal.findViewById(R.id.formulario_site);
         campoClassificacao = (RatingBar) formularioPrincipal.findViewById(R.id.formulario_classificacao);
         contato = new Contato();
    }

    public Contato getContato(){
        contato = new Contato(campoNome.getText().toString(),campoEndereco.getText().toString(),campoTelefone.getText().toString(),campoSite.getText().toString(),campoClassificacao.getProgress());
        if(this.id != null) {
            contato.setId(this.id);
        }
        return contato;
    }

    public void PreencheCampos(Contato contato) {
        campoNome.setText(contato.getNome());
        campoEndereco.setText(contato.getEndereco());
        campoTelefone.setText(contato.getTelefone());
        campoSite.setText(contato.getSite());
        campoClassificacao.setProgress((int) contato.getClassificacao());
        this.id = contato.getId();
        this.contato = contato;
    }
}
