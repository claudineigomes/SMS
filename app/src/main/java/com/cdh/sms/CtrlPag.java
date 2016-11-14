package com.cdh.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cdh.sms.dataBase.DatabaseOpenHelper;

public class CtrlPag extends AppCompatActivity {
    private DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pag);

        databaseOpenHelper = new DatabaseOpenHelper(this);
    }

    public void nextT(View view) {

        EditText etNome = (EditText)findViewById(R.id.et_Nome);
        String nomeUsu = etNome.getText().toString();
        System.out.println("NomUsu: " + nomeUsu);

        EditText etCPF = (EditText)findViewById(R.id.et_CPF);
        String cpfUsu = etCPF.getText().toString();

        EditText etNumCart = (EditText)findViewById(R.id.et_NumeroCartao);
        String numCar = etNumCart.getText().toString();

        EditText etCodSeg = (EditText)findViewById(R.id.et_CodSeg);
        String codSeg = etCodSeg.getText().toString();

        EditText etNomImp = (EditText)findViewById(R.id.et_NomeImpresso);
        String nomImp = etNomImp.getText().toString();

        EditText etDatVal= (EditText)findViewById(R.id.et_DataVal);
        String datVal = etDatVal.getText().toString();

        EditText etTel = (EditText)findViewById(R.id.editText_Telefone);
        String telUsu = etTel.getText().toString();

        String pedido = "";
        float valor = 0;

        try {
            pedido = getIntent().getExtras().get("pedido").toString();
            valor = Float.parseFloat(getIntent().getExtras().get("valor").toString());
        }catch (Exception e){

        }

        Intent intent = new Intent(this, CtrlTok.class);
        intent.putExtra("pedido", pedido);
        intent.putExtra("nomeUsu", nomeUsu);
        intent.putExtra("cpfUsu", cpfUsu);
        intent.putExtra("telUsu", telUsu);
        intent.putExtra("valor", valor);
        startActivity(intent);
    }
}
