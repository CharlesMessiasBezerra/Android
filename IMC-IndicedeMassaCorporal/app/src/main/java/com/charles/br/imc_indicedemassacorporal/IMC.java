package com.charles.br.imc_indicedemassacorporal;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;


public class IMC extends AppCompatActivity {


        // Atributos
        private EditText edtPeso;
        private EditText edtAltura;
        private EditText edtResultado;
        private Button btnCalcular;
        private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

       btnCalcular = (Button) findViewById(R.id.btnCalcula);
       btnLimpar = (Button) findViewById(R.id.btnLimpar);
       edtPeso =  (EditText) findViewById(R.id.edtPeso);
       edtAltura =  (EditText) findViewById(R.id.edtAltura);
       edtResultado  =  (EditText) findViewById(R.id.edtResultado);

       btnCalcular.setOnClickListener(new Button_Clicker());
       btnLimpar.setOnClickListener(new Button_Clicker());

    }

    class Button_Clicker implements Button.OnClickListener
    {
        // TRATATOR DE EVENTOS
        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.btnCalcula:
                    CalculaIMC();
                break;

                case R.id.btnLimpar:
                    Toast.makeText(IMC.this, " Os dados foram apagados com sucesso!", Toast.LENGTH_SHORT).show();
                    LimparCampos();
                break;
            }
        }

        private void LimparCampos(){
            edtAltura.setText("");
            edtPeso.setText("");
            edtResultado.setText("");
        }

        private void CalculaIMC(){

            double Altura;
            double Peso;
            double VlrImc;

            Altura = Double.parseDouble(String.valueOf(edtAltura.getText()));
            Peso = Double.parseDouble(String.valueOf(edtPeso.getText()));

                VlrImc = (Peso/Math.pow(Altura, 2));
                edtResultado.setText(tabelaImc(VlrImc));
            }

        private String tabelaImc(double n){
            String strRetorno;
            strRetorno = "";

            if(n < 17)
                strRetorno = "Muito Abaixo do Peso";
            if(n >= 17 && n <= 18.49)
                strRetorno = "Abaixo do Peso";
            if(n >= 18.5 && n <= 24.99)
                strRetorno = "Peso Ideal";
            if(n >= 25 && n <= 29.99)
                strRetorno = "Sobre Peso";
            if(n >= 30 && n <= 34.99)
                strRetorno = "Obesidade Grau I";
            if(n >= 35 && n <= 39.99)
                strRetorno = "Obesidade Grau II";
            if(n >= 40)
                strRetorno = "Obesidade Grau III";

            return strRetorno;

        }
    }
}
