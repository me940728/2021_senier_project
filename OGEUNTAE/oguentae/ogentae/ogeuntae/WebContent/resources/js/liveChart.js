var chart;

function requestData() {
    $.ajax({
        url: 'http://192.168.0.84:5001/deviceCPUResource?',
        success: function(point) {
            var series = chart.series[0],
                shift = series.data.length > 20; 

            chart.series[0].addPoint(point, true, shift);

            setTimeout(requestData, 1000);
        },
        cache: false
    });
}

$(document).ready(function() {
    chart = new Highcharts.Chart({
        chart: {
            renderTo: 'data-container',
            defaultSeriesType: 'spline',
            events: {
                load: requestData
            }
        },
        title: {
            text: 'CPU Status'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150,
            maxZoom: 20 * 1000
        },
        yAxis: {
            minPadding: 0.2,
            maxPadding: 0.2,
            title: {
                text: 'Value',
                margin: 80
            }
        },
        series: [{
            name: 'CPU Performance',
            data: []
        }]
    });
});