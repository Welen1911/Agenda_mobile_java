
package com.example.ola_mundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Agenda agenda;
    int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agenda = new Agenda();
    }

    public void updateList() {
        final EditText nome = findViewById(R.id.nomeText);
        final EditText fone = findViewById(R.id.foneText);


        LinearLayout ll = findViewById(R.id.listaTelefonica);
        ll.removeAllViews();

        for (int i=0; i<agenda.size(); i++) {
            final Contato contato = agenda.get(i);
            final int finall = i;

            TextView tv = new TextView(getApplicationContext());
            tv.setText(contato.toString());
            ll.addView(tv);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    id = finall;
                    nome.setText(contato.getNome());
                    fone.setText(contato.getFone());
                }
            });
        }
    }


    public void addTelefone(View button) {
        String nome = ((EditText)findViewById(R.id.nomeText)).getText().toString();
        String fone = ((EditText)findViewById(R.id.foneText)).getText().toString();

       if (nome.length() > 0 && fone.length() > 0) {
           if (id == -1) {
               agenda.inserir(agenda.size(), nome, fone);
           } else {
               agenda.atualizar(id, nome, fone);
           }
           limpar();
           updateList();
       } else {
           Toast.makeText(this, "Preencha os campos para salvar!", Toast.LENGTH_LONG).show();
       }


    }

    public void limparInputs(View button) {
        limpar();
    }

    public void excluir(View button) {
        if (id == -1 ) {
            Toast.makeText(this, "selecione um contato primeiro!", Toast.LENGTH_LONG).show();
        } else {
            agenda.excluir(id);
            limpar();
            updateList();
        }
    }

    public  void limpar() {
        EditText nome = findViewById(R.id.nomeText);
        EditText fone = findViewById(R.id.foneText);

        nome.setText("");
        fone.setText("");
        id = -1;
    }
}