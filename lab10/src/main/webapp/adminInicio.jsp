<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10.beans.Clientes" %>
<%@ page import="com.example.lab10.beans.Credentials" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Clientes> listaClientes = (ArrayList<Clientes>) request.getAttribute("listaClientes");
    ArrayList<Credentials> listaCredentials = (ArrayList<Credentials>) request.getAttribute("listaCredentials");
%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Iniciar sesión</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style_inicio_sesion.css" rel="stylesheet">

    <body>

        <main>
            <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                            <div class="card mb-3">

                                <div class="card-body">

                                    <div class="pt-4 pb-2">
                                        <h5 class="card-title text-center pb-0 fs-4">Crear usuario</h5>
                                    </div>

                                    <form class="row g-3 needs-validation" novalidate>

                                        <div class="col-12">
                                            <div class="col-lg-3">
                                                <form method="post" action="<%=request.getContextPath()%>/AdminServlet?action=guardar">
                                                <label for="DNI" class="form-label">DNI</label>
                                                <select class="form-select" id="DNI" placeholder="DNI" name="DNI">

                                                    <%  ArrayList<Clientes> listaFinal;

                                                        listaFinal=new ArrayList<>();

                                                        for(Credentials credentials:listaCredentials){
                                                            for (Clientes clientes:listaClientes){
                                                                for (Clientes finales:listaFinal){
                                                                    if (finales.getNumeroDocumento().equals(credentials.getNumeroDocumento())){
                                                                        listaFinal.remove(credentials.getNumeroDocumento());
                                                                    }
                                                                }
                                                                if (clientes.getNumeroDocumento().equals(credentials.getNumeroDocumento())){
                                                                    listaClientes.remove(credentials.getNumeroDocumento());
                                                                }else {
                                                                    listaFinal.add(clientes);
                                                                    listaClientes.remove(credentials.getNumeroDocumento());
                                                                }
                                                            }%>
                                                    <%}%>

                                                    <option value="">Seleccione una opción</option>
                                                    <%for (Clientes clientes2: listaFinal){%>
                                                    <option value="<%=clientes2.getNumeroDocumento()%>"><%=clientes2.getNumeroDocumento()%></option>
                                                    <%}%>
                                                </select>

                                                <div class="col-12">
                                                    <label for="password" class="form-label">Ingrese Contraseña</label>
                                                    <input type="password" name="password" class="form-control" id="password" required>
                                                    <div class="invalid-feedback">Ingresa tu contraseña</div>
                                                </div>
                                                </form>

                                            </div>
                                        </div>



                                        <div class="col-12">
                                            <a class="nav-link  " href="<%=request.getContextPath()%>/ServletIniciarSesion?action=inicioUsuario">
                                                <button type="button" class="btn btn-primary w-100" type="submit">Iniciar Sesión</button>
                                            </a>

                                        </div>

                                    </form>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>

            </div>
        </main><!-- End #main -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>

</html>
