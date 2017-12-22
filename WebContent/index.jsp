<%@ include file="includes/header.jsp" %>

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
		</td>
	</tr>
</table>
<%@ include file="includes/footer.jsp" %>