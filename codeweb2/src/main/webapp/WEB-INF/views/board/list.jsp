<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Board List</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">Board List Page
             <button type="button" id='regBtn' class="btn btn-xs pull-right">Register New Board</button>
             </div>
             <!-- /.panel-heading -->
             <div class="panel-body">
                 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                     <thead>
                         <tr>
                             <th>#번호</th>
                             <th>제목</th>
                             <th>작성자</th>
                             <th>작성일</th>
                             <th>수정일</th>
                         </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="board" items="${list}">
                         <tr>
                             <td><c:out value="${board.bno}" /></td>
                             <td><a class="move" href='<c:out value="${board.bno}" />'>
                             	 	<c:out value="${board.title}" /></a></td>
                             <td><c:out value="${board.writer}" /></td>
                             <%-- <td><c:out value="${board.regdate}" /></td> --%>
                             <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
                             <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd" /> </td>
                         </tr>
                      </c:forEach>
                      </tbody>
                     </table>
                 </div>
                 <!-- /.table-responsive -->
                 
                 <h3>${pageMaker}</h3>
                 <div class="pull-right">
                 	<ul class="pagination">
                 		<c:if test="${pageMaker.prev}">
	                 		<li class="page-item">
	                 			<a class="page-link" href="${pageMaker.startPage - 1}" tabindex="-1">Previous</a>
	                 		</li>
                 		</c:if>
                 		<c:forEach var="num" begin="${pageMaker.startPage}"
                 		           end="${pageMaker.endPage }">
                 			<li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : ''} ">
                 			   <a href="${num}" class="page-link">${num}</a>
                 			</li>
                 		</c:forEach>
                 		<c:if test="${pageMaker.next}">
	                 		<li class="page-item">
	                 			<a class="page-link" href="${pageMaker.endPage + 1}" tabindex="-1">Next</a>
	                 		</li>
                 		</c:if>
                 	</ul>
                 </div>
                 <form action="/board/list" method="get" id="actionForm">
                 	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                 	<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                 </form>
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->
     </div>
     <!-- /.col-lg-6 -->
 </div>
 <!-- /.row -->
 
 <!-- 게시글 등록시 번호 뷰 모달창 -->
 <div class="modal" id="myModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
 
 <script>
  $(document).ready(function(){
	  var result = '<c:out value="${result}" />';
	  
	  checkModal(result);
	  
	  function checkModal(result){
		  if(result === ''){
			  return;
		  }
		  if(parseInt(result) > 0){
			  $(".modal-body").html(
				 "게시글" + parseInt(result) + "번이 등록되었습니다.");
		  }
		  if(result == "success"){
			  $(".modal-body").html("정상 처리되었습니다.");
		  }
		  $("#myModal").modal("show");
	  }
	  
	  //게시글 등록 버튼
	  $("#regBtn").on("click", function(){
		  //window.location과 같음
		  self.location = "/board/register";
	  });
	  
	  let actionForm = $("#actionForm");
	  
	  $(".page-link").on("click", function(e){
		  
		  e.preventDefault();  //기본 동작 제한
		  
		  let targetPage = $(this).attr("href");
		  
		  console.log(targetPage);
		  
		  actionForm.find("input[name='pageNum']").val(targetPage);
		  actionForm.submit();
	  });
	  
	  $(".move").on("click", function(e){
		 e.preventDefault();
		 
		 let targetBno = $(this).attr("href");
		 console.log(targetBno);
		 
		 actionForm.append("<input type='hidden' name='bno' value='" + targetBno + "'>'");
		 actionForm.attr("action", "/board/get");
		 actionForm.submit();
	  });
	  
  });
</script>
 
<%@ include file="../includes/footer.jsp" %>