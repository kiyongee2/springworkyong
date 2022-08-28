<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 <div class="row">
     <div class="col-lg-12">
         <h1 class="page-header">Board Register</h1>
     </div>
     <!-- /.col-lg-12 -->
 </div>
 <!-- /.row -->
 <div class="row">
     <div class="col-lg-12">
         <div class="panel panel-default">
             <div class="panel-heading">
                 게시글 등록
             </div>
             <!-- /.panel-heading -->
             <div class="panel-body">
                 <form action="/board/register" method="post" role="form">
                 	<div class="form-group">
                         <label>Title</label>
                         <input class="form-control" type="text" name="title">
                     </div>
                 	<div class="form-group">
                         <label>Content</label>
                         <textarea class="form-control" rows="3" cols="50" name="content"></textarea>
                     </div>
                 	<div class="form-group">
                         <label>Writer</label>
                         <%-- <input class="form-control" type="text" name="writer" readonly="readonly"
                         		value='<security:authentication property="principal.username"/>' > --%>
                     </div>
          			 <button type="submit" class="btn btn-default">Submit Button</button>
                     <button type="reset" class="btn btn-default">Reset Button</button>
                 </form>
                 
             </div>
             <!-- /.panel-body -->
         </div>
         <!-- /.panel -->
     </div>
     <!-- /.col-lg-6 -->
 </div>
 <!-- /.row -->


<%@ include file="../includes/footer.jsp" %>