package Entity;
import java.io.Serializable;

public class Contato implements Serializable{

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private long classificacao;

	// charles
    public Contato(){

    }

    public Contato( String nome, String endereco, String telefone, String site, long classificacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.site = site;
        this.classificacao = classificacao;
    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSite() {
        return site;
    }

    public long getClassificacao() {
        return classificacao;
    }

    @Override
    public String toString(){
        return getId() +" - "+ getNome();
    }

    public void setId(long id) {
        this.id = id;
    }
}
