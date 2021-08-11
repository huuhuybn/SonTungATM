package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finaltest.adapter.LopAdapter;
import com.example.finaltest.adapter.SinhVienAdapter;
import com.example.finaltest.database.Database;
import com.example.finaltest.model.Lop;
import com.example.finaltest.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText malop, masv, mamon, diem;
    Button btn1, btn2;
    Database database;
    ArrayList<Lop> lop1;
    ArrayList<SinhVien> sinhvien1;
    SinhVienAdapter sva;
    LopAdapter lopa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        malop = findViewById(R.id.edMaLop);
        masv = findViewById(R.id.edMaSV);
        mamon = findViewById(R.id.edMaMon);
        diem = findViewById(R.id.edDiem);
        btn1 = findViewById(R.id.btnAct2);
        btn2 = findViewById(R.id.btnAct3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = new Database(MainActivity.this);
                String edMaLop = malop.getText().toString();
                String edMaSV = masv.getText().toString();
                String edMaMon = mamon.getText().toString();
                String edDiem = diem.getText().toString();
                if (edMaLop.isEmpty() || edMaSV.isEmpty() || edMaMon.isEmpty() || edDiem.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Khong de trong", Toast.LENGTH_SHORT).show();
                } else {
                    database.SendData("INSERT INTO LOP VALUES('" + edMaLop + "')");
                    database.SendData("INSERT INTO SINHVIEN VALUES('" + edMaSV + "','" + edMaMon + "','" + edDiem + "')");
//                    Log.e("Example", String.valueOf(sva.getItemCount()));
//                    Log.e("Example", String.valueOf(lopa.getItemCount()));
                    Toast.makeText(MainActivity.this, "Them du lieu thanh cong", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}
