<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/4/2024
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Sử Dụng Dịch Vụ"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>

    <form method="post">
        <div class="form-group">
            <label for="maKH">Mã Khách Hàng</label>
            <select
                    id="maKH"
                    class="form-control ${not empty error.get("id.maKH") ? 'is-invalid' : ''}"
                    name="id.maKH"
            >
                <option value="" disabled ${empty suDungDichVu.id.maKH ? 'selected' : ''}>Vui lòng chọn khách hàng sử
                    dụng
                    máy
                </option>
                <c:forEach var="khachHang" items="${khachHangList}">
                    <option
                            value="${khachHang.maKH}"
                        ${suDungDichVu.id.maKH eq khachHang.maKH ? 'selected' : ''}
                    >${khachHang.maKH} - ${khachHang.tenKH}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">${error.get("id.maKH")}</div>
        </div>

        <div class="form-group">
            <label for="maDV">Mã Dịch Vụ</label>
            <select
                    id="maDV"
                    class="form-control ${not empty error.get("id.maDV") ? 'is-invalid' : ''}"
                    name="id.maDV"
            >
                <option value="" disabled ${empty suDungDichVu.id.maDV ? 'selected' : ''}>Vui lòng chọn máy được sử dụng
                </option>
                <c:forEach var="khachHang" items="${dichVuList}">
                    <option
                            value="${khachHang.maDV}"
                        ${suDungDichVu.id.maDV eq khachHang.maDV ? 'selected' : ''}
                    >${khachHang.maDV} - ${khachHang.tenDV}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">${error.get("id.maDV")}</div>
        </div>

        <div class="form-group">
            <label for="ngaySuDung">Ngày Sử Dụng</label>
            <input type="date" id="ngaySuDung"
                   class="form-control ${not empty error.get('id.ngaySuDung') ? 'is-invalid' : ''}"
                   name="id.ngaySuDung"
                   value="${suDungDichVu.id.ngaySuDung}"

            >
            <div class="invalid-feedback">${error.get('id.ngaySuDung')}</div>
        </div>

        <div class="form-group">
            <label for="gioSuDung">Giờ Sử Dụng ${error.id}</label>
            <input type="time" id="gioSuDung"
                   class="form-control ${not empty error.get('id.gioSuDung') ? 'is-invalid' : ''}"
                   name="id.gioSuDung"
                   value="${suDungDichVu.id.gioSuDung}"
            >
            <div class="invalid-feedback">${error.get('id.gioSuDung')}</div>
        </div>

        <div class="form-group">
            <label for="soLuong">Số Lượng</label>
            <input type="number" id="soLuong"
                   class="form-control ${not empty error.soLuong ? 'is-invalid' : ''}"
                   name="soLuong"
                   value="${suDungDichVu.soLuong}"
            >
            <div class="invalid-feedback">${error.soLuong}</div>
        </div>
        <div class="text-success">${successMessage}</div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <script>
        $(document).ready(function () {
            let maKH = $('#maKH');
            let maDV = $('#maDV');
            let ngaySuDung = $('#ngaySuDung');
            let gioSuDung = $('#gioSuDung');
            let soLuong = $('#soLuong');

            [maKH, maDV, ngaySuDung, gioSuDung].forEach(item => item.on('change', function () {
                $(this).removeClass('is-invalid');
            }));

            [soLuong].forEach(item => item.on('input', function () {
                $(this).removeClass('is-invalid');
            }))
        })
    </script>
</c:set>

<%@include file="../layout/main.jsp" %>
