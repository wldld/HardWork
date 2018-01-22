<body>
<%! String name = "Garfield";%>
<%
    name += "! Have a nice day!";
    for (int a = 0; a < 5; a++) {
%>
<font color="blue" size="10pt"><%=name %></font>
<%
    }
%>
</body>