<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pageTitle" value="Danh Sách Khách Hàng"/>
<c:set var="pageContent">
  <div class="d-flex justify-content-between">
    <h3>${pageTitle}</h3>
    <%@include file="../common/searchbox.jsp"%>
  </div>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>Mã khách hàng</th>
      <th>Tên khách hàng</th>
      <th>Địa chỉ</th>
      <th>Số điện thoại</th>
      <th>Địa chỉ email</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" varStatus="status" items="${itemList}">
      <tr>
        <td>${item.maKH}</td>
        <td>${item.tenKH}</td>
        <td>${item.diaChi}</td>
        <td>${item.soDienThoai}</td>
        <td>${item.diaChiEmail}</td>
        <td class="d-flex">
          <a href="/khachhang/update/${item.maKH}" class="btn btn-primary mr-2">Cập
            nhật
          </a>
          <button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal${item.maKH}">Xoá
          </button>
        </td>
      </tr>
      <!-- Delete Modal -->
      <div class="modal fade" id="deleteModal${item.maKH}" tabindex="-1">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Xác Nhận Xoá</h5>
              <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              Bạn có chắc muốn xoá ${item.maKH}
            </div>
            <div class="modal-footer">
              <a href="/khachhang/delete/${item.maKH}" class="btn btn-danger">Đồng ý</a>
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
      width: '550px',
      icon: 'success',
      title: '${requestScope.successMessage}',
      showConfirmButton: false,
      timer: 1500
    });
    </c:if>
  </script>
</c:set>
<%@include file="../layout/main.jsp" %>