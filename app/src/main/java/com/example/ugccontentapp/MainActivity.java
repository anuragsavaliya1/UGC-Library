package com.example.ugccontentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ugccontentapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);






        MyUgcButton.init(R.color.white,R.color.black,R.color.gray,R.color.purple_500);

        new MyUgcButton(this,true,binding.img).setOnUGCTapListner(new MyUgcButton.OnUGCTapListner() {
            @Override
            public void onClickReported() {

            }

            @Override
            public void onClickBlockd() {

            }

            @Override
            public void onClickFlagd() {

            }
        });
        //  myUgcButton.setColors();

//binding.img.setOnClickListener(view -> onClickReport());





    }

    public void onClickReport() {

        new UGCsheetChoice(MainActivity.this, true, new UGCsheetChoice.OnChoiceLisnter() {
            @Override
            public void onClickReporte() {
              new UGCReportSheet(MainActivity.this,"","",() -> {

              });
            }

            @Override
            public void onClickBlock() {
                Toast.makeText(MainActivity.this, "Blocked", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClickFlag() {

            }
        });
    }
}