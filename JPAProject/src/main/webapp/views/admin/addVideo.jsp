<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Video</title>
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
									<h4 style="margin-top: -20px;">Home -> Video -> Thêm Video</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="container mt-0">
						<div class="row">
							<div id="recent-transactions" class="col-12">							
								<form action="${pageContext.request.contextPath}/admin/add-video" method="post" enctype="multipart/form-data">
									<% String message = (String) request.getAttribute("message"); %>
									<% if (message != null) { %>
    								<div class="alert alert-info">
        								<%= message %>
    								</div>
									<% } %>
									<div class="mb-3">
										<h6 class="mb-0">Mã video:</h6>
										<input type="text" class="form-control" name="videoId"
											placeholder="Nhập mã video" required />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Mã doanh mục:</h6>
										<select class="form-control" name="categoryId" required>
											<option value="" disabled selected>Chọn mã doanh mục</option>
											<%
												List<String> listCategoryId = (List<String>) request.getAttribute("listCategoryId");
												if (listCategoryId != null) {
													for (String categoryId : listCategoryId) {
											%>
														<option value="<%=categoryId%>"><%=categoryId%></option>
											<%
													}
												}
											%>
										</select>
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Ảnh poster:</h6>
										<input type="file" class="form-control" name="poster" />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Tiêu đề:</h6>
										<input type="text" class="form-control" name="title"
											placeholder="Nhập tiêu đề" required />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Mô tả:</h6>
										<input type="text" class="form-control" name="description"
											placeholder="Nhập tiêu đề" />
									</div>
									<div class="mb-3">
										<h6 class="mb-0">Lượt xem:</h6>
										<input type="number" class="form-control" name="view" />
									</div>
									<div class="mb-3">
                                        <h6 class="mb-0">Trạng thái:</h6>
                                        <select class="form-control" name="active">
                                            <option value="true">Active</option>
                                            <option value="false">Passive</option>
                                        </select>
                                    </div>
									<div class="d-flex justify-content-center mb-3">
										<button type="submit" class="btn btn-primary">Thêm video</button>
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