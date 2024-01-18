package edu.fa.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author: PC
 * @date: 12/28/2023
 */

@Embeddable
@Getter
@Setter
@ToString
public class SuDungMayId implements Serializable {
    @Column(name = "MaKH")
    @NotBlank(message = "Vui lòng chọn mã khách hàng.")
    private String maKH;

    @Column(name = "MaMay")
    @NotBlank(message = "Vui lòng chọn mã máy.")
    private String maMay;

    @Column(name = "NgayBatDauSuDung")
    @NotNull(message = "Vui lòng chọn ngày bắt đầu sử dụng.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày bắt đầu sử dụng phải là Ngày trong quá khứ.")
    private LocalDate ngayBatDauSuDung;

    @Column(name = "GioBatDauSuDung")
    @NotNull(message = "Vui lòng chọn giờ bắt đầu sử dụng.")
    @DateTimeFormat(pattern = "HH:mm")
//    @PastOrPresent(message = "Giờ bắt đầu sử dụng không được quá Giờ và Ngày hiện tại")
    private LocalTime gioBatDauSuDung;

}
