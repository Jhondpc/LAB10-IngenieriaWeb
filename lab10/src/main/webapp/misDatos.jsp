<%@ page import="com.example.lab10.beans.Clientes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Clientes perfil = (Clientes) request.getAttribute("perfil");
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Perfil</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/telepucp.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
              rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/600382161a.js" crossorigin="anonymous"></script>

        <!-- Template Main CSS File -->
        <link href="assets/css/style_seguridad.css" rel="stylesheet">
    </head>
    <body>
        <section class="section profile">
            <div class="container">
                <div class="container-fluid " style="background-color: #6ba7f5;width: 65%">

                    <div class="row">
                        <div>
                            <br>
                            <h3><b style="color:#144C47">Ver perfil</b></h3>
                            <br>

                        </div>

                        <div class="col-md-6">

                            <td style="padding-left: 2rem;">

                                <ul class="list-group list-group-flush">


                                    <label ><b> NOMBRE: </b></label>
                                    <div><%=perfil.getNombreCliente()%></div>

                                </ul>

                                <ul class="list-group list-group-flush">


                                    <label ><b> EDAD: </b></label>
                                    <div> <%=perfil.getEdad()%></div>

                                </ul>

                                <ul class="list-group list-group-flush">


                                    <label ><b> TIPO DE CLIENTE: </b></label>
                                    <div><%=perfil.getTipoCliente()%> </div>

                                </ul>

                                <ul class="list-group list-group-flush">


                                    <label ><b> TIPO DE DNI: </b></label>
                                    <div><%=perfil.getTipoDocumento()%> </div>

                                </ul>

                                <ul class="list-group list-group-flush">


                                    <label ><b> DNI: </b></label>
                                    <div><%=perfil.getNumeroDocumento()%> </div>

                                </ul>

                            </td>

                        </div>
                    </div>


                </div>
            </div>
        </section>
        <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
