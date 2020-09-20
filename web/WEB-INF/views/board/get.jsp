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
<%@include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="panel-heading">Board Read Page</div>

                <div class="panel-body">

                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
                               readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value='<c:out value="${board.title}"/>'
                               readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>Text Area</label>
                        <textarea class="form-control" row="3" name="content" readonly="readonly"><c:out
                                value="${board.content}"/></textarea>
                    </div>

                    <div class="form-group">
                        <label>writer</label>
                        <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'
                               readonly="readonly">
                    </div>

                    <button data-oper="modify" class="btn btn-default">Modify</button>
                    <button data-oper="list" class="btn btn-info">List</button>

                    <form id="operForm" action="/board/modify" method="get">
                        <input type="hidden" id="bno" name="bno" value="<c:out  value="${board.bno}"/>">
                        <input type="hidden" id='pageNum' name='page' value='<c:out value="${cri.page}"/>'>
                        <input type="hidden" id='amount' name='perPageNum' value='<c:out value="${cri.perPageNum}"/>'>
                    </form>
                </div>
            </div>
        </div>

        <div class>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-comments fa-fw"></i>Reply
                    <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글 등록</button>
                </div>

                <ul class="chat">
                    <li class="left clearfix" data-rno='12'>
                        <div>
                            <div class="header">
                                <strong class="primary-font"></strong>
                                <small class="pull-right text-muted"></small>
                            </div>
                            <p>good</p>
                        </div>
                    </li>
                </ul>
                <div class="panel-footer">
                </div>
            </div>
        </div>


    </div>
</div>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        var operForm = $("#operForm");

        $("button[data-oper='modify']").on("click", function (e) {
            operForm.attr("action", "/board/modify").submit();
        });

        $("button[data-oper='list']").on("click", function (e) {
            operForm.find("#bno").remove();
            operForm.attr("action", "/board/list");
            operForm.submit();
        });


    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        console.log(replyService);
        var bnoValue = '<c:out value="${board.bno}"/>';
        var replyUL = $(".chat");

        showList(1);

        function showList(page) {
            replyService.getList({bno:bnoValue, page: page||1}, function (list) {
                var str = "";
                if(list == null || list.length == 0) {
                    replyUL.html("");

                    return;
                }
                for (var i = 0, len = list.length || 0; i < len; i++) {
                    str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
                    str += " <div><div class='header'><strong class='primary-font'>["
                        +list[i].rno+"] "+list[i].replyer + "</strong>";
                    str += " <small class='pull-right text-muted'>"+list[i].replyDate+"</small></div>";
                    str += " <p>" + list[i].reply + "</p></div></li>";
                }
                replyUL.html(str);
            });
        }
    });

    // replyService.getList({bno:bnoValue, page:1}, function (list) {
    //
    //     for(var i = 0, len = list.length||0; i < len; i++) {
    //         console.log(list[i]);
    //     }
    // })

    // replyService.remove(5, function (count) {
    //
    //     if(count === 'success') {
    //         alert("REMOVED");
    //     }
    // }, function (err) {
    //     alert('error');
    // });

    // replyService.update({
    //     rno : 10,
    //     bno : bnoValue,
    //     reply : "Modified"
    // }, function (result) {
    //     alert("수정완료");
    // });

    // replyService.get(10, function (data) {
    //     console.log(data);
    // })
</script>
