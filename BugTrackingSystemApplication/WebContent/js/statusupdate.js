function updateStatus(bugid,projectName)
{
	
	let url = "http://localhost:8080/BugTrackingSystemApplication/CloseBugServlet/"+bugid;
	getHTTPRequestObject();
	if (xhr) {
		xhr.open("GET", url, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let newurl="http://localhost:8080/BugTrackingSystemApplication/ProjectDetailsServlet/"+projectName;
				alert("newurl: "+newurl);
				xhr.open("GET",newurl,true);
				xhr.send();
				xhr.abort();
			}
	}
	}
}

		function getHTTPRequestObject() {
			xhr = new XMLHttpRequest();

		}