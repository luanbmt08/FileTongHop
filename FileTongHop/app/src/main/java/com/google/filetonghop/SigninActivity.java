package com.google.filetonghop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText edtuser,edtpassword;
    Button btndangky,btndangnhap,btnthoat;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Anhxa();
        ControlButton();
    }
    private void ControlButton(){
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(SigninActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Do You Want Exit");
                builder.setMessage("Choose Below To Aceppt");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(SigninActivity.this);
                dialog.setTitle("Dialog Processing");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_signup);
                EditText edttk = (EditText) dialog.findViewById(R.id.edttk);
                EditText edtmk = (EditText) dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtuser.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtuser.getText().length() != 0 && edtpassword.getText().length() != 0){
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(SigninActivity.this,"LOGIN SUCCESS ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SigninActivity.this, ProfileActivity.class);
                        startActivity(intent);
                    }else  if (edtuser.getText().toString().equals("admin") && edtpassword.getText().toString().equals("1")){
                        Toast.makeText(SigninActivity.this,"LOGIN SUCCESS ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SigninActivity.this, ProfileActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SigninActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SigninActivity.this,"MUST MANUAL ENTER INFORMATION",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa(){
        edtuser=(EditText) findViewById(R.id.edittextuser);
        edtpassword=(EditText) findViewById(R.id.edittextpassword);
        btndangnhap=(Button) findViewById(R.id.buttondangnhap);
        btndangky=(Button) findViewById(R.id.buttondangky);
        btnthoat=(Button) findViewById(R.id.buttonthoat);
    }

}