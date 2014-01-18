<jsp:root 
    xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns="http://www.w3.org/1999/xhtml"
    version="2.0">
    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
    <jsp:output omit-xml-declaration="true" />
    <jsp:output doctype-root-element="HTML" 
                doctype-system="about:legacy-compat" />
    <html>
        <head>
            <title>About</title> 
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" type="text/css" href="resources/css/layout.css" />
            <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
        </head>
        <body>
            
            <jsp:directive.include file="../header.jspx" />
            <link rel="stylesheet" type="text/css" href="resources/css/menu.css" />
            
            

            <jsp:directive.include file="../footer.jspx" />
        </body>
    </html>
</jsp:root>
