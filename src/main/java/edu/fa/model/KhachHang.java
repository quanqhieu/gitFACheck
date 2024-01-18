package edu.fa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author: PC
 * @date: 12/28/2023
 */

@Table(name = "KHACHHANG")
@Entity
@Getter
@Setter
@ToString
public class KhachHang {
    @Id
    @NotBlank(message = "Vui lòng nhập mã khách hàng.")
    @Pattern(regexp = "^KH[0-9]{5}$", message = "Vui lòng nhập đúng định dạng mã khách hàng. Ví dụ: KH00001")
    @Column(name = "MaKH")
    private String maKH;

    @NotBlank(message = "Vui lòng nhập tên khách hàng.")
    @Column(name = "TenKH", columnDefinition = "nvarchar(255)")
    private String tenKH;

    @NotBlank(message = "Vui lòng nhập địa chỉ.")
    @Column(name = "DiaChi", columnDefinition = "nvarchar(255)")
    private String diaChi;

    @NotBlank(message = "Vui lòng nhập số điện thoại.")
    @Pattern(regexp = "^(\\(84\\)\\+)?(0)?(90|91)\\d{7}$", message = "Vui lòng nhập đúng định dạng số điện thoại. Ví dụ: 090xxxxxxx, 091xxxxxxx, (84)+90xxxxxxx, (84)+91xxxxxxx")
    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @NotBlank(message = "Vui lòng nhập địa chỉ Email.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Vui lòng nhập đúng định dạng email.Ví dụ: example@gmail.com")
    @Column(name = "DiaChiEmail")
    private String diaChiEmail;

    @OneToMany(mappedBy = "khachHang",  cascade = CascadeType.ALL)
    @JsonIgnoreProperties("khachHang")
    private List<SuDungMay> suDungMayList;

    @OneToMany(mappedBy = "khachHang",  cascade = CascadeType.ALL)
    @JsonIgnoreProperties("khachHang")
    private List<SuDungDichVu> suDungDichVuList;
}
