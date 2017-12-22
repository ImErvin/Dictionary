<%@ include file="includes/header.jsp" %>

<div class="animated bounce" style="font-size:32pt; font-family:arial; color:#1f1f1f1f; font-weight:bold">Dictionary Service</div>

</p>&nbsp;</p>&nbsp;</p>

<table width="600" cellspacing="0" cellpadding="7" border="0">
	<tr>
		<td valign="top">

			<form method="POST" action="DictionaryServlet">
				<fieldset>
					<b>Search word:</b><br>
					<input name="searchWord" type="text" />
					<input type="submit" value="Search">
				</fieldset>
			</form>	
			
			<form action="DictionaryServlet" method="GET">
				<%=request.getParameter("definition")%>
			</form>
		</td>
	</tr>
</table>
<%@ include file="includes/footer.jsp" %>