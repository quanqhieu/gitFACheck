package edu.fa.model;

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

@Table(name = "MAY")
@Entity
@Getter
@Setter
@ToString
public class May {
    @Id
    @NotBlank(message = "Vui lòng nhập mã máy.")
    @Pattern(regexp = "^M[0-9]{2}$", message = "Vui lòng nhập đúng định dạng mã máy. Ví dụ: M01")
    @Column(name = "MaMay")
    private String maMay;

    @NotBlank(message = "Vui lòng nhập vị trí máy.")
    @Column(name = "ViTri", columnDefinition = "nvarchar(255)")
    private String viTri;

    @NotBlank(message = "Vui lòng chọn trạng thái máy.")
    @Column(name = "TrangThai", columnDefinition = "nvarchar(50)")
    private String trangThai;

    @OneToMany(mappedBy = "may",  cascade = CascadeType.ALL)
    private List<SuDungMay> suDungMayList;
}
