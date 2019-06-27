
	<nav class="navbar navbar-dark sticky-top bg-red-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Cinema XYZ</a>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
             <li class = "nav-item"> 
             <div class = "container d-flex justify-content-center">
             <img class="mb-2 img-fluid" src="${pageContext.request.contextPath}/resources/img/logoxyz.png" alt="" width="80">
             </div></li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/movies">
                  <span data-feather="film"></span>
                  Películas <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/theaters">
                  <span data-feather="monitor"></span>
                  Salas
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/showtimes">
                  <span data-feather="calendar"></span>
                  Funciones
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/users">
                  <span data-feather="users"></span>
                  Usuarios
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="bar-chart-2"></span>
                  Logs
                </a>
              </li>
             
            </ul>
          </div>
        </nav>
