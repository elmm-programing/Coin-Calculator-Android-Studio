package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eTextNombre;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnLimpiar,btnDolar,btnEuro,btnPesoRd,btnYen;
    TextView textCalcNumber,textCoin;
    Double Value;
    Boolean Valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //alert dialog
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Ingrese un numero")
                .setTitle("Error");

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        //Declarando botones para convertir las monedas
        btnDolar = (Button) findViewById(R.id.btnDolar);
        btnEuro = (Button)findViewById(R.id.btnEuro);
        btnPesoRd = (Button)findViewById(R.id.btnPesoRd);
        btnYen = (Button)findViewById(R.id.btnYen);

        //Declarando boton para limpiar
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        //Declarando botones numericos
        btn0 =(Button) findViewById(R.id.btn0);
        btn1 =(Button) findViewById(R.id.btn1);
        btn2 =(Button) findViewById(R.id.btn2);
        btn3 =(Button) findViewById(R.id.btn3);
        btn4 =(Button) findViewById(R.id.btn4);
        btn5 =(Button) findViewById(R.id.btn5);
        btn6 =(Button) findViewById(R.id.btn6);
        btn7 =(Button) findViewById(R.id.btn7);
        btn8 =(Button) findViewById(R.id.btn8);
        btn9 =(Button) findViewById(R.id.btn9);
        //declarando los textviews y los editText
        textCalcNumber=(TextView) findViewById(R.id.textCalcNumber);
        textCoin=(TextView) findViewById(R.id.textCoin);
        eTextNombre = (EditText) findViewById(R.id.eTextNombre);
        textCalcNumber.setText("");

        if (TextUtils.isEmpty(eTextNombre.getText().toString())){
//Disable buttons
            btn1.setEnabled(false);
            btn0.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btnDolar.setEnabled(false);
            btnEuro.setEnabled(false);
            btnPesoRd.setEnabled(false);
            btnYen.setEnabled(false);
            btnLimpiar.setEnabled(false);
        }else{
            btn0.setEnabled(true);
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            btnDolar.setEnabled(true);
            btnEuro.setEnabled(true);
            btnPesoRd.setEnabled(true);
            btnYen.setEnabled(true);
            btnLimpiar.setEnabled(true);
        }
        eTextNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(eTextNombre.getText().toString()) ){
//Disable buttons
                    btn1.setEnabled(false);
                    btn0.setEnabled(false);
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnDolar.setEnabled(false);
                    btnEuro.setEnabled(false);
                    btnPesoRd.setEnabled(false);
                    btnYen.setEnabled(false);
                    btnLimpiar.setEnabled(false);
                }else{
                    btn0.setEnabled(true);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    btnDolar.setEnabled(true);
                    btnEuro.setEnabled(true);
                    btnPesoRd.setEnabled(true);
                    btnYen.setEnabled(true);
                    btnLimpiar.setEnabled(true);
                }

            }
        });





        //Convertir a Yen
        btnYen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textCalcNumber.getText().equals("")){
                    dialog.show();
                }else{
                    Value =Double.parseDouble(textCalcNumber.getText()+"");
                    switch (textCoin.getText().toString()){
                        case "Peso Dominicano":
                            Value = Value*2.31;
                            textCoin.setText("Yen");
                            break;
                        case "Dolar":
                            Value = Value *127.29;
                            textCoin.setText("Yen");
                            break;
                        case "Euro":
                            Value = Value*135.95 ;
                            textCoin.setText("Yen");
                            break;
                        case "Yen":
                            Value = Value;
                            break;
                        default:
                            break;
                    }

                    textCalcNumber.setText(Value.toString());
                }

            }
        });
        //Convertir a Peso Dominicano
        btnPesoRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textCalcNumber.getText().equals("")){
                    dialog.show();
                }else {
                    Value = Double.parseDouble(textCalcNumber.getText() + "");
                    switch (textCoin.getText().toString()) {
                        case "Peso Dominicano":
                            Value = Value;

                            break;
                        case "Dolar":
                            Value = Value * 55.21;
                            textCoin.setText("Peso Dominicano");
                            break;
                        case "Euro":
                            Value = Value * 58.97;
                            textCoin.setText("Peso Dominicano");
                            break;
                        case "Yen":
                            Value = Value * 0.43;
                            textCoin.setText("Peso Dominicano");
                            break;
                        default:
                            break;
                    }

                    textCalcNumber.setText(Value.toString());
                }
                }
        });
        //Convertir a Euros
        btnEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textCalcNumber.getText().equals("")){
                    dialog.show();
                }else {
                    Value = Double.parseDouble(textCalcNumber.getText() + "");
                    switch (textCoin.getText().toString()) {
                        case "Peso Dominicano":
                            Value = Value * 0.017;
                            textCoin.setText("Euro");
                            break;
                        case "Dolar":
                            Value = Value * 0.94;
                            textCoin.setText("Euro");
                            break;
                        case "Euro":
                            Value = Value;

                            break;
                        case "Yen":
                            Value = Value * 0.0074;
                            textCoin.setText("Euro");
                            break;
                        default:
                            break;
                    }

                    textCalcNumber.setText(Value.toString());
                }}
        });
        //Convertir a dolares
        btnDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textCalcNumber.getText().equals("")){
                    dialog.show();
                }else{
                Value =Double.parseDouble(textCalcNumber.getText()+"");
                switch (textCoin.getText().toString()){
                    case "Peso Dominicano":
                        Value = Value*0.018;
                        textCoin.setText("Dolar");
                        break;
                    case "Dolar":
                        Value = Value;
                        break;
                    case "Euro":
                        Value = Value *1.07;
                        textCoin.setText("Dolar");
                        break;
                    case "Yen":
                        Value = Value*0.0079;
                        textCoin.setText("Dolar");
                        break;
                    default:
                        break;
                }

                textCalcNumber.setText(Value.toString());
            }}
        });

        //limpiar el textView
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText("");

            }
        });

//Parte de los numeros
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    textCalcNumber.setText(textCalcNumber.getText()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"1");
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCalcNumber.setText(textCalcNumber.getText()+"9");
            }
        });
        //fin
    }

}