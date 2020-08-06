<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Redirecting</title>
</head>
<style>
    body {
        background-color: #fdffa1;
    }
</style>
<body onload="redirect()">
<h1 style="text-align: center; padding-top: 50px; display: block;">Redirecting........</h1>
<h1 style="text-align: center; padding-top: 50px; display: block;">You may not have the right to do this.</h1>
<script>
    function redirect() {
        setTimeout(function(){
                window.location.replace("/");
            }
            , 3000);
    }
</script>
</body>
</html>