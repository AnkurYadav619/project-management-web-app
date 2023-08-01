//chartData is coming from within the script tag in home.html
var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr)

var arrayLength = chartJsonArray.length;

var labelData = [];
var numericData = [];

for(var i=0; i<arrayLength; i++){
	labelData[i] = chartJsonArray[i].label;
	numericData[i] = chartJsonArray[i].count;
}

new Chart(document.getElementById("myChart"),{
	
	//type of the chart required
	type: 'doughnut',
	
	//Data for the dataset
	data: {
		labels:labelData,
		datasets:[{
			//label: 'My first chart',
			backgroundColor: ["#FE0000","#7D7463","#F4E0B9"],
			borderColor: 'rgb(0,0,0)',
			data:numericData
		}]
	},
	
	//Configuration
	options : {
	    responsive: true,
	    plugins: {
	      legend: {
	        position: 'top',
	      },
	      title: {
	        display: true,
	        text: 'Project Statuses'
	      }
	   }
	}
});

//This method will decode the cryptic chartData variable to 
//[{"label": "NOTSTARTED", "count":"1"},{"label": "INPROGRESS", "count":"2"},{"label": "COMPLETED", "count":"1"}]
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}