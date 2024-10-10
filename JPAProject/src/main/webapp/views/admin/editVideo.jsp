<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa Video</title>
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
									<h4 style="margin-top: -20px;">Home -> Video -> Cập nhật video</h4>
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
								<%@ page import="entity.Video" %>	
								<%@ page import="java.util.Base64" %>	
								<%
    								Video video = (Video) request.getAttribute("video");
								%>						
								<form action="${pageContext.request.contextPath}/admin/edit-video" method="post" enctype="multipart/form-data">
									<div class="mb-3">
										<h6 class="mb-0">Mã doanh mục:</h6>
										<input type="text" class="form-control" name="categoryId"
											value="<%= video.getCategory().getCategoryId()%>" placeholder="Nhập mã doanh mục" required />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Ảnh:</h6>
										<input type="file" class="form-control" name="image" />
									</div>
									<td>
                                    	<c:if test="${not empty video.poster}">
                                        	<img src="data:image/jpeg;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(video.poster))}" 
                                        		alt="Product Image" style="width:100px; height:100px; margin: -20px 0 50px 0;" />
                                         </c:if>
                                    </td>
                                    <div class="mb-3">
										<h6 class="mb-0">Tiêu đề:</h6>
										<input type="text" class="form-control" name="title"
											value="<%= video.getTitle()%>" placeholder="Nhập tiêu đề" required />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Mô tả:</h6>
										<input type="text" class="form-control" name="description"
											value="<%= video.getDescription()%>" placeholder="Nhập mô tả" />
									</div>
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