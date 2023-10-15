package br.com.unicsul.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnReiniciar;
    private TextView txtVencedor;
    private TextView txtValueCasa;
    private TextView txtValueVisitante;
    private int pontosCasa;
    private int pontosVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValueCasa = findViewById(R.id.txtValueCasa);
        txtValueVisitante = findViewById(R.id.txtValueVisitante);

        pontosCasa = 0;
        pontosVisitante = 0;
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        if (pontosCasa == 3 || pontosVisitante == 3) {
            return;
        }
        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);
        ImageView imagemResultado2 = findViewById(R.id.imagemResultado2);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if (
                (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ){
            imagemResultado2.setImageResource(R.drawable.robo);
            pontosVisitante++;
        }
        else if (
                (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))
        ){
            imagemResultado2.setImageResource(R.drawable.ganhou);
            pontosCasa++;
        }
        else {
            imagemResultado2.setImageResource(R.drawable.emapte);
        }

        txtValueCasa.setText(String.valueOf(pontosCasa));
        txtValueVisitante.setText(String.valueOf(pontosVisitante));

        txtValueCasa.setText(String.valueOf(pontosCasa));
        txtValueVisitante.setText(String.valueOf(pontosVisitante));

        if (pontosCasa == 3 || pontosVisitante == 3) {

            if (pontosCasa == 3) {
                exibirVencedor("Casa");
            } else {
                exibirVencedor("Visitante");
            }
        }
    }
    private void exibirVencedor(String vencedor) {
        txtVencedor = findViewById(R.id.txtVencedor);
        txtVencedor.setText(vencedor + " ganhou!");
        txtVencedor.setVisibility(View.VISIBLE);

        btnReiniciar = findViewById((R.id.btnReiniciar));
        btnReiniciar.setVisibility(View.VISIBLE);

    }
    public void resetarJogo(View view) {
        pontosCasa = 0;
        pontosVisitante = 0;

        txtValueCasa.setText("0");
        txtValueVisitante.setText("0");
        txtVencedor.setVisibility(View.GONE);
        btnReiniciar.setVisibility(View.GONE);
    }
}

