<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa doanh mục</title>
</head>
<body>
	<div class="app-content content">
		<div class="content-wrapper">
			<div class="content-header row"></div>
			<div class="content-body">
				<div class="row match-height">
					<div class="col-xl-8 col-12">
						<div class="card card-transparent">
							<div class="card-header card-header-transparent py-20">
								<div class="btn-group dropdown">
									<h4 style="margin-top: -20px;">Home -> Doanh mục -> Cập nhật doanh mục</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="container mt-0">
						<div class="row">
							<div id="recent-transactions" class="col-12">
								<% String message = (String) request.getAttribute("message"); %>
								<% if (message != null) { %>
    								<div class="alert alert-info">
        								<%= message %>
    								</div>
								<% } %>
								<%@ page import="entity.Category" %>	
								<%@ page import="java.util.Base64" %>	
								<%
    								Category category = (Category) request.getAttribute("category");
								%>						
								<form action="${pageContext.request.contextPath}/admin/edit-category" method="post" enctype="multipart/form-data">
									<div class="mb-3">
										<h6 class="mb-0">Tên hãng sản xuất:</h6>
										<input type="text" class="form-control" name="categoryName"
											value="<%= category.getCategoryName() %>" placeholder="Nhập tên hãng sản xuất" required />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Ảnh:</h6>
										<input type="file" class="form-control" name="image" />
									</div>
									<td>
                                    	<c:if test="${not empty category.image}">
                                        	<img src="data:image/jpeg;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(category.image))}" 
                                        		alt="Product Image" style="width:100px; height:100px; margin: -20px 0 50px 0;" />
                                         </c:if>
                                    </td>
									<div class="mb-3">
										<h6 class="mb-0">Trạng thái:</h6>
										<select class="form-control" name="status">
											<option value="true">Active</option>
											<option value="false">Passive</option>
										</select>
									</div>
									<div class="d-flex justify-content-center mb-3">
										<button type="submit" class="btn btn-primary">Cập nhật doanh mục</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>