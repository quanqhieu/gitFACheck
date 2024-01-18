<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/29/2023
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="pageTitle" value="Cập Nhật Máy"/>
<c:set var="pageContent">
    <h3>${pageTitle}</h3>
    <form action="/may/update" method="post">
        <div class="form-group">
            <label for="maMay">Mã Máy</label>
            <input type="text"
                   id="maMay"
                   class="form-control ${empty error.maMay ? '' : 'is-invalid'}"
                   name="maMay"
                   value="${may.maMay}"
                   readonly
            >
            <div class="invalid-feedback">${error.maMay}</div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="viTri">Vị Trí</label>--%>
<%--            <input type="text"--%>
<%--                   id="viTri"--%>
<%--                   class="form-control ${empty error.viTri ? '' : 'is-invalid'}"--%>
<%--                   name="viTri"--%>
<%--                   value="${may.viTri}"--%>
<%--            >--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="viTri">Vị Trí</label>
            <select id="viTri"
                    class="form-control ${empty error.viTri ? '' : 'is-invalid'}"
                    name="viTri"
                    value="${may.viTri}"
            >
                <option value="" ${empty may.viTri ? 'selected' : ''} disabled>...</option>
                <option value="Tầng 1" $${may.viTri eq 'Tầng 1' ? 'selected' : ''}>Tầng 1</option>
                <option value="Tầng 2" ${may.viTri eq 'Tầng 2' ? 'selected' : ''}>Tầng 2</option>
                <option value="Tầng 3" ${may.viTri eq 'Tầng 3' ? 'selected' : ''}>Tầng 3
                </option>
            </select>
            <div class="invalid-feedback">${error.trangThai}</div>
        </div>
        <div class="form-group">
            <label for="trangThai">Trạng Thái</label>
            <select id="trangThai"
                    class="form-control ${empty error.trangThai ? '' : 'is-invalid'}"
                    name="trangThai"
                    value="${may.trangThai}"
            >
                <option value="" ${empty may.trangThai ? 'selected' : ''} disabled>...</option>
                <option value="Ok" $${may.trangThai eq 'Ok' ? 'selected' : ''}>Ok</option>
                <option value="Bận" ${may.trangThai eq 'Bận' ? 'selected' : ''}>Bận</option>
                <option value="Bảo trì" ${may.trangThai eq 'Bảo trì' ? 'selected' : ''}>Bảo trì
                </option>
            </select>
            <div class="invalid-feedback">${errorUpdate.trangThai}</div>
        </div>
        <div class="text-success">${successMessage}</div>
        <button type="submit" class="btn btn-primary">${pageTitle}</button>
    </form>
    <script>
        $(document).ready(function () {
            let maMay = $('#maMay');
            let viTri = $('#viTri');
            let trangThai = $('#trangThai');

            [maMay, viTri].forEach(item => item.on('input', function () {
                $(this).removeClass('is-invalid');
            }))
            trangThai.on('input', function () {
                $(this).removeClass('is-invalid')
            })
        })
    </script>
</c:set>

<%@include file="/WEB-INF/views/layout/main.jsp" %>