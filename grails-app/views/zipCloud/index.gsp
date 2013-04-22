<html>
  <head>
  <link type="text/css" href="${resource(dir: 'css', file: 'main.css')}" />
    </head>
  <body>
  	<div>
  	  <g:form name="refresh" url="[controller: 'zipCloud', action: 'refresh']">
  	    <g:submitButton name="refresh" value="Refresh"/>
  	  </g:form>
  	</div>  	
    <p>
      <% states.each { state -> %>
        <a class="zipCloud href="#" style="font-size: ${ state.fontSize };" title="${ state.zipCount }"
		  >${ state.name }</a>
      <% } %>
    </p>
  </body>
</html>
