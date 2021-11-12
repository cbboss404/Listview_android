package vn.edu.stu.listview2;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String maNV;
    private String tenNV;
    private String sdt;

    public NhanVien(String maNV, String tenNV, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
