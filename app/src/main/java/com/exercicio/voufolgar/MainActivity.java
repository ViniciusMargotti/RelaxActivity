package com.exercicio.voufolgar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText dia;
    private EditText mes;
    private EditText ano;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia = findViewById(R.id.textDia);
        mes = findViewById(R.id.textMes);
        ano = findViewById(R.id.textAno);
        resultado = findViewById(R.id.resultado);
    }

    public void sendMessage(View view) {
        try {
            String dateStr = dia.getText()+"/"+mes.getText()+"/"+ano.getText();
            Calendar data = Calendar.getInstance();
            SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
            data.setTime(simpleFormat.parse(dateStr));
            verificaData(data);
        }catch (Exception ex){
            resultado.setText("Informe uma data válida por favor");
        }
    }

    public void verificaData(Calendar data)
    {
        // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            resultado.setText("Você irá folgar, a data cairá em um domingo");
        }
        // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            resultado.setText("Você irá folgar, a data cairá em um sábado");
        }
        else
        {
            resultado.setText("É dia de semana, bora trabalhar 😁");
        }
    }
}