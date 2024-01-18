package edu.fa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * @author: PC
 * @date: 12/28/2023
 */

@Table(name = "DICHVU")
@Entity
@Getter
@Setter
@ToString
public class DichVu {
    @Id
    @NotBlank(message = "Vui lòng nhập mã dịch vụ.")
    @Pattern(regexp = "^DV[0-9]{3}$", message = "Vui lòng nhập đúng định dạng mã dịch vụ. Ví dụ: DV001")
    @Column(name = "MaDV")
    private String maDV;

    @NotBlank(message = "Vui lòng nhập tên dịch vụ.")
    @Column(name = "TenDV", columnDefinition = "nvarchar(255)")
    private String tenDV;

    @NotBlank(message = "Vui lòng chọn đơn vị tính.")
    @Column(name = "DonViTinh", columnDefinition = "nvarchar(50)")
    private String donViTinh;

    @NotNull(message = "Vui lòng nhập đơn giá.")
    @DecimalMin(value = "1.0", inclusive = false, message = "Đơn giá phải lớn hơn 0")
    @Column(name = "DonGia")
    private double donGia;

    @OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
    private List<SuDungDichVu> suDungDichVuList;
}
