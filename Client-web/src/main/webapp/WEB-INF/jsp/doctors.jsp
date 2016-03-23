<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Medical PDM</title>
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="/assets/app.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="navbar-header">                                               
                <span class="navbar-brand text-info">Bem vindo ${username} <a class="btn btn-sm btn-link" href="/logout">Sair</a></span>                
            </div>
            <div class="row container">
                <div class="col-md-10 col-md-offset-2">
                    <span class="form-group-sm pull-right">
                        <input class="form-control" onkeyup="filter(this)" type="text" id="filter" placeholder="Filtrar">                        
                        <br>
                    </span>
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="text-center">Médicos</h3>
                            <div class="panel">
                                <c:forEach items="${doctors}" var="d">
                                    <div class="media" style="cursor: pointer" onclick="location.href='/view/${d.id}'">
                                        <div class="media-left">
                                            <img src="/assets/img/icon.png" class="img-circle img-rounded" style="margin-top: 5px;">
                                        </div>
                                        <div class="media-body">
                                            <h4>${d.name}</h4>
                                            <span hidden>${d.location}</span>
                                            <span class="text-muted">${d.clinic.name}</span>
                                        </div>
                                        <div class="media-right">
                                            <div class="rating" style="width: 100px; font-size: 10px" data-rating="${d.rating}"/></div>
                                    </div>
                                </div>
                                <hr>
                            </c:forEach>
                            <div id="nresults" class="text-muted pull-right">Exibindo ${doctors.size()} resultados(s)</div>
                            <br>
                        </div>  
                    </div>
                </div>                    
            </div>
        </div>
    </div>
</body>
<script src="/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/rating/bootstrap-star-rating.js" type="text/javascript"></script>    
<script>
    $(document).ready(function () {

        $(".rating").rating();
    });
</script>
</html>
