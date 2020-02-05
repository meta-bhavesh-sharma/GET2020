function valid()
	{
	const
	queryString = window.location.search;
	const
	urlParams = new URLSearchParams(queryString);
	const email = urlParams.get('email')
	document.getParameterById("email").value=email;
	document.write();
	document.getParameterById("details").submit;
}