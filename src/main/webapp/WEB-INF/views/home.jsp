<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"  rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap-datepicker.min.css" />"  rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.7.1.min.js" /> "></script>
    <script  src="<c:url value="/resources/bootstrap/js/popper.min.js" /> "></script>
    <script  src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js" /> "></script>
    <script  src="<c:url value="/resources/bootstrap/js/bootstrap-datepicker.min.js" /> "></script>
    <script  src="<c:url value="/resources/bootstrap/js/bootstrap-datepicker.ja.min.js" /> "></script>
</head>
<body>
<div class="container p-5">
    <h2>Documents Table</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Document Name</th>
            <th scope="col">Status</th>
            <th scope="col">Date Time</th>
            <th scope="col">Memo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="document" items="${listDocs}">
            <tr>
                <th scope="row">${document.id}</th>
                <td>${document.fileName}</td>
                <td>${document.status}</td>
                <td>${document.registerDate}</td>
                <td>${document.memo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <!-- Button to Open the Modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Open Modal
    </button>

    <!-- The Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Document Form</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" >
                    <form:form enctype="multipart/form-data" modelAttribute="newDoc" action="create">
                        <!-- Document File Input -->
                        <div class="mb-3">
                            <label for="documentFile" class="form-label">Document</label>
                            <input class="form-control" type="file" id="documentFile" name="file" accept=".png, .jpg, .jpeg"/>
                        </div>
                        <!-- Document Name Input -->
                        <div class="mb-3">
                            <label for="documentName" class="form-label">Document Name</label>
                            <form:input type="text" class="form-control" id="documentName" path="fileName"/>
                        </div>
                        <!-- Register Date Input -->
                        <div class="mb-3">
                            <label for="registerDate" class="form-label">Register Date</label>
                            <form:input type="text" class="form-control" id="registerDate" placeholder="Select date" path="registerDate" />
                        </div>
                        <!-- Status Option Element -->
                        <div class="mb-3">
                            <label for="status" class="form-label">Status</label>
                            <form:select class="form-select" id="status" path="status">
                                <option selected>Select status</option>
                                <form:option value="Active">Active</form:option>
                                <form:option value="Inactive">Inactive</form:option>
                                <form:option value="Pending">Pending</form:option>
                            </form:select>
                        </div>
                        <!-- Memo Text Area Element -->
                        <div class="mb-3">
                            <label for="memo" class="form-label">Memo</label>
                            <form:textarea class="form-control" id="memo" rows="3" path="memo"></form:textarea>
                        </div>
                        
                                        <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
                    </form:form>
                </div>

            </div>
        </div>
    </div>
</div>

    <script>
        $(document).ready(function () {
            $('#registerDate').datepicker({
            	 language:'ja', // 日本語化
                 format: 'yyyy/mm/dd', // 日付表示をyyyy/mm/ddにフォーマット
            });
        });
    </script>
</body>
</html>
