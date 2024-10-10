<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>
<%@ page import="java.util.Base64" %>
<%@ page import="entity.Video" %>
<%@ page import="entity.Category" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
									<h4 style="margin-top: -50px;">Home -> Video</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="row" style="margin: -60px 0 0 20px;">
						<div id="recent-transactions" class="col-12">
							<% String message = (String) request.getAttribute("message"); %>
								<% if (message != null) { %>
    								<div class="alert alert-info">
        								<%= message %>
    								</div>
							<% } %>		
							<h6 class="my-2">Các sản phẩm</h6>
							<div style="margin: -60px 0 20px 1100px;">
								<div class="btn-group me-2">
									<a class="btn btn-primary btn-sm"
										href="http://localhost:8080/JPAProject/admin/add-video"
										style="font-size: 15px; padding: 8px 16px;">Thêm</a>
								</div>
								<div class="btn-group">
									<a href="http://localhost:8080/JPAProject/admin/video" class="btn btn-warning btn-sm" 
										style="font-size: 15px; padding: 8px 22px;">Lọc</a>
								</div>
							</div>
							<div class="card">
								<div class="card-content">
									<div class="table-responsive">
										<div class="table-wrapper">
											<table id="recent-orders"
												class="table table-hover table-xl mb-0">
												<thead>
													<tr>
														<th class="border-top-0" style="width: 10%;">Mã video</th>
														<th class="border-top-0" style="width: 10%;">Mã doanh mục</th>
														<th class="border-top-0" style="width: 20%;">Tiêu đề</th>
														<th class="border-top-0" style="width: 20%;">Mô tả</th>
														<th class="border-top-0" style="width: 20%;">Ảnh</th>
														<th class="border-top-0" style="width: 15%;">Trạng thái</th>
														<th class="border-top-0">Hàng động</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="video" items="${video}">
														<tr>
															<td><a class="border-top-1">${video.videoId}</a></td>
															<td><a>${video.category.categoryId}</a></td>
															<td><a>${video.title}</a></td>
															<td><a>${video.description}</a></td>
															<td>
                                                                <c:if test="${not empty video.poster}">
                                                                    <img src="data:image/jpeg;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(video.poster))}" 
                                                                         alt="Video Image" style="width:100px; height:100px;" />
                                                                </c:if>
                                                            </td>
                                                            <td><a>${video.active}</a></td>
															<td class="d-flex flex-column gap-0">
																<a href="${pageContext.request.contextPath}/admin/edit-video?videoId=${video.videoId}"
																	class="btn btn-warning btn-sm"
																	style="margin: 0 0 15px 0;">Sửa</a>
																<form action="${pageContext.request.contextPath}/admin/delete-video" 
																	method="POST" style="display: inline;" onsubmit="return confirmDelete();">
																	<input type="hidden" name="videoId" value="${video.videoId}">
																	<button type="submit" class="btn btn-danger btn-sm" style="padding: 7px 52px;">Xóa</button>
																</form>
																<script>
																	function confirmDelete() {
																		return confirm("Bạn có chắc chắn muốn xóa video này không?");
																	}
																</script>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>