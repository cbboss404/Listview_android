package vn.edu.stu.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    Button btn_edit;
    EditText manv,tennv,sdtnv;
    int position=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
        getNhanVien();
        setEvent();

    }


    /**
     * khởi tạo
     */
    private void init(){
        btn_edit =findViewById(R.id.edit_save);
        manv=findViewById(R.id.edit_MaNV);
        tennv=findViewById(R.id.edit_TenNV);
        sdtnv=findViewById(R.id.edit_SDT);
    }
    /**
     * lấy thông tin
     */
    private void getNhanVien(){
        Intent intent =getIntent();
        if(intent.hasExtra("editnhanvien")){
            NhanVien nv = (NhanVien) intent.getSerializableExtra("editnhanvien");
            setNhanVienEdit(nv);
            position= intent.getIntExtra("position",-1);

        }
    }

    /**
     * set event
     */
    private void setEvent(){
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nhanVien =getNhanVienEdit();
                returNhanVienMain(nhanVien);
            }
        });
    }

    /**
     * get user edit
     * @return
     */
    private void setNhanVienEdit(NhanVien nv){
        manv.setText(nv.getMaNV());
        tennv.setText(nv.getTenNV());
        sdtnv.setText(nv.getSdt());
    }
    /**
     * get user edit
     * @return
     */
    private NhanVien getNhanVienEdit(){
        String ma= manv.getText().toString();
        String ten=tennv.getText().toString();
        String sdt=sdtnv.getText().toString();
        NhanVien nv=new NhanVien(ma,ten,sdt);
        return nv;
    }

    /**
     * return user và đóng màn hình
     */
    private void returNhanVienMain(NhanVien nv){
        Intent intent =new Intent();
        intent.putExtra("editnhanvien",nv);
        intent.putExtra("position",position);
        setResult(RESULT_OK,intent);
        finish();
    }
}