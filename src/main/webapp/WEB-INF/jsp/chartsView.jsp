<%@ include file="common/header.jspf" %>
<script type="text/javascript">
    window.onload = function() {

        var dps = [[]];
        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            exportEnabled: true,
            title:{
                text: "Corona Virus Pie Chart"
            },
            data: [{
                type: "pie",
                yValueFormatString: "#,###\"\"",
                showInLegend: true,
                indexLabel: "{y}",
                indexLabelPlacement: "inside",
                dataPoints: dps[0]
            }]
        });

        var yValue;
        var name;

        <c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
        <c:forEach items="${dataPoints}" var="dataPoint">
        yValue = parseFloat("${dataPoint.y}");
        name = "${dataPoint.name}";
        dps[parseInt("${loop.index}")].push({
            name : name,
            y : yValue
        });
        </c:forEach>
        </c:forEach>

        chart.render();

    }
</script>
<div class="container my-2">
    <div class="row">
        <div class="col">
            <div class="card card-cascade wider mt-5" style="">
                <div class="view view-cascade gradient-card-header aqua-gradient">
                    <h2 class="card-header-title mt-1 text-center ">Select Country</h2>

                </div>
                <div class="card-body card-body-cascade text-center">
                    <form action="/canvasjschart">
                                <select class="custom-select custom-select-sm" name='country' style="margin-top: 8%;">
                                    <option selected>Select Country</option>
                                    <c:forEach items="${countries}" var="country">
                                        <option value="${country}">${country}</option>
                                    </c:forEach>
                                </select>

                                <div class="text-center mb-3" style="margin-top: 8%;">
                                    <button type="submit"
                                            class="btn btn-unique waves-effect waves-light btn-block btn-rounded purple-gradient z-depth-1a">
                                        Submit
                                    </button>
                                </div>

                    </form>
                    <div class="mt-3">
                        <h2> Country : ${country}</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card card-cascade wider mt-5">
                <div class="view view-cascade gradient-card-header aqua-gradient">
                    <h2 class="card-header-title mt-1 text-center ">Graph</h2>

                </div>
                <div class="card-body card-body-cascade text-center">
                    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>