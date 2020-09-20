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

                    <form role=form" action="/board/modify" method="post">
                        <input type="hidden" name="page" value="<c:out value="${cri.page}"/>">
                        <input type="hidden" name="perPageNum" value="<c:out value="${cri.perPageNum}"/>">
                        <div class="form-group">
                            <label>Bno</label>
                            <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
                        </div>
                        <div class="form-group">
                            <label>Title</label>
                            <input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
                        </div>
                        <div class="form-group">
                            <label>Text Area</label>
                            <textarea class="form-control" row="3" name="content"><c:out value="${board.content}"/></textarea>
                        </div>

                        <div class="form-group">
                            <label>writer</label>
                            <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
                        </div>

                        <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                        <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                        <button type="submit" data-oper="list" class="btn btn-info">List</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var formObj =$("form");

        $('button').on("click", function (e) {

            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if(operation === 'remove') {
                formObj.attr("action", "/board/remove");
            }else if(operation === 'list') {
                formObj.attr("action", "/board/list").attr("method", "get");
                var pageTag = $("input[name='page']").clone();
                var perPageNumTag = $("input[name='perPageNum']").clone();

                formObj.empty();
                formObj.append(pageTag);
                formObj.append(perPageNumTag);
            }
            formObj.submit();
        });
    });

</script>