package br.example.cadastroaluno;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText edNome, edEmail, edIdade, edDiciplina, edNota1, edNota2;
    TextView edMensagem, edResumo;
    Button btnEnviar, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // jailson Inicializando os campos//

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edIdade = findViewById(R.id.edIdade);
        edDiciplina = findViewById(R.id.edDiciplina);
        edNota1 = findViewById(R.id.edNota1);
        edNota2 = findViewById(R.id.edNota2);
        edMensagem = findViewById(R.id.edMensagem);
        edResumo = findViewById(R.id.edResumo);

        btnEnviar = findViewById(R.id.ButtonEviar);
        btnLimpar = findViewById(R.id.ButonLimpar);

        // jailson Lógica do botão enviar//
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDados();
            }
        });

        // jailson Lógica do botão limpar //

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    // jailson Método para enviar os dados//

    private void enviarDados() {
        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();
        String idade = edIdade.getText().toString();
        String diciplina = edDiciplina.getText().toString();
        String nota1 = edNota1.getText().toString();
        String nota2 = edNota2.getText().toString();

        // jailson  Verificando se todos os campos estão preenchidos//

        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(email) || TextUtils.isEmpty(idade)
                || TextUtils.isEmpty(diciplina) || TextUtils.isEmpty(nota1) || TextUtils.isEmpty(nota2)) {
            Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // jailson Verificando se o email está correto//

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edMensagem.setVisibility(View.VISIBLE);
            edMensagem.setText("O Email está incorreto!");
            return;
        }

        // jaiklson Calculando a média das notas//

        double notaFinal = (Double.parseDouble(nota1) + Double.parseDouble(nota2)) / 2;

        // jailson Exibindo o resumo//

        edMensagem.setVisibility(View.GONE);               // Oculta a mensagem de erro
        edResumo.setVisibility(View.VISIBLE);
        edResumo.setText("Dados do aluno:\n" +
                "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "Idade: " + idade + "\n" +
                "Disciplina: " + diciplina + "\n" +
                "Média Final: " + notaFinal);
    }

    // jailson Método para limpar os campos//

    private void limparCampos() {
        edNome.setText("");
        edEmail.setText("");
        edIdade.setText("");
        edDiciplina.setText("");
        edNota1.setText("");
        edNota2.setText("");
        edMensagem.setVisibility(View.GONE);
        edResumo.setVisibility(View.GONE);
    }
}




