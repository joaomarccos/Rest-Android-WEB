<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Medical PDM - ${doctor.name}</title>
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="/assets/app.js" type="text/javascript"></script>
    </head>
    <body style="overflow-x: hidden">
        <div class="container-fluid">
            <div class="navbar-header">                                                               
                <span class="navbar-brand text-info"><a href="/doctors" class="btn btn-link"><i class="glyphicon glyphicon-arrow-left"></i></a>Voltar</span>                
            </div>
            <div class="row container">
                <div class="col-md-10 col-md-offset-2">                    
                    <div class="row">
                        <div class="col-md-4">
                            <div class="media">
                                <div class="media-left">
                                    <img src="/assets/img/icon.png" class="img-circle img-rounded" style="margin-top: 5px;">
                                </div>
                                <div class="media-body">
                                    <h4>${doctor.name}</h4>
                                    <div class="rating" style="width: 200px; font-size: 12px; margin-top: -7px;" data-rating="${doctor.rating}"></div>
                                    <span class="text-muted">${comments.size()} reviews <b>Nota: ${doctor.rating}</b></span>
                                </div>              
                                <br>                                
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="panel panel-body">
                                <b>Contato: </b>${doctor.contact}<br>
                                <b>Especialidade: </b>${doctor.specialty}<br>
                                <b>Cidade/UF/: </b>${doctor.location}<br>                                    
                            </div>
                        </div>
                        <c:if test="${doctor.opinion != null}">
                            <div class="col-md-4">
                                <div class="panel panel-body">
                                    <b>Opinião</b><br>
                                    ${doctor.opinion}<br>                                
                                </div>
                            </div>
                        </c:if>
                    </div>  
                    <div class="row container">                        
                        <br>
                        <br>
                        <br>
                        <div class="col-md-4">
                            <c:if test="${comments.size() == 0}">
                                <h4>Seja o primeiro a avaliar</h4>
                            </c:if>
                            <c:if test="${comments.size() != 0}">
                                <h4>Avaliações e comentários</h4>
                            </c:if>
                            <c:forEach items="${comments}" var="comment">
                                <div class="panel">                                    
                                    <div class="panel-body">
                                        <h5><i class="glyphicon glyphicon-user"></i> ${comment.userName}<div class="rating pull-right" style="width: 90px; font-size: 8px; margin-top: -7px;" data-rating="${comment.rating}"></div></h5>                                                                            
                                        <p class="text-justify text-muted">${comment.comment}</p>
                                    </div>
                                </div>
                            </c:forEach>
                            <br>
                            <br>
                            <br>
                            <form action="/comment" method="post">
                                <input hidden name="doctorId" value="${doctor.id}">
                                <div class="form-group-sm">
                                    <label>Como classifica esse médico?</label>
                                    <div class="rating pull-right" style="font-size: 8px; width: 100px" data-rating="5"><input hidden type="text" name="userRating"></div>
                                    <textarea class="form-control" required name="comment" placeholder="Comentário"></textarea>
                                </div>                            
                                <input class="btn btn-sm btn-success" style="margin-top: 3px;" type="submit" value="Enviar">
                            </form>
                        </div>                    
                        <div class="col-md-8 text-center">
                            <h5>${doctor.clinic.name}</h5>
                            <c:if test="${doctor.clinic.coord_lat == '' || doctor.clinic.coord_lng == ''}">
                                <h5 class="text-muted">Sem foto</h5>                                
                            </c:if>
                            <c:if test="${doctor.clinic.coord_lat != '' && doctor.clinic.coord_lng != ''}">
                                <img  class="img-responsive" style="margin: 0 auto" src="http://maps.googleapis.com/maps/api/staticmap?center=${doctor.clinic.coord_lat},${doctor.clinic.coord_lng}&size=500x350&maptype=roadmap&sensor=false&zoom=15&scale=0&markers=size:mid%7Ccolor:0xff0000%7C${doctor.clinic.coord_lat},${doctor.clinic.coord_lng}">
                            </c:if>
                        </div>                            
                    </div>
                </div>
            </div>        
        </div>
                            <br>
                            <br>
                            <br>
                            <br>
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
