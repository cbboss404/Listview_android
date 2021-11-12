package vn.edu.stu.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    EditText txt_MaNV,txt_TenNV,txt_SDT;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        setEvent();

    }
    private void init(){
        txt_MaNV= findViewById(R.id.txt_MaNV);
        txt_TenNV=findViewById(R.id.txt_TenNV);
        txt_SDT=findViewById(R.id.txt_SDT);
        btnSave =findViewById(R.id.btn_save);
    }
    private void setEvent(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv= getNhanVien();
                returnResult(nv);
            }
        });
    }

    private NhanVien getNhanVien(){
        String ma= txt_MaNV.getText().toString();
        String ten=txt_TenNV.getText().toString();
        String sdt=txt_SDT.getText().toString();
        NhanVien nv=new NhanVien(ma,ten,sdt);
        return nv;
    }
    private void returnResult(NhanVien nv){
        Intent intent =new Intent();
        intent.putExtra("nhanvien",nv);
        setResult(RESULT_OK,intent);
        finish();
    }
}