<%--
  Created by IntelliJ IDEA.
  User: kimjunwoo
  Date: 2020/09/19
  Time: 9:56 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="panel-heading">Board Register</div>

                <div class="panel-body">

                    <form role=form" action="/board/register" method="post">
                        <div class="form-group">
                            <label>Title</label>
                            <input class="form-control" name="title">
                        </div>
                        <div class="form-group">
                            <label>Text Area</label>
                            <textarea class="form-control" row="3" name="content"></textarea>
                        </div>

                        <div class="form-group">
                            <label>writer</label>
                            <input class="form-control" name="writer">
                        </div>

                        <button id="submit" type="submit" class="btn btn-default">submit</button>
                        <button type="reset" class="btn btn-default">Reset Button</button>

                    </form>
                 </div>
            </div>
        </div>
    </div>
</div>
