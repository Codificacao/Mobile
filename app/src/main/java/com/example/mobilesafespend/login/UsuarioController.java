package com.example.mobilesafespend.login;

import android.content.ContentValues;
import android.content.Context;
import java.util.Collections;
import java.util.List;

public class UsuarioController extends AppDataBase implements ICrud<Usuario> {

    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Usuario obj) {
        ContentValues dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put(UsuarioDataModel.NOME, obj.getUserNome() );
        dadosDoObjeto.put(UsuarioDataModel.EMAIL, obj.getUserEmail() );
        dadosDoObjeto.put(UsuarioDataModel.NACIONALIDADE,obj.getNacionalidade() );
        dadosDoObjeto.put(UsuarioDataModel.NASCIMENTO, obj.getNascimento() );
        dadosDoObjeto.put(UsuarioDataModel.SENHA, obj.getPassword() );
        dadosDoObjeto.put(UsuarioDataModel.GENERO, obj.getGenero() );

        return insert(UsuarioDataModel.TABELA, dadosDoObjeto);
    }

    @Override
    public boolean alterar(Usuario obj) {
        return false;
    }

    @Override
    public boolean deletar(Usuario obj) {
        return false;
    }
    @Override
    public Usuario buscar(int id){
        return null;
    }

    @Override
    public List<Usuario> listar() {
        return Collections.emptyList();
    }

    public boolean usuarioeSenha(String username, String password) {
        return checkUserPassword(username, password);

    }

    public boolean usuario(String user) {
        return checkUser(user);
    }
}




