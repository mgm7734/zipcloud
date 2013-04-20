<html>
  <body>
    <p>
      <% states.each { state -> %>
        <span data="${ state.zipCount }">
	  ${ state.name }
	</span>
      <% } %>
    </p>
  </body>
</html>
