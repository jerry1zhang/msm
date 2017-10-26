<%@ page import="java.util.List" %>
<%@ page import="com.zking.pojo.ListStatic" %>
<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2017/10/23
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户列表</strong> / <small>userList</small></div>
</div>

<hr>
<%
    List<ListStatic> userList = (List<ListStatic>)request.getAttribute("userList");
%>
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
                <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
            </div>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-3">
        <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}">
                <option value="-1">所有类别</option>
                <%
                    if (userList!=null)
                    for (ListStatic e:userList) {
                %>
                <option value="<%=e.getItemValue()%>"><%=e.getItemName()%></option>
                <%
                        }
                %>
            </select>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-3">
        <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
            <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
        </div>
    </div>
</div>

<div class="am-g">
    <div class="am-u-sm-12">

        <form action="user" id="Form" class="am-form" method="post">
        </form>



        <div class="am-cf">
            共有 <%=(long)request.getAttribute("listNum")%> 记录

            <div class="am-fr">
                <ul class="am-pagination">
                    <li class="am-disabled"><a href="#">«</a></li>
                    <li class="am-active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>

        <hr />
        <p>注：.....</p>
    </div>

</div>
</div>

