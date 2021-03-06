<%--
  Created by IntelliJ IDEA.
  User: kimjunwoo
  Date: 2020/09/19
  Time: 8:39 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Board List
                        <button id="regBtn" type="button" class="btn btn-xs pull-right">글 등록</button>
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
                                <th>수정</th>
                            </tr>
                            </thead>

                            <c:forEach items="${list}" var="board">
                                <tr>
                                    <td><c:out value="${board.bno}"/></td>
                                    <td><a class="move" href='<c:out value="${board.bno}"/>'>
                                        <c:out value="${board.title}"/></a></td>
                                    <td><c:out value="${board.writer}"/></td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                </tr>
                            </c:forEach>
                        </table>

                        <div class="pull-right">
                            <ul class="pagination">

                                <c:if test="${pageMaker.prev}">
                                    <li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">Previous</a> </li>
                                </c:if>

                                <C:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                                    <li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
                                </C:forEach>

                                <c:if test="${pageMaker.next}">
                                    <li class="paginate_button next"><a href="${pageMaerk.endPage+1}">Next</a> </li>
                                </c:if>
                            </ul>
                        </div>

                        <form id="actionForm" action="/board/list" method="get">
                            <input type="hidden" name="page" value="${pageMaker.cri.page}">
                            <input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}">
                        </form>

                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                    </div>
                                    <div class="modal-body">
                                        처리완료됬습니다.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-6 -->
        </div>
        <!-- /.row -->

<script tyoe="text/javascript">

    $(document).ready(function () {
        var result = '<c:out value="${result}"/>';

        checkModal(result);

        //글등록후 모달창 뜨고 뒤로가기하고 앞으로 가기해도 다시 모달창안뜸
        history.replaceState({}, null, null);

        function checkModal(result){
            if(result === '' || history.state){
                return;
            }

            if(parseInt(result) > 0) {
                $(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
            }
            $("#myModal").modal("show");
        }

        $("#regBtn").on("click", function () {
            self.location = "/board/register";
        });

        var actionForm = $("#actionForm");

        $(".paginate_button a").on("click", function(e){
            e.preventDefault();//a태그 클릭해도 이동 없도록 처리
            console.log('click');
            actionForm.find("input[name='page']").val($(this).attr("href"));
            actionForm.submit();
        });

        $(".move").on("click", function (e) {
            e.preventDefault();
            actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
            actionForm.attr("action", "/board/get");
            actionForm.submit();
        });

    });

</script>
<%@include file="../includes/footer.jsp"%>
