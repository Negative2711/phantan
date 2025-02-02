package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.ogm.options.shared.IndexOption;
import org.hibernate.ogm.options.shared.IndexOptions;

@Entity
@Table(name = "dsDia", indexes = { @Index(columnList = "MaDia, TenDia, HangDia", name = "MaDia_TenDia_HangDia_idx") })
@IndexOptions(@IndexOption(forIndex = "MaDia_TenDia_HangDia_idx", options = "{text:true}"))
@NamedNativeQueries({ @NamedNativeQuery(name = "getDSXeNative", query = "{}", resultClass = Xe.class), })
public class Xe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3681991820684678549L;
	@Id
	@Column(name = "MaDia")
	private String maXe;
	@Column(name = "TheLoaiDia")
	private String nuocSX;
	@Column(name = "MoTaDia")
	private String loaiXe;
	@Column(name = "SoLo")
	private int soPK;
	@Column(name = "ChatLieu")
	private String soKhung;
	@Column(name = "DungLuong")
	private String soSuon;
	@Column(name = "LoaiDia")
	private String mauXe;
	@Column(name = "TenDia")
	private String tenXe;
	private double donGia;
	@Column(name = "HangDia")
	private String hangXe;
	private int soLuongTon;

	public Xe(String maXe, String nuocSX, String loaiXe, int soPK, String soKhung, String soSuon, String mauXe,
			String tenXe, double donGia, String hangXe, int soLuongTon) {
		this.maXe = maXe;
		this.nuocSX = nuocSX;
		this.loaiXe = loaiXe;
		this.soPK = soPK;
		this.soKhung = soKhung;
		this.soSuon = soSuon;
		this.mauXe = mauXe;
		this.tenXe = tenXe;
		this.donGia = donGia;
		this.hangXe = hangXe;
		this.soLuongTon = soLuongTon;
	}

	public Xe(String maXe) {
		this(maXe, "", "", 0, "", "", "", "", 0, "", 0);
	}

	public Xe() {
		this("", "", "", 0, "", "", "", "", 0, "", 0);
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}

	public String getNuocSX() {
		return nuocSX;
	}

	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public int getSoPK() {
		return soPK;
	}

	public void setSoPK(int soPK) {
		this.soPK = soPK;
	}

	public String getSoKhung() {
		return soKhung;
	}

	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}

	public String getSoSuon() {
		return soSuon;
	}

	public void setSoSuon(String soSuon) {
		this.soSuon = soSuon;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getHangXe() {
		return hangXe;
	}

	public void setHangXe(String hangXe) {
		this.hangXe = hangXe;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", nuocSX=" + nuocSX + ", loaiXe=" + loaiXe + ", soPK=" + soPK + ", soKhung="
				+ soKhung + ", soSuon=" + soSuon + ", mauXe=" + mauXe + ", tenXe=" + tenXe + ", donGia=" + donGia
				+ ", hangXe=" + hangXe + ", soLuongTon=" + soLuongTon + "]";
	}

}