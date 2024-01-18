<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/5/2024
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Danh Sách Tổng"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Mã KH</th>
            <th>Tên KH</th>
            <th>Mã Máy</th>
            <th>Vị Trí</th>
            <th>Trạng Thái</th>
            <th>Ngày Bắt Đầu Sử Dụng Máy</th>
            <th>Giờ Bắt Đầu Sử Dụng Máy</th>
            <th>Thời gian Sử Dụng Máy</th>
            <th>Mã Dịch Vụ</th>
            <th>Tên Dịch Vụ</th>
            <th>Ngày Sử Dụng Dịch Vụ</th>
            <th>Giờ Sử Dụng Dịch Vụ</th>
            <th>Số Lượng</th>
            <th>Tổng Tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${dtoList}">
            <tr>
                <td>${dto.maKH}</td>
                <td>${dto.tenKH}</td>
                <td>${dto.maMay}</td>
                <td>${dto.viTri}</td>
                <td>${dto.trangThai}</td>
                <td>${dto.ngayBatDauSuDung}</td>
                <td>${dto.gioBatDauSuDung}</td>
                <td>${dto.thoiGianSuDung}</td>
                <td>${dto.maDV}</td>
                <td>${dto.tenDV}</td>
                <td>${dto.ngaySuDung}</td>
                <td>${dto.gioSuDung}</td>
                <td>${dto.soLuong}</td>
                <td>
                        ${dto.tongTienDichVu != 0 ? dto.tongTienDichVu : (dto.tongTienMay != null ? dto.tongTienMay : '')}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:set>

<%@include file="layout/main.jsp" %>
