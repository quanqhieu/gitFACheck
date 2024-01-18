<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Cập Nhật Khách Khàng"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>
    <form action="/khachhang/update" method="post">
        <div class="form-group">
            <label for="maKH">Mã Khách Hàng</label>
            <input type="text"
                   id="maKH"
                   class="form-control ${empty error.maKH ? '' : 'is-invalid'}"
                   name="maKH"
                   value="${khachHang.maKH}"
                   readonly
            >
            <div class="invalid-feedback">${error.maKH}</div>
        </div>
        <div class="form-group">
            <label for="tenKH">Tên Khách Hàng</label>
            <input type="text"
                   id="tenKH"
                   class="form-control ${empty error.tenKH ? '' : 'is-invalid'}"
                   name="tenKH"
                   value="${khachHang.tenKH}"
            >
            <div class="invalid-feedback">${error.tenKH}</div>
        </div>
        <div class="form-group">
            <label for="diaChi">Địa Chỉ</label>
            <input type="text"
                   id="diaChi"
                   class="form-control ${empty error.diaChi ? '' : 'is-invalid'}"
                   name="diaChi"
                   value="${khachHang.diaChi}"
            >
            <div class="invalid-feedback">${error.diaChi}</div>
        </div>
        <div class="form-group">
            <label for="soDienThoai">Số Điện Thoại</label>
            <input type="text"
                   id="soDienThoai"
                   class="form-control ${empty error.soDienThoai ? '' : 'is-invalid'}"
                   name="soDienThoai"
                   value="${khachHang.soDienThoai}"
            >
            <div class="invalid-feedback">${error.soDienThoai}</div>
        </div>
        <div class="form-group">
            <label for="diaChiEmail">Địa Chỉ Email</label>
            <input type="text"
                   id="diaChiEmail"
                   class="form-control ${empty error.diaChiEmail ? '' : 'is-invalid'}"
                   name="diaChiEmail"
                   value="${khachHang.diaChiEmail}"
            >
            <div class="invalid-feedback">${error.diaChiEmail}</div>
        </div>

        <div class="text-success">${successMessage}</div>
        <button type="submit" class="btn btn-primary">${pageTitle}</button>
    </form>
    <script>
        $(document).ready(function () {
            let maKH = $('#maKH');
            let tenKH = $('#tenKH');
            let diaChi = $('#diaChi');
            let soDienThoai = $('#soDienThoai');
            let diaChiEmail = $('#diaChiEmail');

            [maKH, tenKH, diaChi, soDienThoai, diaChiEmail].forEach(item => item.on('input', function () {
                $(this).removeClass('is-invalid');
            }))
        })
    </script>
</c:set>

<%@include file="/WEB-INF/views/layout/main.jsp" %>