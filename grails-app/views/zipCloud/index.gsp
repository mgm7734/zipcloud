<html>
  <body>
    <p>
      <% states.each { state -> %>
        <span style="font-size: ${ state.fontSize };">
	  ${ state.name }
	</span>
      <% } %>
    </p>
  </body>
</html>
