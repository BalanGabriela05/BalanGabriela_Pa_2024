<!DOCTYPE html>
<html>
<head>
    <title>Employee Documents Report</title>
</head>
<body>
<h1>Employee Documents Report</h1>
<#list employees?keys as name>
    <h2>${name}</h2>
    <ul>
    <#list employees[name] as document>
        <li>${document.name} (${document.format})</li>
    </#list>
    </ul>
</#list>
</body>
</html>
