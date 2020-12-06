<%@ include file="common/header.jspf" %>
<div class="container my-2">
    <div class="row">
        <div class="col">
            <div class="card card-cascade wider mt-5">
                <div class="view view-cascade gradient-card-header aqua-gradient">
                    <h2 class="card-header-title mt-1 text-center ">Create New User</h2>

                </div>
                <div class="card-body card-body-cascade text-center">
                    <form method="POST" action="/create/user">
                        <div class="mt-5">
                            <input type="text" name="username" id="Form-email1" class="form-control"
                                   placeholder="Username"></input>
                        </div>

                        <div class="mt-5 ">

                            <input type="password" name="password" id="exampleForm2" class="form-control"
                                   placeholder="password">
                        </div>
                        <div class="mt-5 ">
                            <select class="custom-select custom-select-sm" name='role'>
                                <option value="ROLE_USER">USER</option>
                                <option value="ROLE_ADMIN">ADMIN</option>
                            </select>
                        </div>

                        <div class="text-center mb-3 mt-5">
                            <button type="submit"
                                    class="btn btn-unique waves-effect waves-light btn-block btn-rounded purple-gradient z-depth-1a">
                                Create
                                User
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card card-cascade wider mt-5">
                <div class="view view-cascade gradient-card-header aqua-gradient">
                    <h2 class="card-header-title mt-1 text-center ">System Users</h2>

                </div>
                <div class="card-body card-body-cascade text-center">
                    <table class="table table-striped" style="margin-top: 20px;">
                        <thead>
                        <tr>
                            <th scope="col">Username</th>
                            <th scope="col">Password</th>
                            <th scope="col">Role</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>

                                <td>${user.getName()}</td>
                                <td>${user.getPassword()}</td>
                                <td>${user.getRole()}</td>
                                <td>
                                    <form method="POST" action="/delete/user">
                                        <input type="hidden" value="${user.getId()}" name="userId">
                                        <button type="submit" class="btn btn-unique waves-effect waves-light purple-gradient btn-sm">
                                            delete
                                        </button>
                                    </form>
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
</body>

</html>
