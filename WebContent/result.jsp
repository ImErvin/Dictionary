<%@ include file="includes/header.jsp" %>

<%String jobId=(String)request.getAttribute("JobNumber");
			  out.print("<h3>Job#"+jobId+"</h3>");%>

<table width="600" cellspacing="0" cellpadding="7" border="0">
	<tr>
		<td valign="top">			  
		
			
			<%String definition=(String)request.getAttribute("definition");
			  out.print("<h3>Definition:"+definition+"</h3>");%>
			
			<form method="POST" action="DictionaryServlet" name="formGetDef">
				<fieldset>
						<b>Search another word:</b><br>
						<input name="searchWord" type="text" />
						<input type="submit" value="Search">
				</fieldset>
			</form>	
		</td>
	</tr>
</table>
<%@ include file="includes/footer.jsp" %>