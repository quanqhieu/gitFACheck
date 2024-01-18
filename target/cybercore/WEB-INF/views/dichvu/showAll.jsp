<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/28/2023
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Danh Sách Dịch Vụ"/>
<c:set var="pageContent">
    <div class="d-flex justify-content-between">
        <h3>${pageTitle}</h3>
        <%@include file="../common/searchbox.jsp"%>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Mã Dịch Vụ</th>
            <th>Tên Dịch Vụ</th>
            <th>Đơn Vị Tính</th>
            <th>Đơn Giá</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" varStatus="status" items="${itemList}">
            <tr>
                <td>${item.maDV}</td>
                <td>${item.tenDV}</td>
                <td>${item.donViTinh}</td>
                <td>${item.donGia}</td>
                <td class="d-flex">
                    <a href="/dichvu/update/${item.maDV}" class="btn btn-primary mr-2">Cập
                        nhật
                    </a>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal${item.maDV}">Xoá
                    </button>
                </td>
            </tr>
            <!-- Delete Modal -->
            <div class="modal fade" id="deleteModal${item.maDV}" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Xác Nhận Xoá</h5>
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Bạn có chắc muốn xoá ${item.maDV}
                        </div>
                        <div class="modal-footer">
                            <a href="/dichvu/delete/${item.maDV}" class="btn btn-danger">Đồng ý</a>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Huỷ</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="../common/pagination.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        <c:if test="${not empty requestScope.successMessage}">
        Swal.fire({
            icon: 'success',
            title: '${requestScope.successMessage}',
            showConfirmButton: false,
            timer: 1500
        });
        </c:if>
    </script>
</c:set>
<%@include file="../layout/main.jsp" %>