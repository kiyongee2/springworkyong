<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Board Modify/Delete</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">
                 Board Modify/Delete
             </div>
             <!-- /.panel-heading -->
             <div class="panel-body">
             	<form>
	               	<div class="form-group">
	                    <label>Bno</label><input class="form-control" type="text" name="bno" 
	                           value='<c:out value="${board.bno}" />' readonly="readonly">
	                </div>
	               	<div class="form-group">
	                    <label>Title</label><input class="form-control" type="text" name="title" 
	                           value='<c:out value="${board.title}" />'>
	                </div>
	               	<div class="form-group">
	                    <label>Content</label>
	                    <textarea class="form-control" rows="3" cols="50" 
	                       name="content"><c:out value="${board.content}" /></textarea>
	                </div>
	               	<div class="form-group">
	                   <label>Writer</label>
	                   <input class="form-control" type="text" name="writer"
	                   		value='<c:out value="${board.writer}" />'>
	                </div>
	   			    <button data-oper='modify' class="btn btn-default">Modify</button>
	   			    <button data-oper='remove' class="btn btn-danger">Remove</button>
	                <button data-oper='list' class="btn btn-info">List</button>
                </form>
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
		
		var form = $("form");
		
		$('.btn').click(function(e){
			
			e.preventDefault(); //모든 이벤트 중지
			
			var operation = $(this).data("oper");
			
			//console.log(operation);
			
			if(operation === 'list'){
				self.location = "/board/list";
			}else if(operation === 'remove'){
				form.attr("action", "/board/remove")
				    .attr("method", "post");
			}else if(operation === 'modify'){
				form.attr("action", "/board/modify")
			    .attr("method", "post");
			}
			form.submit();
			
		});	
	});
</script>

<%@ include file="../includes/footer.jsp" %>