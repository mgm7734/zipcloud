<html>
  <body>
  	<div>
  	  <g:form name="refresh" url="[controller: 'zipCloud', action: 'refresh']">
  	    <g:submitButton name="refresh" value="Refresh"/>
  	  </g:form>
  	</div>  	
    <p>
      <% states.each { state -> %>
        <a href="#" style="font-size: ${ state.fontSize };" title="${ state.zipCount }">
		  ${ state.name }
		</a>
      <% } %>
    </p>
  </body>
</html>
