<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Board Read Page</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">
                 Board Read Page
             </div>
             <!-- /.panel-heading -->
             <div class="panel-body">
               	<div class="form-group">
                    <label>Bno</label><input class="form-control" type="text" name="bno" 
                           value='<c:out value="${board.bno}" />' readonly="readonly">
                </div>
               	<div class="form-group">
                    <label>Title</label><input class="form-control" type="text" name="title" 
                           value='<c:out value="${board.title}" />' readonly="readonly">
                </div>
               	<div class="form-group">
                    <label>Content</label>
                    <textarea class="form-control" rows="3" cols="50" readonly="readonly"
                       name="content"><c:out value="${board.content}" /></textarea>
                </div>
               	<div class="form-group">
                   <label>Writer</label>
                   <input class="form-control" type="text" name="writer"
                   		value='<c:out value="${board.writer}" />' readonly="readonly">
                </div>
                <form action="/board/list" method="get" id="actionForm">
                 	<input type="hidden" name="pageNum" value="${cri.pageNum }">
                 	<input type="hidden" name="amount" value="${cri.amount }">
                 	<input type="hidden" name="bno" value="${board.bno}">
                 </form>
                
   			    <button data-oper='modify' class="btn btn-default">Modify</button>
                <button data-oper='list' class="btn btn-info">List</button>
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->
     </div>
     <!-- /.col-lg-6 -->
 </div>
 <!-- /.row -->
 
<script type="text/javascript">
	$(document).ready(function(){
		
		$('.btn').click(function(e){
			
			e.preventDefault(); //모든 이벤트 중지
			
			let operation = $(this).data("oper");
			
			//console.log(operation);
			let actionForm = $("#actionForm");
			
			if(operation === 'list'){
				self.location = "/board/list";
				//actionForm.find("input[name='bno']").remove();
				actionForm.submit();
			}
			if(operation === 'modify'){
				self.location = "/board/modify?bno=<c:out value='${board.bno}' />";
			}
		});	
	});
</script>

<%@ include file="../includes/footer.jsp" %>