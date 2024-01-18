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
public class SuDungDichVuId implements Serializable {
    @Column(name = "MaKH")
    @NotBlank(message = "Vui lòng chọn mã khách hàng.")
    private String maKH;

    @Column(name = "MaDV")
    @NotBlank(message = "Vui lòng chọn mã dịch vụ.")
    private String maDV;

    @Column(name = "NgaySuDung")
    @NotNull(message = "Vui lòng chọn ngày sử dụ    ng dịch vụ.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày bắt đầu sử dụng phải là Ngày trong quá khứ.")
    private LocalDate ngaySuDung;

    @Column(name = "GioSuDung")
    @NotNull(message = "Vui lòng chọn giờ sử dụng dịch vụ.")
    @DateTimeFormat(pattern = "HH:mm")
//    @PastOrPresent(message = "Giờ bắt đầu sử dụng không được quá Giờ và Ngày hiện tại")
    private LocalTime gioSuDung;
}
