package com.exercicios.conversor_moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText entradaUser;
    private Button btnDolar;
    private Button btnEuro;
    private TextView respostaParaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSetupView();
    }

    private void setSetupView() {
        entradaUser = findViewById(R.id.entradaUser);
        btnDolar = findViewById(R.id.bntDolar);
        btnDolar.setOnClickListener(this);
        btnEuro = findViewById(R.id.btnEuro);
        btnEuro.setOnClickListener(this);
        respostaParaUser = findViewById(R.id.respostaParaUser);
    }

    private void prepareIntentParaResultadoDolar() {
        double valorReal = Double.parseDouble(entradaUser.getText().toString());
        double calculoResultado = valorReal / 5.03;

        String value = String.format(Locale.getDefault(), getString(R.string.format_dolar), calculoResultado);

        respostaParaUser.setText(value);
    }

    private void prepareIntentParaResultadoEuro(){
        double valorReal = Double.parseDouble(entradaUser.getText().toString());
        double calculoResultado = valorReal / 5.29;

        String value = String.format(Locale.getDefault(), getString(R.string.format_euro), calculoResultado);

        respostaParaUser.setText(value);
    }


    public void onClick(View view) {
        if (!entradaUser.getText().toString().isEmpty()) {
            switch (view.getId()) {
                case R.id.bntDolar:
                    prepareIntentParaResultadoDolar();
                    break;
                case R.id.btnEuro:
                    prepareIntentParaResultadoEuro();
                    break;
            }
        } else {
            Toast.makeText(this, getString(R.string.mensagem_erro), Toast.LENGTH_SHORT).show();
        }
    }

}



