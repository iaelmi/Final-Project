<%@ include file="common/header.jspf" %>
<div class="container my-2">
    <div class="card card-cascade wider ">
        <div class="view view-cascade gradient-card-header aqua-gradient ">
            <h2 class="card-header-title mt-1 text-center ">SnapShots</h2>

        </div>
        <div class="card-body card-body-cascade text-centery">

            <c:if test="${role.equals('ROLE_USER')}">
                <table class="table table-striped" style="margin-top: 20px;">
                    <thead>
                    <tr>
                        <th scope="col">Country</th>
                        <th scope="col">Total Cases</th>
                        <th scope="col">Total Deaths</th>
                        <th scope="col">New Cases</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${stats}" var="stat">
                        <tr>

                            <td>${stat.getCountryName()}</td>
                            <td>${stat.getTotalCases()}</td>
                            <td>${stat.getTotalDeaths()}</td>
                            <td>${stat.getNewCases()}</td>
                            <td>
                                <form method="GET" action="/delete/stat">
                                    <input type="hidden" value="${stat.getId()}" name="statId">
                                    <button type="submit"
                                            class="btn btn-unique waves-effect waves-light purple-gradient btn-sm">
                                        delete
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${role.equals('ROLE_ADMIN')}">

                <table class="table table-striped" style="margin-top: 20px;">
                    <thead>
                    <tr>
                        <th scope="col">Country</th>
                        <th scope="col">Total Cases</th>
                        <th scope="col">Total Deaths</th>
                        <th scope="col">New Cases</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${stats}" var="stat">
                        <tr>
                            <form method="POST" action="/update/stat">
                                <td>
                                    <div class="md-form">
                                        <input type="text" id="form1" value="${stat.getCountryName()}"
                                               name="countryName" class="form-control">
                                        <label for="form1">Country</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="md-form">
                                        <input type="text" id="form2" value="${stat.getTotalCases()}" name="totalCases"
                                               class="form-control">
                                        <label for="form2">Total Cases</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="md-form">
                                        <input type="text" id="form3" value="${stat.getTotalDeaths()}"
                                               name="totalDeaths" class="form-control">
                                        <label for="form3">Total Deaths</label>
                                    </div>
                                </td>
                                <td>
                                    <div class="md-form">
                                        <input type="text" id="form4" value="${stat.getNewCases()}" name="newCases"
                                               class="form-control">
                                        <label for="form4">New Cases</label>
                                    </div>
                                </td>

                                <td>


                                    <input type="hidden" value="${stat.getId()}" name="statId">
                                    <button type="submit"
                                            class="btn btn-unique waves-effect waves-light purple-gradient mt-4 btn-sm">
                                        update
                                    </button>

                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </div>
    </div>
</div>