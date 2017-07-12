package DataAccess;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import Entity.Contato;

public class daoContato extends SQLiteOpenHelper {
// charles teste
    public daoContato(Context context) {
        super(context, "MinhaAgenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str_sql = "create table TbContatos(id integer PRIMARY KEY, nome text, endereco text, telefone text,site text,classificacao real)";
        db.execSQL(str_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String str_sql = "drop table If exists TbContatos";
        db.execSQL(str_sql);
        onCreate(db);
    }

    public void insere(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getDadosContato(contato);

        db.insert("TbContatos", null, dados);
    }

    private ContentValues getDadosContato(Contato contato) {

        ContentValues dados = new ContentValues();

        dados.put("nome", contato.getNome());
        dados.put("endereco", contato.getEndereco());
        dados.put("telefone", contato.getTelefone());
        dados.put("site", contato.getSite());
        dados.put("classificacao", contato.getClassificacao());

        return dados;
    }

    public List<Contato> BuscaContatos() {
        String str_sql = "select * from TbContatos";
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(str_sql,null);

        List<Contato> lstcontatos = new ArrayList<Contato>();
        while (c.moveToNext()) {
            Contato contato = new Contato(c.getString(c.getColumnIndex("nome")),c.getString(c.getColumnIndex("endereco")),c.getString(c.getColumnIndex("telefone")),c.getString(c.getColumnIndex("site")),c.getLong(c.getColumnIndex("classificacao")));
            contato.setId(c.getLong(c.getColumnIndex("id")));
            lstcontatos.add(contato);
        }
        c.close();
        return lstcontatos;
    }

    public void deletarContato(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        String[] Str_where = {String.valueOf(contato.getId())};
        db.delete("TbContatos", "id = ?", Str_where);
    }

    public void Alterar(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getDadosContato(contato);
        String[] Str_where = {String.valueOf(contato.getId())};
        db.update("TbContatos", dados, "id = ?", Str_where);
    }
}

