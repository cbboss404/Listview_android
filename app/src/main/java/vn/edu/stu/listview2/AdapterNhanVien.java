package vn.edu.stu.listview2;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterNhanVien extends ArrayAdapter {

    private List<NhanVien> nhanViens;
    private Context activity;
    private int resource;


    /**
     * @param context  -->activity
     * @param resource -->file layout item(item_layout.xml)
     * @param objects --> list (Nhân Viên)
     */
    public AdapterNhanVien(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.activity =context;
        this.nhanViens=objects;
        this.resource =resource;
    }
    /**
     *
     * @param position --> vị trí item trong lisview
     * @param convertView -->view của items
     * @param parent -->view của lớp cha
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //lấy lớp layout
        LayoutInflater layoutInflater =(LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.item_layout,null);

        //tim id trong items của listview
        TextView  maNV=view.findViewById(R.id.maVN);
        TextView  tenNV=view.findViewById(R.id.tenNV);
        TextView  sdt=view.findViewById(R.id.sdt);
        maNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        maNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        maNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        NhanVien nv =nhanViens.get(position);

        maNV.setText(nv.getMaNV());
        tenNV.setText(nv.getTenNV());
        sdt.setText(nv.getSdt());

        return view;
    }
}
