package vn.edu.stu.listview2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Lisview
    ListView listView;
    //Adapter
    AdapterNhanVien adapterNhanVien;
    //ds nhân viên
    ArrayList<NhanVien> nhanVienArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
        showListView();
    }
    private void init(){
        listView =findViewById(R.id.id_listview);
    }
    /**
     *
     */
    private void setEvent(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NhanVien nv =(NhanVien) nhanVienArrayList.get(position);
                Intent intent=new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("editnhanvien",nv);
                intent.putExtra("position",position);
                startActivityForResult(intent,1001);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        //Thiết lập tiêu đề
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa không?");
                        // Nút Ok
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        nhanVienArrayList.remove(position);
                        showListView();
                    }
                });
                    //Nút Cancel
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                    //Tạo dialog
                AlertDialog al = builder.create();
                    //Hiển thị
                al.show();
                return false;
            }
        });
    }

    /**
     * Quan trọng!
     */
    private void showListView(){
        Intent intent =new Intent(MainActivity.this, ProcessbarActivity.class);
        startActivity(intent);
        //khởi tạo Adapter
        adapterNhanVien =new AdapterNhanVien(MainActivity.this,R.layout.item_layout,nhanVienArrayList);
        //set adapter vào listview
        listView.setAdapter(adapterNhanVien);
        //set action dữ liệu
        adapterNhanVien.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_Add:
                Intent intent =new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,1000);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1000:
            if (resultCode==RESULT_OK){
                    NhanVien nv =(NhanVien) data.getSerializableExtra("nhanvien");
                    nhanVienArrayList.add(nv);
                    showListView();
            }
            break;
            case 1001:
                if (resultCode==RESULT_OK){
                    NhanVien nv =(NhanVien) data.getSerializableExtra("editnhanvien");
                    int id=data.getIntExtra("position",-1);
                    nhanVienArrayList.get(id).setMaNV(nv.getMaNV());
                    nhanVienArrayList.get(id).setTenNV(nv.getTenNV());
                    nhanVienArrayList.get(id).setSdt(nv.getSdt());
                    showListView();
                }
                break;
        }
    }


}