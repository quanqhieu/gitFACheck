<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/3/2024
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${totalPages > 0}">
    <div class="d-flex justify-content-between">
        <!-- Pagination -->
        <nav>
            <ul class="pagination">
                <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                    <a class="page-link"
                       href="?q=${query}&page=${currentPage - 1}&size=${pageSize}"
                    >Previous</a>
                </li>

                <c:forEach var="pageNumber" begin="0" end="${totalPages - 1}">
                    <li class="page-item ${pageNumber == currentPage ? 'active' : ''}">
                        <a class="page-link"
                           href="?q=${query}&page=${pageNumber}&size=${pageSize}"
                        >${pageNumber + 1}</a>
                    </li>
                </c:forEach>

                <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
                    <a class="page-link"
                       href="?q=${query}&page=${currentPage + 1}&size=${pageSize}"
                    >Next</a>
                </li>
            </ul>
        </nav>
        <!-- Page size selector -->
        <div class="form-inline mt-3">
            <label for="pageSize" class="mr-2">Items per page:</label>
            <select class="form-control" id="pageSize" onchange="changePageSize()">
                <option value="5" ${pageSize eq 5 ? 'selected' : ''}>5</option>
                <option value="10" ${empty pageSize or pageSize eq 10 ? 'selected' : ''}>10</option>
                <option value="20" ${pageSize eq 20 ? 'selected' : ''}>20</option>
                <!-- Add more options as needed -->
            </select>
        </div>
        <script>
            function changePageSize() {
                const newSize = $('#pageSize').val();
                window.location.search = 'q=${query}&page=0&size=' + newSize;
            }
        </script>
    </div>
</c:if>
